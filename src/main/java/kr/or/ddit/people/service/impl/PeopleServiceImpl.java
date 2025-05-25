package kr.or.ddit.people.service.impl;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.mapper.PeopleMapper;
import kr.or.ddit.mapper.impl.PeopleMapperImpl;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.vo.PersonVO;

public class PeopleServiceImpl implements PeopleService{
	PeopleMapper mapper = new PeopleMapperImpl();
	
	@Override
	public List<PersonVO> readPersonList() {
		return mapper.selectPeopleList();
	}

	@Override
	public Optional<PersonVO> readPerson(String id) {
		return Optional.ofNullable(mapper.selectPeople(id));
	}

	@Override
	public void createPerson(PersonVO person) {
		mapper.insertPeople(person);		
	}

	@Override
	public void modifyPerson(PersonVO person) {
		mapper.updatePeople(person);		
	}

	@Override
	public void removePerson(String id) {
		mapper.deletePeople(id);		
	}

}
