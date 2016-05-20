package GroupBy.GroupBy.service;

import java.util.ArrayList;
import java.util.List;

import GroupBy.GroupBy.bean.Member;
import GroupBy.GroupBy.dao.MemberJNDIDAO;

public class MemberService {
	private MemberJNDIDAO dao;

	public List<Member> findAll() {
		List<Member> members = new ArrayList<Member>();
		members = dao.findAll();
		return members;
	}

	public Member findById(int i) {
		Member member = dao.findById(i);
		return member;
	}

	public boolean insert(Member member) {
		try {
			dao.insert(member);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean update(Member member) {
		try {
			dao.update(member);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delete(int i){
		try{
			Long j=Long.valueOf(i);
			dao.delete(j);
		return true;
		}catch(Exception e){
			return false;
		}
	}
}
