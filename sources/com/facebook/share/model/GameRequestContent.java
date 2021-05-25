package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new a();
    public final String a;
    public final List<String> b;
    public final String c;
    public final String d;
    public final ActionType e;
    public final String f;
    public final Filters g;
    public final List<String> h;

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    public static class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        public String a;
        public List<String> b;
        public String c;
        public String d;
        public ActionType e;
        public String f;
        public Filters g;
        public List<String> h;

        public Builder setActionType(ActionType actionType) {
            this.e = actionType;
            return this;
        }

        public Builder setData(String str) {
            this.c = str;
            return this;
        }

        public Builder setFilters(Filters filters) {
            this.g = filters;
            return this;
        }

        public Builder setMessage(String str) {
            this.a = str;
            return this;
        }

        public Builder setObjectId(String str) {
            this.f = str;
            return this;
        }

        public Builder setRecipients(List<String> list) {
            this.b = list;
            return this;
        }

        public Builder setSuggestions(List<String> list) {
            this.h = list;
            return this;
        }

        public Builder setTitle(String str) {
            this.d = str;
            return this;
        }

        public Builder setTo(String str) {
            if (str != null) {
                this.b = Arrays.asList(str.split(","));
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public GameRequestContent build() {
            return new GameRequestContent(this, null);
        }

        public Builder readFrom(GameRequestContent gameRequestContent) {
            if (gameRequestContent == null) {
                return this;
            }
            return setMessage(gameRequestContent.getMessage()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }
    }

    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    public static class a implements Parcelable.Creator<GameRequestContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    }

    public GameRequestContent(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.d;
        this.d = builder.c;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActionType getActionType() {
        return this.e;
    }

    public String getData() {
        return this.d;
    }

    public Filters getFilters() {
        return this.g;
    }

    public String getMessage() {
        return this.a;
    }

    public String getObjectId() {
        return this.f;
    }

    public List<String> getRecipients() {
        return this.b;
    }

    public List<String> getSuggestions() {
        return this.h;
    }

    public String getTitle() {
        return this.c;
    }

    public String getTo() {
        if (getRecipients() != null) {
            return TextUtils.join(",", getRecipients());
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeStringList(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeSerializable(this.e);
        parcel.writeString(this.f);
        parcel.writeSerializable(this.g);
        parcel.writeStringList(this.h);
    }

    public GameRequestContent(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.createStringArrayList();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = (ActionType) parcel.readSerializable();
        this.f = parcel.readString();
        this.g = (Filters) parcel.readSerializable();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.h = createStringArrayList;
        parcel.readStringList(createStringArrayList);
    }
}
