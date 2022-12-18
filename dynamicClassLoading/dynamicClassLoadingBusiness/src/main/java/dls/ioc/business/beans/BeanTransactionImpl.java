package dls.ioc.business.beans;

import dls.ioc.business.interfaces.IBean;

/**
 * Bean class for Financial Transaction Value Object data implementing IBean interface.
 * REMARK: There is not any reference to this class within the class loader core.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 *
 */
public class BeanTransactionImpl implements IBean{

	private String currency;
	private Object personalData;

	public String toString(){
		return this.getClass().getSimpleName();
	}

	public String getCurrency() {  
		return currency; 
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Object getPersonalData() { 
		return personalData; 
	}
	public void setPersonalData(Object personalData) {
		this.personalData = personalData;
	}
}