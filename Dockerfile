#Using alpine openjdk as a base image to ensure a smaller memory footprint
FROM openjdk:17-alpine3.13 as builder

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract


#Multistage
FROM openjdk:17-alpine3.13

#Adding application labels
LABEL maintainer=thakur.ganeshsingh@bazaarvoice.com

#Creating custom user group and user for application specific usage
RUN addgroup -S devadv-group && adduser -S devadv-user -G devadv-group

#Switch to new user home directory
WORKDIR /devadv-user/bash-insider

#Copy required files
COPY package*.json ./

#Install dependencies
RUN npm ci --only=production

#Copy dependencies and modules
COPY . .

#Removing defalut node user from security standpoint as it has elevated privileges
RUN deluser --remove-home node

#Switch to new user
USER devadv-user

#Expose node default port for port mapping
EXPOSE 8080

#Adding healthcheck URI
#HEALTHCHECK CMD wget --fail http://localhost:3000/health || exit 1

#Launch node application
CMD [ "npm", "start" ]

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]