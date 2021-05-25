package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new a();
    public final String a;
    public final String b;
    public AppGroupPrivacy c;

    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    public static class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {
        public String a;
        public String b;
        public AppGroupPrivacy c;

        public Builder setAppGroupPrivacy(AppGroupPrivacy appGroupPrivacy) {
            this.c = appGroupPrivacy;
            return this;
        }

        public Builder setDescription(String str) {
            this.b = str;
            return this;
        }

        public Builder setName(String str) {
            this.a = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, null);
        }

        public Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            if (appGroupCreationContent == null) {
                return this;
            }
            return setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
        }
    }

    public static class a implements Parcelable.Creator<AppGroupCreationContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    }

    public AppGroupCreationContent(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppGroupPrivacy getAppGroupPrivacy() {
        return this.c;
    }

    public String getDescription() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeSerializable(this.c);
    }

    public AppGroupCreationContent(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (AppGroupPrivacy) parcel.readSerializable();
    }
}
