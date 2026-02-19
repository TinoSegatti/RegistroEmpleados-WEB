<%-- =====================================================================
     index.jsp  –  Vista principal: listado de todos los empleados.

     Esta vista recibe del controlador (IndexControlador.iniciar) el atributo
     "empleados" (List<Empleado>) en el ModelMap, disponible aquí como
     expresión EL: ${empleados}.

     Conceptos demostrados:
       - <c:forEach>: iterador JSTL que recorre la lista de empleados y genera
         una fila <tr> por cada uno. Equivale a un for-each en Java.
       - ${empleado.campo}: Expression Language (EL) que accede a los getters
         del objeto (por ejemplo, empleado.getNombreEmpleado()).
       - <fmt:formatNumber>: formatea el sueldo como moneda ($#,##0.00).
       - <c:set> + <c:url> + <c:param>: construyen URLs dinámicas para las
         acciones Editar y Eliminar, pasando el idEmpleado como query param.
       - Clases Bootstrap: table-striped, table-hover, table-bordered, btn-warning, btn-danger.
     ===================================================================== --%>

<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp" %>

        <div class = "container">
            <div class = "text-center" style="margin: 30px">
                <h3>SISTEMA DE EMPLEADOS</h3>
            </div>
            <div class="container">
                <%-- Tabla Bootstrap con estilos de filas alternadas, hover y bordes --%>
                <table class="table table-striped table-hover table-bordered aling-middle">
                    <thead class="table-dark text-center">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Departamento</th>
                        <th scope="col">Sueldo</th>
                        <th scope="col">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%-- Iteramos la lista "empleados" que envió el controlador en el ModelMap --%>
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <th scope="row">${empleado.idEmpleado}</th>
                            <td>${empleado.nombreEmpleado}</td>
                            <td>${empleado.departamento}</td>
                            <td>
                                <%-- Formato monetario: convierte 1500.5 en $1,500.50 --%>
                                <fmt:formatNumber value="${empleado.sueldo}" pattern="$#,##0.00"/>
                            </td>
                            <td class="text-center">
                                <%-- URL dinámica para editar: /empleados/editar?idEmpleado=X --%>
                                <c:set var="urlEditar">
                                    <c:url value="${application.contextPath}/editar">
                                        <c:param name="idEmpleado" value="${empleado.idEmpleado}"/>
                                    </c:url>
                                </c:set>
                                <a href="${urlEditar}" class="btn btn-warning btn-sm me-3">Editar</a>
                                <%-- URL dinámica para eliminar: /empleados/eliminar?idEmpleado=X --%>
                                <c:set var="urlEliminar">
                                    <c:url value="${application.contextPath}/eliminar">
                                        <c:param name="idEmpleado" value="${empleado.idEmpleado}"/>
                                    </c:url>
                                </c:set>
                                <a href="${urlEliminar}" class="btn btn-danger btn-sm me-3">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

<%@ include file="comunes/pie-pagina.jsp" %>
