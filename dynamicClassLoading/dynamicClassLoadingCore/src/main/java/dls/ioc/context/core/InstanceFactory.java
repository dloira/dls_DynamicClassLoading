package dls.ioc.context.core;

import java.util.Map;

import dls.ioc.context.beans.InstanceConfiguration;

/**
 * Factoría para crear instancias de objetos
 * 
 */
public class InstanceFactory {
 
      
       /* 
        * Creación de instancias de clases a partir de su nombre. 
        * La clase debe tener contructor sin parámetros.
        */
       public Object getNewInstance(String type){
              try {
                      Class clase = Class.forName(type);
                      return clase.newInstance();
              } catch (ClassNotFoundException e) {
                      System.out.println("Error de instanciación, clase no encontrada:" + type);
                      e.printStackTrace();
              } catch (InstantiationException e) {
                      System.out.println("Error de instanciación:" + type);
                      e.printStackTrace();
              } catch (IllegalAccessException e) {
                      System.out.println("Error de instanciación, acceso ilegal:" + type);
                      e.printStackTrace();
              }
              return null;
       }
      
       /*
        * Creación de todas las instancias definidas en InstanceConfigurations
        * (Se crean los objetos vacío = SIN VALORES ASIGNADOS y se añaden a la lista de instancias)
        */
       public void createInstances(Map<String, InstanceConfiguration> instanceConfigurations, Map<String, Object> instances){
              for (Map.Entry<String, InstanceConfiguration> entry: instanceConfigurations.entrySet()){
                      InstanceConfiguration ic = entry.getValue();
                      instances.put(ic.getName(), getNewInstance(ic.getType()));
                      System.out.println("Carga de objeto: NOMBRE = " + ic.getName() + " \n\t\t CLASE = "+ ic.getType());
              }
       }
}