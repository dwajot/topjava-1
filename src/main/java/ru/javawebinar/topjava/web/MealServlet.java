package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Artem on 14.12.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to meals");
        List<MealWithExceed> mealWithExceeds = MealsUtil.getFilteredWithExceeded(MealsUtil.getMeals(), LocalTime.MIN, LocalTime.MAX, 2000);

        request.setAttribute("meals", mealWithExceeds);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/meals.jsp");
        requestDispatcher.forward(request, response);
    }
}
