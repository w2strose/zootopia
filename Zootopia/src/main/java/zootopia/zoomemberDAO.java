package zootopia;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class zoomemberDAO {

	// ��� ���� �Լ�
		private Connection getConnection() {// DBCP 
			
			Connection con = null;
			
			try {
				InitialContext ctx = new InitialContext();	
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
				con = ds.getConnection();
			}catch(Exception e) {
				System.out.println("Connection ����");
			}
			return con;

		}
	
		// ���̵� üũ �Լ�
		public boolean idCheck(String id) {
			boolean result = true;

			Connection con = null;
			PreparedStatement pstmt = null; // ����	
			ResultSet rs = null;

			try {
				// DB����
				con = getConnection();
				pstmt = con.prepareStatement("select * from zoomember where id=?");
				pstmt.setString(1,id);

				rs = pstmt.executeQuery();

				if(!rs.next()) result = false;

			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();}catch(SQLException s1) {}
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}

			return result;
		}
		

		// regProc�� ��� ȸ������
		public boolean memberInsert(zoomemberVO vo) {

			Connection con = null;
			PreparedStatement pstmt = null; // ���ε�����
			ResultSet rs = null;
			boolean flag = false;
			
			try {
				con = getConnection();
				
				String strQuery = "insert into zoomember values(?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getPhone1());
				pstmt.setString(5, vo.getPhone2());
				pstmt.setString(6, vo.getPhone3());
				pstmt.setString(7, vo.getEmail());
				pstmt.setString(8, vo.getBirth());
				int count = pstmt.executeUpdate();
				if(count > 0) flag = true;
				
			}catch(Exception se) {
				System.out.println("Exception " + se);
			}finally {
				if(rs != null) try {rs.close();}catch(SQLException s1) {}
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}// end of try&catch
			
			return flag;
		
		}// end of memberInsert(zoomemberVO vo)
		

		// DB���� ID/PASSWORD�� ���Ͽ� �� ����� ���������� �������ִ� �޼ҵ带 ������. 
		// 1 : �α��� ����, 0 : �α��� ����, -1 : ���̵����
		public int loginCheck(String id, String pass) {
			
			Connection con = null; // Ŀ�ؼ�
			PreparedStatement pstmt = null; //�������� 
			ResultSet rs = null; // �������
			int check = -1;
			try {
				con = getConnection();
				
				String strQuery = "select pass from zoomember where id=?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String dbPass = rs.getString("pass"); // "pass"�� DB�÷���
					if(pass.equals(dbPass)) check =1;
					else check = 0;
				}
			}catch(Exception se) {
				System.out.println("Exception " + se);
			}finally {
				if(rs != null) try {rs.close();}catch(SQLException s1) {}
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}// end of try&catch
			
			return check;
			
		}// end of loginCheck(String id, String pass)
		
		

		public zoomemberVO getMember(String id) {// student���̺� ���� �������� �޼ҵ� 
		
			Connection con = null; // Ŀ�ؼ�
			PreparedStatement pstmt = null; //�������� 
			ResultSet rs = null; // �������
			zoomemberVO vo = null;
			
			try {
				con = getConnection();
				
				String strQuery = "select * from zoomember where id=?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
		
				if(rs.next()) {// ���̵� �ش��ϴ� ȸ���� �����Ѵٸ� 
					vo = new zoomemberVO();
					vo.setId(rs.getString("id"));
					vo.setPass(rs.getString("pass"));
					vo.setName(rs.getString("name"));
					vo.setPhone1(rs.getString("phone1"));
					vo.setPhone2(rs.getString("phone2"));
					vo.setPhone3(rs.getString("phone3"));
					vo.setEmail(rs.getString("email"));
					vo.setBirth(rs.getString("birth"));
				}// end of if
		
			}catch(Exception se) {
				System.out.println("Exception " + se);
			}finally {
				if(rs != null) try {rs.close();}catch(SQLException s1) {}
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}// end of try&catch
			
			return vo;
		}// end of getMember(String id)
		
		
		// �������� ��ư Ŭ���� �����ͺ��̽��� update�� �����ؾ���.
		// ���������� ó������ �޼ҵ� �߰�.
		public void updateMember(zoomemberVO vo) {
			Connection con = null;
			PreparedStatement pstmt = null; // ���ε�����
			
			try {
				con = getConnection();
				
				String strQuery = "update zoomember set pass=?, phone1=?, phone2=?, phone3=?, email=?, birth=? where id=?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, vo.getPass());
				pstmt.setString(2, vo.getPhone1());
				pstmt.setString(3, vo.getPhone2());
				pstmt.setString(4, vo.getPhone3());
				pstmt.setString(5, vo.getEmail());
				pstmt.setString(6, vo.getBirth());
				pstmt.setString(7, vo.getId());
				
				pstmt.executeUpdate();
			}catch(Exception se) {
				System.out.println("Exception " + se);
			}finally {
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}// end of try&catch
			
		}// end of updateMember(StudentVO vo)
		

		// Ż���ư�� Ŭ���ϸ�, ������ �����ͺ��̽����� ȸ�������Ͱ� �����Ǿ����.
		// DB���� ȸ�������� ó������ �޼ҵ� �߰�
		public int deleteMember(String id, String pass) {
			
			Connection con = null; // Ŀ�ؼ�
			PreparedStatement pstmt = null; //�������� 
			ResultSet rs = null; // �������
		
			String dbPass=""; // ���� DB�� ����� ��й�ȣ
			int result = -1;
			try {
				con= getConnection();
				String strQuery ="select pass from zoomember where id=?";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dbPass = rs.getString("pass");
					if(dbPass.equals(pass)) {
						pstmt = con.prepareStatement("delete from zoomember where id=?");
						pstmt.setString(1,id);
						pstmt.executeUpdate();
						result=1; // ȸ��Ż�� ����
					}else {
						result=0;// ��й�ȣ ����
					}
				}
			}catch(Exception se) {
				System.out.println("Exception " + se);
			}finally {
				if(rs != null) try {rs.close();}catch(SQLException s1) {}
				if(pstmt != null) try {pstmt.close();}catch(SQLException s1) {}
				if(con != null) try {con.close();}catch(SQLException s1) {}
			}// end of try&catch
		
			return result;
		
		}// end of deleteMamber(String id, String pass) 
		
		
		
}
