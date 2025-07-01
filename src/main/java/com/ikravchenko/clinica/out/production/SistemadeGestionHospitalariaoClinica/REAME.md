mkdir src/main/java

docker exec -it mysql-container mysql -u root -p <passw0rd>

mvn compile exec:java -Dexec.mainClass=TestConnection

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=passw0rd -p 3306:3306 -d mysql:latest

mvn compile

mvn exec:java


// Preguntas 

como acer único
horario

excepciones(como)

layer for database


Persona (abstract) 
├── Paciente (concrete) → persona + pacientes tables
└── Empleado (concrete) → persona + empleado table
    ├── Medico (concrete) → persona + empleado + medico tables
    ├── Enfermero (concrete) → persona + empleado + enfermero tables
    └── Administrativo (concrete) → persona + empleado + administrativo tables