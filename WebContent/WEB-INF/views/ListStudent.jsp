
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table border="1" align="center">
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Diploma</th>
            <th>Email</th>
            <th colspan="2"><center>Action</center></th>
                <c:forEach var="Stu" items="${studList}">  
            <tr>
                <c:choose>                       
                    <c:when test = "${idNew ==Stu.studentId}">
                        <td><b>${Stu.studentId}</b></td>
                        <td><b>${Stu.firstName}</b></td>
                        <td><b>${Stu.lastName}</b></td>
                        <td><b>${Stu.diploma}</b></td>
                        <td><b>${Stu.email}</b></td>
                    </c:when>
                    <c:otherwise>
                        <td>${Stu.studentId}</td>
                        <td>${Stu.firstName}</td>
                        <td>${Stu.lastName}</td>
                        <td>${Stu.diploma}</td>
                        <td>${Stu.email}</td>
                        <td>
                   <!-- <a href="StudentDelete/${Stu.studentId}" >delete</a></td>-->
                            <a href="<c:url value='/StudentDelete/${Stu.studentId}' />" >Delete</a>

                        </td>
                        <td><a href="<c:url value='/FormStudentUpdate/${Stu.studentId}'/>"> update</a></td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
