####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode.
#
# Before building the container image run:
#
# ./mvnw package -Pnative
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.native -t quarkus/size-api-quarkus-edition .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/size-api-quarkus-edition
#
###
FROM registry.access.redhat.com/ubi8/ubi-minimal:8.6

WORKDIR /work/
COPY target/*-runner.jar application
RUN chmod +x application

EXPOSE 8080

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]