package dls.ioc.context.beans;

/**
 * Value Object for configuration parameter.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
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