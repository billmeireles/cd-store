package w3s.cdstore.forms;

import org.apache.struts.validator.ValidatorForm;

public class SearchRegister extends ValidatorForm
{
	private static final long serialVersionUID = 1L;
	
	private String idTitle;
	private String nameTitle;	
	
	/**
	 * @return the idTitle
	 */
	public String getIdTitle() {
		return idTitle;
	}

	/**
	 * @param idTitle the idTitle to set
	 */
	public void setIdTitle(String idTitle) {
		this.idTitle = idTitle;
	}

	/**
	 * @return the nameTitle
	 */
	public String getNameTitle() {
		return nameTitle;
	}

	/**
	 * @param nameTitle the nameTitle to set
	 */
	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}
}