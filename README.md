# What is Hamcrest

Hamcrest is an anagram for "matcher". It is a framework for writing matcher objects allowing ‘match’ rules to be defined declaratively. There are a number of situations where matchers are invaluable, such as UI validation or data filtering, but it is in the area of writing flexible tests that matchers are most commonly used. 
This tutorial shows you how to use Hamcrest for unit testing.

# How to download Hamcrest dependency

From version SpringBoot 2.2.11 and above, Hamcrest dependencies can be downloaded as part of testContainers dependency. Testcontainers is a Java library that supports JUnit tests, providing lightweight, throwaway instances of common databases, Selenium web browsers, or anything else that can run in a Docker container. 

    build.gradle

    dependencies {
	      implementation 'org.springframework.boot:spring-boot-starter'
	      testImplementation('org.springframework.boot:spring-boot-starter-test') {
		          exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	      }
	      testImplementation 'org.testcontainers:junit-jupiter'
    }
