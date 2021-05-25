package com.yandex.mobile.ads.video.models.vmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
public final class TimeOffset implements Parcelable {
    public static final Parcelable.Creator<TimeOffset> CREATOR = new Parcelable.Creator<TimeOffset>() { // from class: com.yandex.mobile.ads.video.models.vmap.TimeOffset.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeOffset createFromParcel(@NonNull Parcel parcel) {
            return new TimeOffset(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeOffset[] newArray(int i) {
            return new TimeOffset[i];
        }
    };
    @NonNull
    private final String a;

    public TimeOffset(@NonNull String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NonNull
    public final String getRawValue() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
    }

    public TimeOffset(@NonNull Parcel parcel) {
        this.a = parcel.readString();
    }
}
