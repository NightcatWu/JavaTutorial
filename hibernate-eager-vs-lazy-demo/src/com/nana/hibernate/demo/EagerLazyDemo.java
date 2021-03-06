package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Course;
import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // Steps:
            // Create object
            // associate objects
            // start a transaction
            // save the insturctor
            // commit instructor

            // start a transaction
            session.beginTransaction();

            // get instructor from db
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            //session.close();

            //System.out.println("Courses... : " + tempInstructor.getCourses());


            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
