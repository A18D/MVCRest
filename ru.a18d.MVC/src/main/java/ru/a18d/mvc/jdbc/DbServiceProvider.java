package ru.a18d.mvc.jdbc;

import java.util.Optional;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.a18d.mvc.core.DB.DataSourceMSSQL;
import ru.a18d.mvc.core.objects.User;
import ru.a18d.mvc.core.service.DbServiceUserImpl;
import ru.a18d.mvc.jdbc.dao.UserDaoJdbc;
import ru.a18d.mvc.jdbc.sessionmanager.SessionManagerJdbc;

public class DbServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(DbServiceProvider.class);

    public static void main(String[] args) throws Exception {
        User user = getUserByName("Petr");
        System.out.println(user);
    }

    public static User getUserByName(String name) throws Exception {
        DataSource dataSource = new DataSourceMSSQL();
        SessionManagerJdbc sessionManager = new SessionManagerJdbc(dataSource);
        DbExecutorImpl<User> dbExecutor = new DbExecutorImpl<>();
        UserDaoJdbc userDao = new UserDaoJdbc(sessionManager, dbExecutor);

        DbServiceUserImpl dbServiceUser = new DbServiceUserImpl(userDao);
        Optional<User> userOptional = dbServiceUser.getUserByName(name);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        else {
            user = new User();
        }

        return user;
    }
}
