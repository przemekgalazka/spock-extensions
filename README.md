## What is it?

Spock extension - doomsday, it helps ignore failling feature till specific date (the doomsday)    
 
## Examples
```groovy
    @DoomsDay('2018-06-30')
    def "TC-1111 - It's not possible to refresh access token when.."() {

        given: 'user logs in obtaining app access token' 
        ...
        ...
``` 

## Usage 
Add annotation *@DoomsDay('yyyy-MM-dd')* to your feature or specification.
From now on, a feature or specification will be ignored till 'yyyy-MM-dd'

##Maven
```xml
 <dependency>
  <groupId>com.geodevv.testing</groupId>
  <artifactId>spock-extensions</artifactId>
  <version>1.0.2</version>
</dependency>
```

##Dependencies
    compile 'org.codehaus.groovy:groovy-all:2.4.3'
    compile 'org.spockframework:spock-core:1.0-groovy-2.4'
    compile 'org.slf4j:slf4j-api:1.7.7'
    compile 'joda-time:joda-time:2.7'

##Latest Release
* 1.0.2

