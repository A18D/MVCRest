package ru.a18d.mvc.core.DB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
public class ConfigMSSQL {
    @Value("${connectionDB.login}")
    private String login;
    @Value("${connectionDB.password}")
    private String password;
    @Value("${connectionDB.nameDataBase}")
    private String nameDataBase;
    @Value("${connectionDB.server}")
    private String server;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNameDataBase(String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLogin() {

        return login.trim();
    }

    public String getPassword() {

        return password.trim();
    }

    public String getNameDataBase() {

        return nameDataBase.trim();
    }

    public String getServer() {
        return server.trim();
    }
}