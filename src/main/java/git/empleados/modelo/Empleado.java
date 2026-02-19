package git.empleados.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entidad que representa un Empleado en la base de datos.
 * @Entity le indica a JPA/Hibernate que esta clase se mapea a una tabla de MySQL.
 * Las anotaciones de Lombok generan automaticamente getters, setters,
 * constructores, equals, hashCode y toString sin escribirlos manualmente.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {

    // Clave primaria de la tabla, generada automaticamente por MySQL (AUTO_INCREMENT)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    // Atributos del empleado - Hibernate crea las columnas correspondientes en la BD
    private String nombreEmpleado;
    private String departamento;
    private Double sueldo;

}
