package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class bq implements Parcelable {
    public static final Parcelable.Creator<bq> CREATOR = new Parcelable.Creator<bq>() { // from class: com.yandex.mobile.ads.impl.bq.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ bq createFromParcel(@NonNull Parcel parcel) {
            return new bq(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ bq[] newArray(int i) {
            return new bq[i];
        }
    };
    private final boolean a;
    @Nullable
    private final bp b;
    @Nullable
    private final br c;

    public static class a {
        private boolean a;
        @Nullable
        private bp b;
        @Nullable
        private br c;

        @NonNull
        public final bq a() {
            return new bq(this, (byte) 0);
        }

        @NonNull
        public final a a(boolean z) {
            this.a = z;
            return this;
        }

        @NonNull
        public final a a(@Nullable bp bpVar) {
            this.b = bpVar;
            return this;
        }

        @NonNull
        public final a a(@Nullable br brVar) {
            this.c = brVar;
            return this;
        }
    }

    public /* synthetic */ bq(a aVar, byte b2) {
        this(aVar);
    }

    @Nullable
    public final bp a() {
        return this.b;
    }

    @Nullable
    public final br b() {
        return this.c;
    }

    public final boolean c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : 0);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    private bq(@NonNull a aVar) {
        this.b = aVar.b;
        this.c = aVar.c;
        this.a = aVar.a;
    }

    public bq(@NonNull Parcel parcel) {
        this.a = parcel.readByte() != 0;
        this.b = (bp) parcel.readParcelable(bp.class.getClassLoader());
        this.c = (br) parcel.readParcelable(br.class.getClassLoader());
    }
}
