package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new a();
    public final String g;
    public final String h;
    public final SharePhoto i;
    public final ShareVideo j;

    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        public String g;
        public String h;
        public SharePhoto i;
        public ShareVideo j;

        public Builder setContentDescription(@Nullable String str) {
            this.g = str;
            return this;
        }

        public Builder setContentTitle(@Nullable String str) {
            this.h = str;
            return this;
        }

        public Builder setPreviewPhoto(@Nullable SharePhoto sharePhoto) {
            SharePhoto sharePhoto2;
            if (sharePhoto == null) {
                sharePhoto2 = null;
            } else {
                sharePhoto2 = new SharePhoto.Builder().readFrom(sharePhoto).build();
            }
            this.i = sharePhoto2;
            return this;
        }

        public Builder setVideo(@Nullable ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.j = new ShareVideo.Builder().readFrom(shareVideo).build();
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        public Builder readFrom(ShareVideoContent shareVideoContent) {
            if (shareVideoContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
        }
    }

    public static class a implements Parcelable.Creator<ShareVideoContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    }

    public ShareVideoContent(Builder builder, a aVar) {
        super(builder);
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getContentDescription() {
        return this.g;
    }

    @Nullable
    public String getContentTitle() {
        return this.h;
    }

    @Nullable
    public SharePhoto getPreviewPhoto() {
        return this.i;
    }

    @Nullable
    public ShareVideo getVideo() {
        return this.j;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.j, 0);
    }

    public ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
        this.h = parcel.readString();
        SharePhoto.Builder readFrom = new SharePhoto.Builder().readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        if (readFrom.c == null && readFrom.b == null) {
            this.i = null;
        } else {
            this.i = readFrom.build();
        }
        this.j = new ShareVideo.Builder().readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader())).build();
    }
}
