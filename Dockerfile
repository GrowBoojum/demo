FROM openjdk:11-jdk-slim AS build

WORKDIR /build-env
ADD . /build-env
RUN ./gradlew build --no-daemon 

FROM openjdk:11-jre-slim
COPY --from=build /build-env/build/libs/demo-0.0.1-SNAPSHOT.jar /app/graphql-notes.jar

CMD java -jar /app/graphql-notes.jar