package com.chipmunk.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.ConvertUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/***
 * 数据库操作辅助类
 * 该类中封装了关于数据库的常用操作
 */
public abstract class DBUtil {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    //创建数据源DataSource对象,基于Druid的数据源
    private static DataSource dataSource;

    /***
     * 静态代码块
     * 当类加载时就被执行，而且只会执行一次
     */
    static {
        try {
            //读取db.properties文件中的数据
            InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //Properties类，该类的一个实例对应一个properties文件
            //Properties类是一个Map集合
            Properties properties = new Properties();
            //将输入流中的数据加载到properties对象
            properties.load(input);
            //创建Druid的dataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /***
     * 使用Druid数据库连接池技术连接数据库
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected Connection getConn() throws ClassNotFoundException, SQLException {
        //从连接池中获取一个连接对象
        conn = dataSource.getConnection();
        return conn;
    }

    /***
     * 释放数据库资源方法
     */
    protected void closeAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
            ps = null;
            rs = null;
        }
    }

    /***
     * 执行增、删、改等修改数据库的操作
     * @param sql   带有?号占位符的SQL语句
     * @param params  SQL语句中?号占位符的值
     *                 由于SQL语句中可以有多个?号也可以没有?号,
     *                 ?号所占位的数据的数据类型也是不统一的
     *                  所以该参数为一个Object数组
     * @return int类型整数，该返回值表示SQL语句执行后的影响行数
     */
    protected int executeUpdate(String sql, Object... params) {
        try {
            //1.连接数据库(调用本类中的连接数据库方法获得数据库连接对象)
            this.getConn();
            //2.获得预处理对象(根据连接对象和SQL语句创建预处理对象)
            ps = conn.prepareStatement(sql);

            //3.设置SQL语句中?号占位符的值
            //3.1判断SQL语句中是否存在?号占位符
            // (根据params数组对象判断,该对象存在并且长度大于0表示有?号占位符)
            if (params != null && params.length != 0) {
                //3.2 SQL语句中存在?号占位符，则循环为每个?号占位符赋值
                for (int i = 0; i < params.length; i++) {
                    //通过ps.setObject()方法为不同类型的?号占位符赋值
                    ps.setObject(i + 1, params[i]);
                }
            }

            //4.执行SQL语句并返回结果
            return ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源(调用本类中释放资源方法)
            this.closeAll();
        }
        return 0;
    }

