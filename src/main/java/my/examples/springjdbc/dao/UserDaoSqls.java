package my.examples.springjdbc.dao;

public class UserDaoSqls {
	public static final String SELECT_USERS =
			"SELECT id, name, nickname, email, passwd, regdate from user limit :start, :limit";

	public static final String SELECT_USER_BY_EMAIL =
			"SELECT id, name, nickname, email, passwd, regdate from user where email = :email";

	public static final String UPDATE_USER =
			"update user set name = :name, nickname = :nickname where id = :id";
}
