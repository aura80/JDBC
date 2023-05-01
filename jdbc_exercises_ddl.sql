create database jdbc_exercises;

--create user student identified by 'student_password';

use jdbc_exercises;

create table student (
    id_student int not null auto_increment primary key,
    student_name varchar(150) not null unique,
    phone varchar(10) not null
);

describe student;

create table school (
    id_school int not null primary key,
    school_name varchar(50),
    id_student int,
    CONSTRAINT kf_schools_students FOREIGN KEY (id_student) REFERENCES student(id_student)
);

describe schools;

insert into student(student_name, phone) values ("Gica", "0722745896"), ("Aurel","0724561146"), ("Costel","0789145236"),
                                                ("Mihaita","0247265148"), ("Anatol","0554799145"), ("Azorel","0245689745");
                                                
select * from student;

insert into school(id_school, school_name, id_student) values (22, "Liceul Mihai Viteazu", 4),(28, "Ana Aslan", 3),
                                                              (15, "I.L. Caragiale", 2),(8, "Aurel Vlaicu", 5),
                                                              (32, "Titu Maiorescu", 1),(20, "I.L. Caragiale" , 6);

select * from school;

select * from student inner join school on school.id_student=student.id_student;

select * from student left join school on school.id_student=student.id_student;

select * from student right join school on school.id_student=student.id_student;
