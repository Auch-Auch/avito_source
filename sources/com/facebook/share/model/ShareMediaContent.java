package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new a();
    public final List<ShareMedia> g;

    public static class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        public final List<ShareMedia> g = new ArrayList();

        public Builder addMedia(@Nullable List<ShareMedia> list) {
            if (list != null) {
                for (ShareMedia shareMedia : list) {
                    addMedium(shareMedia);
                }
            }
            return this;
        }

        public Builder addMedium(@Nullable ShareMedia shareMedia) {
            ShareMedia shareMedia2;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    shareMedia2 = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    shareMedia2 = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.g.add(shareMedia2);
            }
            return this;
        }

        public Builder setMedia(@Nullable List<ShareMedia> list) {
            this.g.clear();
            addMedia(list);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMediaContent build() {
            return new ShareMediaContent(this, null);
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom((Builder) shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }
    }

    public static class a implements Parcelable.Creator<ShareMediaContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent createFromParcel(Parcel parcel) {
            return new ShareMediaContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent[] newArray(int i) {
            return new ShareMediaContent[i];
        }
    }

    public ShareMediaContent(Builder builder, a aVar) {
        super(builder);
        this.g = Collections.unmodifiableList(builder.g);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public List<ShareMedia> getMedia() {
        return this.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((ShareMedia[]) this.g.toArray(), i);
    }

    public ShareMediaContent(Parcel parcel) {
        super(parcel);
        this.g = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    }
}
