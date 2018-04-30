package com.example.reax.ggr.POJO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by reax on 25/1/18.
 */

public class EventlistPojo2 {
    @SerializedName("event_id")
    @Expose
    private String eventId;
    @SerializedName("event_title")
    @Expose
    private String eventTitle;
    @SerializedName("event_type")
    @Expose
    private String eventType;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("date")
    @Expose
    private String date;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
