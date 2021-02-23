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
  1	horror
  2	adventure
  3	action
  4	drama
  5	documentary
  6	comedy
  7	fantastic
  8	romance
  9	classics
  10	sport
  12	independent
  13	animation
  14	musicals
  15	thriller
  16	science-fiction
  	\
  inMemoryAuthentication is used \
  in application.properties \
  MySQL is used\
  spring.datasource.username=root \
  spring.datasource.password=12345

