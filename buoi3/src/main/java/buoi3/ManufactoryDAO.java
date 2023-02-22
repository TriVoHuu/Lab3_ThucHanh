package buoi3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ManufactoryDAO {
	public static boolean add(Manufactory p) {
		try {
				Session session = HibernateUtils.getFactory().openSession();
				session.beginTransaction();
				
				session.save(p);
				session.getTransaction().commit();
				return true;
			}
		catch(Exception e) {
			  	return false;
			}
		}
	
	public static Manufactory get(int id) {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		
		List<Manufactory> ls = session.createQuery("SELECT p FROM Manufactory p WHERE p.manu_id = '"+id+"'", Manufactory.class).getResultList();
		if(!ls.isEmpty()) {	
			for(Manufactory i: ls) {
				System.out.println(i);
				session.getTransaction().commit();
				return i;
			}
		} else session.getTransaction().commit();
		return null;
	}
	public static List<Manufactory> getAll() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		
		List<Manufactory> ls = session.createQuery("SELECT p FROM Manufactory p", Manufactory.class).getResultList();
		for(Manufactory i: ls) {
			System.out.println(i);
		}
		session.getTransaction().commit();
		return ls;
	}
	
	public static boolean remove(String id) {
		Session session = HibernateUtils.getFactory().openSession();
		try {
		    session.beginTransaction();
		    Query query = session.createQuery("delete from Manufactory where id = :id");
		    query.setParameter("id", id);
		    int result = query.executeUpdate();
		    System.out.println("Rows affected: " + result);
		    session.close();
		    System.out.println("thanh cong");
		    return true;
		} catch (Exception e) {
			System.out.println("that bai");
			session.close();
			return false;
		}
	}
	
	public static boolean updata(Manufactory p) {
		Session session = HibernateUtils.getFactory().openSession();
		try {
		    session.beginTransaction();
		    Query query = session.createQuery("update Manufactory p set p.name=:name, p.location=:location, p.employee=:employee where p.manu_id=:id");
		    query.setParameter("id", p.getManu_id());
		    query.setParameter("name", p.getName());
		    query.setParameter("location", p.getLocation());
		    query.setParameter("employee", p.getEmployee());
		    int result = query.executeUpdate();
		    System.out.println("Rows affected: " + result);
		    session.close();
		    System.out.println("thanh cong");
		    return true;
		} catch (Exception e) {
			System.out.println("that bai");
			session.close();
			return false;
		}
	}
	
	public static List<Manufactory> over100employee() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		
		List<Manufactory> ls = session.createQuery("from Manufactory m where m.employee > 100", Manufactory.class).getResultList();
		for(Manufactory i: ls) {
			System.out.println(i);
		}
		session.getTransaction().commit();
		return ls;
	}
	
	public static int sum_employee() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		int sum = 0;
		List<Manufactory> ls = session.createQuery("SELECT p FROM Manufactory p", Manufactory.class).getResultList();
		for(Manufactory i: ls) {
			sum = sum + i.getEmployee();
		}
		session.getTransaction().commit();
		System.out.println(sum);
		return sum;
	}
	
	public static Manufactory base_in_US() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		List<Manufactory> ls = session.createQuery("FROM Manufactory p where p.location = 'US'", Manufactory.class).getResultList();
		if(ls.isEmpty()) {
			System.out.println(" InvalidOperationException");
			return null;
		}
		else {
			System.out.println(ls.get(ls.size()-1));
			session.getTransaction().commit();
			return ls.get(ls.size()-1);
		}
	}
}
