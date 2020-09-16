Create table if not exists Person (
   id          bigint(20) not null auto_increment,
   address     varchar(100) not null,
   first_name  varchar(100) not null,
   gender      varchar(100) not null, 
   last_name   varchar(100) not null,
   primary key(id)
)