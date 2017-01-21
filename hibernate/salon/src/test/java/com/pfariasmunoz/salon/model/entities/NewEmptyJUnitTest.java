/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;


/**
 *
 * @author pablo
 */
public class NewEmptyJUnitTest extends TestCase {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public NewEmptyJUnitTest() {
    }

    @Before
    @Override
    protected void setUp() {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("salon_mysql");
                                                                       

    }

    @After
    @Override
    protected void tearDown() {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        addServicesBooked();
    }
    
    private void addEmployees() {
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
    
    private void addClients() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        Client client1 = new Client();
        client1.setmClientName("Seroa Rosita");
        
        Client client2 = new Client("La Loca");
        client2.setmContactMail("laloca@gmail.com");
        
        Client client3 = new Client("Pablo", "94062006", "pfariasmunoz@gmail.com");
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    private void addSchedules() {
        
    }
    
    private void addAppointments() {
        
        Employee employee1 = new Employee("Pablo", "Farias");
        Employee employee2 = new Employee("Carolina", "Farias");
        Employee employee3 = new Employee("Cristopher", "Rojas");
        
        LocalDate localDate1 = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate localDate2 = LocalDate.of(2000, Month.MARCH, 2);
        LocalDate localDate3 = LocalDate.of(2000, Month.MARCH, 3);
        
        
        Appointment appointment4 = new Appointment(localDate3, employee3, "Roberto", "roberto@gmail.com", LocalDateTime.now(), LocalDateTime.of(2017, Month.MARCH, 4, 10, 34), new BigDecimal(20000), false);
        Appointment appointment5 = new Appointment();
        
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        

        entityManager.persist(appointment4);
        entityManager.persist(appointment5);
         
        entityManager.getTransaction().commit();
        entityManager.close();        
    }
    
    private void addService() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        Service service1 = new Service("Corte", 60, BigDecimal.TEN);
        entityManager.persist(service1);
        
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    private void addServicesBooked() {
        
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ServiceBooked sb1 = new ServiceBooked(BigDecimal.ZERO);
        ServiceBooked sb2 = new ServiceBooked(BigDecimal.TEN);
        Service service = new Service("Rastrillo", 45, BigDecimal.ONE);
        
        entityManager.persist(service);
        sb1.setmService(service);
        sb2.setmService(service);
        entityManager.persist(sb1);
        entityManager.persist(sb2);
        
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    private void addServicesProvided() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ServiceProvided sp1 = new ServiceProvided(BigDecimal.ONE);
        ServiceProvided sp2 = new ServiceProvided(BigDecimal.ONE);
        ServiceProvided sp3 = new ServiceProvided(BigDecimal.ONE);
        ServiceProvided sp4 = new ServiceProvided(BigDecimal.ONE);
        
        Service service = new Service("corte de pelo", 333, BigDecimal.TEN);
        entityManager.persist(service);
        sp1.setmService(service);
        
        
        
        entityManager.persist(sp1);
        entityManager.persist(sp2);
        entityManager.persist(sp3);
        entityManager.persist(sp4);
        
        entityManager.getTransaction().commit();
        entityManager.close();        
    }
}
