package ru.a18d.mvc.objects;

public class User {
    private String name;
    private String password;

    private boolean admin;

    public User() {
        name = "";
        password = "";
        admin = false;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }
}
