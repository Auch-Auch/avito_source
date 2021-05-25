package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class tt implements Parcelable {
    public static final Parcelable.Creator<tt> CREATOR = new Parcelable.Creator<tt>() { // from class: com.yandex.mobile.ads.impl.tt.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ tt createFromParcel(@NonNull Parcel parcel) {
            return new tt(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ tt[] newArray(int i) {
            return new tt[i];
        }
    };
    @NonNull
    private final String a;
    @NonNull
    private final List<VideoAd> b;

    public tt(@NonNull String str, @NonNull List<VideoAd> list) {
        this.a = str;
        this.b = list;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @NonNull
    public final List<VideoAd> b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedList(this.b);
    }

    public tt(@NonNull Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.createTypedArrayList(VideoAd.CREATOR);
    }
}
