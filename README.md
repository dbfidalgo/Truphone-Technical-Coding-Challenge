# Truphone---Technical-Coding-Challenge

## Truphone Tech Assessment | Backend Software Engineer - RSP

In order to organise my code I tried to follow the SOLID principles of JAVA for object-oriented architectures. Let me break my code down for you very briefly:

1. **Controller Layer/AP Layer** - This layer job is simply to receive and handle HTTP (*GET, POST, PUT, DELETE*) requests sent by clients. When an HTTP request is received this layer must forward the request to the service layer.

2. **Service Layer** - This layer handles the business logic/the rules for this application. In this case, implements the list of operations required with all the validations included and forward the request to the Data Access layer.

3. **Data Access Layer** - The main purpose of this layer is to contain logic that performs CRUD (Create Read, Update, Delete) operations against the data repository/database.
For example receive a device from the service layer and insert into the database/repository. Note: For this challenge and to represent a DB, I used a Java Collection - HashMap to store my devices information. 

Here's a diagram to help:

![image](https://user-images.githubusercontent.com/89163592/134897087-0c93b400-ade4-4960-b60b-87ea50cf293d.png)


In this GIT repo, you may find the project folder within the source code application and a Postman collection with all the operations/requests pre-set to be used.

👍
