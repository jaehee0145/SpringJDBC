package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //    @Autowired
    private UserDao userDao;

    // UserServiceImpl객체를 생성하려고 UserDaoImpl 객체를 주입한다.
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 서비스 메소드는 트랜젝션 단위로 동작한다.
    // 트랜젝션 단위로 동작하려면 @Transactional 어노테이션이 붙는다.
    // RuntimeException이 발생하면 자동 rollback한다.
    // 성공하면 commit한다.
    @Override
    @Transactional
    public User addUser(User user) {

//        Long id = userDao.addUser(user);
//        user.setId(id);
            userDao.addUser(user);

        return user;
    }

    // 서비스 메소드 안에서 조회만 있을 경우엔 @Transactional(readOnly=true)
    // 를 설정한다.
    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers(int page) {
        int start = page * 3 - 3;
        return userDao.selectByPage(start, 3);
    }
}
