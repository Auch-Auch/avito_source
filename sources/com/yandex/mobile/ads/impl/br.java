package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
public class br implements Parcelable {
    public static final Parcelable.Creator<br> CREATOR = new Parcelable.Creator<br>() { // from class: com.yandex.mobile.ads.impl.br.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ br createFromParcel(@NonNull Parcel parcel) {
            return new br(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ br[] newArray(int i) {
            return new br[i];
        }
    };
    @NonNull
    private final String a;

    public br(@NonNull String str) {
        this.a = str;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
    }

    public br(@NonNull Parcel parcel) {
        this.a = parcel.readString();
    }
}
