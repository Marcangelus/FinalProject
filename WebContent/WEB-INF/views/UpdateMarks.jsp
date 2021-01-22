<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/tlds/marc.tld" prefix="marc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
       <form id="updateStud" name="updateStud" action="MarksUpdate" method="post" >
            <fieldset>
                <legend>Update marks </legend>
                <ul>
                    <li>   
                        Student:
                         <input type="text" name="studentN" id="student" value="<marc:nameField table="students" id="${marks.student}"></marc:nameField>" readonly />
                         <input type="hidden" name="student" id="studentN" value="${marks.student}"  />
                    </li>
                    <li>   
                        Course:
                        <input type="text" name="courseN" id="courseN" value="<marc:nameField table="courses" id="${marks.course}"></marc:nameField>" readonly />
                        <input type="hidden" name="course" id="course" value="${marks.course}"  />
                    </li>
                    <li>
                        Marks 1:
                        <input type="text" name="marks1" id="marks1" value="${marks.marks1}"  maxlength="3" onKeyPress="soloNumeros()" required />        
                    </li>
                    <li>
                        Marks 2:
                        <input type="text" name="marks2" id="marks2" value="${marks.marks2}"  maxlength="3" onKeyPress="soloNumeros()" required />        
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
