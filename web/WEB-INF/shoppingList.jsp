<%-- 
    Document   : shoppingList
    Created on : Oct 10, 2017, 2:17:08 PM
    Author     : 715060
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    Add item <input type="text" name ="item">
                    <input type="submit" value="Add">
                </form>
                ${shoppingListItems}
                <br>
                <input type="submit" value ="delete" action ="ShoppingList?action=delete">
    </body>
</html>
