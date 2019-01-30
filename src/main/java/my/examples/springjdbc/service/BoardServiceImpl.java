package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int page) {
        int start = 5* page -5;

        return boardDao.selectByPage(start, 5);
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        boardDao.updateReadCount(id);
        return boardDao.getBoard(id);
    }

    @Override
    @Transactional
    public Board getBoardForModify(Long id) {
        return boardDao.getBoard(id);
    }

    @Override
    @Transactional
    public void modifyBoard(Long id, String title, String content) {
        boardDao.modifyBoard(id, title, content);
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
//        Long id = boardDao.addBoard(board);
//        board.setId(id);
//        return board;
        boardDao.addBoard(board);
        Long lastInsertId = boardDao.getLastInsertId();
        boardDao.updateLastInsertId(lastInsertId);

        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        boardDao.deleteBoard(id);
    }
}
