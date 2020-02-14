package fun.ticsmyc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 测试jdbc
 */
public class JDBCTest {
   //表已建好 2019cov tb_user
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;

        try {
            // 加载驱动
            //调用froName("x")会初始化名为x的类
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库连接
            String url = "jdbc:mysql://127.0.0.1:3306/2019ncov";
            String user = "root";
            String password = "root";
            //建立连接
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql1 = "select * from tb_user where id=?";
            String sql = "select * from tb_user where email=?";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
            prepareStatement.setLong(1, 1);
            // 执行查询
            rs = prepareStatement.executeQuery();
            // 处理结果集
            while (rs.next()) {
                System.out.println("用户名："+rs.getString("userName"));
                System.out.println("密码为："+rs.getString("password"));
            }
        } finally {
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
