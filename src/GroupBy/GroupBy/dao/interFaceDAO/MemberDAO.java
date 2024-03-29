package GroupBy.GroupBy.dao.interFaceDAO;

import java.sql.SQLException;
import java.util.List;

import GroupBy.GroupBy.bean.Member;


public interface MemberDAO {
	public List<Member> findAll();
	public Member findById(int id);
	public int insert(Member Member);
	public int update(Member Member);
	public int delete(Long id);
	

}
