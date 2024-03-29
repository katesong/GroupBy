package GroupBy.GroupBy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import GroupBy.GroupBy.bean.Photo;
import GroupBy.GroupBy.dao.interFaceDAO.PhotoDAO;

public class PhotoJNDIDAO implements PhotoDAO {
	private Connection conn = null;
	private DataSource ds = null;

	public PhotoJNDIDAO() throws NamingException {
		InitialContext context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/GroupBy");

	}

	public List<Photo> findAll()  {

		List<Photo> Photos = new ArrayList<Photo>();
		PreparedStatement pstemt = null;
		try {
			conn = ds.getConnection();
			String stmt = "Select * from photo";
			pstemt = conn.prepareStatement(stmt);
			ResultSet rs = pstemt.executeQuery();
			while (rs.next()) {
				Photo ph = new Photo();
				ph.setPhotoId(rs.getInt(1));
				ph.setPhoto(rs.getBytes(2));
				Photos.add(ph);
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

		return Photos;

	}

	public Photo findById(int id)  {
		Photo ph = new Photo();
		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement pstemt = null;
			String str = "Select * from photo where photoId=?";
			pstemt = conn.prepareStatement(str);
			ResultSet rs = pstemt.executeQuery();
			while (rs.next()) {
				ph.setPhotoId(rs.getInt(1));
				ph.setPhoto(rs.getBytes(2));
			}
			try {
				if (pstemt != null) {
					pstemt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ph;
	}
	
	public String photoAdd(Photo ph){
		String str="Insert into photo value(?,?)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int rs=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setInt(1, ph.getPhotoId());
			pstm.setBytes(2, ph.getPhoto());
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
		
				return "Sucess insert "+rs+" datas";
	}
	
	public int upDate(Photo ph){
		String str="Updata photo set photo=? where photoId=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int rs=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setBytes(1, ph.getPhoto());
			pstm.setInt(1, ph.getPhotoId());
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
	
	public int delete(int id){
		String str="Delete form photo where id=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int rs=0;
		try {
			PreparedStatement pstm=conn.prepareStatement(str);
			pstm.setInt(1,id);
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
