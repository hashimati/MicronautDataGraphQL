# MicronautDataGraphQL
A simple Micornaut Data JDBC WIth GraphQL Example


Excecute this command to run the application: 
```
./gradlew run
```
Go to the OpenAPI page and insert countries to H2 database. 
```
http://localhost:8080//swagger/views/swagger-ui/index.html
```

From GraphQL playground or Postman, do a POST call using the following:


URL : http://localhost:8080/graphql

GraphQL Body: 
```graphql
query {
  find(id:10){
      id, 
      name
    
  }
}
```
