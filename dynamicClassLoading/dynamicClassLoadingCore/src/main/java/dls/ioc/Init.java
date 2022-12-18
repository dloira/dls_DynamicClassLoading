package dls.ioc;

import dls.ioc.context.beans.Context;
import dls.ioc.context.core.DependencyInjector;

public class Init {

	/**
	 * Entry point for dynamic class loading
	 * 
	 * @param args none for testing.
	 */
	public static void main(String[] args) {
		
		Context context = new Context();
		DependencyInjector dependencyInjector = new DependencyInjector();
        
        dependencyInjector.execute(context);
        context.print();
	}
}
