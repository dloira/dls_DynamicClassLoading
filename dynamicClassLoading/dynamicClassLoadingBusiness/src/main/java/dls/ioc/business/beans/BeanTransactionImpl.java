package dls.ioc.business.beans;

import dls.ioc.business.interfaces.IBean;

/**
 * Bean class for financial transaction executed.
 * There is not any reference to this class within the class loader core.
 *
 * @author Diego.Loira
 */
public class BeanTransactionImpl implements IBean{
	
       private String currency;
       private Object personalData;
      
       /**
        * Gets the class name to be printed
        * 
        * @return the info to be printed
        */
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