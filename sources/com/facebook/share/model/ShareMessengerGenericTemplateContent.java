package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
@Deprecated
public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new a();
    public final boolean g;
    public final ImageAspectRatio h;
    public final ShareMessengerGenericTemplateElement i;

    public static class Builder extends ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder> {
        public boolean g;
        public ImageAspectRatio h;
        public ShareMessengerGenericTemplateElement i;

        public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            this.i = shareMessengerGenericTemplateElement;
            return this;
        }

        public Builder setImageAspectRatio(ImageAspectRatio imageAspectRatio) {
            this.h = imageAspectRatio;
            return this;
        }

        public Builder setIsSharable(boolean z) {
            this.g = z;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerGenericTemplateContent build() {
            return new ShareMessengerGenericTemplateContent(this);
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            if (shareMessengerGenericTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
        }
    }

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    public static class a implements Parcelable.Creator<ShareMessengerGenericTemplateContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    }

    public ShareMessengerGenericTemplateContent(Builder builder) {
        super(builder);
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.i;
    }

    public ImageAspectRatio getImageAspectRatio() {
        return this.h;
    }

    public boolean getIsSharable() {
        return this.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeSerializable(this.h);
        parcel.writeParcelable(this.i, i2);
    }

    public ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.g = parcel.readByte() != 0;
        this.h = (ImageAspectRatio) parcel.readSerializable();
        this.i = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }
}
