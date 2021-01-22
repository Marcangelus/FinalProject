<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create student</title>
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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">    
    </head>
    <body>
        <form id="createStud" name="createStud" action="createStudent" method="post" >
            <fieldset>
                <legend>Create student </legend>
                <ul>
                    <li>   
                        Student ID:
                        <input type="text" name="studentId" id="studentId" placeholder="Write student ID" maxlength="4" onKeyPress="soloNumeros()" required />
                    </li>
                    <li>   
                        First name:
                        <input type="text" name="firstName" id="fName" placeholder="Write your first name" onkeyup="firstCapital(this)" required />
                    </li>
                    <li>
                        Last name:
                        <input type="text" name="lastName" id="lName" placeholder="Write your last name" onKeyPress="firstCapital(this)" required />        
                    </li>
                    <li>
                        Diploma:
                        <input type="text" name="diploma" id="diploma" placeholder="Write the diploma" required />        
                    </li>
                     <li>
                        E-mail
                        <input type="email" name="email" id="stuEmail" placeholder="Write the email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required />        
                    </li>
                </ul>
            </fieldset>
            <table>
                <tr>
                    <td>
                        <input type="submit" name="sData" id="sData" value="Send data"/> 
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