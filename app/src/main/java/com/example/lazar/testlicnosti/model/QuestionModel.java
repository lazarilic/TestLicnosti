package com.example.lazar.testlicnosti.model;

/**
 * Created by Lazar on 9/29/17.
 */

public class QuestionModel {

    private int id;
    private int points;
    private String type;
    private int isAscending;
    private String text;

    public int isAscending() {
        return isAscending;
    }

    public void setAscending(int ascending) {
        isAscending = ascending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionModel(int id, String type, int isAscending,  int points) {
        this.id = id;
        this.points = points;
        this.isAscending = isAscending;
        this.type = type;
    }

    public QuestionModel(int id, String text, String type, int isAscending) {

        this.id = id;
        this.text = text;
        this.isAscending = isAscending;
        this.type = type;
    }

    public QuestionModel() {
    }

    public QuestionModel(int points, String type) {
        this.points = points;
        this.type = type;
    }
}