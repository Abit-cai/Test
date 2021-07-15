package com.example.demo.pojo;

public class Project {
    private int id;
    private String name;//活动名称
    private String pname;//项目名称
    private String time;
    private String site;
    private int cost;//预计花费

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pname='" + pname + '\'' +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", cost=" + cost +
                '}';
    }
}
