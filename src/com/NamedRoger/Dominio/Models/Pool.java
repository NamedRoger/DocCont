package src.com.NamedRoger.Dominio.Models;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Pool {

    public DataSource dataSource;

    public final String db = "ejemplo";
    public final String url = "jdbc:mysql:/localhost/href de la base de datos" +db+"";
    public final String user = "root";
    public final String pass = "#";

    private static DataSource dataSource;
    private BasicDataSource basicDataSource=null;

    private DataSource(){

        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);

    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException{
        return this.basicDataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
