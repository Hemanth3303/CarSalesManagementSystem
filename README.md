# CarSalesManagementSystem

A Car Sales Management System, made using Java and MySQL as group project for DBMS Lab(CSL333 under KTU)

## Group Members(Group No: 6)

* [Gowtham](https://example.com/)
* [Hemanth](https://github.com/Hemanth3303)
* [Jasna](https://example.com/)(Group Leader)
* [Jayadeep](https://github.com/JayadeepPrakash)
* [Jemin](https://example.com/)

## Database Configuration

Database name: carmgmtdb

### Tables

* `customer(id int primary key auto_increment, username varchar(20), password varchar(20), fname varchar(20), lname varchar(20),
  email varchar(20), phone varchar(20), address varchar(100))`
* `staff(id int primary key auto_increment, username varchar(20), password varchar(20), fname varchar(20), lname varchar(20), phone
  varchar(20), email varchar(20))`
* `cars(id int primary key auto_increment, model varchar(20), year varchar(20), availability boolean, price varchar(20));`
* `sales(id int primary key auto_increment, customer_id int references customer(id), car_id int references cars(id), amount int, payment_time varchar(20));`

## Third Party Resources

* [mysql-connector-j](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)