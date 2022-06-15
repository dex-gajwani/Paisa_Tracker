package com.example.paisatracker;

public class data_list {
    private int money;
    private String comment;

    data_list(int money , String comment){
        this.money = money;
        this.comment = comment;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
