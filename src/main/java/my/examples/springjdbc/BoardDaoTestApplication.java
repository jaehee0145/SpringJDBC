package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardDaoTestApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        BoardDao boardDao = applicationContext.getBean(BoardDao.class);
//        int boardCount = boardDao.getBoardCount();
//        System.out.println(boardCount);

        Board board =
                boardDao.getBoard(16L);
        System.out.println(board);
    }
}
