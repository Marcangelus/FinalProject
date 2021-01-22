<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Log in</title>     
      
        <link href="<c:url value="/Resources/Styles/Style.css" />" rel="stylesheet">
    </head>

    <body>
        <div id="apDiv1" width="737">           
            <form id="form1" name="form1" method="post" action="index">
                <fieldset>
                    <legend>Log in </legend>
                    <ul>
                        <li>Nick Name:
                            <input type="text" name="nickUser" id="cusuario" required/>
                        </li>
                        <li>Password
                            <input type="password" name="Password" id="cclave" required/>
                        </li> 
                    </ul>
                </fieldset>
                <table>
                    <tr>                        
                        <td>
                            <input type="submit" name="button" id="button" value="Enter"  />
                        </td> 
                        <td>
                            <input type="reset" name="button" id="button" value="Reset data" /> 
                        </td>                        
                    </tr>
                     <span style="color:red"><b>${message}</b></span>
                </table>
            </form>
        </div>
        <div id="apDiv3"></div>
    </body>
</html>