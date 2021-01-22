<%-- 
    Document   : ListStudent
    Created on : Aug 24, 2020, 6:58:16 PM
    Author     : Marc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="Styles/Style.css" type="text/css" > 
           <link rel="stylesheet" href="Styles/main.css" type="text/css" > 
        <title>Course list</title>
    </head>
    <body> 
        <table border="1" align="center">
            <th>Course ID</th>
            <th>Course name</th>
            <th colspan="2"><center>Action</center></th>
                <c:forEach var="cur" items="${csList}">  
            <tr>
                <c:set var = "idNew" scope = "session" value = "${idCreate}"/>
                <c:choose>
                    <c:when test = "${idNew ==cur.courseId}">
                        <td><b>${cur.courseId}</b></td>
                        <td><b>${cur.courseName}</b></td>                            
                    </c:when>
                    <c:otherwise>
                        <td>${cur.courseId}</td>
                        <td>${cur.courseName}</td>  
                    </c:otherwise>
                </c:choose>
                <td><a href="<c:url value='/CourseDelete/${cur.courseId}'/>"> delete</a></td>
                <td><a href="<c:url value='/FormCourseUpdate/${cur.courseId}'/>"> update</a></td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
