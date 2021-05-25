package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new a();
    public final String a;
    public final String b;
    public final Uri c;
    public final ShareMessengerActionButton d;
    public final ShareMessengerActionButton e;

    public static class Builder implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder> {
        public String a;
        public String b;
        public Uri c;
        public ShareMessengerActionButton d;
        public ShareMessengerActionButton e;

        public Builder readFrom(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            if (shareMessengerGenericTemplateElement == null) {
                return this;
            }
            return setTitle(shareMessengerGenericTemplateElement.a).setSubtitle(shareMessengerGenericTemplateElement.b).setImageUrl(shareMessengerGenericTemplateElement.c).setDefaultAction(shareMessengerGenericTemplateElement.d).setButton(shareMessengerGenericTemplateElement.e);
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.e = shareMessengerActionButton;
            return this;
        }

        public Builder setDefaultAction(ShareMessengerActionButton shareMessengerActionButton) {
            this.d = shareMessengerActionButton;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.c = uri;
            return this;
        }

        public Builder setSubtitle(String str) {
            this.b = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.a = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerGenericTemplateElement build() {
            return new ShareMessengerGenericTemplateElement(this, null);
        }
    }

    public static class a implements Parcelable.Creator<ShareMessengerGenericTemplateElement> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateElement(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerGenericTemplateElement[] newArray(int i) {
            return new ShareMessengerGenericTemplateElement[i];
        }
    }

    public ShareMessengerGenericTemplateElement(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShareMessengerActionButton getButton() {
        return this.e;
    }

    public ShareMessengerActionButton getDefaultAction() {
        return this.d;
    }

    public Uri getImageUrl() {
        return this.c;
    }

    public String getSubtitle() {
        return this.b;
    }

    public String getTitle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
    }

    public ShareMessengerGenericTemplateElement(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.d = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.e = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }
}
