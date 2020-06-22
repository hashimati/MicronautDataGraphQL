FROM openjdk:14-alpine
COPY build/libs/com.mygroup.countrygraphql-*-all.jar countrygraphql.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "countrygraphql.jar"]