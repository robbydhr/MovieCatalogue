package com.skripsi.robby.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int photo;
    private String title;
    private String description;
    private String fact;

    public Film(){

    }

    protected Film(Parcel in) {
        photo = in.readInt();
        title = in.readString();
        description = in.readString();
        fact = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photo);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(fact);
    }
}
