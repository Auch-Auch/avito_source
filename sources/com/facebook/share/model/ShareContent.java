package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public abstract class ShareContent<P extends ShareContent, E extends Builder> implements ShareModel {
    public final Uri a;
    public final List<String> b;
    public final String c;
    public final String d;
    public final String e;
    public final ShareHashtag f;

    public static abstract class Builder<P extends ShareContent, E extends Builder> implements ShareModelBuilder<P, E> {
        public Uri a;
        public List<String> b;
        public String c;
        public String d;
        public String e;
        public ShareHashtag f;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.share.model.ShareContent$Builder<P extends com.facebook.share.model.ShareContent, E extends com.facebook.share.model.ShareContent$Builder> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            return readFrom((Builder<P, E>) ((ShareContent) shareModel));
        }

        public E setContentUrl(@Nullable Uri uri) {
            this.a = uri;
            return this;
        }

        public E setPageId(@Nullable String str) {
            this.d = str;
            return this;
        }

        public E setPeopleIds(@Nullable List<String> list) {
            this.b = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public E setPlaceId(@Nullable String str) {
            this.c = str;
            return this;
        }

        public E setRef(@Nullable String str) {
            this.e = str;
            return this;
        }

        public E setShareHashtag(@Nullable ShareHashtag shareHashtag) {
            this.f = shareHashtag;
            return this;
        }

        public E readFrom(P p) {
            return p == null ? this : (E) setContentUrl(p.getContentUrl()).setPeopleIds(p.getPeopleIds()).setPlaceId(p.getPlaceId()).setPageId(p.getPageId()).setRef(p.getRef()).setShareHashtag(p.getShareHashtag());
        }
    }

    public ShareContent(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Uri getContentUrl() {
        return this.a;
    }

    @Nullable
    public String getPageId() {
        return this.d;
    }

    @Nullable
    public List<String> getPeopleIds() {
        return this.b;
    }

    @Nullable
    public String getPlaceId() {
        return this.c;
    }

    @Nullable
    public String getRef() {
        return this.e;
    }

    @Nullable
    public ShareHashtag getShareHashtag() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeStringList(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, 0);
    }

    public ShareContent(Parcel parcel) {
        this.a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.b = arrayList.size() == 0 ? null : Collections.unmodifiableList(arrayList);
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = new ShareHashtag.Builder().readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader())).build();
    }
}
