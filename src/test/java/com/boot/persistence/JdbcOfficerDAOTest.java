package com.boot.persistence;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.boot.persistence.dao.OfficerDAO;
import com.boot.persistence.entities.Officer;
import com.boot.persistence.entities.Rank;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class JdbcOfficerDAOTest {
	@Autowired
	@Qualifier("JdbcOfficerDAO")
    private OfficerDAO dao;
	
	@Test
	public void save() throws Exception {
	    Officer officer = new Officer(Rank.LIEUTENANT, "Nyota", "Uhuru");
	    officer = dao.save(officer);
	    assertNotNull(officer.getId());
	}
	
	@Test
	public void findByIdThatExists() throws Exception {
	    Optional<Officer> officer = dao.findById(1);
	    assertTrue(officer.isPresent());
	    assertEquals(1, officer.get().getId().intValue());
	}

	@Test
	public void findByIdThatDoesNotExist() throws Exception {
	    Optional<Officer> officer = dao.findById(999);
	    assertFalse(officer.isPresent());
	}
}
