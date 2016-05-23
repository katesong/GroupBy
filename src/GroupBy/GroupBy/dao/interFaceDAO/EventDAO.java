package GroupBy.GroupBy.dao.interFaceDAO;

import java.util.List;

import GroupBy.GroupBy.bean.Event;

public interface EventDAO {
	public List<Event> findAll();
	public Event findById(int id);
	public int insert(Event event);
	public int update(Event event);
	public int delete(Long id);
}
