# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official OpenTelemetry documentation](https://opentelemetry.io/docs/languages/java/getting-started/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)

### How to run the project

follow the below instructions to run the project successfully:

* first build the project
  * `mvn clean install package`
* Download the javaagent in the root folder of the project
  * `curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar`
* from command line run the instruction from the root folder
  * `java -javaagent:opentelemetry-javaagent.jar -Dotel.traces.exporter=logging -Dotel.metrics.exporter=logging -Dotel.logs.exporter=logging -jar target/basic-instrumentation-0.0.1-SNAPSHOT.jar`
* If you want to run the project just by clicking the run/debug, then set all the above values as vmoptions in project config
  * -javaagent:opentelemetry-javaagent.jar
    -Dotel.traces.exporter=logging
    -Dotel.metrics.exporter=logging
    -Dotel.logs.exporter=logging`
* If the springboot server is running without error, the access the API as below
  * http://localhost:8080/api/v1/order/12345676
* watch the console for the trace to appear.

