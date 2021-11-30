--Datos para carga inicial de la base de datos
delete from Atleta;
insert into Atleta(email,nombre,apellidos,genero,fechaNacimiento,dni) values 
	('mariafdz92@hotmail.es','Maria','Fernandez Fernandez','femenino','1992-11-04','342'),
	('juangg73@hotmail.es','Juan','Gomez Garcia','masculino','1973-05-23','432342'),
	('albertoce11@hotmail.es','Alberto','Castillo Egea','masculino','1988-02-18','55665'),
	('frangg80@hotmail.es','Fran','Gomez Garcia','masculino','1980-08-12','5454'),
	('laurarl@hotmail.es','Laura','Romano Lopez','femenino','1997-01-20','8764');
	
delete from Competicion;
insert into Competicion(id,inicio,fin,tipo,numPlazas, fecha, nombre, descr, distancia, hayCancelacion, dorsalesReservados) values 
	(3244,'2021-05-04','2021-05-12','asfalto',50, '2021-06-12','asfalto por oviedo', 'Carrera que recorre toda la ciudad de Oviedo',25, false,2),
	(56564,'2021-07-10','2021-08-01','montaña',60, '2021-10-15','somiedo', 'Carrera que recorre parte de la fauna de Somiedo',40, false,3),
	(5332,'2021-01-21','2021-02-28','montaña',30, '2021-03-17','lagunas', 'Recorrido por las lagunas',15, false,2),
	(6712,'2021-12-13','2021-12-14','asfalto',30, '2021-12-28','luarca', 'Luarca Racing',25, false,3),
	(4200,'2021-11-15','2021-11-17','montaña',20, '2021-12-31','gijon', 'San Silvestre',13, false,2),	
	(1221,'2021-12-31','2022-01-20','asfalto',40, '2022-02-17','navia', 'Carrera por el antroxu',8, false,0);

delete from MetodoDePago;
insert into MetodoDePago(id, tipo, estado) values
	(2555, "tc", true),
	(0105, "tc", true),
	(6789, "transferencia", false),
	(1256, "transferencia", true),
	(9090, "tc", true),
	(11888, "tc", true);	
	
delete from Inscripcion;
insert into Inscripcion(dorsal,tiempo,precio,email_atleta, ultFechaModif,categoriaSexo, metodoPago, id_metodoPago, id_competicion) values 
	('A','---',3,'mariafdz92@hotmail.es','2021-05-05','femenino','tarjeta', 2555, 3244),
	('12','12',3,'mariafdz92@hotmail.es','2021-07-22','femenino','tarjeta', 0105, 56564),
	('15','---',13,'juangg73@hotmail.es','2021-07-20','masculino','transferencia', 6789, 56564),
	('10','50',2,'albertoce11@hotmail.es','2021-05-07','masculino','tarjeta', 1256, 3244),
	('11','1',6,'frangg80@hotmail.es','2021-01-22','masculino','transferencia', 9090, 5332),
	('B','---',5,'laurarl@hotmail.es','2021-02-12','femenino','tarjeta', 11888, 5332);
	
insert into Competicion(id,inicio,fin,tipo,numPlazas, fecha, nombre, descr, distancia, hayCancelacion, porcentajeDevuelto, fechaLimite, dorsalesReservados) values 
	(43432,'2021-11-11','2021-12-12','asfalto',50, '2022-01-12','cantabria', 'descripcion',25, true,40,'2021-12-20',2),
	(97554,'2021-11-11','2021-12-01','montaña',60, '2022-10-15','montañas', 'descripcion',40, true,10,'2021-12-21',3),
	(123,'2021-11-11','2021-12-01','asfalto',30, '2022-03-17','rios', 'descripcion',15, true,20,'2021-12-19',2);

insert into MetodoDePago(id, tipo, estado) values
	(543, "tc", true),
	(432, "tc", true),
	(5353, "transferencia", false),
	(5435, "tc", true);
	
insert into Inscripcion(dorsal,tiempo,precio,email_atleta, ultFechaModif,categoriaSexo, metodoPago, id_metodoPago, id_competicion) values 
	('23','---',15,'mariafdz92@hotmail.es','2021-05-05','femenino','tarjeta', 543, 43432),
	('A','---',8,'mariafdz92@hotmail.es','2021-07-22','femenino','tarjeta', 432, 97554),
	('54','---',13,'juangg73@hotmail.es','2021-07-20','masculino','transferencia', 5353, 43432),
	('12','---',23,'albertoce11@hotmail.es','2021-05-07','masculino','tarjeta', 5435, 123);
	
