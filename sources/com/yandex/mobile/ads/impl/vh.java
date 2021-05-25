package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class vh implements Parcelable {
    public static final Parcelable.Creator<vh> CREATOR = new Parcelable.Creator<vh>() { // from class: com.yandex.mobile.ads.impl.vh.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ vh createFromParcel(@NonNull Parcel parcel) {
            return new vh(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ vh[] newArray(int i) {
            return new vh[i];
        }
    };
    @Nullable
    private final String a;
    @Nullable
    private final String b;

    public static class a {
        @Nullable
        private String a;
        @Nullable
        private String b;

        @NonNull
        public final a a(@NonNull String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public final a b(@NonNull String str) {
            this.b = str;
            return this;
        }
    }

    public /* synthetic */ vh(a aVar, byte b2) {
        this(aVar);
    }

    @Nullable
    public final String a() {
        return this.a;
    }

    @Nullable
    public final String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    private vh(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }

    public vh(@NonNull Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
