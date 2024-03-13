FROM vegardit/graalvm-maven:latest-java21 as builder

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/

RUN mvn -X -Pnative native:compile -DskipTests
