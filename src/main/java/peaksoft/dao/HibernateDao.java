package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import peaksoft.Entity.Person;
import peaksoft.config.DbConnection;

import java.sql.ResultSet;

public class HibernateDao {

    public void create(@NotNull Person person) {
        try (Session session = DbConnection.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            System.out.println("person was successfully created");
        }

    }
    public Person read (@NotNull String id){
        try(Session session = DbConnection.getSessionFactory().openSession()){
            Person result = session.get(Person.class, id);
            return result != null ? result : new Person();
        }
    }
    public void update(@NotNull Person person){
        try (Session session = DbConnection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        }
    }
    public void delete(@NotNull Person person){
        try(Session session = DbConnection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
    }
    public Person findPerson(Long id){
        try(Session session = DbConnection.getSessionFactory().openSession();){
            session.beginTransaction();
           Person person = session.find(Person.class, id);
            session.getTransaction().commit();
            return person;
        }
    }
}
