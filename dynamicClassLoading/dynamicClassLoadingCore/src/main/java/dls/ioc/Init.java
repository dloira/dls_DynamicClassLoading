package dls.ioc;

import java.lang.reflect.Method;
import java.util.Map;

import dls.ioc.business.interfaces.IBean;
import dls.ioc.context.core.DependencyInjector;

public class Init {

	public static void main(String[] args) {
		
	/*
		 * Instanciación del gestor de IoC
		 */
		DependencyInjector dependencyInjector = new DependencyInjector();
        
		/*
		 * Carga de objetos
		 */
		System.out.println("################ BEGIN ################\n");
		System.out.println("STEP 1: Context loading...\n");
		
        dependencyInjector.execute();
        
        System.out.println("\nSTEP 2: Listing object loaded in the context...\n");
        
        for (Map.Entry<String, Object> entry: dependencyInjector.getInstances().entrySet()){
			IBean bean = (IBean) entry.getValue();
			System.out.println("Accesing to object:");
			System.out.println("\t CLASS: " + bean.toString());
		        
	        Method[] methods = bean.getClass().getMethods();
	        try{
	        	for(int i=0; i<methods.length; i++){
	        		if(methods[i].getName().startsWith("get") && !methods[i].getName().equals("getClass") )
	        			System.out.println("\t PARAMETER: "+ methods[i].getName().replaceFirst("get", "") + " = "	+ methods[i].invoke(bean, null).toString());
	        	}
	        } catch(Exception e){
	        	System.out.println(e.getMessage());
	        }
		}
        System.out.println("\n################ END ################");
	}
}
