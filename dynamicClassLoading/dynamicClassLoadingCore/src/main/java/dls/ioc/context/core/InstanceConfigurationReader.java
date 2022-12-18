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
 * Utility class for reading configuration XML file to build the needed instance configuration list
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 * 
 */
public class InstanceConfigurationReader {
	
	/**
	 * Read the configuration file and build the InstanceConfiguration list.
	 * 
	 * @param instance configurations list to be filled once the file configuration XML will be read.
	 */
	public void readConfiguration(Map<String, InstanceConfiguration> instanceConfigurations) {

		Document document = null;            
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			/*
			 * Configuration file accessing.
			 * REMARK: getResourceAsStream method works properly also with package files (.jar).
			 */
			builder = factory.newDocumentBuilder();          
			document = builder.parse(this.getClass().getResourceAsStream("/instance-config.xml"));

			/*
			 * Reading the configuration file and building InstanceConfiguration list within the context.
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