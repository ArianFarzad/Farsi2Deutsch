FROM gradle:8.4-jdk21 AS build
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon || return 0

COPY . .

RUN ./gradlew installDist --no-daemon

FROM eclipse-temurin:22-jre AS runtime
WORKDIR /app

COPY --from=build /app/build/install/Farsi2Deutsch .

EXPOSE 8085
ENTRYPOINT ["./bin/Farsi2Deutsch"]
