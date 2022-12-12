package dls.ioc.context.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dls.ioc.context.beans.InstanceConfiguration;
import dls.ioc.context.beans.ParameterConfiguration;
 
/**
 * Configurador de instancias genérico para asignar valores a los parámetros de cada instancia.
 * NOTA: Usa el API de reflexión de Java
 */
public class InstanceConfigurator {
 
       List<ParameterConfiguration> parameters =  new ArrayList<ParameterConfiguration>();
      
       public void configureInstances(Map<String, InstanceConfiguration> instanceConfigurations, Map<String, Object> instances){
             
              for (Map.Entry<String, InstanceConfiguration> entry: instanceConfigurations.entrySet()){
                      InstanceConfiguration ic = entry.getValue();
                      Object instance = instances.get(ic.getName());
                      try {                            
                             for (ParameterConfiguration parameter : ic.getParameters()) {
                                    /*
                                     *  Asignación de valores según tipo de la variable
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
      
      
       public void addParameter(String name, String type, String value){
              ParameterConfiguration param = new ParameterConfiguration();
              param.setName(name);
              param.setType(type);
              param.setValue(value);
              parameters.add(param);
       }
}