create table user(
  id bigint primary key auto_increment,
  account varchar(50) not null unique,
  password varchar(30),
  username varchar(20),
  tel varchar(20),
  phone varchar(20),
  zipcode varchar(10),
  address varchar(100),
  email varchar(50) not null unique,
  created datetime default current_timestamp,
  modified datetime default current_timestamp on update current_timestamp
)

create table menu (
  id int primary key auto_increment,
  name varchar(50)
)

create table submenu (
  id int primary key auto_increment,
  menuid int,
  name varchar(50)
)

create table product (
  id bigint primary key auto_increment,
  name varchar(50),
  price int,
  menuid int,
  submenuid int,
  details text,
  image varchar(100),
  factory varchar(50)
)

create table cart (
  id bigint primary key auto_increment,
  userid bigint,
  productid bigint,
  price int,
  amount int,
  total int
)

create table review (
  id bigint primary key auto_increment,
  productid bigint,
  userid bigint,
  content text,
  created datetime default current_timestamp,
  modified datetime default current_timestamp on update current_timestamp
)