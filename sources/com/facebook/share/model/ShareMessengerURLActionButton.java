package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareMessengerActionButton;
@Deprecated
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new a();
    public final Uri b;
    public final Uri c;
    public final boolean d;
    public final boolean e;
    public final WebviewHeightRatio f;

    public static final class Builder extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder> {
        public Uri b;
        public boolean c;
        public Uri d;
        public WebviewHeightRatio e;
        public boolean f;

        public Builder setFallbackUrl(@Nullable Uri uri) {
            this.d = uri;
            return this;
        }

        public Builder setIsMessengerExtensionURL(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setShouldHideWebviewShareButton(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setUrl(@Nullable Uri uri) {
            this.b = uri;
            return this;
        }

        public Builder setWebviewHeightRatio(WebviewHeightRatio webviewHeightRatio) {
            this.e = webviewHeightRatio;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerURLActionButton build() {
            return new ShareMessengerURLActionButton(this, null);
        }

        public Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            if (shareMessengerURLActionButton == null) {
                return this;
            }
            return setUrl(shareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton.getShouldHideWebviewShareButton());
        }
    }

    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    public static class a implements Parcelable.Creator<ShareMessengerURLActionButton> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ShareMessengerURLActionButton[] newArray(int i) {
            return new ShareMessengerURLActionButton[i];
        }
    }

    public ShareMessengerURLActionButton(Builder builder, a aVar) {
        super(builder);
        this.b = builder.b;
        this.d = builder.c;
        this.c = builder.d;
        this.f = builder.e;
        this.e = builder.f;
    }

    @Nullable
    public Uri getFallbackUrl() {
        return this.c;
    }

    public boolean getIsMessengerExtensionURL() {
        return this.d;
    }

    public boolean getShouldHideWebviewShareButton() {
        return this.e;
    }

    public Uri getUrl() {
        return this.b;
    }

    @Nullable
    public WebviewHeightRatio getWebviewHeightRatio() {
        return this.f;
    }

    public ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        boolean z = true;
        this.d = parcel.readByte() != 0;
        this.c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f = (WebviewHeightRatio) parcel.readSerializable();
        this.e = parcel.readByte() == 0 ? false : z;
    }
}
