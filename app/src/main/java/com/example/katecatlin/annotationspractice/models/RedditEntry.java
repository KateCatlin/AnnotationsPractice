package com.example.katecatlin.annotationspractice.models;

/**
 * Created by katecatlin on 12/17/14.
 */
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobbake4 on 11/13/14.
 */
public class RedditEntry implements Parcelable {
    private String title;
    private String author;
    private String selfText;
    private String ListingUrl;
    private boolean isSelfText;

    public RedditEntry() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSelfText() {
        return selfText;
    }

    public void setSelfText(String selfText) {
        this.selfText = selfText;
    }

    public String getListingUrl() {
        return ListingUrl;
    }

    public void setListingUrl(String listingUrl) {
        ListingUrl = listingUrl;
    }

    public boolean getIsSelfText() {
        return isSelfText;
    }

    public void setIsSelfText(boolean isSelfText) {
        this.isSelfText = isSelfText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.selfText);
        dest.writeString(this.ListingUrl);
        dest.writeByte(isSelfText ? (byte) 1 : (byte) 0);
    }

    private RedditEntry(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.selfText = in.readString();
        this.ListingUrl = in.readString();
        this.isSelfText = in.readByte() != 0;
    }

    public static final Parcelable.Creator<RedditEntry> CREATOR = new Parcelable.Creator<RedditEntry>() {
        public RedditEntry createFromParcel(Parcel source) {
            return new RedditEntry(source);
        }

        public RedditEntry[] newArray(int size) {
            return new RedditEntry[size];
        }
    };
}