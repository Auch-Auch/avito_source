package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
@Deprecated
public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new a();
    public final MediaType g;
    public final String h;
    public final Uri i;
    public final ShareMessengerActionButton j;

    public static class Builder extends ShareContent.Builder<ShareMessengerMediaTemplateContent, Builder> {
        public MediaType g;
        public String h;
        public Uri i;
        public ShareMessengerActionButton j;

        public Builder setAttachmentId(String str) {
            this.h = str;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.j = shareMessengerActionButton;
            return this;
        }

        public Builder setMediaType(MediaType mediaType) {
            this.g = mediaType;
            return this;
        }

        public Builder setMediaUrl(Uri uri) {
            this.i = uri;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerMediaTemplateContent build() {
            return new ShareMessengerMediaTemplateContent(this, null);
        }

        public Builder readFrom(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            if (shareMessengerMediaTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareMessengerMediaTemplateContent)).setMediaType(shareMessengerMediaTemplateContent.getMediaType()).setAttachmentId(shareMessengerMediaTemplateContent.getAttachmentId()).setMediaUrl(shareMessengerMediaTemplateContent.getMediaUrl()).setButton(shareMessengerMediaTemplateContent.getButton());
        }
    }

    public enum MediaType {
        IMAGE,
        VIDEO
    }

    public static class a implements Parcelable.Creator<ShareMessengerMediaTemplateContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerMediaTemplateContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerMediaTemplateContent[] newArray(int i) {
            return new ShareMessengerMediaTemplateContent[i];
        }
    }

    public ShareMessengerMediaTemplateContent(Builder builder, a aVar) {
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

    public String getAttachmentId() {
        return this.h;
    }

    public ShareMessengerActionButton getButton() {
        return this.j;
    }

    public MediaType getMediaType() {
        return this.g;
    }

    public Uri getMediaUrl() {
        return this.i;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
        parcel.writeParcelable(this.j, i2);
    }

    public ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        this.g = (MediaType) parcel.readSerializable();
        this.h = parcel.readString();
        this.i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.j = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }
}
