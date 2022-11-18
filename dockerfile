# Multistage build

# stage 1
# Start with a bas image containing Java runtime
FROM openjdk:11-slim as build

# Add Maintainer Info
LABEL maintainer="raymond <raymond@gmail.com>"

# The application's jar file
# Defines the JAR_FILE variable set by dockerfile-maven-plugin
ARG JAR_FILE

# Add the application's jar to the container
# copies the JAR file to the filesystem of the image named app.jar
COPY ${JAR_FILE} app.jar

# unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# stage 2
# Same Java runtime
FROM openjdk:11-slim

# Add volume pointing to /tmp
VOLUME /tmp

# Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# execute the application
# test of the github commit
ENTRYPOINT [ "java", "-cp", "app:app/lib/*", "com.optimagrowth.license.LicenseServiceApplication" ]

####################################
####################################

## Single Stage build docker file
## Start with a bas image containing Java runtime
# FROM openjdk:11-slim

# # Add Maintainer Info
# LABEL maintainer="raymond <raymond@gmail.com>"

# # The application's jar file
# # Defines the JAR_FILE variable set by dockerfile-maven-plugin
# ARG JAR_FILE

# # Add the application's jar to the container
# # copies the JAR file to the filesystem of the image named app.jar
# COPY ${JAR_FILE}} app.jar

# # execute the application
# ENTRYPOINT [ "java", "-jar", "/app.jar" ]
