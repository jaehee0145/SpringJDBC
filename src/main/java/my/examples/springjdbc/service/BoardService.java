package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardService {

    public List<Board> getBoards(int page);

    public Board getBoard(Long id);

    Board addBoard(Board board);

    void deleteBoard(Long id);

    void modifyBoard(Long id, String title, String content);

    Board getBoardForModify(Long id);
}
