package com.joelenpastva.Assignment5;

import com.joelenpastva.Assignment5.models.Planet;
import com.joelenpastva.Assignment5.models.Visit;
import com.joelenpastva.Assignment5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import java.util.List;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

            String dbName = System.getenv("RDS_DB_NAME");
            String hostname = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            cfg.setProperty("hibernate.connection.url", jdbcUrl);
            cfg.setProperty("hibernate.connection.username", System.getenv("RDS_USERNAME"));
            cfg.setProperty("hibernate.connection.password", System.getenv("RDS_PASSWORD"));

            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public static List<Planet> listPlanets() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Planet").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Starship> listStarships() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Starship").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Visit> listVisits() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Visit").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet findPlanetById(int planetId) {
        Session session = getSessionFactory().openSession();

        try {
            return (Planet) session.get(Planet.class, planetId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship findStarshipById(int starshipId) {
        Session session = getSessionFactory().openSession();

        try {
            return (Starship) session.get(Starship.class, starshipId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet updatePlanet(int planetId, Planet planetToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            existing.setId(planetToUpdate.getId());
            existing.setName(planetToUpdate.getName());
            existing.setRadius(planetToUpdate.getRadius());
            existing.setAtmosphere(planetToUpdate.getAtmosphere());

            session.update(existing);
            tx.commit();

            return existing;

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship updateStarship(int starshipId, Starship starshipToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Starship existing = findStarshipById(starshipId);
            existing.setCrewSize(starshipToUpdate.getCrewSize());
            existing.setName(starshipToUpdate.getName());
            existing.setShipClass(starshipToUpdate.getShipClass());
            existing.setLaunchStarDate(starshipToUpdate.getLaunchStarDate());

            session.update(existing);
            tx.commit();

            return existing;

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet savePlanet(Planet planetToAdd) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet newPlanet = new Planet();
            newPlanet.setId(planetToAdd.getId());
            newPlanet.setName(planetToAdd.getName());
            newPlanet.setRadius(planetToAdd.getRadius());
            newPlanet.setAtmosphere(planetToAdd.getAtmosphere());
            session.save(newPlanet);

            tx.commit();

            return newPlanet;
        } catch (HibernateException e) {
            if(tx != null) {
                tx.rollback();
            } e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public static Starship saveStarship(Starship starshipToAdd) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Starship newStarship = new Starship();
            newStarship.setId(starshipToAdd.getId());
            newStarship.setName(starshipToAdd.getName());
            newStarship.setShipClass(starshipToAdd.getShipClass());
            newStarship.setLaunchStarDate(starshipToAdd.getLaunchStarDate());
            session.save(newStarship);

            tx.commit();

            return newStarship;
        } catch (HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Visit saveVisit(Visit visitToAdd) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Visit newVisit = new Visit();
            newVisit.setPlanetId(visitToAdd.getPlanetId());
            newVisit.setStarshipId(visitToAdd.getStarshipId());
            newVisit.setArrivalStarDate(visitToAdd.getArrivalStarDate());
            newVisit.setDepartureStarDate(visitToAdd.getDepartureStarDate());
            session.save(newVisit);

            tx.commit();

            return newVisit;
        } catch (HibernateException e) {
            if(tx != null) {
                tx.rollback();
            } e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static void deletePlanet(int planetId) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet planetToDelete = findPlanetById(planetId);

            session.delete(planetToDelete);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteStarship(int starshipId) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Starship starshipToDelete = findStarshipById(starshipId);

            session.delete(starshipToDelete);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
