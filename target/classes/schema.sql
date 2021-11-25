--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:


drop table if exists Atleta;

create table Atleta (
  email varchar(32) primary key not null,
  genero varchar(1) NOT NULL,
  nombre varchar(32) NOT NULL,
  apellidos varchar(32) NOT NULL,
  dni varchar(32) NOT NULL,
  fechaNacimiento date NOT NULL
);

drop table if exists Competicion;

create table Competicion(
	id int primary key not null,
	inicio date not null, 
	fin date not null,
	tipo varchar(32) not null,
	numPlazas int not null,
	fecha date not null,
	nombre varchar(32) not null, 
	descr varchar(32), 
	distancia int not null,
	check(numPlazas>=0),	
	check(inicio<=fin), 
	check(fin<fecha)  
);

drop table if exists MetodoDePago;

create table MetodoDePago(
	id int NOT NULL,
	tipo varchar(32) NOT NULL,
	estado boolean,
	primary key (id_metodopago)
);

drop table if exists Inscripcion;

create table Inscripcion(
	dorsal varchar(32) not null,
	tiempo String not null,
	precio int not null,
	ultFechaModif date not null,
	email_atleta varchar(32) not null,
	categoriaSexo varchar(32) not null,
	id_metodoPago int not null,
	id_competicion int not null,
	foreign key (email_atleta) references Atleta (email),
	foreign key (id_metodoPago) references MetodoDePago (id),
	foreign key (id_competicion) references Competicion (id),
	primary key (id_competicion, email_atleta)

);

drop table if exists Resultados;

create table Resultados(
	id_competicion int not null,
	dorsal varchar(32) not null,
	tInicio String not null,
	tFin String not null,
	estado String,
	foreign key(id_competicion) references Competicion(id),
	foreign key(dorsal) references Inscripcion(dorsal),
	primary key(id_competicion, dosal)
);