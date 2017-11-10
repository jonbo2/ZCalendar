package eu.jonbo.zcalendar.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jonas on 2017-11-10.
 */

public class ExtendedCalendar {

    public static final int MILLIS_IN_ONE_SECOND = 1000;
    public static final int MILLIS_IN_ONE_MINUTE = MILLIS_IN_ONE_SECOND * 60;
    public static final long MILLIS_IN_ONE_HOUR = MILLIS_IN_ONE_MINUTE * 60;
    public static final long MILLIS_IN_ONE_DAY = MILLIS_IN_ONE_HOUR * 24;
    public static final long MILLIS_IN_ONE_WEEK = MILLIS_IN_ONE_DAY * 7;

    private Calendar mCalendar;

    public ExtendedCalendar(Calendar calendar) {
        mCalendar = calendar;

        String dayOfWeek = PreferenceHandler.getFirstDayOfWeek(null, "0");
        int calendarDayOfWeek = -1;

        if (dayOfWeek.equals("_1")) calendarDayOfWeek = Calendar.MONDAY;
        else if (dayOfWeek.equals("_2")) calendarDayOfWeek = Calendar.TUESDAY;
        else if (dayOfWeek.equals("_3")) calendarDayOfWeek = Calendar.WEDNESDAY;
        else if (dayOfWeek.equals("_4")) calendarDayOfWeek = Calendar.THURSDAY;
        else if (dayOfWeek.equals("_5")) calendarDayOfWeek = Calendar.FRIDAY;
        else if (dayOfWeek.equals("_6")) calendarDayOfWeek = Calendar.SATURDAY;
        else if (dayOfWeek.equals("_7")) calendarDayOfWeek = Calendar.SUNDAY;
        else calendarDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();

        if (calendarDayOfWeek != -1)
            mCalendar.setFirstDayOfWeek(calendarDayOfWeek);
    }

