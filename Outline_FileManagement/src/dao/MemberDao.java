package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import models.Member;

public class MemberDao {
	private MemberDao() {

	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public int findByUsernameAndPassword(String username, String pwd) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE USERNAME = ? AND PASSWORD = ?");

			pstmt.setString(1, username);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int save(Member member) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)");
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public Vector<Member> findByAll() {
		conn = DBConnection.getConnection();
		Vector<Member> members = new Vector<>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getLong("Id"));
				member.setUsername(rs.getString("Username"));
				member.setPwd(rs.getString("Password"));
				member.setName(rs.getString("Name"));
				member.setEmail(rs.getString("Email"));
				member.setPhone(rs.getString("Phone"));
				member.setCreateDate(rs.getTimestamp("createDate"));
				members.add(member);
			}

			return members;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void delete(int id) {

	}

}
