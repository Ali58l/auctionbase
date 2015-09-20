package service;

import java.util.List;

import model.dao.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

	
@Service
public class PersonService {
	   
	  // An EntityManager will be automatically injected from EntityManagerFactory setup on
	  // spring-context.xml
	  @PersistenceContext
	  private EntityManager em;
	   
	  // Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
	  // any bean method annotated with @Transactional will cause Spring to magically call
	  // begin() and commit() at the start/end of the method. If exception occurs it will also
	  // call rollback()
	  @Transactional
	  public List<Person> getAll() {
	    List<Person> result = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	    return result;
	  }
	   
	  @Transactional
	  public void add(Person p) {
	    em.persist(p);
	  }
	  
	  @Transactional
	  public Person findPerson(int id) {
	    Person person = em.find(Person.class,id);
	    
	    return person;
	  }
	@Transactional
	public Person findPersonByUsernameAndPassword(String username,String password) {

		Person person = null;
		try{
		person = new Person();
        try {
        	Query personQuery = em.createQuery("Select p from Person p where p.username = :username and"
    				+ " p.password = :password and p.isActive = :isActive");
        	personQuery.setParameter("username", username);
        	personQuery.setParameter("password", password);
        	personQuery.setParameter("isActive", true);
        	
        	
    		person = (Person) personQuery.getResultList().get(0);
        } finally {
        }
		
		return person;
				
		}
		catch(Exception ex){
			System.out.println(ex.getMessage()+"hi");
			
			return person;
		}
		
	}
}
