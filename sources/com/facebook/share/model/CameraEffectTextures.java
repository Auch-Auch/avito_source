package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.internal.Utility;
import java.util.Set;
public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new a();
    public final Bundle a;

    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        public Bundle a = new Bundle();

        public Builder putTexture(String str, Bitmap bitmap) {
            if (!Utility.isNullOrEmpty(str) && bitmap != null) {
                this.a.putParcelable(str, bitmap);
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
        }

        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.a.putAll(cameraEffectTextures.a);
            }
            return this;
        }

        public Builder putTexture(String str, Uri uri) {
            if (!Utility.isNullOrEmpty(str) && uri != null) {
                this.a.putParcelable(str, uri);
            }
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }
    }

    public static class a implements Parcelable.Creator<CameraEffectTextures> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    }

    public CameraEffectTextures(Builder builder, a aVar) {
        this.a = builder.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Object get(String str) {
        return this.a.get(str);
    }

    @Nullable
    public Bitmap getTextureBitmap(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    @Nullable
    public Uri getTextureUri(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    public Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    public CameraEffectTextures(Parcel parcel) {
        this.a = parcel.readBundle(getClass().getClassLoader());
    }
}
