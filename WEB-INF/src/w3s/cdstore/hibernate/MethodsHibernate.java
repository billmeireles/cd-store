package w3s.cdstore.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import w3s.cdstore.beans.TitleEntity;

public class MethodsHibernate
{		
	public List consultMethod(String titleOfForm, String artistOfForm, String genderOfForm, String costMin, String costMax)
	{	
		Session session = ConfigurationSession.getSession();	 
		
		List searchResult = null;
		
		try
		{	
			session = ConfigurationSession.getSession();
		
			Criteria criteria = session.createCriteria(TitleEntity.class);
				
								  if(titleOfForm != null && titleOfForm.length() > 0)
								  {					  
									  criteria.add(Expression.eq("titleName", titleOfForm).ignoreCase()); 
								  }				  
								 					  
								  if(costMin != null && costMin.length() > 0 && costMax != null && costMax.length() > 0)
								  {
									  criteria.add(Expression.between("price", Double.valueOf(costMin), Double.valueOf(costMax)));
								  }								  
									  
								  else if(costMin != null && costMax.length() > 0)
								  {								  		
									  criteria.add(Expression.ge("price", Double.valueOf(costMin)));
								  }	  
									  
								  else if(costMax != null && costMax.length() > 0)
								  {
									  criteria.add(Expression.le("price", Double.valueOf(costMax)));
								  }				  
								  
								  criteria.addOrder(Order.desc("price"));								  	  
								 								  
								  if(genderOfForm != null && genderOfForm.length() > 0)
								  {									 
									  criteria.createAlias("Gen","g");								  
									  criteria.add(Expression.eq("g.idGender", Integer.valueOf(genderOfForm)));
								  }
								 								 
								  if(artistOfForm != null && artistOfForm.length() > 0)
								  {			  
									  criteria.createAlias("Art","a");
									  criteria.add(Expression.eq("a.artistName", artistOfForm).ignoreCase());								  
								  }							  
								  
								  searchResult = criteria.list();
	        
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			if(session != null)
			{
				try
				{
					session.close();					
				}
				catch(Exception e)
				{
					e.printStackTrace();					
				}				
			}						
		}
		return searchResult;
	}
}