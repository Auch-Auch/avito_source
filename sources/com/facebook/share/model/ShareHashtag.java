package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new a();
    public final String a;

    public static class Builder implements ShareModelBuilder<ShareHashtag, Builder> {
        public String a;

        public String getHashtag() {
            return this.a;
        }

        public Builder setHashtag(String str) {
            this.a = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareHashtag build() {
            return new ShareHashtag(this, null);
        }

        public Builder readFrom(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : setHashtag(shareHashtag.getHashtag());
        }
    }

    public static class a implements Parcelable.Creator<ShareHashtag> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    }

    public ShareHashtag(Builder builder, a aVar) {
        this.a = builder.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHashtag() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }

    public ShareHashtag(Parcel parcel) {
        this.a = parcel.readString();
    }
}
