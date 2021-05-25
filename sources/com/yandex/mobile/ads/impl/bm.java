package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class bm implements Parcelable {
    public static final Parcelable.Creator<bm> CREATOR = new Parcelable.Creator<bm>() { // from class: com.yandex.mobile.ads.impl.bm.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ bm createFromParcel(Parcel parcel) {
            return new bm(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ bm[] newArray(int i) {
            return new bm[i];
        }
    };
    @NonNull
    private final List<bn> a;
    @NonNull
    private final Map<String, String> b;

    public bm(@NonNull List<bn> list, @NonNull Map<String, String> map) {
        this.a = list;
        this.b = map;
    }

    @NonNull
    public final List<bn> a() {
        return this.a;
    }

    @NonNull
    public final Map<String, String> b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
        parcel.writeInt(this.b.size());
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public bm(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        parcel.readList(arrayList, bn.class.getClassLoader());
        int readInt = parcel.readInt();
        this.b = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.b.put(parcel.readString(), parcel.readString());
        }
    }
}
