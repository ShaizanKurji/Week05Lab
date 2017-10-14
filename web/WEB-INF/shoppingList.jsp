<%-- 
    Document   : shoppingList
    Created on : Oct 10, 2017, 2:17:08 PM
    Author     : 715060
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href ="ShoppingList?action=logout">Logout</a></p>


        <h1>List</h1>
        <form action="ShoppingList?action=add" method ="post">
            Add item <input type="text" name ="itemAdd" value ="${itemToAdd}">
            <input type="submit" value="Add">
        </form>


        <c:if test = "${fn:length(shoppingListItems) gt 0}">
            <form action ="ShoppingList?action=delete" method="post">
                <%--Advanced for look copies values in shoppingListItems to i--%>
                <c:forEach var ="i" items = "${shoppingListItems}"> 
                    <input type="radio" name ="itemDelete"value ="${i}">${i}<br>
                </c:forEach>
                <input type="submit" value ="Delete">
            </form>
        </c:if>
    </body>
</html>
