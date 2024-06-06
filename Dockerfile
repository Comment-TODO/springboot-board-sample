FROM eclipse-temurin:17-jdk-alpine
ARG VERSION
ENV VERSION=$VERSION
WORKDIR /springboot-board-sample
COPY ./gradle ./gradle
COPY ./src ./src
COPY build.gradle gradlew gradlew.bat settings.gradle ./
RUN ./gradlew assemble
EXPOSE 8080
ENTRYPOINT java -jar ./build/libs/springboot-board-sample-${VERSION}.jar