package ru.a18d.mvc.core.DB;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DataSourceMSSQL implements DataSource {
    private final String URL;

    public DataSourceMSSQL() {
        ConfigMSSQL prop = Config.getPropertiesMSSQL();
        URL = "jdbc:sqlserver:" + prop.getServer() + ";"
                + "database=" + prop.getNameDataBase() + ";"
                + "user=" + prop.getLogin() + ";"
                + "password=" + prop.getPassword() + ";"
                + "trustServerCertificate=false;"
                + "loginTimeout=30";
    }

    @Override
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        Connection connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    @Override
    public PrintWriter getLogWriter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLogWriter(PrintWriter out) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int getLoginTimeout() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLoginTimeout(int seconds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getParentLogger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        throw new UnsupportedOperationException();
    }

}
