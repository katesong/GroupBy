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

import GroupBy.GroupBy.bean.Event;
import GroupBy.GroupBy.dao.interFaceDAO.EventDAO;

public class EventJNDIDAO implements EventDAO {
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
	public List<Event> findAll() {
		List<Event> events=new ArrayList<Event>();
		
		String src="Select * from event ";
		try {
			PreparedStatement pstm=conn.prepareStatement(src);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Event event=new Event();
				event.setEventId(rs.getLong(1));
				event.setNemberId(rs.getLong(2));
				event.setLocal(rs.getString(3));
				//給瑜瑜
				
				rs.getString(3);
			}
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events;
	}

	@Override
	public Event findById(int id) {
		return null;
	}

	@Override
	public int insert(Event event) {
		return 0;
	}

	@Override
	public int update(Event event) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		return 0;
	}

}
