<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/marc.tld" prefix="marc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/Style.css" />
          <link rel="stylesheet" href="Styles/main.css" type="text/css" > 
        <title>Student list</title>
    </head>
    <body> 
        <c:set var = "idNew" scope = "session" value = "${idCreate}"/> 
        <c:set var = "idNew2" scope = "session" value = "${idCreate2}"/>            
        <table border="1" align="center">
            <th>Student</th>
            <th>Course</th>
            <th>Marks 1</th>
            <th>Marks 2</th>
            <th colspan="3"><center>Action</center></th>
                <c:forEach var="marks" items="${marksList}">  
            <tr>
                <c:choose>                       
                    <c:when test = "${(idNew ==marks.student) && (idNew2 == marks.course)}">
                        <td><b><marc:nameField table="students" id="${marks.student}"></marc:nameField></b></td>
                        <td><b><marc:nameField table="courses" id="${marks.course}"></marc:nameField></b></td>                      
                        <td><b>${marks.marks1}</b></td>
                        <td><b>${marks.marks2}</b></td>
                    </c:when>
                    <c:otherwise>                       
                        <td><marc:nameField table="students" id="${marks.student}"></marc:nameField></td>
                        <td><marc:nameField table="courses" id="${marks.course}"></marc:nameField></td>
                        <td>${marks.marks1}</td>
                        <td>${marks.marks2}</td>
                    </c:otherwise>
                </c:choose>
                <td><a href="<c:url value='/Marks?student=${marks.student}&course=${marks.course}&act=delete'/>"> delete</a></td>
                <td><a href="<c:url value='/Marks?student=${marks.student}&course=${marks.course}&act=update'/>"> update</a></td>
                <td><a href="<c:url value='/Marks?student=${marks.student}&course=${marks.course}&act=sendMail'/>"> send email</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
