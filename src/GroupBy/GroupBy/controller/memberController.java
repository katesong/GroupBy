package GroupBy.GroupBy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import GroupBy.GroupBy.bean.member;

public class memberController {
	private Connection conn = null;
	private DataSource ds = null;

	public memberController() throws NamingException {
		InitialContext context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/GroupBy");
	}
	
	public List<member> findAll() {
	
		List<member> members = new ArrayList<member>();
		PreparedStatement pstemt = null;
		try {
			conn = ds.getConnection();
			String stmt = "Select * from member";
			pstemt = conn.prepareStatement(stmt);
			ResultSet rs = pstemt.executeQuery();
			while (rs.next()) {
				member member = new member();
				member.setId(rs.getLong(1));
				member.setFirstName(rs.getString(2));
				member.setLastName(rs.getString(3));
				member.setBirthDate(rs.getDate(4));
				member.setSex(rs.getString(5));
				member.setPhone(rs.getInt(6));
				member.setEmail(rs.getString(7));
				member.setUserName(rs.getString(8));
				member.setPassword(rs.getString(9));
				members.add(member);			
			}
			try {
				if (pstemt != null) {
					pstemt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
		}

		return members;

	}
	
	public member findById(int id) throws SQLException{
		String str="Select * from member where memberId=?";
		conn = ds.getConnection();
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setInt(1,id);
			ResultSet rs=pstm.executeQuery();
			member member =new member();
			while(rs.next()){
				Long lid=new Long((long) id);
				member.setId(lid);
				member.setFirstName(rs.getString(2));
				member.setLastName(rs.getString(3));
				member.setBirthDate(rs.getDate(4));
				member.setSex(rs.getString(5));
				member.setPhone(rs.getInt(6));
				member.setEmail(rs.getString(7));
				member.setUserName(rs.getString(8));
				member.setPassword(rs.getString(9));
			}
			try {
				if(pstm!=null){
				pstm.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {if(conn!=null){
				conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public int insert2() throws SQLException{
//		conn = ds.getConnection();
//		String str = "insert into member (firstName,lastName,birthDate,sex,phone,email,username,password) values('kate','huang','2010/02/04','fmale','1233','222@gmail.com','224','123')";
//		PreparedStatement pstmt = null;
//		int rs = 0;
//		try {System.out.println(conn);
//			pstmt = conn.prepareStatement(str);
//			
//			rs = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if (pstmt !=null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			}
//		}
//		
//		return rs;
//		
//		
//	}
//	
	public int insert(member member) throws SQLException{
		String str="insert into member (firstName,lastName,birthDate,sex,phone,email,username,password) values(?,?,?,?,?,?,?,?)";
		int rs=0;
		conn = ds.getConnection();
		PreparedStatement pstm=null;
		try {
//			pstm=conn.prepareStatement(str);
//			
//			pstm.setString(1, Member.getFirstName());
//			pstm.setString(2, Member.getLastName());
//			pstm.setDate(3, Member.getBirthDate());
//			pstm.setString(4, Member.getSex());
//			pstm.setInt(5, Member.getPhone());
//			pstm.setString(6, Member.getEmail());
//			pstm.setString(7, Member.getUserName());
//			pstm.setString(8, Member.getPassword());
//			rs = pstm.executeUpdate();
//			
			System.out.println("aaaa");
		}finally{
			try {if(pstm!=null){
				pstm.close();}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			try {if(conn!=null){
				conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	public int update(member member) throws SQLException{
		String str="Update member set firstName=?,lastName=?,birthDate=?,sex=?,phone=?,email=?,username=?,password=? where memberId=?";
		int rs=0;
		conn = ds.getConnection();
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setString(1, member.getFirstName());
			pstm.setString(2, member.getLastName());
			pstm.setDate(3, member.getBirthDate());
			pstm.setString(4, member.getSex());
			pstm.setInt(5, member.getPhone());
			pstm.setString(6, member.getEmail());
			pstm.setString(7, member.getUserName());
			pstm.setString(8, member.getPassword());
			pstm.setLong(9, member.getId());
			rs = pstm.executeUpdate();
			try {if(pstm!=null){
				pstm.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {if(conn!=null){
				conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int delete(Long id){
		String str="Delete form member where memberId=?";
		int rs=0;
		
		try {
			conn = ds.getConnection();
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setLong(1,id);
			pstm.execute();
			try {
				if(pstm!=null){
				pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
}
