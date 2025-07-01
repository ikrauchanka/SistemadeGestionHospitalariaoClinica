# SistemadeGestionHospitalariaoClinica
Sistema de Gestion Hospitalaria/Clínica

mvn clean spring-boot:run
docker exec -it mysql-container mysql -u root -p


```bash
mkdir src/main/java

docker exec -it mysql-container mysql -u root -p <passw0rd>

mvn compile exec:java -Dexec.mainClass=TestConnection

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=passw0rd -p 3306:3306 -d mysql:latest

mvn compile

mvn exec:java

```
// Preguntas

como acer único

horario

excepciones(como)

layer for database

creando los objetos (horario etc...) do I need to run init script to create it ?

```
mvn clean spring-boot:run

# Quick Start Guide

## Docker Setup

### Create MySQL Container
```bash
docker run --name clinica-mysql \
  -e MYSQL_ROOT_PASSWORD=root123 \
  -e MYSQL_DATABASE=clinica \
  -e MYSQL_USER=clinica \
  -e MYSQL_PASSWORD=clinica123 \
  -p 3306:3306 \
  -d mysql:8.0
```

### Run Container
```bash
docker start clinica-mysql
```

## Database Setup

### Access MySQL
```bash
docker exec -it clinica-mysql mysql -u clinica -pclinica123
```

### Create Database (if needed)
```sql
CREATE DATABASE IF NOT EXISTS clinica;
USE clinica;
```

### Import Data
```bash
docker exec -i clinica-mysql mysql -u clinica -pclinica123 clinica < misc/fake_data.sql
```

## Run Application

### Maven Commands
```bash
# Clean and compile
mvn clean compile

# Run application
mvn spring-boot:run

# Package JAR
mvn clean package

# Run JAR
java -jar target/SistemadeGestionHospitalariaoClinica-0.0.1-SNAPSHOT.jar
```

## Access Application
- **URL**: http://localhost:8080
- **Database**: localhost:3306 (clinica/clinica123)

## Quick Commands Summary
```bash
# Start everything
docker start clinica-mysql
mvn spring-boot:run

# Stop everything
docker stop clinica-mysql

``` 