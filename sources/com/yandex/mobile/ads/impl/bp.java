package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
public class bp implements Parcelable {
    public static final Parcelable.Creator<bp> CREATOR = new Parcelable.Creator<bp>() { // from class: com.yandex.mobile.ads.impl.bp.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ bp createFromParcel(@NonNull Parcel parcel) {
            return new bp(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ bp[] newArray(int i) {
            return new bp[i];
        }
    };
    private final int a;
    @NonNull
    private final String b;

    public bp(int i, @NonNull String str) {
        this.a = i;
        this.b = str;
    }

    public final int a() {
        return this.a;
    }

    @NonNull
    public final String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }

    public bp(@NonNull Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }
}
