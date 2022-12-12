package dls.ioc.context.beans;

/**
 * Bean para almacenar los datos de un parámetro de configuración de una instancia
 *
 */
public class ParameterConfiguration {
	
       private String name;
       private String type;
       private String value;
      
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
}