package my.examples.springjdbc.dao;

public class BoardDaoSqls {
    public static final String SELECT_BY_ID =
            "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth, content from board where id = :id";
    public static final String SELECT_BY_PAGING =
            "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth  from board b order by group_no desc, group_seq limit :start, :limit";
    public static final String INSERT =
            "insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) values( :title, :userId, :nickname, :content ,  0 , 0, 0 )";
    public static final String SELECT_LAST_INSERT_ID =
            "select LAST_INSERT_ID()";
    public static final String UPDATE_LAST_INSERT_ID =
            "update board set group_no = :groupNo where id = :id";
    public static final String UPDATE =
            "update board set read_count = read_count + 1 where id = :id";
    public static final String DELETE =
            "delete from board where id = :id";
    public static final String UPDATE_GROUP_SEQ_GT =
            "update board set group_seq = group_seq + 1 where group_no = :groupNo and group_seq > :groupSeq";

    public static final String MODIFY = "UPDATE board SET title=:title, content=:content where id =:id";


}
