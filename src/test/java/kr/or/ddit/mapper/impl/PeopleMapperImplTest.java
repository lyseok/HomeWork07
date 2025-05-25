package kr.or.ddit.mapper.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.PeopleMapper;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PeopleMapperImplTest {
	PeopleMapper mapper = new PeopleMapperImpl();
	
	@Test
	void testSelectPeopleList() {
		mapper.selectPeopleList()
				.forEach((people) -> log.info("people : {} {} ", people.getName(), people.getAge()));
	}
	
	@Test
	void testSelectPeople() {
		PersonVO person = mapper.selectPeople("V0014");
		log.info("people : {} {} ", person.getName(), person.getAge());
		
	}
	
	@Test
	void testInsertPeople() {
		PersonVO person = new PersonVO();
		person.setId("test");
		person.setName("testname");
		person.setGender("F");
		person.setAge(33);
		person.setAddress("TestAddress");
		assertEquals(1, mapper.insertPeople(person));
	}
	
	@Test
	void testUpdatePeople() {
		PersonVO person = new PersonVO();
		person.setId("test");
		person.setName("updatename");
		person.setGender("M");
		person.setAge(34);
		person.setAddress("UpdateAddress");
		assertEquals(1, mapper.updatePeople(person));
	}
	
	@Test
	void testDeletePerson() {
		assertEquals(1, mapper.deletePeople("test"));
	}

}
