package com.nopackname.response;

import java.util.List;

import com.nopackname.bean.Event;
import com.nopackname.bean.Gift;
import com.nopackname.bean.Status;
import com.nopackname.bean.User;

public class API_GET_USERINFO_RESPONSE extends API_SUB_RESPONSE {
    private User user;
    private List<Gift> gifts;
    private List<Event> events;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
