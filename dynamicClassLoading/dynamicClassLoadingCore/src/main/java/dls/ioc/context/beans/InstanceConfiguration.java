package dls.ioc.context.beans;

import java.util.ArrayList;
import java.util.List;
 
/**
 * Bean que almacena la configuración de una instancia
 *
 */
public class InstanceConfiguration {
 
       private String name;
       private String type;
       private String value;
       private List<ParameterConfiguration> parameters =  new ArrayList<ParameterConfiguration>();
      
       public String getName() {
              return name;
       }
      
       public void setName(String name) {
              this.name = name;
       }
       public String getType() {
              return type;
       }
       public void setType(String type) {
              this.type = type;
       }
       public String getValue() {
              return value;
       }
       public void setValue(String value) {
              this.value = value;
       }
 
       public List<ParameterConfiguration> getParameters() {
              return this.parameters;
       }
 
       public void setParameters(List<ParameterConfiguration> parameters) {
              this.parameters = parameters;
       }                    
}