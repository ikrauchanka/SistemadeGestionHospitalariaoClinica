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
docker exec -i clinica-mysql mysql -u clinica -pclinica123 clinica < fake_data.sql
```

## Run Application

### Maven Commands
```bash
# Clean and compile
mvn clean compile

# Run application
mvn spring-boot:run

# Package WAR
mvn clean package

# Run WAR (embedded Tomcat)
java -jar target/clinica-0.0.1-SNAPSHOT.war

# Deploy to external Tomcat (optional)
# Copy target/clinica-0.0.1-SNAPSHOT.war to $TOMCAT_HOME/webapps/
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
# Ctrl+C to stop Spring Boot
```

## Mejoras del Proyecto

- **Pruebas unitarias**: Implementar tests con JUnit 5 y Mockito
- **Implementar RBAC**: Control de acceso basado en roles (Role-Based Access Control)
- **Mejorar validación**: Agregar Bean Validation y validadores personalizados
- **Notificaciones por email**: Sistema de alertas y recordatorios automáticos
- **Paginación**: Manejo eficiente de grandes volúmenes de datos
- **Búsqueda y filtros**: Funcionalidad de búsqueda avanzada
- **Interfaz responsiva**: Diseño adaptable para dispositivos móviles
