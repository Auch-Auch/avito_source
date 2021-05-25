package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
public abstract class ShareMedia implements ShareModel {
    public final Bundle a;

    public static abstract class Builder<M extends ShareMedia, B extends Builder> implements ShareModelBuilder<M, B> {
        public Bundle a = new Bundle();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.share.model.ShareMedia$Builder<M extends com.facebook.share.model.ShareMedia, B extends com.facebook.share.model.ShareMedia$Builder> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            return readFrom((Builder<M, B>) ((ShareMedia) shareModel));
        }

        @Deprecated
        public B setParameter(String str, String str2) {
            this.a.putString(str, str2);
            return this;
        }

        @Deprecated
        public B setParameters(Bundle bundle) {
            this.a.putAll(bundle);
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setParameters(m.getParameters());
        }
    }

    public enum Type {
        PHOTO,
        VIDEO
    }

    public ShareMedia(Builder builder) {
        this.a = new Bundle(builder.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract Type getMediaType();

    @Deprecated
    public Bundle getParameters() {
        return new Bundle(this.a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    public ShareMedia(Parcel parcel) {
        this.a = parcel.readBundle();
    }
}
