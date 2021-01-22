<%-- 
    Document   : CreateMarks
    Created on : Aug 26, 2020, 9:59:08 PM
    Author     : Marc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/Style.css" type="text/css" > 
        <title>Create Marks</title>
        <script>
            function soloNumeros() {
                if (event.keyCode < 48 || event.keyCode > 57)
                    event.returnValue = false;
            }
            function validateForm() {
                if (createMarks.marks1.value>100) {
                    alert("number must less than 100");
                    createMarks.marks1.value = "";
                    createMarks.marks1.focus();
                }
                if (createMarks.marks2.value>100) {
                    alert("number must less than 100");
                    createMarks.marks2.value = "";
                    createMarks.marks2.focus();
                }
            }
            function firstCapital(name) {
                name.value = name.value.charAt(0).toUpperCase() + name.value.slice(1);
                name.value = name.value.slice(0, name.value.search(" ") + 1) + name.value.charAt(name.value.search(" ") + 1).toUpperCase() + name.value.slice(name.value.search(" ") + 2);
            }
        </script>
    </head>
    <body>
        <form id="createMarks" name="createMarks" action="Marks" method="post" >
            <fieldset>
                <legend>Create Marks </legend>
                <ul>
                    <li>  Student: 
                        <select id="student" name="student" onchange="myFunction()">   
                            <c:forEach var="Stu" items="${stList}"> 
                                <option value="${Stu.studentId}">${Stu.firstName} ${Stu.lastName}</option>              
                            </c:forEach>
                        </select>
                    </li>
                    <li>   
                        Course:
                        <select id="course" name="course">   
                            <c:forEach var="cur" items="${csList}"> 
                                <option value="${cur.courseId}">${cur.courseName}</option>              
                            </c:forEach>
                        </select>
                    </li>
                    <li>
                        Marks 1:
                        <input type="text" name="marks1" id="marks1" placeholder="Write marks 1" maxlength="3" onKeyPress="soloNumeros()" required />        
                    </li>
                    <li>
                        Marks 2:
                        <input type="text" name="marks2" id="marks2" placeholder="Write marks 2" maxlength="3" onKeyPress="soloNumeros()" required />        
                    </li>
                </ul>
            </fieldset>
            <table>
                <tr>
                    <td>
                        <input type="submit" name="sData" id="sData" value="Send data" onclick="validateForm()" /> 
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
