package com.example.submission3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DaftarFavoriteModel implements Parcelable {

    private String login;
    private String avatar_url;

    public DaftarFavoriteModel(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.login);
        parcel.writeString(this.avatar_url);

    }

    public DaftarFavoriteModel() {
    }

    private DaftarFavoriteModel(Parcel in) {
        this.login = in.readString();
        this.avatar_url = in.readString();

    }

    public static final Parcelable.Creator<DaftarFavoriteModel> CREATOR = new Parcelable.Creator<DaftarFavoriteModel>() {
        @Override
        public DaftarFavoriteModel createFromParcel(Parcel source) {
            return new DaftarFavoriteModel(source);
        }

        @Override
        public DaftarFavoriteModel[] newArray(int size) {
            return new DaftarFavoriteModel[size];
        }
    };
}
