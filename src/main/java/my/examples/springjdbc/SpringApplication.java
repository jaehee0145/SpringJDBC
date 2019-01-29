package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dao.UserDaoImpl;
import my.examples.springjdbc.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);
//        List<User> users = userDao.selectByPage();
//        for(User user : users){
//            System.out.println(user);
//        }
//        User user = userDao.selectUserByEmail("urstory2@gmail.com");
//        System.out.println(user);

//        User user = new User();
//        user.setName("홍길동");
//        user.setEmail("hong@hong.com");
//        user.setNickname("hong");
//        user.setPasswd("1324");
//        long id = userDao.addUser(user);
//        System.out.println(id);

        userDao.updateUser(8L, "고길동", "둘리아빠");
    }
}
