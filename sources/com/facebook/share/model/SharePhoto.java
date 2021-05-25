package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareMedia;
public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new a();
    public final Bitmap b;
    public final Uri c;
    public final boolean d;
    public final String e;

    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        public Bitmap b;
        public Uri c;
        public boolean d;
        public String e;

        public Builder setBitmap(@Nullable Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public Builder setCaption(@Nullable String str) {
            this.e = str;
            return this;
        }

        public Builder setImageUrl(@Nullable Uri uri) {
            this.c = uri;
            return this;
        }

        public Builder setUserGenerated(boolean z) {
            this.d = z;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhoto build() {
            return new SharePhoto(this, null);
        }

        public Builder readFrom(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
        }
    }

    public static class a implements Parcelable.Creator<SharePhoto> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    }

    public SharePhoto(Builder builder, a aVar) {
        super(builder);
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.b;
    }

    public String getCaption() {
        return this.e;
    }

    @Nullable
    public Uri getImageUrl() {
        return this.c;
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.Type getMediaType() {
        return ShareMedia.Type.PHOTO;
    }

    public boolean getUserGenerated() {
        return this.d;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeString(this.e);
    }

    public SharePhoto(Parcel parcel) {
        super(parcel);
        this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.d = parcel.readByte() != 0;
        this.e = parcel.readString();
    }
}
