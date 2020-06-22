use webshop;

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
);

create table menu (
  id bigint primary key auto_increment,
  name varchar(50)
);

create table submenu (
  id bigint primary key auto_increment,
  menuid bigint,
  name varchar(50),

  FOREIGN KEY (menuid) REFERENCES menu(id)
);

create table product (
  id bigint primary key auto_increment,
  name varchar(50),
  price int,
  menuid bigint,
  submenuid bigint,
  details text,
  factory varchar(50),
  
  FOREIGN KEY(menuid) REFERENCES menu(id),
  FOREIGN KEY(submenuid) REFERENCES submenu(id)
);

create table cart (
  id bigint primary key auto_increment,
  userid varchar(50),
  productid bigint,
  price int,
  amount int,
  total int,
  created datetime default current_timestamp,
  
  FOREIGN KEY(userid) REFERENCES user(account),
  FOREIGN KEY(productid) REFERENCES product(id)
);

create table review (
  id bigint primary key auto_increment,
  productid bigint,
  userid bigint,
  content text,
  created datetime default current_timestamp,
  modified datetime default current_timestamp on update current_timestamp,
  
  FOREIGN KEY(productid) REFERENCES product(id),
  FOREIGN KEY(userid) REFERENCES user(id)
);

