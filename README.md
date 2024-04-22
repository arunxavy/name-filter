## Name filter assesment

Checkout the project in your IDE, run as springboot.
Make sure you have **docker deamon** running on your system and you have **jdk 21**.

On startup, application should create postgres, kafka and zookeeper containers with the embedded docker compose support.

## Available endpoints :

localhost:8080/create

Http Method- Post 

Sample payload - {"name":"Eva"}


localhost:8080/fetch-all

Http Method - GET 

Returns all names

localhost:8080/hello/contacts?nameFilter={regex}

Http Method - GET 

Returns data that does not match the reg ex from db.
