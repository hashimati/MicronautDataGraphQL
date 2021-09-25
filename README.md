[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/P5P411AKC)
<a href="https://www.buymeacoffee.com/hashimati"><img src="https://img.buymeacoffee.com/button-api/?text=Buy me a coffee&emoji=&slug=hashimati&button_colour=BD5FFF&font_colour=ffffff&font_family=Cookie&outline_colour=000000&coffee_colour=FFDD00"></a>
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

Release
