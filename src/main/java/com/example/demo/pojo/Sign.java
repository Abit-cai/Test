package com.example.demo.pojo;

public class Sign {
    private int id;
    private String username;
    private String aname;
    private String pname;
    private int cost;
    private int costed;
    private int ended;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

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

    public int getEnded() {
        return ended;
    }

    public void setEnded(int ended) {
        this.ended = ended;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", aname='" + aname + '\'' +
                ", pname='" + pname + '\'' +
                ", cost=" + cost +
                ", costed=" + costed +
                ", ended=" + ended +
                '}';
    }
}
