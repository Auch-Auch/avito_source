package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new a();
    @Deprecated
    public final String g;
    @Deprecated
    public final String h;
    @Deprecated
    public final Uri i;
    public final String j;

    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        public String g;

        @Deprecated
        public Builder setContentDescription(@Nullable String str) {
            return this;
        }

        @Deprecated
        public Builder setContentTitle(@Nullable String str) {
            return this;
        }

        @Deprecated
        public Builder setImageUrl(@Nullable Uri uri) {
            return this;
        }

        public Builder setQuote(@Nullable String str) {
            this.g = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareLinkContent build() {
            return new ShareLinkContent(this, null);
        }

        public Builder readFrom(ShareLinkContent shareLinkContent) {
            if (shareLinkContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }

    public static class a implements Parcelable.Creator<ShareLinkContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    }

    public ShareLinkContent(Builder builder, a aVar) {
        super(builder);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = builder.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getContentDescription() {
        return this.g;
    }

    @Nullable
    @Deprecated
    public String getContentTitle() {
        return this.h;
    }

    @Nullable
    @Deprecated
    public Uri getImageUrl() {
        return this.i;
    }

    @Nullable
    public String getQuote() {
        return this.j;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, 0);
        parcel.writeString(this.j);
    }

    public ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.j = parcel.readString();
    }
}
