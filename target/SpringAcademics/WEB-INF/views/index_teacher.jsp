<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/tlds/marc.tld" prefix="mm" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Courses Grades - Teacher</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">

    </head>
    <body>

        <fieldset>
            <h1 style="text-align:center" >Courses Grades - Teacher</h1> 

            <div id="apDiv2" > 
                <table width="737" border="1" > 
                    <tr> 
                        <td><a href="Student" target="Main">Create new student</a></td>  
                        <td><a href="/CreateCourse.jsp" target="Main">Create new course</a>
                        <td><a href="user" target="Main">Create </a>
                        <td><a href="StudentList" target="Main">Students list</a></td>
                        <!--<td><a href="MarksForm" target="Main">Insert marks</a>
                        <td><a href="StudentList" target="Main">Students list</a></td> 
                        <td><a href="CourseList" target="Main">Courses list</a></td>
                        <td><a href="MarksList" target="Main">Marks list</a></td> 
                        <td><a href="MarkStudent" target="Main">Marks by Student</a></td>-->

                        </td> 


                    <h3 style="text-align:right"><span style="color:blue">Welcome <a href="#">${nUser}</a></span>&nbsp;&nbsp;&nbsp;
                        <span style="color:red"><a href="">Logout</a></span><br></h3>
                    <h3> <mm:currentDate/></h3>
                    </tr> 
                </table> 
                <iframe src="/CreateStudent.jsp" name="Main" width="1000" height="509" style="stylesheet"></iframe> 
            </div> 
        </fieldset>

    </body>
</html>