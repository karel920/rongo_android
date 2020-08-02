package com.mobilestar.rongo.android.helper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtill {

    public static String formatDate(String date){
        try {
            return new SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH).format(
                    new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return date;
        }
    }


    public static String formatTime(String date){
        try {
            return new SimpleDateFormat("h:mm a", Locale.ENGLISH).format(
                    new SimpleDateFormat("HH:mm", Locale.ENGLISH).parse(date)
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String formatDateTime(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(
                    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.ENGLISH).parse(date)
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String formatDateTime2(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).format(
                    new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).parse(date)
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }


    public static void showCalender(TextView textView, Activity context) {
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, textView);
            }

        };
        DatePickerDialog datePickerDialog=new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        //
        // datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
        datePickerDialog.show();

    }

    public static void updateLabel(Calendar myCalendar, TextView textView) {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        textView.setText(sdf.format(myCalendar.getTime()));
    }

    public static String formatCreatedDateTime(String date) {
        try {
            return new SimpleDateFormat("dd MMM yyyy '|' h:mm a", Locale.ENGLISH).format(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(date)
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String formatDate1(String date){
        try {
            return new SimpleDateFormat("dd MMM", Locale.ENGLISH).format(
                    new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return date;
        }
    }


    public static String changeNotificationDateType(String date) {
        String reformattedStr = "";
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MMM yy");

        try {
            reformattedStr = myFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reformattedStr;
    }

    public static boolean isFutureDate(String date){
        SimpleDateFormat dateFormat=null;
        Date formattedDate=null;
        try {
             dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            formattedDate=dateFormat.parse(date);
        }catch (ParseException e){
            return false;
        }

        if(formattedDate!=null){
           if( formattedDate.compareTo(new Date(System.currentTimeMillis()))>0){
               return true;
           }else{
               return false;
           }
        }

        return false;
    }
}
