CREATE DATABASE IF NOT EXISTS assignment;
use assignment ;

CREATE TABLE IF NOT EXISTS students
(id_student int unique auto_increment primary key,
nume char(20),
birth char(20),
address char(40));

CREATE TABLE IF NOT EXISTS course
(id_course int unique auto_increment primary key,
nume char(20),
teacher char(20),
study_year char(40));

CREATE TABLE IF NOT EXISTS sc
(id int unique auto_increment primary key,
id_student int,
id_course int,
FOREIGN KEY (id_student) REFERENCES students(id_student),
FOREIGN KEY(id_course) REFERENCES course(id_course));