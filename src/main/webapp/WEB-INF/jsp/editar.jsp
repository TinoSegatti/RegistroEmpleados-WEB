<%-- Vista para editar un empleado existente.
     El controlador pasa el objeto "empleado" en el ModelMap y los campos
     se pre-llenan con los valores actuales usando expresiones EL ${empleado.campo}.
     El campo oculto "idEmpleado" es clave: le indica a JpaRepository.save()
     que debe hacer un UPDATE y no un INSERT. --%>

<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp" %>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Editar Empleado</h3>
    </div>
    <form action="${urlEditar}" modelAttribute="empleadoForma" method="post">
        <%-- Campo oculto: transporta el ID sin mostrarlo al usuario.
             Sin este campo, Spring no podria saber si actualizar o insertar. --%>
        <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <%-- value="${empleado.nombreEmpleado}" pre-carga el valor actual del campo --%>
            <input type="text" class="form-control" id="nombre" name="nombreEmpleado" required="required" value="${empleado.nombreEmpleado}">
        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="departamento" name="departamento" value="${empleado.departamento}">
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo</label>
            <input type="number" step="any" class="form-control" id="sueldo" name="sueldo" value="${empleado.sueldo}">
        </div>
        <div>
            <button type="submit" class="btn btn-warning btn-sm me-3">Editar</button>
            <a href="${urlInicio}" class="btn btn-danger btn-sm">Volver</a>
        </div>

    </form>
</div>

<%@ include file="comunes/pie-pagina.jsp" %>
