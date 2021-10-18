--Datos para carga inicial de la base de datos
delete from Atleta;
insert into Atleta(email,nombre,apellidos,genero,fechaNacimiento) values 
	('mariafdz92@hotmail.es','Maria','Fernandez Fernandez','femenino','1992-11-04'),
	('juangg73@hotmail.es','Juan','Gomez Garcia','masculino','1973-05-23'),
	('albertoce11@hotmail.es','Alberto','Castillo Egea','masculino','1988-02-18'),
	('frangg80@hotmail.es','Fran','Gomez Garcia','masculino','1980-08-12'),
	('laurarl@hotmail.es','Laura','Romano Lopez','femenino','1997-01-20'),
	
delete from Competicion;
insert into Competicion(id, inicio, fin, tipo, numPlazas, fecha, nombre, descr, distancia, cuota) values
	(1,'2021-10-08','2021-10-31','montaña',100,'2021-11-07','montaña 1',' ',1000),
	(2,'2021-10-10','2021-10-21','asfalto',100,'2021-11-01','asfalto 1',' ',2000),
	(3,'2021-10-03','2021-10-11','asfalto',100,'2021-11-30','asfalto 2',' ',2000),
	(4,'2021-11-08','2021-11-20','montaña',100,'2021-11-27','montaña 2',' ',5000),
	(5,'2021-11-10','2021-11-20','montaña',100,'2021-11-21','montaña 3',' ',8000),
	(6,'2021-09-03','2021-09-11','asfalto',100,'2021-09-30','asfalto 3',' ',3000),
