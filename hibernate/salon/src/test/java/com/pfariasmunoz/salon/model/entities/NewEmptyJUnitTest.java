/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;


/**
 *
 * @author pablo
 */
public class NewEmptyJUnitTest extends TestCase {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public NewEmptyJUnitTest() {
    }

 
    @Override
    public void setUp() {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("salon_mysql");
                                                                       

    }

  
    @Override
    public void tearDown() {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        // create a couple of events...
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LocalDateTime from1 = LocalDateTime.of(2000, Month.MARCH, 15, 11, 0);
        LocalDateTime to1 = LocalDateTime.of(2000, Month.MARCH, 15, 11, 1);
        Schedule schedule = new Schedule(from1, to1);
        Employee pablo = new Employee("Pablo", "Farias");
        Employee cristopher = new Employee("Cristopher", "Rojas");
        Employee carolina = new Employee("Carolina", "Farias");
        pablo.addSchedule(schedule);
        entityManager.persist(cristopher);
        entityManager.persist(carolina);
        entityManager.persist(pablo);
        entityManager.getTransaction().commit();
        entityManager.close();

        // now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Employee> result;
        result = entityManager.createQuery("from Employee", Employee.class).getResultList();
        result.forEach((employee) -> {
            System.out.println("Employee: " + employee.getmFirstName() + " " + employee.getmLastName());
        });
        List<Schedule> result2;
        result2 = entityManager.createQuery("from Schedule", Schedule.class).getResultList();
        result2.forEach((schedule2) -> {
            System.out.println("Schedule employee: " + schedule2.getmEmployee() 
                    + " from: " + schedule2.getmFrom().toString() 
                    + " to: " + schedule2.getmTo());
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
