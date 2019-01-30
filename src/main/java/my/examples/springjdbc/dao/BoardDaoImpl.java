package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.examples.springjdbc.dao.BoardDaoSqls.*;

@Repository
public class BoardDaoImpl implements BoardDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardDaoImpl(DataSource dataSource) {
        jdbc = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Board getBoard(Long id) {
        Board board = null;
        try {
            Map<String, Object> paramMap =
                    Collections.singletonMap("id", id);
            board = jdbc.queryForObject(SELECT_BY_ID, paramMap, rowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        return null;
    }

    @Override
    public Board addBoard(Board board) {
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("userId", board.getUserId());
        paramMap.put("title", board.getTitle());
        paramMap.put("content", board.getContent());
        paramMap.put("nickname", board.getNickname());

        jdbc.update(INSERT, paramMap);
        return board;
    }

    @Override
    public Long getLastInsertId() {
        Map emptyMap = Collections.emptyMap();
        Long lastId = jdbc.queryForObject(SELECT_LAST_INSERT_ID, emptyMap, Long.class);
        return lastId;
    }

    @Override
    public void updateLastInsertId(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("groupNo", id);
        paramMap.put("id", id);
        jdbc.update(UPDATE_LAST_INSERT_ID, paramMap);
    }

    @Override
    public void deleteBoard(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbc.update(DELETE, paramMap);
    }

    @Override
    public void modifyBoard(Long id, String title, String content) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("title", title);
        paramMap.put("content", content);
        jdbc.update(MODIFY, paramMap);
    }

    @Override
    public void updateReadCount(long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbc.update(UPDATE, paramMap);
    }

    @Override
    public void updateGroupSeqGt(int groupNo, int groupSeq) {

    }

    @Override
    public void addReBoard(Board board) {

    }

    @Override
    public int getBoardCount() {
        Map emptyMap = Collections.emptyMap();
        int count = jdbc.queryForObject("select count(*) from board", emptyMap, Integer.class);
        return count;
    }

    @Override
    public List<Board> selectByPage(int start, int limit) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("start", start);
        paramMap.put("limit", limit);

        return jdbc.query(SELECT_BY_PAGING, paramMap, rowMapper);
    }
}
