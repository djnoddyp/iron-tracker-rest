FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/djnoddyp/iron-tracker-rest.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/iron-tracker-rest /app
RUN mvn install

FROM tomcat:9.0.2-jre8-alpine
#WORKDIR target
#RUN pwd
COPY --from=1 /app/target/iron-tracker-rest-1.0-SNAPSHOT.war usr/local/tomcat/webapps
EXPOSE 8082
CMD ["catalina.sh", "run"]