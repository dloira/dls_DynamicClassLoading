package dls.ioc.context.core;

import java.util.HashMap;
import java.util.Map;

import dls.ioc.context.beans.InstanceConfiguration;
 
/**
 * Clase principal del patrón DependencyInjector
 *
 */
public class DependencyInjector {
 
       private Map<String,Object> instances = new HashMap<String, Object>();
       private Map<String,InstanceConfiguration> instanceConfigurations = new HashMap<String, InstanceConfiguration>();
      
       private InstanceConfigurationReader instanceConfigurationReader = new InstanceConfigurationReader();
       private InstanceConfigurator instanceConfigurator = new InstanceConfigurator();
       private InstanceFactory instanceCreator = new InstanceFactory();
      
       public Map<String, Object> getInstances() {
              return instances;
       }
       public Map<String, InstanceConfiguration> getInstanceConfigurations() {
              return instanceConfigurations;
       }
      
       /* 
        * Método para ejecutar el patrón
        */
       public void execute() {
              instanceConfigurationReader.readConfiguration(instanceConfigurations);
              instanceCreator.createInstances(instanceConfigurations, instances);
              instanceConfigurator.configureInstances(instanceConfigurations, instances);
       }
}
