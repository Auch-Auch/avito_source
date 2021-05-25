package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new a();
    public String g;
    public CameraEffectArguments h;
    public CameraEffectTextures i;

    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        public String g;
        public CameraEffectArguments h;
        public CameraEffectTextures i;

        public Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.h = cameraEffectArguments;
            return this;
        }

        public Builder setEffectId(String str) {
            this.g = str;
            return this;
        }

        public Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.i = cameraEffectTextures;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        public Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            return shareCameraEffectContent == null ? this : ((Builder) super.readFrom((Builder) shareCameraEffectContent)).setEffectId(this.g).setArguments(this.h);
        }
    }

    public static class a implements Parcelable.Creator<ShareCameraEffectContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent createFromParcel(Parcel parcel) {
            return new ShareCameraEffectContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    }

    public ShareCameraEffectContent(Builder builder, a aVar) {
        super(builder);
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public CameraEffectArguments getArguments() {
        return this.h;
    }

    public String getEffectId() {
        return this.g;
    }

    public CameraEffectTextures getTextures() {
        return this.i;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.h, 0);
        parcel.writeParcelable(this.i, 0);
    }

    public ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
        this.h = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.i = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }
}
