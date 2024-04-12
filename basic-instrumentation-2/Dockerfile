FROM eclipse-temurin:21-alpine

ADD target/inventory-service.jar /inventory-service.jar
# we dont need the agent since we are using the micrometer opentelemetry bridge.
# ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENTRYPOINT java -jar /inventory-service.jar

# pass these VM arguments to opentelemetry-javaagent.jar agents
#  java -javaagent:opentelemetry-javaagent.jar \
#                -Dotel.traces.exporter=logging \
#                -Dotel.metrics.exporter=logging \
#                -Dotel.logs.exporter=logging \
#                -jar /order-service.jar
