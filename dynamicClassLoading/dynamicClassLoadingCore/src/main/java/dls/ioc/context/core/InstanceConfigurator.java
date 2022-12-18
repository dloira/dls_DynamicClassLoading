package dls.ioc.context.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dls.ioc.context.beans.InstanceConfiguration;
import dls.ioc.context.beans.ParameterConfiguration;

/**
 * Generic instances (objects) configurator for assigning values to the each object parameter.
 * REMARK: Java reflection dependency.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 * 
 */
public class InstanceConfigurator {

	List<ParameterConfiguration> parameters =  new ArrayList<ParameterConfiguration>();

	/**
	 * Value objects fullfilment 
	 * 
	 * @param instanceConfigurations objects (instances) definition list.
	 * @param instances objects (instances) built list. 
	 */
	public void configureInstances(Map<String, InstanceConfiguration> instanceConfigurations, Map<String, Object> instances){

		for (Map.Entry<String, InstanceConfiguration> entry: instanceConfigurations.entrySet()){
			InstanceConfiguration ic = entry.getValue();
			Object instance = instances.get(ic.getName());
			
			try {                            
				for (ParameterConfiguration parameter : ic.getParameters()) {
					/*
					 *  Value assignment according variable type.
					 */
					if (parameter.getType().equals("String")) {
						Field attribute = instance.getClass().getDeclaredField(parameter.getName());
						attribute.setAccessible(true);
						attribute.set(instance, parameter.getValue());
					} else if (parameter.getType().equals("Object")) {
						Field objectAttribute = instance.getClass().getDeclaredField (parameter.getName());
						objectAttribute.setAccessible(true);
						objectAttribute.set(instance,instances.get(parameter.getValue()));     
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
	}
}