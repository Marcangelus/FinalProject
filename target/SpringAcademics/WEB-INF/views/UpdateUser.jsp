<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
        <link rel="stylesheet" href="Styles/Style.css">
    </head>
    <body>
       <form id="updateStud" name="updateStud" action="StudUpdate" method="post" >
            <fieldset>
                <legend>Update User </legend>
                <ul>
                    <li>   
                        New Password:
                        <input type="password" name="passU" id="passU" />
                    </li>
                    <li>   
                        Repeat New Password:
                        <input type="password" name="passRU" id="passRU" />
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
