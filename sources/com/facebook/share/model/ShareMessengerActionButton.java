package com.facebook.share.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
@Deprecated
public abstract class ShareMessengerActionButton implements ShareModel {
    public final String a;

    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        public String a;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.share.model.ShareMessengerActionButton$Builder<M extends com.facebook.share.model.ShareMessengerActionButton, B extends com.facebook.share.model.ShareMessengerActionButton$Builder> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            return readFrom((Builder<M, B>) ((ShareMessengerActionButton) shareModel));
        }

        public B setTitle(@Nullable String str) {
            this.a = str;
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }

    public ShareMessengerActionButton(Builder builder) {
        this.a = builder.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        this.a = parcel.readString();
    }
}
