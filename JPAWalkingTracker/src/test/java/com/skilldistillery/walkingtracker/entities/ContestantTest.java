package com.skilldistillery.walkingtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContestantTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Contestant contestant;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAWalkingTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		contestant = em.find(Contestant.class,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		contestant = null;
	}

	@Test
	void test_PostEntityMapping() {
		assertNotNull(contestant);
		assertEquals("John", contestant.getName());
		assertEquals(1, contestant.getId());
	}
}
