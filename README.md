# MovieCollection
 Movie collection with spring boot / thymeleaf \
 localhost:8989 -> Login Page


# Users
  User -> username = "user" - password = "123456" \
  Admin -> username = "admin" - password = "123456" \ 
  
  authorizeRequests() 
  
  "/movies/showForm*" -> "ADMIN", "USER" \
  "/movies/save*" -> "ADMIN", "USER" \
  "/movies/**" -> "ADMIN", "USER" \
  "/movies/delete" -> "ADMIN" \
  "/star/**" -> "ADMIN", "USER" 
  
  
  
  
  
  
  
# Db
  Genre filled in db. \
  inMemoryAuthentication is used \
  application.properties \
  spring.datasource.username=root \
  spring.datasource.password=12345

