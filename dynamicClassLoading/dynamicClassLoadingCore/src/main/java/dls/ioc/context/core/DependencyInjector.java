package dls.ioc.context.core;

import dls.ioc.context.beans.Context;
import dls.ioc.common.enums.MessagesEnum;

/**
 * Main class for pattern Dependency Injection.
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 * 
 */
public class DependencyInjector {

	private InstanceConfigurationReader instanceConfigurationReader = new InstanceConfigurationReader();
	private ObjectFactory objectCreator = new ObjectFactory();
	private InstanceConfigurator instanceConfigurator = new InstanceConfigurator();

	/**
	 * Executes the pattern loading the context with the configured beans.
	 * 
	 */
	 public void execute(Context context) {
		 System.out.println(MessagesEnum.KEY_MSG_LOADCONTEXT_STARTING.getValue());
		 
		 instanceConfigurationReader.readConfiguration(context.getInstanceConfigurations());
		 objectCreator.createObjects(context.getInstanceConfigurations(), context.getInstances());
		 instanceConfigurator.configureInstances(context.getInstanceConfigurations(), context.getInstances());
	 }
}