    /***
     * Object... params:可变参数，该位置的参数数量是可变的，可以为0个也可以为多个
     *                  在方法声明时可变参数必须在所有参数的最后
     *                  可变参数是数组
     */
    /**
     * 通用查询
     *
     * @param sql    SQL语句
     * @param cla    SQL语句中查询的表所对应的实体Bean的类的Class对象
     * @param params SQL语句中？号占位符的值
     * @return List集合
     */
    protected <T> List<T> executeQueryList(String sql, Class<T> cla, Object... params) {
        try {
            //1.连接数据库(调用本类中的连接数据库方法获得数据库连接对象)
            this.getConn();
            //2.获得预处理对象(根据连接对象和SQL语句创建预处理对象)
            ps = conn.prepareStatement(sql);
            //3.设置SQL语句中?号占位符的值
            //3.1判断SQL语句中是否存在?号占位符
            // (根据params数组对象判断,该对象存在并且长度大于0表示有?号占位符)
            if (params != null && params.length != 0) {
                //3.2 SQL语句中存在?号占位符，则循环为每个?号占位符赋值
                for (int i = 0; i < params.length; i++) {
                    //通过ps.setObject()方法为不同类型的?号占位符赋值
                    ps.setObject(i + 1, params[i]);
                }
            }

            //4.执行查询SQL语句，返回结果集
            rs = ps.executeQuery();
            //从结果集中获得结果集的"元数据"(元数据指：当前结果集的表结构)
            ResultSetMetaData rsmt = rs.getMetaData();
            //获得结果集中记录的总列数
            int columnCount = rsmt.getColumnCount();
            //创建用于存储结果对象的List集合
            List<T> list = new ArrayList<>();
            while (rs.next()) {

                //创建类的对象cla
                T t = cla.newInstance();

                //循环列
                for (int i = 0; i < columnCount; i++) {
                    //构建与对象中属性相对应的set方法
                    //获得set方法名
                    //获得set方法所对应的属性名(属性名和表中的列名一致)
                    String fieldName = rsmt.getColumnName(i + 1);
                    //根据属性名拼接方法名
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    //获得set方法参数的类型
                    //根据属性名获得属性对象
                    Field field = cla.getDeclaredField(fieldName);
                    //创建set方法所对应的method对象
                    Method method = cla.getDeclaredMethod(methodName, field.getType());
                    //根据列编号获得该列编号对应的数据
                    Object value = rs.getObject(i + 1);
                    //调用method方法并为t对象赋值
                    //使用ConvertUtils对value数据进行类型转换，转换为Java中属性所对应的类型
                    method.invoke(t, ConvertUtils.convert(value, field.getType()));
                }
                //将t对象添加到list集合中
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return null;
    }


    /***
     * Object... params:可变参数，该位置的参数数量是可变的，可以为0个也可以为多个
     *                  在方法声明时可变参数必须在所有参数的最后
     *                  可变参数是数组
     */
    /**
     * 通用查询(获得只有一行数据的查询)
     *
     * @param sql    SQL语句
     * @param cla    SQL语句中查询的表所对应的实体Bean的类的Class对象
     * @param params SQL语句中？号占位符的值
     * @return 单行数据封装的对象
     */
    protected <T> T executeQueryOne(String sql, Class<T> cla, Object... params) {
        try {
            //1.连接数据库(调用本类中的连接数据库方法获得数据库连接对象)
            this.getConn();
            //2.获得预处理对象(根据连接对象和SQL语句创建预处理对象)
            ps = conn.prepareStatement(sql);
            //3.设置SQL语句中?号占位符的值
            //3.1判断SQL语句中是否存在?号占位符
            // (根据params数组对象判断,该对象存在并且长度大于0表示有?号占位符)
            if (params != null && params.length != 0) {
                //3.2 SQL语句中存在?号占位符，则循环为每个?号占位符赋值
                for (int i = 0; i < params.length; i++) {
                    //通过ps.setObject()方法为不同类型的?号占位符赋值
                    ps.setObject(i + 1, params[i]);
                }
            }

            //4.执行查询SQL语句，返回结果集
            rs = ps.executeQuery();
            //从结果集中获得结果集的"元数据"(元数据指：当前结果集的表结构)
            ResultSetMetaData rsmt = rs.getMetaData();
            //获得结果集中记录的总列数
            int columnCount = rsmt.getColumnCount();

            if (rs.next()) {

                //创建类的对象cla
                T t = cla.newInstance();

                //循环列
                for (int i = 0; i < columnCount; i++) {
                    //构建与对象中属性相对应的set方法
                    //获得set方法名
                    //获得set方法所对应的属性名(属性名和表中的列名一致)
                    String fieldName = rsmt.getColumnName(i + 1);
                    //根据属性名拼接方法名
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    //获得set方法参数的类型
                    //根据属性名获得属性对象
                    Field field = cla.getDeclaredField(fieldName);
                    //创建set方法所对应的method对象
                    Method method = cla.getDeclaredMethod(methodName, field.getType());
                    //根据列编号获得该列编号对应的数据
                    Object value = rs.getObject(i + 1);
                    //调用method方法并为t对象赋值
                    //使用ConvertUtils对value数据进行类型转换，转换为Java中属性所对应的类型
                    method.invoke(t, ConvertUtils.convert(value, field.getType()));
                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return null;

    }


    protected Object executeQueryNumber(String sql, Object... params) {
        try {
            //1.连接数据库(调用本类中的连接数据库方法获得数据库连接对象)
            this.getConn();
            //2.获得预处理对象(根据连接对象和SQL语句创建预处理对象)
            ps = conn.prepareStatement(sql);
            //3.设置SQL语句中?号占位符的值
            //3.1判断SQL语句中是否存在?号占位符
            // (根据params数组对象判断,该对象存在并且长度大于0表示有?号占位符)
            if (params != null && params.length != 0) {
                //3.2 SQL语句中存在?号占位符，则循环为每个?号占位符赋值
                for (int i = 0; i < params.length; i++) {
                    //通过ps.setObject()方法为不同类型的?号占位符赋值
                    ps.setObject(i + 1, params[i]);
                }
            }

            //4.执行查询SQL语句，返回结果集
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return 0;

    }

}
