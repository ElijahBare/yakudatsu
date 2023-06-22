# Yakudatsu

Yakudatsu is a collection of useful Java utilities and skidded code hehe.

## Installation

To use Yakudatsu in your Java project, you need to add the following repository and dependency to your project configuration.

### Gradle

Add the following code to your `build.gradle` file:

```groovy
dependencies {
    // Other dependencies
    implementation(files("lib/yakulib.jar"))
}
```

### Maven
To include Yakudatsu in your Maven project, add the following code to your pom.xml file:

```xml
<dependencies>
    <!-- Other dependencies -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>yakulib</artifactId>
        <version>1.0.0</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/lib/yakulib.jar</systemPath>
    </dependency>
</dependencies>
```

Make sure to replace the <groupId>, <artifactId>, and <version> values with the appropriate ones for your project.

### The lib Folder
The lib folder mentioned in the code snippets above refers to a directory within your project where you should place the yakulib.jar file. This JAR file contains the compiled classes and resources of the Yakudatsu library. By including the JAR file in the lib folder, your build system (Gradle or Maven) can automatically resolve and include the library in your project's classpath during compilation and execution.
