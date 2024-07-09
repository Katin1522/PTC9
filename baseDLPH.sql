CREATE TABLE Usuarios (
    idUsuario NUMBER NOT NULL,
    contrasenaUsuario VARCHAR2(50) NOT NULL,
    fechaRegistro DATE,
    edadU NUMBER NOT NULL CHECK (edadU >= 0),
    CONSTRAINT pk_Usuarios PRIMARY KEY (idUsuario)
);

CREATE SEQUENCE Usua START WITH 1 INCREMENT BY 1;
 
CREATE TRIGGER TrigUsua
BEFORE INSERT ON Usuarios
FOR EACH ROW
BEGIN
    SELECT Usua.NEXTVAL INTO :NEW.idUsuario FROM DUAL;
END;
 
CREATE TABLE rangos (
    idRango NUMBER NOT NULL,
    nombreRango VARCHAR2(50) NOT NULL,
    CONSTRAINT pk_rangos PRIMARY KEY (idRango)
);

CREATE SEQUENCE Rang START WITH 1 INCREMENT BY 1;


CREATE TRIGGER TrigRang
BEFORE INSERT ON rangos
FOR EACH ROW
BEGIN
    SELECT Rang.NEXTVAL INTO :NEW.idRango FROM DUAL;
END;
 
CREATE TABLE Visitas (
    idVisita NUMBER NOT NULL,
    fechaVisita DATE,
    nombreVisita VARCHAR2(100),
    CONSTRAINT pk_Visitas PRIMARY KEY (idVisita)
); 

CREATE SEQUENCE Vis START WITH 1 INCREMENT BY 1;
 
CREATE TRIGGER TrigVis
BEFORE INSERT ON Visitas
FOR EACH ROW
BEGIN
    SELECT Vis.NEXTVAL INTO :NEW.idVisita FROM DUAL;
END;
 
CREATE TABLE Pacientes (
    idPaciente NUMBER NOT NULL,
    nombrePaciente VARCHAR2(100) NOT NULL,
    condicionPaciente VARCHAR2(100) NOT NULL,
    fechaVisita DATE NOT NULL,
    estaturaPaciente NUMBER(3,2) NOT NULL CHECK (estaturaPaciente >= 0),
    tratamiento VARCHAR2(100),
    edadP NUMBER NOT NULL,
    rangoP NUMBER NOT NULL,
    idUsuarioP NUMBER NOT NULL,
    CONSTRAINT pk_Pacientes PRIMARY KEY (idPaciente),
    FOREIGN KEY (rangoP) REFERENCES rangos(idRango),
    FOREIGN KEY (idUsuarioP) REFERENCES Usuarios(idUsuario)
);
 
CREATE TABLE doctores (
    idDoctor NUMBER NOT NULL,
    nombreDoctor VARCHAR2(100) NOT NULL,
    rangoD NUMBER NOT NULL,
    idUsuarioD NUMBER NOT NULL,
    edadD NUMBER NOT NULL CHECK (edadD >= 0),
    CONSTRAINT pk_doctores PRIMARY KEY (idDoctor),
    FOREIGN KEY (rangoD) REFERENCES rangos(idRango),
    FOREIGN KEY (idUsuarioD) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE enfermeras (
    idEnfermera NUMBER NOT NULL,
    nombreEnfermera VARCHAR2(50) NOT NULL,
    rangoEa NUMBER NOT NULL,
    idUsuarioEa NUMBER NOT NULL,
    edadEa NUMBER NOT NULL CHECK (edadEa >= 0),
    CONSTRAINT pk_enfermeras PRIMARY KEY (idEnfermera),
    FOREIGN KEY (rangoEa) REFERENCES rangos(idRango),
    FOREIGN KEY (idUsuarioEa) REFERENCES Usuarios(idUsuario)
);
 
CREATE TABLE recetas (
  idReceta NUMBER NOT NULL,
  medicamento VARCHAR2(100),
  CONSTRAINT pk_recetas PRIMARY KEY (idReceta)
);

CREATE TABLE tratamientos (
  idTratamiento NUMBER NOT NULL,
  idReceta NUMBER NOT NULL,
  medicamento VARCHAR2(100),
  
  fechaConsultaDoctor DATE,
  CONSTRAINT pk_tratamientos PRIMARY KEY (idTratamiento),
  CONSTRAINT fk_Receta FOREIGN KEY (idReceta) REFERENCES receta(idReceta)
);
 
CREATE TABLE TratamientoR (
  idTratamientoR NUMBER NOT NULL,
  fechaConsultaDoctor DATE,
  idTratamiento NUMBER NOT NULL,
  idReceta NUMBER NOT NULL,
  CONSTRAINT pk_TratamientoR PRIMARY KEY (idTratamientoR),
  CONSTRAINT fk_TratamientoR_Ref FOREIGN KEY (idTratamiento) REFERENCES tratamiento(idTratamiento),
  CONSTRAINT fk_Receta_Ref FOREIGN KEY (idReceta) REFERENCES receta(idReceta)
);
 
SELECT d.*, u.*
FROM doctor d
JOIN Usuarios u ON d.idUsuarioD = u.idUsuario;