package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new a();
    public final List<SharePhoto> g;

    public static class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        public final List<SharePhoto> g = new ArrayList();

        public Builder addPhoto(@Nullable SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.g.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public Builder addPhotos(@Nullable List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto sharePhoto : list) {
                    addPhoto(sharePhoto);
                }
            }
            return this;
        }

        public Builder setPhotos(@Nullable List<SharePhoto> list) {
            this.g.clear();
            addPhotos(list);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhotoContent build() {
            return new SharePhotoContent(this, null);
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            return sharePhotoContent == null ? this : ((Builder) super.readFrom((Builder) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }
    }

    public static class a implements Parcelable.Creator<SharePhotoContent> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    }

    public SharePhotoContent(Builder builder, a aVar) {
        super(builder);
        this.g = Collections.unmodifiableList(builder.g);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public List<SharePhoto> getPhotos() {
        return this.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        List<SharePhoto> list = this.g;
        ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            shareMediaArr[i2] = list.get(i2);
        }
        parcel.writeParcelableArray(shareMediaArr, i);
    }

    public SharePhotoContent(Parcel parcel) {
        super(parcel);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
        ArrayList arrayList = new ArrayList(readParcelableArray.length);
        for (Parcelable parcelable : readParcelableArray) {
            arrayList.add((ShareMedia) parcelable);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareMedia shareMedia = (ShareMedia) it.next();
            if (shareMedia instanceof SharePhoto) {
                arrayList2.add((SharePhoto) shareMedia);
            }
        }
        this.g = Collections.unmodifiableList(arrayList2);
    }
}
