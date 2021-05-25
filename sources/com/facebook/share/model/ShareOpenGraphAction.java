package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new a();

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        public Builder setActionType(String str) {
            putString("og:type", str);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareOpenGraphAction build() {
            return new ShareOpenGraphAction(this, null);
        }

        public Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((Builder) super.readFrom((Builder) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
        }
    }

    public static class a implements Parcelable.Creator<ShareOpenGraphAction> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    }

    public ShareOpenGraphAction(Builder builder, a aVar) {
        super(builder);
    }

    @Nullable
    public String getActionType() {
        return getString("og:type");
    }

    public ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }
}
