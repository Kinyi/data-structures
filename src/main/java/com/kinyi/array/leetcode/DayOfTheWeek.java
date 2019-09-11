package com.kinyi.array.leetcode;

/**
 * 1185. 一周中的第几天
 *
 * @author Kinyi_Chan
 * @since 2019-09-09
 */
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysOfMonth[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            days += daysOfMonth[i];
        }
        days += day;
        String[] outputs = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        return outputs[days % 7];
    }

    private Boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(9, 9, 2019));
    }
}
