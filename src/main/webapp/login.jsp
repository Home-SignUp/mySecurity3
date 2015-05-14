<%--
  Created by IntelliJ IDEA.
  User: alexandr
  Date: 13.05.15
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="/Servlet/userValidator" method="POST">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <td>
                        <table>
                            <tr>
                                <td align="right">Name: </td>
                                <td><input type="text" name="name"/></td>
                            </tr>
                            <tr>
                                <td align="right">Password: </td>
                                <td><input type="password" name="password"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" value="Войти"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>