# Dynamic Class Loading

Here, you could find the principles to use an Inversion of control pattern to face a clean approach for dynamic class loading. Day by day, the teams apply this design pattern in hidden mode with frameworks like Spring in Java or Autofac in DotNet; however, it could be a great toolbox for achieve any challenge related with teams and architectural dependencias in a dynamic environment.

## Getting Started

The basic idea behind is to get a Dependency Injector for managing the generic class loading without any knowledge of the concrete classes in fact. Please, find below the concept diagram for better understanding.

![Concept diagram](https://github.com/dloira/dls_DynamicClassLoading/blob/master/concept_diagram.jpg)

### Maven Multi Module Project

Drilling Down the code two modules arise: dynamicClassLoadingCore and dynamicClassLoadingBusiness. Both ones gets the same parent pom.xml file coming from dynamicClassLoading folder.

```
<parent>
    <groupId>dls</groupId>
    <artifactId>dynamicClassLoading</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
```

It was built in this way to show how two teams could work in parallel sharing only the interface IBean among both.

Please advise to note that the dynamicClassLoadingCore pom.xml file should be changed in case the version of dynamicClassLoadingBusiness would be changed, because the final MANIFEST file has to reference the proper business .jar version one.

```
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-jar-plugin</artifactId>
			<configuration>
				<archive>
					<manifestEntries>
						<Main-Class>dls.ioc.Init</Main-Class>
						<Class-Path>dynamicClassLoadingBusiness-0.0.1-SNAPSHOT.jar</Class-Path>
					</manifestEntries>
				</archive>
			</configuration>
		</plugin>
	</plugins>
  </build>
```

### Dependency Injector configuration file

The objects to be built dynamically by Dependency Injector are described within the instance-config.xml file. The sintax used was created for this project and it could be changed for your convenience; moreover, this configuration could be stored in any other format like for instance database or http service parameter.

The code contains an example where two business beans (BeanPersonImpl and BeanTransactionImpl) were created and a bunch of dummy objects are requested to be built during execution within descriptor config file. 

```
<?xml version="1.0" encoding="UTF-8"?>
<instances>
      <instance name="objectBeanPerson_1" type="dls.ioc.business.beans.BeanPersonImpl">
            <parameter name="name" type="String" value="Diego Loira" />
            <parameter name="idCard" type="String" value="11111111A" />
      </instance>
      <instance name="objectBeanPerson_2" type="dls.ioc.business.beans.BeanPersonImpl">
            <parameter name="name" type="String" value="Tom Smith" />
            <parameter name="idCard" type="String" value="22222222B" />
      </instance>
      <instance name="objectBeanPerson_3" type="dls.ioc.business.beans.BeanPersonImpl">
            <parameter name="name" type="String" value="Kathering Evans" />
            <parameter name="idCard" type="String" value="33333333B" />
      </instance>
      <instance name="objetBeanTransaction_A" type="dls.ioc.business.beans.BeanTransactionImpl">
            <parameter name="currency" type="String" value="Euro" />
            <parameter name="personalData" type="Object" value="objectBeanPerson_1" />
      </instance>
      <instance name="objetBeanTransaction_B" type="dls.ioc.business.beans.BeanTransactionImpl">
            <parameter name="currency" type="String" value="Dolar" />
            <parameter name="personalData" type="Object" value="objectBeanPerson_2" />
      </instance>
</instances>
```

### Business Beans

The Dependency Injector works with the interface IBean, however, it will have to built the requested objects instantiating those classes with business logic inside.

Those business beans implement IBean interface and include those variables needed to represent their business entities. The shared code includes two implementations (BeanPersonImpl and BeanTransactionImpl) but it could any others.

## Running the tests

The code could be downloaded and executed with your favourite IDE (some knowledge of Java and Maven is required); just run the Init class (the main method is inside) and the console will prompt something like that:

```
Context loading...
Context printing...
accesing to object:
	 CLASS: BeanPersonImpl
	 VARIABLE: Name = Kathering Evans
	 VARIABLE: IdCard = 33333333B
accesing to object:
	 CLASS: BeanTransactionImpl
	 VARIABLE: PersonalData = BeanPersonImpl
	 VARIABLE: Currency = Euro
accesing to object:
	 CLASS: BeanTransactionImpl
	 VARIABLE: PersonalData = BeanPersonImpl
	 VARIABLE: Currency = Dolar
accesing to object:
	 CLASS: BeanPersonImpl
	 VARIABLE: Name = Tom Smith
	 VARIABLE: IdCard = 22222222B
accesing to object:
	 CLASS: BeanPersonImpl
	 VARIABLE: Name = Diego Loira
	 VARIABLE: IdCard = 11111111A
```

A step forward could be gone by coping the .jar files from target folder and pasted wherever you like; it is enough to place both .jar files in the same path and execute the following command to give the same console log than previously with the IDE approach.

```
java -jar dynamicClassLoadingCore-0.0.1-SNAPSHOT.jar
```

## Built With

* [Java-jdk1.8.0_102](https://www.oracle.com/es/java/technologies/javase/javase8-archive-downloads.html) - The java toolkit framework
* [Maven-3.3.9](https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.3.9/) - Dependency Management
* [Eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers) - IDE

## Versioning

I use [SemVer](http://semver.org/) for versioning. For the versions available, see the tags on this repository. 
