create database db_estacion;
use db_estacion;

create table if not exists trayecto(
id_trayecto integer primary key auto_increment,
distancia integer,
cantidad_Max integer,
origen varchar(40),
destino varchar(40),
estado varchar(30),
costo double
);

create table if not exists boleto(
id_boleto integer primary key auto_increment,
nro_boleto integer,
email varchar(60),
nombre_cliente varchar(50),
origen varchar(40),
destino varchar(40),
camino varchar(20),
costo double
);
create table if not exists estacion(
id_estacion integer primary key auto_increment,
nombre varchar(40),
inicio datetime,
cierre datetime,
estado varchar(20),
id_trayecto integer,
id_boleto integer,
constraint fk_trayecto foreign key (id_trayecto) references trayecto(id_trayecto),
constraint fk_boleto foreign key (id_boleto) references boleto(id_boleto)
);

create table if not exists mantenimiento(
id_mantenimiento integer primary key auto_increment,
fecha_inicio date,
fecha_fin date,
observaciones varchar (50),
id_estacion integer,
constraint fk_id_Estacion foreign key (id_estacion) references estacion (id_estacion)
);


create table if not exists linea(
id_linea integer primary key auto_increment,
nombre  varchar(50),
color varchar(30),
estado varchar(30)
);

create table if not exists linea_estacion(
id_estacion integer,
id_linea integer,
constraint pk_linea_estacion primary key(id_estacion,id_linea),
constraint fk_estacion foreign key (id_estacion)references estacion(id_estacion),
constraint fk_linea foreign key(id_linea) references linea(id_linea)
);

