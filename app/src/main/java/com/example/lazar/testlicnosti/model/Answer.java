package com.example.lazar.testlicnosti.model;

/**
 * Created by Lazar on 4/1/18.
 */
public class Answer {

    private String title;
    private String text;

    public Answer(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
