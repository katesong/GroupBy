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

import GroupBy.GroupBy.bean.Member;

public class MemberController {
	private Connection conn = null;
	private DataSource ds = null;

	public MemberController() throws NamingException {
		InitialContext context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/GroupBy");
	}
	
	public List<Member> findAll() {
	
		List<Member> Members = new ArrayList<Member>();
		PreparedStatement pstemt = null;
		try {
			conn = ds.getConnection();
			String stmt = "Select * from member";
			pstemt = conn.prepareStatement(stmt);
			ResultSet rs = pstemt.executeQuery();
			while (rs.next()) {
				Member Member = new Member();
				Member.setId(rs.getLong(1));
				Member.setFirstName(rs.getString(2));
				Member.setLastName(rs.getString(3));
				Member.setBirthDate(rs.getDate(4));
				Member.setSex(rs.getString(5));
				Member.setPhone(rs.getInt(6));
				Member.setEmail(rs.getString(7));
				Member.setUserName(rs.getString(8));
				Member.setPassword(rs.getString(9));
				Members.add(Member);			
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

		return Members;

	}
	
	public Member findById(int id){
		String str="Select * from member where memberId=?";
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setInt(1,id);
			ResultSet rs=pstm.executeQuery();
			Member Member =new Member();
			while(rs.next()){
				Long lid=new Long((long) id);
				Member.setId(lid);
				Member.setFirstName(rs.getString(2));
				Member.setLastName(rs.getString(3));
				Member.setBirthDate(rs.getDate(4));
				Member.setSex(rs.getString(5));
				Member.setPhone(rs.getInt(6));
				Member.setEmail(rs.getString(7));
				Member.setUserName(rs.getString(8));
				Member.setPassword(rs.getString(9));
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
			
			return Member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(Member Member){
		String str="insert into member (firstName,lastName,birthDate,sex,phone,email,username,password) values(?,?,?,?,?,?,?,?)";
		int rs=0;
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(str);
			
			pstm.setString(1, Member.getFirstName());
			pstm.setString(2, Member.getLastName());
			pstm.setDate(3, Member.getBirthDate());
			pstm.setString(4, Member.getSex());
			pstm.setInt(5, Member.getPhone());
			pstm.setString(6, Member.getEmail());
			pstm.setString(7, Member.getUserName());
			pstm.setString(8, Member.getPassword());
			rs = pstm.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public int update(Member Member){
		String str="Update member set firstName=?,lastName=?,birthDate=?,sex=?,phone=?,email=?,username=?,password=? where memberId=?";
		int rs=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setString(1, Member.getFirstName());
			pstm.setString(2, Member.getLastName());
			pstm.setDate(3, Member.getBirthDate());
			pstm.setString(4, Member.getSex());
			pstm.setInt(5, Member.getPhone());
			pstm.setString(6, Member.getEmail());
			pstm.setString(7, Member.getUserName());
			pstm.setString(8, Member.getPassword());
			pstm.setLong(9, Member.getId());
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
	
	public int delete(int id){
		String str="Delete form member where memberId=?";
		int rs=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setLong(1,id);
			rs = pstm.executeUpdate();
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
