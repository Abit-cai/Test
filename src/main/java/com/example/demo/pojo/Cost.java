package com.example.demo.pojo;

public class Cost {
    private String pname;
    private int cost;
    private int costed;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCosted() {
        return costed;
    }

    public void setCosted(int costed) {
        this.costed = costed;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "pname='" + pname + '\'' +
                ", cost=" + cost +
                ", costed=" + costed +
                '}';
    }
}
