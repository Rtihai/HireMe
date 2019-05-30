package com.roman.tihai.hireme;

public class Company {
    private String CompanyName;
    private String Email;
    private String Status;
    private String Date;
    private String Link;
    private String Info;

    public Company (String CompanyName, String Email, String Status, String Date, String Link, String Info ){
        this.CompanyName = CompanyName;
        this.Email = Email;
        this.Status = Status;
        this.Date = Date;
        this.Link = Link;
        this.Info = Info;
    }


    public Company(String CompanyName, String Email, String Status){
        this.CompanyName = CompanyName;
        this.Email = Email;
        this.Status = Status;

    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getEmail() {
        return Email;
    }

    public String getStatus() {
        return Status;
    }

    public String getDate() { return Date; }

    public String getLink() { return Link; }

    public String getInfo() { return Info; }
}
