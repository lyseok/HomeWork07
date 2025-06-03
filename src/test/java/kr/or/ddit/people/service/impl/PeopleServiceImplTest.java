package kr.or.ddit.people.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.conf.AppConfig;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.vo.PersonVO;

@SpringJUnitConfig(AppConfig.class)
class PeopleServiceImplTest {

	@Autowired
	private PeopleService service;
	
	@Test
	void testReadPersonList() {
		List<PersonVO> list = service.readPersonList();
		
	}

	@Test
	void testReadPerson() {
		fail("Not yet implemented");
	}

	@Test
	void testCreatePerson() {
		fail("Not yet implemented");
	}

	@Test
	void testModifyPerson() {
		fail("Not yet implemented");
	}

	@Test
	void testRemovePerson() {
		fail("Not yet implemented");
	}

	@Test
	void testPeopleServiceImpl() {
		fail("Not yet implemented");
	}

}