    public boolean isToday() {
        ExtendedCalendar calendar = getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR) == get(Calendar.DAY_OF_YEAR) && calendar.get(Calendar.YEAR) == get(Calendar.YEAR);
    }

    public boolean isCurrentWeek() {
        ExtendedCalendar calendar = getInstance();
        return calendar.get(Calendar.WEEK_OF_YEAR) == get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == get(Calendar.YEAR);
    }

    public boolean isCurrentMonth() {
        ExtendedCalendar calendar = getInstance();
        return calendar.get(Calendar.MONTH) == get(Calendar.MONTH) && calendar.get(Calendar.YEAR) == get(Calendar.YEAR);
    }

    public boolean isCurrentYear() {
        return getInstance().get(Calendar.YEAR) == get(Calendar.YEAR);
    }

    public int get(int field) {
        return mCalendar.get(field);
    }

    @Override
    public Object clone() {
        return new ExtendedCalendar((Calendar) mCalendar.clone());
    }

    public void set(int field, int value) {
        mCalendar.set(field, value);
    }

    public void add(int field, int value) {
        mCalendar.add(field, value);
    }

    public void setCalendarToFirstDayInMonth() {
        mCalendar.add(Calendar.DAY_OF_MONTH, -mCalendar.get(Calendar.DAY_OF_MONTH) + 1);
    }

    public void setCalendarToLastDayInMonth() {
        mCalendar.add(Calendar.DAY_OF_MONTH, mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)-mCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void setToStartOfDay() {
        mCalendar.set(Calendar.HOUR_OF_DAY, mCalendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        mCalendar.set(Calendar.MINUTE, mCalendar.getActualMinimum(Calendar.MINUTE));
        mCalendar.set(Calendar.SECOND, mCalendar.getActualMinimum(Calendar.SECOND));
        mCalendar.set(Calendar.MILLISECOND, mCalendar.getActualMinimum(Calendar.MILLISECOND));
		/*
		mCalendar.setTimeInMillis(mCalendar.getTimeInMillis()
				- mCalendar.get(Calendar.HOUR_OF_DAY)
				* ExtendedCalendar.MILLIS_IN_ONE_HOUR);
		mCalendar.setTimeInMillis(mCalendar.getTimeInMillis()
				- mCalendar.get(Calendar.MINUTE)
				* ExtendedCalendar.MILLIS_IN_ONE_MINUTE);
		mCalendar.setTimeInMillis(mCalendar.getTimeInMillis()
				- mCalendar.get(Calendar.SECOND)
				* ExtendedCalendar.MILLIS_IN_ONE_SECOND);
		mCalendar.setTimeInMillis(mCalendar.getTimeInMillis()
				- mCalendar.get(Calendar.MILLISECOND));
				*/
    }

    public void setToEndOfDay() {
        mCalendar.set(Calendar.HOUR_OF_DAY, mCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        mCalendar.set(Calendar.MINUTE, mCalendar.getActualMaximum(Calendar.MINUTE));
        mCalendar.set(Calendar.SECOND, mCalendar.getActualMaximum(Calendar.SECOND));
        mCalendar.set(Calendar.MILLISECOND, mCalendar.getActualMaximum(Calendar.MILLISECOND));
    }

    public void setCalendarToFirstDayInWeek() {
        mCalendar.getTimeInMillis();

        mCalendar.set(Calendar.DAY_OF_WEEK, mCalendar.getFirstDayOfWeek());
        setToStartOfDay();
    }

    public void setCalendarToLastDayInWeek() {
        setCalendarToFirstDayInWeek();
        mCalendar.add(Calendar.DAY_OF_WEEK, 7);
        mCalendar.add(Calendar.MILLISECOND, -1);
        setToEndOfDay();
    }

    public void setCalendarToFirstDayInYear() {
        mCalendar.set(Calendar.DAY_OF_YEAR, 1);
    }

    public void setCalendarToMonth(int i) {
        setCalendarToFirstDayInYear();
        while (mCalendar.get(Calendar.MONTH) != i) {
            mCalendar.add(Calendar.DAY_OF_MONTH, mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)+1);
        }
        setCalendarToFirstDayInMonth();
    }

    public void setTimeInMillis(long milliseconds) {
        mCalendar.setTimeInMillis(milliseconds);
    }

    public long getTimeInMillis() {
        return mCalendar.getTimeInMillis();
    }

    public void addMillis(long millis) {
        long time = mCalendar.getTimeInMillis();
        time += millis;
        mCalendar.setTimeInMillis(time);
    }

    public static ExtendedCalendar getInstance() {
        return new ExtendedCalendar(Calendar.getInstance());
    }

    public void addDays(int days) {
        mCalendar.add(Calendar.DATE, days);
    }

    public void addYears(int years) {
        mCalendar.add(Calendar.YEAR, years);
    }

    public int getActualMaximum(int i) {
        return mCalendar.getActualMaximum(i);
    }

    @Override
    public String toString() {
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int month = mCalendar.get(Calendar.MONTH)+1;
        int year = mCalendar.get(Calendar.YEAR);
        int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        int min = mCalendar.get(Calendar.MINUTE);
        int sec = mCalendar.get(Calendar.SECOND);
        int millis = mCalendar.get(Calendar.MILLISECOND);
        return "" + day + "/" + month + "/" + year + " " + hour + ":" + min + ":" + sec + ":" + millis;
    }

    public static long getTime(long time, String timeZoneFromId, String TimeZoneToId) {
        TimeZone z = TimeZone.getTimeZone(timeZoneFromId);

        int fOffset = z.getRawOffset();
        if (z.inDaylightTime(new Date(time))){
            fOffset += z.getDSTSavings();
        }

        if (!TimeZoneToId.isEmpty())
            z = TimeZone.getTimeZone(TimeZoneToId);

        int tOffset = z.getRawOffset();
        if (z.inDaylightTime(new Date(time))){
            tOffset += z.getDSTSavings();
        }

        return time + tOffset - fOffset;
    }

    public int getDayNumberOfMonth() {
        int dayOfMonth = mCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        return dayOfMonth;
    }

    public void setTimeZone(TimeZone timezone) {
        mCalendar.setTimeZone(timezone);
    }

    public int getDayNumberOfWeek() {
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        int firstdayOfWeek = mCalendar.getFirstDayOfWeek();

        if (dayOfWeek >= firstdayOfWeek) {
            return dayOfWeek - firstdayOfWeek+1;
        } else {
            return 7 - firstdayOfWeek + dayOfWeek + 1;
        }
    }















}

