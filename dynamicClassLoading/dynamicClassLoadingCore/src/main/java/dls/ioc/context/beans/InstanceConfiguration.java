package dls.ioc.context.beans;

import java.util.ArrayList;
import java.util.List;
 
/**
 * Value Object for instance class descriptors (instance = object).
 * <p> 
 * REMARK: Any class has to be described with a general V.O., because it will be loaded dynamically without previous reference.  
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
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