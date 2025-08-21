#  SS-Beauty-Products Business Management Web Application : <br>

<img width="960" alt="Home Page" src="https://github.com/SnehalAShinde/Spring_Boot_Project/assets/126142130/3e29d81e-ac4d-4e4c-98fe-9aaf600867a3">

## Project Desc : Business Management Web Application 
  => The Business Management web application is a comprehensive tool designed to help businesses manage various aspects of their operations. 
          It provides a user-friendly interface for tasks like managing customer data, inventory, orders, and more.

## Features  :

- **Customer Management**: Easily add, update, and delete customer information.
- **Inventory Management**: Keep track of your inventory items, including stock levels and pricing.
- **User Authentication**: Secure login and authentication for admin and staff members.
- **Role-Based Access Control**: Define roles and permissions for different user types.
- **Thymeleaf Templates**: Utilizes Thymeleaf for dynamic HTML templates.
- **Database Integration**: Integrated with MySQL for data storage.
- **Redis Integration**: Integrated with Redis for caching.

## Technologies Used :

- Spring Boot: Backend framework for building Java-based web applications.
- Thymeleaf: Server-side Java template engine for dynamic HTML generation.
- MySQL: Relational database management system for data storage.
- IDE/Tool : Spring Tool Suite 4 (Eclipse)
- Redis : Cache Tool
- Docker: Contanerize the application with MySql DB and Redis


## Installation :

1. Clone the repository : $ git clone https://github.com/pranjaljoshinagarro/beautyappproject <br>
           OR
    Download the zip

2. Go inside the beautyappproject directory.

3. Build your Redis Image using Dockerfilee https://github.com/pranjaljoshinagarro/beautyappproject/blob/main/Dockerfilee

4. Then Locate your docker-compose.yml file and run docker compose up --build -d to start your application docker containers with MySQL DB and redis. 

5. Wait for 30 seconds so admin related schemas/tables/data will be created in db and application will get started. 

6. Open http://localhost:8080/home in any browser. <br>

7. Now you can login to Admin Page as well using default admin credentials created in the database. <br>
   - Admin Email: admin@example.com <br>
   - Admin Password: admin123 <br>     

## Database :

MySQL can be used as the database for this project. 
The database connection can be configured in the application.properties file/Docker-Compose file using environment, with the appropriate values for the following properties: <br>

  - Integerated this MySQL DB with our application. 
  - After running docker-compose.yml your db container will be visible, Go to your container using containerid and run command to login mysql -u root -p root

spring.datasource.name=[Your Database Name] <br>
spring.datasource.url=jdbc:mysql://localhost:3306/[Your Database Name] <br>
spring.datasource.password=[Your password] <br>
spring.datasource.username=[Your username] <br>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver <br>
spring.jpa.hibernate.ddl-auto=update <br>


## Caching Layer

- **Redis** is used for caching product information for improved performance.
  - Product data is cached using Spring Cache abstraction, backed by Redis.
  - Integerated this with our application. 
  - After running docker-compose.yml your redis container will be visible, Go to your container using containerid and run command to login redis-cli -h redis -a pranjalpassword
  - Run command in redis-cli: KEYS * then add few products/user from webpage and run GET "admins::SimpleKey []" , GET "products::SimpleKey []" , GET "users::SimpleKey []"
  - See `src/main/java/com/business/config/RedisConfig.java` for configuration details.


## Preview :

#### Products 
<img width="960" alt="Product Page" src="https://github.com/SnehalAShinde/Spring_Boot_Project/assets/126142130/afbd9286-8ca1-4708-9586-b6fed113cac3">

#### Location 

<img width="960" alt="Location page" src="https://github.com/SnehalAShinde/Spring_Boot_Project/assets/126142130/880e2a07-f155-4f22-baa6-ce7a5377a379">

#### Login Page

<img width="960" alt="Login Page" src="https://github.com/SnehalAShinde/Spring_Boot_Project/assets/126142130/29641b29-9181-4ac9-8037-5740baf269ff">

#### AdminPanel

<img width="960" alt="Admin Page" src="https://github.com/SnehalAShinde/Spring_Boot_Project/assets/126142130/54684ea2-e0f0-456f-9c35-d98b0a30e3e1">