package GroupBy.GroupBy.dao.interFaceDAO;

import java.util.List;

import GroupBy.GroupBy.bean.Photo;

public interface PhotoDAO {
	public List<Photo> findAll() ;
	public Photo findById(int id);
	public String photoAdd(Photo ph);
	public int upDate(Photo ph);
	public int delete(int id);
	
}
