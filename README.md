# Empresa CRUD Application

Este proyecto es una API REST desarrollada con **Spring Boot** que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una entidad "empresa". La aplicación también incluye una interfaz de documentación de la API mediante **Swagger**.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Maven**
- **MySQL**

## Instrucciones para ejecutar el proyecto localmente

### 1. Clonar el repositorio

```bash
git clone https://github.com/memetrigueros/prueba-backend-3.git
cd prueba-backend-3
```

### 2. Configuración de la base de datos

Asegúrate de tener MySQL instalado y en funcionamiento. Crea una base de datos en MySQL llamada company_db (o el nombre que desees) con el siguiente comando:

```bash
CREATE DATABASE empresa_db;
```

### 3. Configuración de la conexión a la base de datos

Abre el archivo src/main/resources/application.properties y configura los siguientes parámetros de la base de datos:

spring.datasource.url=jdbc:mysql://localhost:3306/company_db
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true


### 4. Ejecutar la aplicación

Para ejecutar la aplicación de forma local, usa el siguiente comando:

```bash
mvn spring-boot:run
```

El proyecto se iniciará en el puerto por defecto de Spring Boot (8080).

### 5. Acceder a la API

Una vez que la aplicación esté en funcionamiento, puedes acceder a los siguientes endpoints de la API:

* Obtener todas las empresas (GET):
GET http://localhost:8080/api/companies

* Obtener una empresa por ID (GET):
GET http://localhost:8080/api/companies/{id}

* Crear una nueva empresa (POST):
POST http://localhost:8080/api/companies

* Actualizar una empresa (PUT):
PUT http://localhost:8080/api/companies/{id}

* Eliminar una empresa (DELETE):
DELETE http://localhost:8080/api/companies/{id}

#### Swagger API Documentation

La documentación de la API está disponible en Swagger. Para acceder a Swagger, abre tu navegador y ve a la siguiente URL:

```bash
http://localhost:8080/swagger-ui.html
```