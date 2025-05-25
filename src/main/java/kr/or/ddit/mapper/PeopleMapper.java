package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.PersonVO;

public interface PeopleMapper {
	public List<PersonVO> selectPeopleList();
	public PersonVO selectPeople(String id);
	public int insertPeople(PersonVO person);
	public int updatePeople(PersonVO person);
	public int deletePeople(String id);
}
