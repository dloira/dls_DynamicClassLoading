package dls.ioc.context.core;

import java.io.IOException;
import java.util.Map;
 


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dls.ioc.context.beans.InstanceConfiguration;
import dls.ioc.context.beans.ParameterConfiguration;
 
/**
 * Clase de utilidad para leer el fichero de configuración XML y crear la lista de descriptores de instancias.
 * 
 */

public class InstanceConfigurationReader {
 
 
       /*
        * Lee la configuración y crea la lista de instanceConfigurations
        */   
       public void readConfiguration(Map<String, InstanceConfiguration> instanceConfigurations) {
    	   
              Document document = null;            
              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
              DocumentBuilder builder;

              try {
            	  	 /*
            	  	  * Acceso al fichero de configuración
            	  	  */
                      builder = factory.newDocumentBuilder();          
                      document = builder.parse(this.getClass().getResourceAsStream("/instance-config.xml"));
      
                      /*
                       *  Creación de las configuraciones (=DESCRIPTORES de clase)
                       */
                      NodeList list = document.getElementsByTagName("instance");
                      for (int i=0; i<list.getLength(); ++i){
                             Element element = (Element) list.item(i);                          
                             InstanceConfiguration instanceConfiguration = new InstanceConfiguration();
                             instanceConfiguration.setName(element.getAttribute("name"));
                             instanceConfiguration.setType(element.getAttribute("type"));
                            
                             NodeList parameterNodes = element.getElementsByTagName("parameter");
                             for (int j=0; j < parameterNodes.getLength(); ++j) {
                                    Element parameterNode = (Element) parameterNodes.item(j);
                                    ParameterConfiguration pc = new ParameterConfiguration();
                                    pc.setName(parameterNode.getAttribute("name"));
                                    pc.setType(parameterNode.getAttribute("type"));
                                    pc.setValue(parameterNode.getAttribute("value"));
                                    instanceConfiguration.getParameters().add(pc);
                             }
                             instanceConfigurations.put(element.getAttribute("name"), instanceConfiguration);
                      }
              } catch (SAXException e) {
                      e.printStackTrace();
              } catch (ParserConfigurationException e) {
                      e.printStackTrace();
              } catch (IOException e) {
                      e.printStackTrace();
              }
       }
}