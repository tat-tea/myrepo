package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.UserInfoBean;

public class MySQLConnector {

	public void insert_user_info(String login_id, String password) {
		Connection con = null;
		Statement stmt = null;
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "admin");
			con.setAutoCommit(false);
			System.out.println("MySQLに接続できました。");

			stmt = con.createStatement();
			String sql = createInsertSQL(login_id, password);
			int ret = stmt.executeUpdate(sql);
			System.out.println("更新件数は" + ret + "です。");

			con.commit();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");

		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("Statementのクローズに失敗しました。");
				}
			}
		}
	}

	@SuppressWarnings("finally")
	public List<UserInfoBean> select_user_info(String login_id, String password) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<UserInfoBean> result = new ArrayList<UserInfoBean>();
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "admin");
			stmt = con.createStatement();
			String sql = createSelectSQL(login_id, password);
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {

					String id = rs.getString("user_id");
					String loginid = rs.getString("login_id");
					String pwd = rs.getString("password");
					UserInfoBean bean = new UserInfoBean(id, loginid, pwd);
					result.add(bean);
					bean.writeLog();
					;

				}
			}

		} catch (InstantiationException | IllegalAccessException |

				ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");

		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Resultsetのクローズに失敗しました。");
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("Statementのクローズに失敗しました。");
				}
			}

			return result;
		}
	}

	private String createInsertSQL(String login_id, String password) {

		StringBuilder builder = new StringBuilder();
		builder.append("insert into TestDB.user_info value (NULL,'");
		builder.append(login_id);
		builder.append("','");
		builder.append(password);
		builder.append("');");

		System.out.println("発行SQL：" + builder.toString());

		return builder.toString();

	}

	private String createSelectSQL(String login_id, String password) {

		StringBuilder builder = new StringBuilder();
		builder.append("select * from TestDB.user_info");
		if (login_id != null || password != null) {

			builder.append(" where ");

			if (login_id != null) {
				builder.append("login_id = '");
				builder.append(login_id);
				builder.append("'");

				if (password != null) {

					builder.append(" and ");
				}
			}

			if (password != null) {
				builder.append("password = '");
				builder.append(password);
				builder.append("'");

			}

		}
		builder.append(";");

		System.out.println("発行SQL：" + builder.toString());

		return builder.toString();

	}

}