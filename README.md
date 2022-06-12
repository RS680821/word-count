Word Counter Solution

I used Quarkus as my lightweight microservice which will expose my REST endpoints

To run Quarkus in development debug mode then run the following
mvn compile quarkus:dev

Alternatively you can run it like so
java -jar target/quarkus-app/quarkus-run.jar

The first option allows you to poke a swagger-ui endpoint
http://localhost:8080/q/swagger-ui

Alternatively you can just run it like so
E.G.
http://localhost:8080/api/word-counter/count?word=bla

I have setup my environment vars using the setevn.sh file.