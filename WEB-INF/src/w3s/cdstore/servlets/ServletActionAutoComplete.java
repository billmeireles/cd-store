
package w3s.cdstore.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import w3s.cdstore.constants.Constants;
import w3s.cdstore.forms.SearchRegister;
import w3s.cdstore.hibernate.MethodsHibernate;

public class ServletActionAutoComplete extends Action implements Constants
{
	private static final long serialVersionUID  = 1L;		
	 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{	
		String forward = SUCCESS_FORWARD;	
		
		try
		{			
			SearchRegister formConsult = (SearchRegister) form;
			MethodsHibernate resultMethod = new MethodsHibernate();
			
//			List result = resultMethod.consultMethod(formConsult.getTitle(), formConsult.getArtist(), formConsult.getGender(), formConsult.getMin_cost(), formConsult.getMax_cost());
//			request.setAttribute("listResults", result);	
		}
		catch(Exception e)
		{			
			forward = ERROR_FORWARD;
			e.printStackTrace();
		}
		finally
		{
			System.out.println();
			System.out.println();
			System.out.println("ServletActionConsult: Mensagem declarada em finally da servlet !");
			System.out.println();
			System.out.println();
		}
		
		return mapping.findForward(forward);
	}
}