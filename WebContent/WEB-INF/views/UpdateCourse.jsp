<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">
        <title>Update Student</title>
        <script>
            function soloNumeros() {
                if (event.keyCode < 48 || event.keyCode > 57)
                    event.returnValue = false;
            }
            function firstCapital(name) {
                name.value = name.value.charAt(0).toUpperCase() + name.value.slice(1);
                name.value  = name.value.slice(0,name.value.search(" ")+1)+name.value.charAt(name.value.search(" ")+1).toUpperCase() + name.value.slice(name.value.search(" ")+2);                
            }                      
        </script>
          <link rel="stylesheet" href="Styles/Style.css">
    </head>
    <body>
       <form id="updateCourse" name="updateCourse" action="CourseUpdate" method="post" >
            <fieldset>
                <legend>Update course </legend>
                <ul>
                    <li>   
                        Course ID:
                        <input type="text" name="idCourseU" id="idCourseU" value="${cs.courseId}" readonly />
                    </li>
                    <li>   
                        Course name:
                        <input type="text" name="courseNameU" id="courseNameU" value="${cs.courseName}"  onkeyup="firstCapital(this)" required />
                    </li>                    
                </ul>
            </fieldset>
            <table>
                <tr>
                    <td>
                        <input type="submit" name="uData" id="uData" value="Update data" /> 
                    </td>                     
                </tr>
            </table>
        </form>
    </body>
</html>
