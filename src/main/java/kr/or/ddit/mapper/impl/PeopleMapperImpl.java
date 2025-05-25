package kr.or.ddit.mapper.impl;

import java.util.List;

import kr.or.ddit.mapper.PeopleMapper;
import kr.or.ddit.mapper.util.MapperProxyTemplate;
import kr.or.ddit.vo.PersonVO;

public class PeopleMapperImpl implements PeopleMapper{
	private MapperProxyTemplate<PeopleMapper> template = new MapperProxyTemplate<PeopleMapper>(PeopleMapper.class);
	
	@Override
	public List<PersonVO> selectPeopleList() {
		return template.execute(mp -> mp.selectPeopleList());
	}

	@Override
	public PersonVO selectPeople(String id) {
		return template.execute(mp -> mp.selectPeople(id));
	}

	@Override
	public int insertPeople(PersonVO person) {
		return template.execute(mp -> mp.insertPeople(person));
	}

	@Override
	public int updatePeople(PersonVO person) {
		return template.execute(mp -> mp.updatePeople(person));
	}

	@Override
	public int deletePeople(String id) {
		return template.execute(mp -> mp.deletePeople(id));
	}

}
