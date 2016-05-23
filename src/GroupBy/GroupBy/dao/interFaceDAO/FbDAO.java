package GroupBy.GroupBy.dao.interFaceDAO;

import java.util.List;

import GroupBy.GroupBy.bean.Fb;


public interface FbDAO {
	public List<Fb> findAll();
	public Fb findById(int id);
	public int insert(Fb fb);
	public int update(Fb fb);
	public int delete(Long id);
}
