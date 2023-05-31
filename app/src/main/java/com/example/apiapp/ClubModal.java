package com.example.apiapp;

public class ClubModal {
    private int id;
    private String name;
    private String address;
    private String type;
    private int entryfee;

    public ClubModal(int id,String name,String address,String type,int entryfee){
        this.id=id;
        this.name=name;
        this.address=address;
        this.type=type;
        this.entryfee=entryfee;

    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getAddress(){
        return address;
    }
    public int getEntryfee(){
        return entryfee;
    }
}
