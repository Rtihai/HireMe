package com.roman.tihai.hireme;

import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable {
    private String CompanyName;
    private String Email;
    private String Status;
    private String Date;
    private String Link;
    private String Info;

    public Company (String CompanyName, String Email, String Date, String Link, String Info, String Status ){
        this.CompanyName = CompanyName;
        this.Email = Email;
        this.Date = Date;
        this.Link = Link;
        this.Info = Info;
        this.Status = Status;
    }


    public Company(String CompanyName, String Email, String Status){
        this.CompanyName = CompanyName;
        this.Email = Email;
        this.Status = Status;

    }

    protected Company(Parcel in) {
        CompanyName = in.readString();
        Email = in.readString();
        Status = in.readString();
        Date = in.readString();
        Link = in.readString();
        Info = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setInfo(String info) {
        Info = info;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CompanyName);
        dest.writeString(Email);
        dest.writeString(Status);
        dest.writeString(Date);
        dest.writeString(Link);
        dest.writeString(Info);
    }

}
