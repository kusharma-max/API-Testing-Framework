package com.netomi.framework.models;

public class UserPayload {
    private String name;
    private String job;

    // Getters and Setters (This lets our framework read and write data to this object)
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String getJob() { 
        return job; 
    }
    public void setJob(String job) { 
        this.job = job; 
    }
}