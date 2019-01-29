package my.examples.springjdbc.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Long id;
    private Long userId;
    private String nickname;
    private String title;
    private String content;
    private String name;
    private Date regdate;
    private int readCount;
    private int groupNo;
    private int groupSeq;
    private int groupDepth;

    public Board(){
        this.regdate = new Date();
        this.readCount = 0;
    }

    public Board(String title, String content, String name) {
        this();
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public Board(Long id, String title, String content, String name, Date regdate, int readCount) {
        this(title, content, name);
        this.id = id;
        this.regdate = regdate;
        this.readCount = readCount;
    }


}
