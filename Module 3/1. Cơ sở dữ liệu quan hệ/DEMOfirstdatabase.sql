create database ClassManagement;

/* xoa db */
drop database ClassManagement;

/* chon database su dung*/
use ClassManagement;

/*tao bang*/
create table `students`(
	/* cot cua bang: name datatype(11) null */
    id int(11) not null,
    name varchar(255) not null
);

show tables;
/* xoa bang*/
drop table `students`;

/* cac cau lenh truy van csdl*/
/* lay du lieu*/

select * from `students`;

/* Them 1 ban ghi*/
insert into `students`(id,name)
value (1, 'hoang');

insert into `students`(id,name)
values (2, 'dung'),(4, 'quan');

/* delete all*/
delete from `students`;

/* delete kem dk -> where */
delete from `students` where id = 1;

/* update */

update students set name = 'hoang' where id = 1;