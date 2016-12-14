# --- Sample dataset

# --- !Ups

insert into category (id,name) values ( 1,'Guitar' );
insert into category (id,name) values ( 2,'Drums' );
insert into category (id,name) values ( 3,'Keyboards' );
insert into category (id,name) values ( 4,'Amps' );
insert into category (id,name) values ( 5,'Microphone' );
insert into category (id,name) values ( 6,'Lighting' );


insert into product (id,name,category,description,stock,price) values ( 1,'Gibson','Guitar','Gibson J 45 Custom',3,2999.00 );
insert into product (id,name,category,description,stock,price) values ( 2,'Mapex','Drums','Mapex Saturn',5,1234.99 );
insert into product (id,name,category,description,stock,price) values ( 3,'Casio','Keyboards','Casio CDP-220R Digital Piano Deluxe Pack',5, 434.99 );
insert into product (id,name,category,description,stock,price) values ( 4,'Marshall','Amps','Marshall MG50CFX Carbon Fibre',9,234.99 );
insert into product (id,name,category,description,stock,price) values ( 5,'Shure','Microphone','Shure SM 58',5,109.00 );
insert into product (id,name,category,description,stock,price) values ( 6,'Staireville','Lighting','Stairvile Octagon Theater CW/WW 36x1W',12,149.00);

insert into user (email,name,password,role) values ( 'admin@products.com', 'Phil Admin', 'password', 'admin' );
insert into user (email,name,password,role) values ( 'manager@products.com', 'Howie Manager', 'password', 'manager' );
insert into user (email,name,password,role) values ( 'customer@products.com', 'Shane Customer', 'password', 'customer' );