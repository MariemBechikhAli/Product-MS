FROM java:8
EXPOSE 8089
ADD /target/Product-MS-0.0.1-SNAPSHOT.jar Product-MS.jar
ENTRYPOINT ["java","-jar","Product-MS.jar"]