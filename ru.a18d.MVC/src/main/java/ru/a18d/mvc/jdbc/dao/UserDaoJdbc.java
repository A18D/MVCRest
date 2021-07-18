package ru.a18d.mvc.jdbc.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.a18d.mvc.core.dao.UserDao;
import ru.a18d.mvc.core.objects.User;
import ru.a18d.mvc.core.sessionmanager.SessionManager;
import ru.a18d.mvc.jdbc.DbExecutorImpl;
import ru.a18d.mvc.jdbc.sessionmanager.SessionManagerJdbc;

public class UserDaoJdbc implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoJdbc.class);

    private final SessionManagerJdbc sessionManager;
    private final DbExecutorImpl<User> dbExecutor;

    public UserDaoJdbc(SessionManagerJdbc sessionManager, DbExecutorImpl<User> dbExecutor) {
        this.sessionManager = sessionManager;
        this.dbExecutor = dbExecutor;
    }

    @Override
    public Optional<User> findByName(String name) {
        try {
            return dbExecutor.executeSelect(getConnection(), "select UserID, Name, Pass, Mail from tUser where Name  = ?",
                    name, rs -> {
                        try {
                            if (rs.next()) {
                                User user = new User();
                                user.setId(rs.getInt("UserID"));
                                user.setName(rs.getString("Name"));
                                user.setPassword(rs.getString("Pass"));
                                user.setMail(rs.getString("Mail"));
                                return user;
                            }
                        } catch (SQLException e) {
                            logger.error(e.getMessage(), e);
                        }
                        return null;
                    });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    private Connection getConnection() {
        return sessionManager.getCurrentSession().getConnection();
    }
}
