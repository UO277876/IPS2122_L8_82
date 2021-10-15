--Datos para carga inicial de la base de datos
delete from carreras;
insert into carreras(id,inicio,fin,fecha,descr,numPlazas,nombre, tipo,distancia) values 
	(100,'2016-10-05','2016-10-25','2016-11-09','finalizada', 50,'A', 'montaña',5000),
	(101,'2016-10-05','2016-10-25','2016-11-10','en fase 3', 60, 'B','asfalto',10000),
	(102,'2016-11-05','2016-11-09','2016-11-20','en fase 2', 100, 'C', 'montaña',5000),
	(103,'2016-11-10','2016-11-15','2016-11-21','en fase 1', 150, 'D', 'montaña',6000),
	(104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion', 62, 'E','asfalto',4000);
	
delete from atleta;
insert into atleta(email,nombre,apellidos,genero,fechaNacimiento) values 
	('pepe504@gmail.com','Pepe','Fernandez Herrero','masculino','1987-02-13'),
	('manola4@yahoo.es','Manola','Cordero Vazquez','femenino','1997-09-06'),
	('carlos9oo@hotmail.com','Carlos','Gonzalez Huelmo','masculino','2000-11-23'),
	('sealoquesea@gmail.com','Sara','Eliseo Almirante','femenino','1999-05-16'),
