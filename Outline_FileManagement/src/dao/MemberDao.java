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

	public int findByUsernameAndPassword(String Id, String pwd) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?");
			pstmt.setString(1, Id);
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

	public int findIdByPhone(String Name, String Phone1, String Phone2) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE NAME = ? AND PHONE1 = ? AND PHONE2 = ?");
			pstmt.setString(1, Name);
			pstmt.setString(2, Phone1);
			pstmt.setString(3, Phone2);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int findIdByEmail(String Email) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE Email = ?");
			pstmt.setString(1, Email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int findPwd(String Name, String Phone1, String Phone2, String Id, String Email) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM MEMBER WHERE NAME = ? AND PHONE1 = ? AND PHONE2 = ? AND ID = ? AND EMAIL = ?");
			pstmt.setString(1, Name);
			pstmt.setString(2, Phone1);
			pstmt.setString(3, Phone2);
			pstmt.setString(4, Id);
			pstmt.setString(5, Email);

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
			pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, SYSDATE)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone1());
			pstmt.setString(5, member.getPhone2());
			pstmt.setString(6, member.getEmail());
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
				member.setId(rs.getString("Id"));
				member.setPwd(rs.getString("Password"));
				member.setName(rs.getString("Name"));
				member.setPhone1(rs.getString("Phone1"));
				member.setPhone2(rs.getString("Phone2"));
				member.setEmail(rs.getString("Email"));
				member.setCreateDate(rs.getTimestamp("createDate"));
				members.add(member);
			}

			return members;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
