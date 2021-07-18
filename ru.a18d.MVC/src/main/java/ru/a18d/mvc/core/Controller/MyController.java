package ru.a18d.mvc.core.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.a18d.mvc.core.objects.User;
import ru.a18d.mvc.jdbc.DbServiceProvider;


@Controller
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @RequestMapping(value = "/get-json-user/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("name") String name) {
        logger.debug("getJsonUser. argument :" + name);
        User user = null;

        try {
            user = DbServiceProvider.getUserByName(name);
        } catch (Exception e) {
            logger.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }
}