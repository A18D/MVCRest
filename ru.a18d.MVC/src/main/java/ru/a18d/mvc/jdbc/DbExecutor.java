package ru.a18d.mvc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface DbExecutor<T> {
    Optional<T> executeSelect(Connection connection, String sql, String name, Function<ResultSet, T> rsHandler) throws SQLException;
}
