
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create course</title>
        <script>
            function soloNumeros() {
                if (event.keyCode < 48 || event.keyCode > 57)
                    event.returnValue = false;
            }
            function firstCapital(name) {
                name.value = name.value.charAt(0).toUpperCase() + name.value.slice(1);
                name.value = name.value.slice(0, name.value.search(" ") + 1) + name.value.charAt(name.value.search(" ") + 1).toUpperCase() + name.value.slice(name.value.search(" ") + 2);
            }
        </script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">

    </head>
    <body>
        <form id="createCourse" name="createCourse" action="createCourse" method="post" >
            <fieldset>
                <legend>Create Course </legend>
                <ul>
                    <li>   
                        Course ID:
                        <input type="text" name="courseId" id="idCourse" placeholder="Write course ID" maxlength="4" onKeyPress="soloNumeros()" required />
                    </li>
                    <li>   
                        Course name:
                        <input type="text" name="courseName" id="courseName" placeholder="Write course name" onkeyup="firstCapital(this)" required />
                    </li>                   
                </ul>
            </fieldset>
            <table>
                <tr>
                    <td>
                        <input type="submit" name="sData" id="sData" value="Send data" /> 
                    </td> 
                    <td>
                        <input type="reset" name="button" id="button" value="Reset data" /> 
                    </td>
                </tr>
                <span style="color:red"><b>${message}</b></span>
            </table>
        </form>
    </body>
</html>
