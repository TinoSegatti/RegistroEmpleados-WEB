package git.empleados.repositorio;

import git.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de acceso a datos para la entidad Empleado.
 * Al extender JpaRepository, Spring genera automaticamente los metodos CRUD:
 *   findAll()       - trae todos los empleados (SELECT *)
 *   findById(id)    - busca por clave primaria
 *   save(empleado)  - inserta o actualiza segun si el ID ya existe
 *   delete(empleado)- elimina el registro de la BD
 * No es necesario escribir ninguna query SQL manualmente.
 */
public interface Empleadorepositorio extends JpaRepository<Empleado, Integer> {
}
