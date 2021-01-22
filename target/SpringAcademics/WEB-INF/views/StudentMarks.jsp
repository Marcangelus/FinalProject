<%-- 
    Document   : CreateMarks
    Created on : Aug 26, 2020, 9:59:08 PM
    Author     : Marc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/tlds/marc.tld" prefix="marc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/Style.css" type="text/css" > 
        <link rel="stylesheet" href="Styles/main.css" type="text/css" > 
        <title>Student Marks</title>             
    </head>
    <body>
        <form id="createMarks" name="createMarks" action="MarkStudent" method="post" >
            <fieldset>
                <legend>Student Marks</legend>
                <ul>
                    <li>  Student: 
                        <select id="student" name="student" onchange="javascript:document.createMarks.submit();">
                            <option>Select a student</option>
                            <c:forEach var="marks" items="${marksList}"> 
                                <option value="${marks.student}"><marc:nameField table="students" id="${marks.student}"></marc:nameField></option>                
                            </c:forEach>
                        </select>
                    </li>                   
                </ul>
            </fieldset>
            <table border="1" align="center" >
                
                <th >Student</th>
                <th >Course</th>
                <th >Marks 1</th>
                <th >Marks 2</th>
                <th>Action</th>
                    <%boolean t = true, s = true;%>             
                    <c:forEach var="markStu" items="${markStudent}"> 
                   
                        <tr>  <%if (s) {%>
                            <th rowspan="2"><marc:nameField table="students" id="${markStu.student}"></marc:nameField></th>
                                <%} else {%>

                            <%}
                                s = false;%>
                            <td><marc:nameField table="courses" id="${markStu.course}"></marc:nameField></td>
                            <td>${markStu.marks1}</td>
                            <td>${markStu.marks2}</td>
                            <%if (t) {%>
                            <td rowspan="2"><a href="<c:url value='/MarkStudent?sstudent=${markStu.student}&course=${markStu.course}&act=sendMail'/>"> send marks by email</a></td>  
                            <%}
                                t = false;%>
                        </tr>                    
                    </c:forEach>

            </table>

        </form>
    </body>
</html>
