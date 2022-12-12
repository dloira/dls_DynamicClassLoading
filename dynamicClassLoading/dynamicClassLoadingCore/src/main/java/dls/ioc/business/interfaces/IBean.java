package dls.ioc.business.interfaces;

/**
 * The interface to be implemented for bean classes.
 * Any bean class will be used to created objects dynamically.
 * <p>
 * 
 * <p>
 * This interface is needed to be included within the project where the beans will be coded.
 * Once the beans will be compiled, they will be deployed in classpath folder to be loaded by DependencyInjector.
 * 
 * @author Diego.Loira
 */
public interface IBean {
	/**
	 * Gets the object data to be printed in any channel
	 * 
	 * @return the info to be printed
	 */
	public String toString();
}
