package dls.ioc.business.beans;

import dls.ioc.business.interfaces.IBean;

/**
 * Bean class for person value object data.
 * There is not any reference to this class within the class loader core.
 *
 * @author Diego.Loira
 */
public class BeanPersonImpl implements IBean{
	
       private String name;
       private String idCard;
 
       /**
        * Gets the class name to be printed
        * 
        * @return the info to be printed
        */
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
