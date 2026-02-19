<%-- Vista para agregar un nuevo empleado.
     El formulario envia los datos por POST a "/agregar".
     Spring MVC mapea automaticamente cada campo (por el atributo "name")
     al setter correspondiente del objeto Empleado en el controlador.
     Como no se incluye el ID, JpaRepository.save() ejecuta un INSERT. --%>

<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp" %>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Agregar Empleado</h3>
    </div>
    <form action="${urlAgregar}" modelAttribute="empleadoForma" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombreEmpleado" required="required">

        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="departamento" name="departamento">
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo</label>
            <%-- step="any" permite ingresar valores decimales (Double) --%>
            <input type="number" step="any" class="form-control" id="sueldo" name="sueldo">
        </div>
        <div>
            <button type="submit" class="btn btn-warning btn-sm me-3">Agregar</button>
            <a href="${urlInicio}" class="btn btn-danger btn-sm">Volver</a>
        </div>

    </form>
</div>

<%@ include file="comunes/pie-pagina.jsp" %>
