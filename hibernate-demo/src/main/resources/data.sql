insert into course(id, course_name, created_date_time, updated_date_time) values(10001, 'MathCourse' , current_timestamp, current_timestamp);
insert into course(id, course_name,created_date_time, updated_date_time) values(10002,'PhysicsCourse', current_timestamp, current_timestamp);
insert into course(id, course_name,created_date_time, updated_date_time) values(10003,'ChemistryCourse', current_timestamp, current_timestamp);

insert into passport(id, number) values (20001,'IND0001');
insert into passport(id, number) values (20002,'IND0002');

insert into student(id,name,passport_id) values(30001,'Ahmad',20001);
insert into student(id,name,passport_id) values(30002,'Kamal',20002);
