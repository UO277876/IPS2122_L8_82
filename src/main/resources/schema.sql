--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:


drop table Atleta;

create table Atleta (
  email varchar(32) primary key not null,
  nombre varchar(32) NOT NULL,
  apellidos varchar(32) NOT NULL,
  genero enum('masculino','femenino') not null,
  fechaNacimiento date not null
);

drop table carreras;

create table carreras(
	id int primary key not null,
	inicio date not null, 
	fin date not null,
	numPlazas int not null,
	fecha date not null,
	nombre varchar(32) not null, 
	descr varchar(32), 
	tipo enum('montaña','asfalto') not null,
	distancia int not null,
	check(numPlazas>=0),	
	check(inicio<=fin), 
	check(fin<fecha)  
);

drop table Inscripcion;

create table Inscripcion(
	inicio date not null, 
	fin date not null,
	categoriaSexo enum ('masculino','femenino') not null,
	dorsal varchar(32) not null,
	tiempo int not null,
	metodoPago enum ('metalico', 'tarjeta') not null,
	email_atleta varchar(32) not null,
	id_competicion int not null,
	foreign key (email_atleta) references Atleta (email),
	foreign key (id_competicion) references Competicion (id),
	primary key (id_competicion, email_atleta)

);