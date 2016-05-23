package GroupBy.GroupBy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import GroupBy.GroupBy.bean.Fb;
import GroupBy.GroupBy.dao.interFaceDAO.FbDAO;

public class FbDAOJNDIDAO implements FbDAO{
	private static Connection conn = null;
	private static DataSource ds = null;
	static{
		try {
			InitialContext context = new InitialContext();	
			ds = (DataSource) context.lookup("java:comp/env/jdbc/GroupBy");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Fb> findAll() {
		List<Fb> Fbs = new ArrayList<Fb>();
		try {
			String str="Select * from fb";
			Fbs = new ArrayList<Fb>();
			PreparedStatement pstm=conn.prepareStatement(str);
			
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Fbs;
	}
	@Override
	public Fb findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(Fb fb) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(Fb fb) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
