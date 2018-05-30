To run the tests we can run the feature files in the IntelliJ IDEA or using the below maven command from the project’s root directory. We can use @WebTests or @APITests for tags
clean install -Dcucumber.options="--tags @APITests"  Browser=Chrome

