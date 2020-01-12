create table emp(
	id integer primary key,
    name varchar(30),
    salary integer
);

call pagination(3,10);