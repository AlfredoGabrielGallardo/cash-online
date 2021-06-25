# _REST API - CASH ONLINE_
The REST API was created to be able to carry out the exam proposed by the [Cash-Online](https://www.cash-online.com.ar/) company. In this project I work with:

- [IntelliJ](https://www.jetbrains.com/es-es/idea/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)

Below i will explain how the REST API was made.
## 1 - Class diagram

![diagram](https://user-images.githubusercontent.com/86318023/123418344-564f2880-d58f-11eb-9a51-dc742cbc1ff2.png)

## 2 - Database

#### 2.1 - Creation of the database
It's necessary to run the API create the database in MySQL with the following line:
```
CREATE DATABASE db_cash_online;
```
#### 2.2 - Database migration
Use flyway to perform the migration.

The files are located in `...main\resources\db\migration.`

- To create the users table (V1__createUserTable.sql)
```
CREATE TABLE db_cash_online.users (
    user_id INT NOT NULL AUTO_INCREMENT UNIQUE,...
```
- To create the loans table (V2__createLoanTable.sql)
```
CREATE TABLE db_cash_online.loans (
    id INT NOT NULL AUTO_INCREMENT UNIQUE,...
```
- To add registers to each table (V3__addRegister.sql)
```
# Add users
INSERT INTO db_cash_online.users(email, first_name, last_name) VALUES("user1@gmail.com", "firstname1", "lastname1");...


# Add loans
INSERT INTO db_cash_online.loans(total, user_id) VALUES(10000, 1);...
```
Initial data loading is implemented.
#### 2.2 - Application.properties file setting
The file is inside `resources` folder. Configure the connection to the database, the dialect and the migration.
```
spring.datasource.url=jdbc:mysql://localhost/db_cash_online
spring.datasource.username=root
spring.datasource.password=cashonline
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL57InnoDBDialect
logging.level.hibernate.SQL=debug
spring.flyway.baseline-on-migrate=true
```
## 3 - Model
#### 3.1 - Creation of entities
Create two file: `User` and `Loan`. They are created within the main package `...\models\entity`.

In these files we will have the class attributes (table columns), the constructors, and their methods getter and setter.

#### 3.2 - Repository creation
Create two: `IUserRepository` and `ILoanRepository`. They are created within the main package `...\models\repository`.

To implement the repository we are going to use Spring Data JPA, inheriting from the JpaRepository interface, which brings all the basic CRUD methods.

#### 3.3 - Service interface
Create two file: `IUserService` and `ILoanService`. They are created within the main package `...\models\service`.

For the user:
```
List<User> findAll();     //To find all users.
User findById(int id);    //To find a user by an indicated id.
User save(User user);     //To save a created user.
void delete(int id);      //To delete a user by an indicated id.
```
For the loan:
```
Page<Loan> findAll(Pageable pageable);                         //To find all loans.
Page<Loan> findLoanByUserId(Integer id, Pageable pageable);    //To find loans by user id.
Loan findById(int id);                                         //To find a loan by an indicated id.
Loan save(Loan loan);                                          //To save a created loan.
void delete(int id);                                           //To delete a loan by an indicated id.
```
#### 3.4 - Service implementation
Create two file: `IUserServiceImpl` and `ILoanServiceImpl`. They are created within the main package `...\models\service`.

The interface is implemented and the CRUDs are described.

## 4 - Controller
#### 4.1 Controllers
Create two file: `UserRestControler` and `LoanRestControler`. They are created within the main package `...\controllers`.

The controllers for http requests are detailed.

#### 4.2 Data tranfer object (DTO)
They are created within the main package `...\controllers\dto`.

The following DTOs were created:
```
- LoanResponseDto: To show pagination.
- PagingDto: To show pagination.
- ItemDto: To show pagination.
- LoanDto: To show the correct view when creating a loan.
- UserDto: To show userId.
```
The use of DTO was implemented to have a correct view in the postman, according to that is required.

#### 4.3 - Exception handling
They were used in the user to show their implementation.

Exceptions are shown for different following cases:
```
- When creating a user: In case of putting an empty field, or create two users with the same email.
- When deleting a user: In case the user Id doesn't correspond to any of the database.
- When obtaining a user: In case the user doesn't correspond to any in the database. This is in ...\controllers\exception.
```
## 5 - Test
They are created within the main package `...src\test\`.

Create three test to show their implementation.

- Two test in the repository: Create user and delete user.
- One test in the controller: GetById.

## 6 - Postman

[Postman Collection](https://www.getpostman.com/collections/89448a10bdf00e3717f2) to assist in testing.
