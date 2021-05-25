package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
public class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new a();
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;

        public Builder setLink(String str) {
            this.h = str;
            return this;
        }

        public Builder setLinkCaption(String str) {
            this.j = str;
            return this;
        }

        public Builder setLinkDescription(String str) {
            this.k = str;
            return this;
        }

        public Builder setLinkName(String str) {
            this.i = str;
            return this;
        }

        public Builder setMediaSource(String str) {
            this.m = str;
            return this;
        }

        public Builder setPicture(String str) {
            this.l = str;
            return this;
        }

        public Builder setToId(String str) {
            this.g = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        public Builder readFrom(ShareFeedContent shareFeedContent) {
            if (shareFeedContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
        }
    }

    public static class a implements Parcelable.Creator<ShareFeedContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    }

    public ShareFeedContent(Builder builder, a aVar) {
        super(builder);
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLink() {
        return this.h;
    }

    public String getLinkCaption() {
        return this.j;
    }

    public String getLinkDescription() {
        return this.k;
    }

    public String getLinkName() {
        return this.i;
    }

    public String getMediaSource() {
        return this.m;
    }

    public String getPicture() {
        return this.l;
    }

    public String getToId() {
        return this.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
    }

    public ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
    }
}
