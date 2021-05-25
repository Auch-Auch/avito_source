package com.yandex.mobile.ads.video.models.vmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.yandex.mobile.ads.video.models.vmap.c.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(@NonNull Parcel parcel) {
            return new c(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i) {
            return new c[i];
        }
    };
    @NonNull
    private final String a;
    @NonNull
    private final String b;

    public c(@NonNull String str, @NonNull String str2) {
        this.b = str2;
        this.a = str;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public c(@NonNull Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
