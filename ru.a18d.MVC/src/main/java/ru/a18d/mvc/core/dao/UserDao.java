package ru.a18d.mvc.core.dao;

import java.util.Optional;

import ru.a18d.mvc.core.objects.User;
import ru.a18d.mvc.core.sessionmanager.SessionManager;

public interface UserDao {
    Optional<User> findByName(String name);

    SessionManager getSessionManager();
}
