package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Set;
public class CameraEffectArguments implements ShareModel {
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new a();
    public final Bundle a;

    public static class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        public Bundle a = new Bundle();

        public Builder putArgument(String str, String str2) {
            this.a.putString(str, str2);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectArguments build() {
            return new CameraEffectArguments(this, null);
        }

        public Builder putArgument(String str, String[] strArr) {
            this.a.putStringArray(str, strArr);
            return this;
        }

        public Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.a.putAll(cameraEffectArguments.a);
            }
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }
    }

    public static class a implements Parcelable.Creator<CameraEffectArguments> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    }

    public CameraEffectArguments(Builder builder, a aVar) {
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
    public String getString(String str) {
        return this.a.getString(str);
    }

    @Nullable
    public String[] getStringArray(String str) {
        return this.a.getStringArray(str);
    }

    public Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    public CameraEffectArguments(Parcel parcel) {
        this.a = parcel.readBundle(getClass().getClassLoader());
    }
}
