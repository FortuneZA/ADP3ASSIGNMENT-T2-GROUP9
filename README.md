# ADP3ASSIGNMENT-T2-GROUP9

## Scope

School Management System

## **Problem Statement:**

In the quest for seamless and effective organisational processes in a college, the technology department of the college has been given the task to digitize and automate its academic-facing processes.

## **Domain problem:**

Education

## Authors:

| Student No | Name            | Assigned Task            |
|------------|-----------------|--------------------------|
| 2181478569 | Lefu Kumeke     | Employee                 |
| 217299822  | Devon Daniels   | City /Country            |
| 219115443  | Cameron Noemdo  | Student                  |
| 2190740540 | Mawande Langa   | Student/Employee Address |
| 217238173  | Themba Khanyile | Address                  |
| 219069514  | Mathew Fortuin  | Name                     |




## **Question 10:**

Reviewing the group solution, it was noted that improvements could be made to the folder structure. As this system contains a number of services, controllers, repositories, and domains, it would be advantageous to separate each package under the "Implementation" and "Interface" folders. It would be then be easier to distinguish between classes that implement objects and classes that implement generic or domain-specific interfaces. 

In addition, complex value objects should be separated from entities. This can assist in identifying the schema of the database , since value objects are not typically part of distinguished tables in the database.  

According to the domain model, all entities and value objects should have private access modifiers rather than public access modifiers. Class objects are meant to hide complexity and therefore promote encapsulation. These private objects can be accessed by using public getters and setters.

## Domain Model

![image](https://user-images.githubusercontent.com/61013523/172817275-ff191665-ca8c-4c3f-90c2-12afba057fdc.png)

## Built with:

- [Maven](https://maven.apache.org/) - Dependency Management
- [JUnit](https://junit.org/junit5/) - Testing Framework
- [Spring](https://spring.io/) - Application Framework
