create table emp(
	id integer primary key,
    name varchar(30),
    salary integer
);

create table deleted_emp(
	id integer primary key,
    name varchar(30),
    salary integer,
    date timestamp DEFAULT CURRENT_TIMESTAMP
);

insert into emp value(1, 'logesh', 500);
insert into emp value(2, 'logesh2', 1000);
insert into emp value(3, 'logesh3', 1200);