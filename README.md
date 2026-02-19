# Sistema de Gestión de Empleados

Aplicacion web CRUD desarrollada con Spring Boot que permite gestionar el registro de empleados mediante una interfaz web conectada a una base de datos MySQL.

## Descripcion

Sistema web para administrar empleados desarrollado con Spring Boot y Spring MVC. Permite listar, agregar, editar y eliminar empleados desde el navegador, con persistencia en base de datos relacional mediante JPA/Hibernate.

El proyecto implementa una arquitectura en capas:

- **Modelo**: `Empleado` (entidad JPA mapeada a tabla MySQL).
- **Repositorio**: `Empleadorepositorio` (CRUD automatico con Spring Data JPA).
- **Servicio**: `IEmpleadoServicio` + `EmpleadoServicio` (logica de negocio).
- **Controlador**: `IndexControlador` (manejo de peticiones HTTP).
- **Vistas**: JSP con JSTL (interfaz web con Bootstrap 5).

## Caracteristicas principales

- Listado de empleados en tabla con Bootstrap 5.
- Alta de nuevo empleado mediante formulario web.
- Edicion de datos de un empleado existente.
- Eliminacion de empleados.
- Formateo de sueldos como moneda con `fmt:formatNumber`.
- Logger con SLF4J para trazabilidad de operaciones en consola.
- Navbar responsive con Bootstrap 5.

## Estructura del proyecto

```text
Empleados/
├── pom.xml                                         # Dependencias Maven
├── src/
│   └── main/
│       ├── java/git/empleados/
│       │   ├── EmpleadosApplication.java           # Punto de entrada (@SpringBootApplication)
│       │   ├── modelo/
│       │   │   └── Empleado.java                   # Entidad JPA con Lombok
│       │   ├── repositorio/
│       │   │   └── Empleadorepositorio.java         # CRUD automatico (JpaRepository)
│       │   ├── servicio/
│       │   │   ├── IEmpleadoServicio.java           # Interfaz de negocio
│       │   │   └── EmpleadoServicio.java            # Implementacion del servicio
│       │   └── controlador/
│       │       └── IndexControlador.java            # Controlador HTTP (rutas y vistas)
│       ├── resources/
│       │   └── application.properties              # Configuracion Spring Boot y MySQL
│       └── webapp/WEB-INF/jsp/
│           ├── index.jsp                           # Vista: listado de empleados
│           ├── agregar.jsp                         # Vista: formulario alta
│           ├── editar.jsp                          # Vista: formulario edicion
│           └── comunes/
│               ├── cabecero.jsp                    # Cabecera HTML compartida (Bootstrap CSS)
│               ├── navegacion.jsp                  # Barra de navegacion compartida
│               └── pie-pagina.jsp                  # Cierre HTML compartido (Bootstrap JS)
```

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4** con Spring MVC y Spring Data JPA
- **Hibernate** como implementacion de JPA (ORM)
- **MySQL** como base de datos relacional
- **Lombok** para eliminar codigo boilerplate (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`)
- **JSP + JSTL** como motor de vistas
- **Bootstrap 5** para el diseño responsive
- **SLF4J + Logback** para el sistema de logging
- **Maven** para la gestion de dependencias

## Conceptos demostrados

- **Arquitectura en capas**: Modelo → Repositorio → Servicio → Controlador → Vista
- **Patron MVC**: separacion entre datos, logica y presentacion
- **Spring Data JPA**: repositorio que genera los metodos CRUD automaticamente sin SQL manual
- **Inyeccion de dependencias**: uso de `@Autowired` para desacoplar componentes
- **Programacion orientada a interfaces**: `IEmpleadoServicio` como contrato de negocio
- **Anotaciones JPA**: `@Entity`, `@Id`, `@GeneratedValue`
- **Lombok**: reduccion de boilerplate con `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`
- **Patron Post/Redirect/Get**: evita reenvio de formularios al refrescar la pagina
- **JSTL**: `c:forEach` para iterar listas, `fmt:formatNumber` para formatear moneda, `c:url` para URLs dinamicas

## Requisitos previos

- Java JDK 21+
- Maven 3.8+
- MySQL Server en ejecucion (puerto 3306)

## Configuracion de la base de datos

Editar `src/main/resources/application.properties` con las credenciales de tu MySQL:

```properties
spring.datasource.username=root
spring.datasource.password=**********
```

La base de datos `empleados_db` y la tabla `empleado` se crean automaticamente al iniciar la aplicacion.

## Como ejecutar el proyecto

### Desde IntelliJ IDEA

1. Abrir la carpeta `Empleados` como proyecto Maven.
2. Esperar que Maven descargue las dependencias.
3. Ejecutar `EmpleadosApplication.java`.
4. Ingresar en el navegador: `http://localhost:8080/empleados`

### Desde linea de comandos

```bash
cd Empleados
mvn spring-boot:run
```

## Flujo de uso

1. Al ingresar a `http://localhost:8080/empleados` se muestra la lista de empleados.
2. **Agregar**: click en "Agregar Empleado" → completar el formulario → click "Agregar".
3. **Editar**: click en "Editar" de un empleado → modificar datos → click "Editar".
4. **Eliminar**: click en "Eliminar" de un empleado → se elimina y vuelve al listado.

## Posibles mejoras futuras

- Agregar validacion del lado del servidor con Bean Validation (`@NotBlank`, `@Positive`).
- Implementar paginacion para manejar grandes volumenes de datos.
- Agregar confirmacion de eliminacion con un modal de Bootstrap.
- Migrar las vistas de JSP a Thymeleaf.
- Implementar tests unitarios con JUnit y Mockito para la capa de servicio.

---