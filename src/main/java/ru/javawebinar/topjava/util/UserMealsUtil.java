package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
    }


    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Set<LocalDate> days = new LinkedHashSet<>();
        Map<LocalDate, Integer> map = new HashMap<>();
        List<UserMealWithExceed> result = new ArrayList<>();
        int count = 0;
        for (UserMeal meal : mealList) {
            days.add(meal.getDateTime().toLocalDate());
        }
        for (LocalDate date : days) {
            for (UserMeal meal : mealList) {
                if (meal.getDateTime().toLocalDate().equals(date)) {
                    count += meal.getCalories();
                    map.put(meal.getDateTime().toLocalDate(), count);
                }
            }
            count = 0;
        }
        for (UserMeal meal : mealList) {
            if (TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime)) {
                result.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(),
                        meal.getCalories(), map.get(meal.getDateTime().toLocalDate()) > caloriesPerDay));
            }
        }
        return result;
    }
}
