package w3s.cdstore.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigurationSession 
{
	public static SessionFactory factory;	
	
	static
	{			
		try
		{		
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			factory = null;
		}
	}
	
	public static Session getSession()
    {
		return factory.openSession();
	}
}
	

