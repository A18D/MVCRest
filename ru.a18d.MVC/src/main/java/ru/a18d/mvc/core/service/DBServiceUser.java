package ru.a18d.mvc.core.service;

import ru.a18d.mvc.core.objects.User;

import java.util.Optional;

public interface DBServiceUser {
    Optional<User> getUserByName(String name);
}
