FROM openjdk:11
ARG JAR_FILE=out/artifacts/webapp_jar/
COPY ${JAR_FILE} /webapp_jar/
RUN ls -la /webapp_jar/*
ENTRYPOINT ["java","-jar","webapp_jar/webapp.jar"]