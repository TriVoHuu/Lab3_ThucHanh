package buoi3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class PhoneDAO {
	public static boolean add(Phone p) {
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
	
	public static Phone get(int id) {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		
		List<Phone> ls = session.createQuery("SELECT p FROM Phone p WHERE p.id = '"+id+"'", Phone.class).getResultList();
		if(!ls.isEmpty()) {	
			for(Phone i: ls) {
				System.out.println(i);
				session.getTransaction().commit();
				return i;
			}
		} else session.getTransaction().commit();
		return null;
	}
	
	public static List<Phone> getAll() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		
		List<Phone> ls = session.createQuery("SELECT p FROM Phone p", Phone.class).getResultList();
		for(Phone i: ls) {
			System.out.println(i);
		}
		session.getTransaction().commit();
		return ls;
	}
	
	public static boolean remove(String id) {
		Session session = HibernateUtils.getFactory().openSession();
		try {
		    session.beginTransaction();
		    Query query = session.createQuery("delete from Phone where id = :id");
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
	
	public static boolean remove(Phone p) {
		Session session = HibernateUtils.getFactory().openSession();
		try {
		    session.beginTransaction();
		    Query query = session.createQuery("delete from Phone where id = :id");
		    query.setParameter("id", p.getId());
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
	
	public static boolean update(Phone p) {
		Session session = HibernateUtils.getFactory().openSession();
		try {
		    session.beginTransaction();
		    Query query = session.createQuery("update Phone p set p.name=:name, p.price=:price, p.color=:color, p.country=:country, p.quantity=:quantity where p.id=:id");
		    query.setParameter("id", p.getId());
		    query.setParameter("name", p.getName());
		    query.setParameter("price", p.getPrice());
		    query.setParameter("color", p.getColor());
		    query.setParameter("country", p.getCountry());
		    query.setParameter("quantity", p.getQuantity());
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
	
	public static void highestPrice() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		int max = 0;
		List<Phone> ls = session.createQuery("SELECT p FROM Phone p", Phone.class).getResultList();
		for(Phone i: ls) {
			if(i.getPrice() > max) max = i.getPrice();
		}
		for(Phone i:ls) {
			if(i.getPrice() == max) System.out.println(i);
		}
		session.getTransaction().commit();
	}
	
	public static List<Phone> sort_country() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		List<Phone> ls = session.createQuery("from Phone p order by p.name asc, p.price desc", Phone.class).getResultList();
		for(Phone i:ls) {
			System.out.println(i);
		}
		session.getTransaction().commit();
		return ls;
	}
	
	public static List<Phone> price_over50M(){
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		List<Phone> ls = session.createQuery("from Phone p where p.price > 50000000", Phone.class).getResultList();
		for(Phone i:ls) {
			System.out.println(i);
		}
		session.getTransaction().commit();
		return ls;
	}
	
	public static Phone pink_over15M() {
		Session session = HibernateUtils.getFactory().openSession();
		session.beginTransaction();
		List<Phone> ls = session.createQuery("from Phone p where p.price > 15000000 and p.color = 'pink'", Phone.class).getResultList();

		if(ls.isEmpty()) {
			session.getTransaction().commit();
			return null;
		}

		System.out.println(ls.get(0));
		session.getTransaction().commit();
		return ls.get(0);
	}
}
