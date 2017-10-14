/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 715060
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.setAttribute("logoutMessage", "You are logged out");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("register")) {
                String username = (String) request.getParameter("username");
                if (username.equals("") || username == null) {
                    request.setAttribute("invalidUsername", "Ensure a username is inputed");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                }
                ArrayList<String> itemList = new ArrayList<String>();
                session.setAttribute("username", username);
                session.setAttribute("shoppingListItems", itemList);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }

        if (action.equals("add")) {
            String itemAdd = request.getParameter("itemAdd");
            ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("shoppingListItems");
            itemList.add(itemAdd);
            session.setAttribute("shoppingListItems", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

        if (action.equals("delete")) {
            String itemDelete = request.getParameter("itemDelete");
            ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("shoppingListItems");
            for (Iterator<String> item = itemList.iterator(); item.hasNext();) {
                String testItem = item.next();
                if (testItem.equals(itemDelete)) {
                    item.remove();
                }
            }
            session.setAttribute("shoppingListItems", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }
}
