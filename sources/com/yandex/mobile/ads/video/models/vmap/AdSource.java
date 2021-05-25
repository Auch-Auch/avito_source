package com.yandex.mobile.ads.video.models.vmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class AdSource implements Parcelable {
    public static final Parcelable.Creator<AdSource> CREATOR = new Parcelable.Creator<AdSource>() { // from class: com.yandex.mobile.ads.video.models.vmap.AdSource.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AdSource createFromParcel(@NonNull Parcel parcel) {
            return new AdSource(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AdSource[] newArray(int i) {
            return new AdSource[i];
        }
    };
    @NonNull
    private final c a;
    @Nullable
    private final Boolean b;
    @Nullable
    private final Boolean c;
    @Nullable
    private final String d;

    public AdSource(@NonNull c cVar, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str) {
        this.d = str;
        this.a = cVar;
        this.b = bool;
        this.c = bool2;
    }

    @NonNull
    public final c a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Nullable
    public final String getId() {
        return this.d;
    }

    @Nullable
    public final Boolean isAllowMultipleAds() {
        return this.b;
    }

    @Nullable
    public final Boolean isFollowRedirects() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeValue(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
    }

    public AdSource(@NonNull Parcel parcel) {
        this.a = (c) parcel.readParcelable(c.class.getClassLoader());
        this.b = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.c = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.d = parcel.readString();
    }
}
