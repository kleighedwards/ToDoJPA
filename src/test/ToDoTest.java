package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.ToDo;

public class ToDoTest {
	
	private EntityManagerFactory emf;
    private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.
	            createEntityManagerFactory("JPAToDo");
	    em = emf.createEntityManager();
	}

	@Test
	public void test() {
		ToDo todo = em.find(ToDo.class, 1);
		
		assertEquals("Get Milk", todo.getTask());
		assertEquals(false, todo.getCompleted());
		
		assertEquals("test", todo.getUser().getUsername());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
        emf.close();
	}


}
