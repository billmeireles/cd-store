package w3s.cdstore.velocity;

import org.apache.velocity.tools.view.servlet.VelocityViewServlet;
import javax.servlet.ServletException;

public class ViewServlet extends VelocityViewServlet
{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	{
		super.init();
		this.log("Inicializando ViewServlet");
		this.log("ViewServlet inicializada");
	}
}
