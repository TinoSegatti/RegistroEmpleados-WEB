package git.empleados.servicio;

import git.empleados.modelo.Empleado;

import java.util.List;

/**
 * Interfaz que define el contrato de operaciones para el servicio de empleados.
 * Usar una interfaz permite desacoplar el controlador de la implementacion concreta,
 * facilitando cambiar o testear la logica de negocio sin tocar la capa de presentacion.
 */
public interface IEmpleadoServicio {

    // Retorna todos los empleados registrados en la BD
    public List<Empleado> listarEmpleados();

    // Busca un empleado por su ID, retorna null si no existe
    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    // Guarda un empleado nuevo (INSERT) o actualiza uno existente (UPDATE)
    public void guardarEmpleado(Empleado empleado);

    // Elimina un empleado de la base de datos
    public void eliminarEmpleado(Empleado empleado);
}
