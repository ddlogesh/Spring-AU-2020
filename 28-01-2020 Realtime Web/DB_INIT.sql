create database realtime;

use realtime;

drop table comment_table;
drop table subscription;
drop table userInteraction;
drop table post;
drop table customer;
drop table seller;
drop table user_details;

create table user_details(
	user_id int primary key auto_increment, 
    user_name varchar(20) unique not null, 
    password varchar(20)
);

create table seller(
	#s_id int references user_details, 
    s_id int, 
    #s_name varchar(20) unique not null, 
    s_name varchar(20) not null, 
    rating DOUBLE default 4.0, 
    shop_name varchar(30)
);

create table customer(
	c_id int references user_details, 
    c_name varchar(20) unique not null
);

create table post( 
	pid int primary key, 
    p_name varchar(20), 
    p_description varchar(100), 
    p_qty int, 
    price int, 
    s_id int references seller(s_id)
);

create table userInteraction(
	user_id int,
	pid int,
	vote boolean,
	foreign key(user_id) references user_details(user_id),
	foreign key(pid) references post(pid)
);

create table subscription (
	c_id int references customer(c_id), 
    s_id int references seller(s_id)
);

create table comment_table(
	comment_id int primary key, 
    user_id int references user_details(user_id),
    post_id int references post(pid),
    comments varchar(1000)
);


#--------------------------------------------------

insert into seller values(1, 'Logesh', 4.0, 'Obeya');
insert into seller values(2, 'Rajini', 3.1, 'Comfort INN');

select * from seller;