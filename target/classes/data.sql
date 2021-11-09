--Datos para carga inicial de la base de datos
delete from Atleta;
insert into Atleta(email,nombre,apellidos,genero,fechaNacimiento) values 
	('mariafdz92@hotmail.es','Maria','Fernandez Fernandez','femenino','1992-11-04'),
	('juangg73@hotmail.es','Juan','Gomez Garcia','masculino','1973-05-23'),
	('albertoce11@hotmail.es','Alberto','Castillo Egea','masculino','1988-02-18'),
	('frangg80@hotmail.es','Fran','Gomez Garcia','masculino','1980-08-12'),
	('laurarl@hotmail.es','Laura','Romano Lopez','femenino','1997-01-20');
	
delete from Inscripcion;
insert into Inscripcion(dorsal,tiempo,precio,email_atleta, ultFechaModif,categoriaSexo, metodoPago, id_competicion) values 
	('A','---',3,'mariafdz92@hotmail.es','2021-05-05','femenino','tarjeta',3244),
	('12','12',3,'mariafdz92@hotmail.es','2021-07-22','femenino','tarjeta',56564),
	('15','---',13,'juangg73@hotmail.es','2021-07-20','masculino','transferencia',56564),
	('10','50',2,'albertoce11@hotmail.es','2021-05-07','masculino','tarjeta',3244),
	('11','1',6,'frangg80@hotmail.es','2021-01-22','masculino','transferencia',5332),
	('B','---',5,'laurarl@hotmail.es','2021-02-12','femenino','tarjeta',5332);
	
delete from Competicion;
insert into Competicion(id,inicio,fin,tipo,numPlazas, fecha, nombre, descr, distancia) values 
	(3244,'2021-05-04','2021-05-12','asfalto',50, '2021-06-12','asfalto por oviedo', 'Carrera que recorre toda la ciudad de Oviedo',25),
	(56564,'2021-07-10','2021-08-01','montaña',60, '2021-10-15','somiedo', 'Carrera que recorre parte de la fauna de Somiedo',40),
	(5332,'2021-01-21','2021-02-28','montaña',30, '2021-03-17','lagunas', 'Recorrido por las lagunas',15),
	(6712,'2021-12-13','2021-12-14','asfalto',30, '2021-12-28','luarca', 'Luarca Racing',25),
	(4200,'2021-11-15','2021-11-17','montaña',20, '2021-12-31','gijon', 'San Silvestre',13),	
	(1221,'2021-12-31','2022-01-20','asfalto',40, '2022-02-17','navia', 'Carrera por el antroxu',8);	

