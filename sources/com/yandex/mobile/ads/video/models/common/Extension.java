package com.yandex.mobile.ads.video.models.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
public final class Extension implements Parcelable {
    public static final Parcelable.Creator<Extension> CREATOR = new Parcelable.Creator<Extension>() { // from class: com.yandex.mobile.ads.video.models.common.Extension.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Extension createFromParcel(@NonNull Parcel parcel) {
            return new Extension(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Extension[] newArray(int i) {
            return new Extension[i];
        }
    };
    @NonNull
    private final String a;
    @NonNull
    private final String b;

    public Extension(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NonNull
    public final String getType() {
        return this.a;
    }

    @NonNull
    public final String getValue() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public Extension(@NonNull Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
