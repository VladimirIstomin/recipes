# Recipes
It'a simple RESTful API to store and retrieve cooking recipes
## Some used technologies
- Spring Boot
- Spring MVC
- Spring Data JPA (Hibernate as ORM and H2 as database)
- Spring Security
- Gradle
- Lombok (we don't need a lot of boilerplate code)
## Available requests
- ```POST /api/register``` to register. Takes JSON as body with the following fields:
  - email - should contain @ and . as usual emails
  - password - should not be blank and at least 8 characters long
  
  *The following requests are only for authorized users*

- ```POST /api/recipe/new``` to create new recipe. Takes JSON as body with the following fields and returns an id of created recipe:
  - name - should not be blank
  - category - should not be blank
  - description - should not be blank
  - ingredients - should contain at least one item
  - directions - should contain at least one item
- ```GET /api/recipe/{id}``` to get recipe with the specified id
- ```GET /api/recipe/search?param=value``` to get all recipes by one of the following parameters (should contain only one parameter):
  - name - to get all recipes, which names contain specified value (case insensitive)
  - category - to get all recipes with the specified category (case insensetive)
- ```PUT /api/recipe/{id}``` to update recipe with the specified id (available only for the owner of the recipe). Takes JSON as body, and all fields should be present and valid
- ```DELETE /api/recipe/{id}``` to delete recipe with the specified id (available only for the owner of the recipe)
## Some other features
- Authorization is available only Basic
- Password is hashed with BCryptPasswordEncoder
- Each recipe has updatable timestamp
- Each recipe has many-to-one relationship with the owner
- Almost not configuration files (only properties), the author doesn't like .xml and uses annotations a lot
