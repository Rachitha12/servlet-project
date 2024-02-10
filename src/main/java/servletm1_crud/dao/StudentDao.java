package servletm1_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servletm1_crud.dto.StudentDto;

public class StudentDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	 public String insert(StudentDto s) 
	    {
	    et.begin();
	    em.persist(s);
	    et.commit();
	    return "data inserted successfully";
	    }

	 
	 public Object fetchbyid(int id) 
	 {
		 StudentDto dto =em.find(StudentDto.class,id);
		 if(dto!=null)
		 {
			 return dto;
	 
		 }
         else
			 return "no data found" ;	 

	 }

  public List<StudentDto> fetchall()
{ 
	Query q = em.createQuery("select e from StudentDto e");
	List<StudentDto> list=q.getResultList();
	System.out.println(list);
	if (list.isEmpty()) {
		return null;
		
	}
	else
		return list;
			
}
  
	 public String deletebyid(int id) 
	 {
		 StudentDto dto =em.find(StudentDto.class,id);
		 if(dto!=null)
		 {
		et.begin();
		em.remove(dto);
		et.commit();
		return "data deleted";
	 
		 }
      else
			 return "no data found" ;	 
	 }
	 
	 
	  public String deleteall()
	  { 
	  	Query q = em.createQuery("select e from StudentDto e");
	  	List<StudentDto> list=q.getResultList();
	  	System.out.println(list);
	  	if (list.isEmpty()) {
	  		return "not found";
	  		
	  	}
	  	else
	  	{
	  		for(StudentDto a:list)
	  		{
	  			et.begin();
	  			em.remove(a);
	  			et.commit();	
	  		}
	  		return "data deleted";
	  	}		
	  }
}

