<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">
        
        <title>Update Student</title>             
    </head>
    <body>
        <form id="updateStud" name="updateStud" action="studentUpdate" method="post" >
            <fieldset>
                <legend>Update student </legend>
                <ul>
                    <li>   
                        Student ID:
                        <input type="text" name="studentId" id="studentId" value="${Stu.studentId}"  />
                    </li>
                    <li>   
                        First name:
                        <input type="text" name="firstName" id="firstName" value="${Stu.firstName}"   />
                    </li>
                    <li>
                        Last name:
                        <input type="text" name="lastName" id="lastName" value="${Stu.lastName}"  />        
                    </li>
                    <li>
                        Diploma:
                        <input type="text" name="diploma" id="diploma" value="${Stu.diploma}" required /> 
                    </li>
                    <li>
                        E-mail:
                        <input type="email" name="email" id="email" value="${Stu.email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required />                                
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
