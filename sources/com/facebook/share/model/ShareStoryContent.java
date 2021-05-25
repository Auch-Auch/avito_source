package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new a();
    public final ShareMedia g;
    public final SharePhoto h;
    @Nullable
    public final List<String> i;
    public final String j;

    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {
        public ShareMedia g;
        public SharePhoto h;
        public List<String> i;
        public String j;

        public Builder setAttributionLink(String str) {
            this.j = str;
            return this;
        }

        public Builder setBackgroundAsset(ShareMedia shareMedia) {
            this.g = shareMedia;
            return this;
        }

        public Builder setBackgroundColorList(List<String> list) {
            this.i = list;
            return this;
        }

        public Builder setStickerAsset(SharePhoto sharePhoto) {
            this.h = sharePhoto;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        public Builder readFrom(ShareStoryContent shareStoryContent) {
            if (shareStoryContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
        }
    }

    public static class a implements Parcelable.Creator<ShareStoryContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent createFromParcel(Parcel parcel) {
            return new ShareStoryContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    }

    public ShareStoryContent(Builder builder, a aVar) {
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

    public String getAttributionLink() {
        return this.j;
    }

    public ShareMedia getBackgroundAsset() {
        return this.g;
    }

    @Nullable
    public List<String> getBackgroundColorList() {
        List<String> list = this.i;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public SharePhoto getStickerAsset() {
        return this.h;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.h, 0);
        parcel.writeStringList(this.i);
        parcel.writeString(this.j);
    }

    public ShareStoryContent(Parcel parcel) {
        super(parcel);
        this.g = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.h = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.i = arrayList.isEmpty() ? null : Collections.unmodifiableList(arrayList);
        this.j = parcel.readString();
    }
}
