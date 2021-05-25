package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
@Deprecated
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new a();
    public final String a;
    public final String b;

    @Deprecated
    public static class Builder implements ShareModelBuilder<LikeContent, Builder> {
        public String a;
        public String b;

        @Deprecated
        public Builder setObjectId(String str) {
            this.a = str;
            return this;
        }

        @Deprecated
        public Builder setObjectType(String str) {
            this.b = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @Deprecated
        public LikeContent build() {
            return new LikeContent(this, null);
        }

        @Deprecated
        public Builder readFrom(LikeContent likeContent) {
            return likeContent == null ? this : setObjectId(likeContent.getObjectId()).setObjectType(likeContent.getObjectType());
        }
    }

    public static class a implements Parcelable.Creator<LikeContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    }

    public LikeContent(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getObjectId() {
        return this.a;
    }

    @Deprecated
    public String getObjectType() {
        return this.b;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    @Deprecated
    public LikeContent(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
