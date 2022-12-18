package dls.ioc.context.beans;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import dls.ioc.business.interfaces.IBean;
import dls.ioc.common.enums.MessagesEnum;

/**
 * Value Object for objects container.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 *
 */
public class Context {

	private Map<String,Object> instances = new HashMap<String, Object>();
	private Map<String,InstanceConfiguration> instanceConfigurations = new HashMap<String, InstanceConfiguration>();

	public Map<String, Object> getInstances() {
		return instances;
	}
	public Map<String, InstanceConfiguration> getInstanceConfigurations() {
		return instanceConfigurations;
	}
	public void print() {
		System.out.println(MessagesEnum.KEY_MSG_PRINTCONTEXT_STARTING.getValue());

		for (Map.Entry<String, Object> entry: getInstances().entrySet()){
			IBean bean = (IBean) entry.getValue();
			
			System.out.println(MessagesEnum.KEY_MSG_PRINTCONTEXT_OBJECTACCESSING.getValue());
			System.out.println(MessagesEnum.KEY_MSG_PRINTCONTEXT_OBJECTCLASS.getValue() + bean.toString());

			Method[] methods = bean.getClass().getMethods();
			try{
				for(int i=0; i<methods.length; i++){
					if(methods[i].getName().startsWith("get") && !methods[i].getName().equals("getClass") )
						System.out.println(MessagesEnum.KEY_MSG_PRINTCONTEXT_OBJECTVARIABLE.getValue() + methods[i].getName().replaceFirst("get", "") + " = "	+ methods[i].invoke(bean).toString());
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
