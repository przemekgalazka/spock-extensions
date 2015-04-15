## What is it?

Spock extension - doomsday, it helps ignore failling feature till specific date (the doomsday)    
 
## Examples

    @DoomsDay('2018-06-30')
    def "TC-1111 - It's not possible to refresh access when.."() {

        given: 'user logs in obtaining PayU app access token' 
        ...
        ... 

## Usage 

Add annotation @DoomsDay('yyyy-MM-dd') to your feature or specification.
From now on, a feature or specification will be ignored till 'yyyy-MM-dd'

#Maven
            <dependency>
                <groupId>com.geodevv.testing</groupId>
                <artifactId>spock-extensions</artifactId>
                <version>1.0.2</version>
            </dependency>


##Dependencies
* Spock 1.0


##Latest Release
* 1.0.2

