package dls.ioc.business.beans;

import dls.ioc.business.interfaces.IBean;

/**
 * Bean class for Person Value Object data implementing IBean interface.
 * REMARK: There is not any reference to this class within the class loader core.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 *
 */
public class BeanPersonImpl implements IBean{

	private String name;
	private String idCard;

	public String toString(){
		return this.getClass().getSimpleName();
	}

	public String getName() { 
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}
