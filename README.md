# Yakudatsu

Yakudatsu is a collection of useful Java utilities.

## Installation

To use Yakudatsu in your Java project, you need to add the following repository and dependency to your project configuration.

### Gradle

Add the following code to your `build.gradle` file:

```groovy
repositories {
    // Other repositories
    maven { url 'https://jitpack.io' }
}

dependencies {
    // Other dependencies
    implementation 'com.github.ElijahBare:yakudatsu:0.1'
}
```


### Maven

Add the following code to your `pom.xml` file:

```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
    <groupId>com.github.ElijahBare</groupId>
    <artifactId>yakudatsu</artifactId>
    <version>Tag</version>
</dependency>

```
