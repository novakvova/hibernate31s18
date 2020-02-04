import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainApp {

	private static SessionFactory sessionFactory=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello app");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		System.out.println("----Config build----- complete");
		try {
			
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("-----Connection succes------");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
//			Category category = new Category();
//			category.setName("Бомба");
//			session.save(category);
			
			Category category = new Category();
			category.setId(1);
			
			Post post = new Post();
			post.setName("ssdfsdfs");
			post.setCategory(category);
			session.save(post);
			
			Post post2 = new Post();
			post2.setName("000000000000");
			post2.setCategory(category);
			session.save(post2);
			
			session.getTransaction().commit();
//			Coffee coffee = new Coffee();
//			coffee.setName("Name");
//			coffee.setImage("image");
//			session.beginTransaction();
//	        session.save(coffee);
//	        session.getTransaction().commit();
			
			
			session.close();
			System.out.println("Creating coffee records...");
			
			
		
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

}
