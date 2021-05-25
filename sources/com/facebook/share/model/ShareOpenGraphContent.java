package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareOpenGraphAction;
public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new a();
    public final ShareOpenGraphAction g;
    public final String h;

    public static final class Builder extends ShareContent.Builder<ShareOpenGraphContent, Builder> {
        public ShareOpenGraphAction g;
        public String h;

        public Builder setAction(@Nullable ShareOpenGraphAction shareOpenGraphAction) {
            ShareOpenGraphAction shareOpenGraphAction2;
            if (shareOpenGraphAction == null) {
                shareOpenGraphAction2 = null;
            } else {
                shareOpenGraphAction2 = new ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.g = shareOpenGraphAction2;
            return this;
        }

        public Builder setPreviewPropertyName(@Nullable String str) {
            this.h = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareOpenGraphContent build() {
            return new ShareOpenGraphContent(this, null);
        }

        public Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            if (shareOpenGraphContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((Builder) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
        }
    }

    public static class a implements Parcelable.Creator<ShareOpenGraphContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    }

    public ShareOpenGraphContent(Builder builder, a aVar) {
        super(builder);
        this.g = builder.g;
        this.h = builder.h;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public ShareOpenGraphAction getAction() {
        return this.g;
    }

    @Nullable
    public String getPreviewPropertyName() {
        return this.h;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.g, 0);
        parcel.writeString(this.h);
    }

    public ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.g = new ShareOpenGraphAction.Builder().readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader())).build();
        this.h = parcel.readString();
    }
}
