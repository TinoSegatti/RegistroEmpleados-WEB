package git.empleados.controlador;

import git.empleados.modelo.Empleado;
import git.empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controlador MVC que maneja todas las peticiones HTTP del sistema de empleados.
 * Recibe las solicitudes del navegador, llama al servicio para procesar los datos
 * y determina que vista JSP se debe mostrar como respuesta.
 */
@Controller
public class IndexControlador {

    // Logger para registrar eventos importantes en consola durante la ejecucion
    // Es la forma profesional de reemplazar System.out.println en Spring Boot
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    // Spring inyecta el servicio automaticamente mediante @Autowired
    @Autowired
    EmpleadoServicio empleadoServicio;

    /**
     * Peticion GET a "/" - muestra el listado de todos los empleados.
     * Todo lo que se agrega al ModelMap queda disponible en el JSP como ${variable}.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados=empleadoServicio.listarEmpleados();
        empleados.forEach((empleado)->logger.info(empleado.toString()));
        //Compartimos el metodo con la vista
        modelo.put("empleados",empleados);
        return "index";
    }

    // Peticion GET a "/agregar" - muestra el formulario vacio para nuevo empleado
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";
    }

    /**
     * Peticion POST a "/agregar" - recibe los datos del formulario y guarda el empleado.
     * @ModelAttribute mapea automaticamente los campos del formulario al objeto Empleado.
     * El redirect evita que al refrescar la pagina se reenvie el formulario.
     */
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a agregar: "+ empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

    /**
     * Peticion GET a "/editar" - busca el empleado por ID y muestra el formulario pre-llenado.
     * @RequestParam extrae el parametro idEmpleado de la URL (?idEmpleado=X).
     */
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado=empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado a editar: "+ empleado);
        modelo.put("empleado",empleado);
        return "editar";
    }

    // Peticion POST a "/editar" - guarda los cambios del formulario de edicion
    // Como el objeto trae el ID, save() ejecuta un UPDATE en lugar de un INSERT
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a aguardar (editar)): "+ empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

    /**
     * Peticion GET a "/eliminar" - elimina el empleado indicado por ID.
     * Se construye un objeto Empleado solo con el ID para que JPA pueda identificarlo
     * y eliminar el registro correspondiente en la base de datos.
     */
    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        logger.info("Empleado a eliminar (borrar)): "+ empleado);
        return "redirect:/";
    }
}
