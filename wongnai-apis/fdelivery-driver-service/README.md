# Getting Started

### System requirements

1.  Windows 10 or Mac or Linux or Ubuntu, minimum memory requirement is 8 gb

### Software requirements
1.  Java SDK v17 or higher
2.  Maven (3.2+)
3.  MongoDB 

### Installation Instructions

1. Download Java Java SDK v17 or higher from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
2. Install Java by following link https://data-flair.training/blogs/install-java/
3. Set Java home (JAVA_HOME) by using this link https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux
4. Verify by typing on console java -version
5. Download maven and placed somewhere https://downloads.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip
6. Set Maven home (M2_HOME) by following this link https://mkyong.com/maven/how-to-install-maven-in-windows/
7. Postgres https://www.postgresql.org/download/
8. Download intelij idea and run project by following this link https://vaadin.com/docs/v14/flow/tutorials/in-depth-course/project-setup


### fdelivery-driver-service apis
1. Swagger (api documentation) url: http://localhost:8088/fdelivery-driver-service/swagger-ui/index.html

### There are improvements which we can discuss in interview

### All APIs are secured which required authorization token, below sample token is provided:

Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE3MDk0MDYxOTQsImV4cCI6MTc0MDk0MjE5NCwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsInVzZXJuYW1lIjoiSm9obm55IiwiUk9MRV8iOiJQcm9qZWN0IEFkbWluaXN0cmF0b3IiLCJuYW1lIjoidGVzdCJ9.hy66j9XLj7iDCP2p-hHXAxvypgtSe8Mq4Ygiw7p2jR5Pih7zV08OH4NZff81Qs9d5KmLi3r6dVO9MAon3n7gqA

### How to run fdelivery-driver-service
1. "mvn clean install" from the folder fdelivery-driver-service
2. "docker-compose up" from the root folder wongnai-apis-by-vinodjagwani
3. check the swagger once service is up: http://localhost:8088/fdelivery-driver-service/swagger-ui/index.html
4. You are ready to using apis using above token.