package DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUtil {
    private PreparedStatement preparedStatement =null;

    private ConnectionUtil connectionUtil=null;
    private String sql;
    //无参构造方法
    public PreparedStatementUtil(){}
    //有参构造方法
    public PreparedStatementUtil(String sql){
        this.sql=sql;
    }
    //初始化 preparedStatement ，connectionUtil
    public void init(String connectionUrl){
        this.connectionUtil = new ConnectionUtil(connectionUrl);
        connectionUtil.ConnectToDataBase();
        Connection connection = connectionUtil.getConnection();
        try {
            this.preparedStatement= connection.prepareStatement(this.sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭资源连接
    public void close(){
        if (connectionUtil == null){
            System.out.println("connectionUtil == null");
            return;
        }
        connectionUtil.close();
        if (preparedStatement == null){
            System.out.println("preparedStatement == null");
            return;
        }
        try {
            preparedStatement.close();
            System.out.println("preparedStatement.close()");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取 preparedStatement
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
}
