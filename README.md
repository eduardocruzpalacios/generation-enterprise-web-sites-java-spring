# Generation Enterprise web sites
Generation enterprise web sites built with JavaSE-11, Java Spring, Maven, SpringBoot, Thymeleaf and Spring Security.
## Public web site
Accessible via [http://localhost:8080/home](http://localhost:8080/home) once application is running.

### Functionality
- Read all proyectos
- Filter proyectos by cliente
- Read all personas
- Create one mensaje

## Admin web site
Accessible via [http://localhost:8080/admine](http://localhost:8080/admin) once application is running.

Protected with Java Spring Security:
- user: user
- password: password

### Functionality
- CRUD over proyectos
- CRUD over personas
- Read all mensajes
## Data Source
[Generation Enterprise API REST](https://github.com/eduardocruzpalacios/generation-enterprise-api-rest-java-spring).

Some personas showed on public web site are fake by using [Java Faker](https://github.com/DiUS/java-faker).