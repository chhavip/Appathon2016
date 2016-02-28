package com.chhavi.appathon2016.Extras;

/**
 * Created by chhavi on 28/2/16.
 */
public class Appointment {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    String date;
    String start_time;
    String end_time;
    String client_name;

    public Appointment(String date, String start_time, String end_time, String client_name) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_name = client_name;
    }
}
