package dls.ioc.context.core;

import java.util.Map;

import dls.ioc.context.beans.InstanceConfiguration;

/**
 * Factory class for building the objects (instances) defined by the instance configurations list loaded.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 * 
 */
public class ObjectFactory {

	/**
	 * Class loading builder from the class name.
	 * REMARK: The class must get constructor without parameters.
	 */
	public Object getNewClassInstance(String type){
		try {
			Class<?> classBuilt = Class.forName(type);
			return classBuilt.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Objects (instances) builder from an instance configurations list.
	 * REMARK: The objects are created empty (without values assigned) and added to the instances list
	 * 
	 * @param instanceConfigurations objects (instances) definition list.
	 * @param instances objects (instances) built list. 
	 */
	public void createObjects(Map<String, InstanceConfiguration> instanceConfigurations, Map<String, Object> instances){
		for (Map.Entry<String, InstanceConfiguration> entry: instanceConfigurations.entrySet()){
			InstanceConfiguration ic = entry.getValue();
			instances.put(ic.getName(), getNewClassInstance(ic.getType()));
		}
	}
}