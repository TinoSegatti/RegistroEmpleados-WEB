package git.empleados.servicio;

import git.empleados.modelo.Empleado;
import git.empleados.repositorio.Empleadorepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion de la capa de negocio para la gestion de empleados.
 * Actua como intermediaria entre el controlador y el repositorio.
 * @Service registra esta clase como componente de Spring para que pueda
 * ser inyectada automaticamente donde se necesite.
 */
@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    // Spring inyecta automaticamente el repositorio mediante @Autowired
    // No es necesario instanciarlo manualmente (Inversion de Control)
    @Autowired
    private Empleadorepositorio empleadorepositorio;

    // Retorna todos los empleados usando el metodo findAll() de JpaRepository
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadorepositorio.findAll();
    }

    // Busca un empleado por su ID
    // orElse(null) devuelve null si no encuentra ninguno con ese ID
    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = empleadorepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    // save() de JpaRepository detecta automaticamente si debe hacer INSERT o UPDATE
    // Si el objeto tiene ID asignado actualiza, si no tiene ID inserta uno nuevo
    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadorepositorio.save(empleado);
    }

    // Elimina el empleado de la base de datos
    @Override
    public void eliminarEmpleado(Empleado empleadoo) {
        empleadorepositorio.delete(empleadoo);
    }
}
