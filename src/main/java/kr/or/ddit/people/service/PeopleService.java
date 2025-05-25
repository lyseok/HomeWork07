package kr.or.ddit.people.service;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.vo.PersonVO;

public interface PeopleService {
	public List<PersonVO> readPersonList();
	public Optional<PersonVO> readPerson(String id);
	public void createPerson(PersonVO person);
	public void modifyPerson(PersonVO person);
	public void removePerson(String id);
}
