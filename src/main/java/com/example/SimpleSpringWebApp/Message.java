package com.example.SimpleSpringWebApp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private @JsonProperty("id") int id;
    private @JsonProperty("userMessage") String userMessage;
    private @JsonProperty("title") String title;


    public int getId(){
        return id;
    }
    
    public String getUserMessage(){
        return userMessage;
    }
    public String getTitle(){
        return title;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setUserMessage(String userMessage){
        this.userMessage = userMessage;
    }
    public void setTitle(String title){
        this.title = title;
    }

}
