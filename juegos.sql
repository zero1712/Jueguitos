create table tipos_usuario(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
	   tipo VARCHAR(30), PRIMARY KEY (clave));

create table usuarios(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), login VARCHAR(16) NOT NULL, 
       password VARCHAR(20) NOT NULL, nombre VARCHAR(40), primer_apellido VARCHAR(20), segundo_apellido VARCHAR(20),
       edad INT, tipo INT, FOREIGN KEY(tipo) REFERENCES tipos_usuario(clave) ON DELETE CASCADE ON UPDATE RESTRICT,
 PRIMARY KEY(clave));

create table juegos(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nombre VARCHAR(30),descripcion VARCHAR(200),reglas VARCHAR(200), PRIMARY KEY (clave));

create table records(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),cve_juego INT , cve_usuario INT, record INT, FOREIGN KEY(cve_juego) REFERENCES juegos(clave) ON DELETE CASCADE ON UPDATE RESTRICT, FOREIGN KEY(cve_usuario) REFERENCES usuarios(clave) ON DELETE CASCADE ON UPDATE RESTRICT, PRIMARY KEY (clave));

create table noticias(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),titulo VARCHAR(30),fecha DATE,descripcion VARCHAR(100),imagen VARCHAR(30), PRIMARY KEY (clave));

create table torneos(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nombre VARCHAR(30),fecha_ini DATE,fecha_fin DATE,descripcion VARCHAR(100),cve_juego INT,FOREIGN KEY(cve_juego) REFERENCES juegos(clave) ON DELETE CASCADE ON UPDATE RESTRICT, PRIMARY KEY (clave));

create table misiones(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nombre VARCHAR(30),fecha_ini DATE,fecha_fin DATE,objetivo INT,cve_juego INT,FOREIGN KEY(cve_juego) REFERENCES juegos(clave) ON DELETE CASCADE ON UPDATE RESTRICT, PRIMARY KEY (clave));

create table inscripciones(clave INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),fecha DATE, cve_torneo INT,cve_usuario INT ,FOREIGN KEY(cve_torneo) REFERENCES torneos(clave) ON DELETE CASCADE ON UPDATE RESTRICT, FOREIGN KEY(cve_usuario) REFERENCES usuarios(clave) ON DELETE CASCADE ON UPDATE RESTRICT, PRIMARY KEY (clave));

