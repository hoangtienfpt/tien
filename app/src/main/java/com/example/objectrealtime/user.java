package com.example.objectrealtime;

public class user {
    private int id ;
    private String name ;
    private job Job;

    public user(int id, String name, job job) {
        this.id = id;
        this.name = name;
        Job = job;
    }

    public job getJob() {
        return Job;
    }

    public void setJob(job job) {
        Job = job;
    }

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Job=" + Job +
                '}';
    }

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

}
