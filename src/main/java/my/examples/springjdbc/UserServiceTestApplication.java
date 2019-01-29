package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTestApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService.getClass().getName());
        User user = new User();
        user.setName("hong");
        user.setEmail("h@hong.com");
        user.setNickname("hong");
        user.setPasswd("1324");
        user = userService.addUser(user);
        System.out.println(user);
    }
}
