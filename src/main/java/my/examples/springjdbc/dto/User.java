package my.examples.springjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String passwd;
    private Date regdate;

    public User() {
    }

    public User(String name, String nickname, String email, String passwd) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.passwd = passwd;
    }
}
