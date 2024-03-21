FROM maven:3.6.2-jdk-11 as build
COPY . /usr/src/
WORKDIR /usr/src/
RUN rm /etc/localtime
RUN ln -s /usr/share/zoneinfo/Europe/Istanbul /etc/localtime
RUN mvn clean package -DskipTests


FROM hirokimatsumoto/alpine-openjdk-11:latest as deploy
RUN apk add tzdata
RUN rm -rf /etc/localtime
RUN ln -s /usr/share/zoneinfo/Europe/Istanbul /etc/localtime
COPY --from=build /usr/src/target/trading-data-gateway.jar /opt/proje/trading-data-gateway.jar
#CMD ["sleep", "100000000"]
CMD ["java","-jar", "/opt/proje/trading-data-gateway.jar"]
