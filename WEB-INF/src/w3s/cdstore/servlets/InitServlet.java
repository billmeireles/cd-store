package w3s.cdstore.servlets;

import org.apache.struts.action.ActionServlet;
import javax.servlet.ServletException;

public class InitServlet extends ActionServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	{
		try
		{
			super.init();
			this.log("Iniciando a ServletActionAlbum");
			this.log("Servlet inicializada");
		}
		catch(ServletException e)
		{
			throw e;
		}
		finally
		{
			System.out.println();
			System.out.println();
			System.out.println("InitServlet: Mensagem declarada em finally da servlet !");
			System.out.println();
			System.out.println();
		}
	}	
}