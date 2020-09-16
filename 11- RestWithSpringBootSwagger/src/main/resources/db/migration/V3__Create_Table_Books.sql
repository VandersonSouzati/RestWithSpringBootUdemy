CREATE TABLE books (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  author varchar(80),
  launch_date date NOT NULL,
  price decimal(65,2) NOT NULL,
  title varchar(80), 
  primary key(id)
);