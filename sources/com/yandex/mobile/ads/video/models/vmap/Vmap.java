package com.yandex.mobile.ads.video.models.vmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.common.Extension;
import java.util.List;
public final class Vmap implements Parcelable {
    public static final Parcelable.Creator<Vmap> CREATOR = new Parcelable.Creator<Vmap>() { // from class: com.yandex.mobile.ads.video.models.vmap.Vmap.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Vmap createFromParcel(@NonNull Parcel parcel) {
            return new Vmap(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Vmap[] newArray(int i) {
            return new Vmap[i];
        }
    };
    @NonNull
    private final String a;
    @NonNull
    private final List<AdBreak> b;
    @NonNull
    private final List<Extension> c;

    public Vmap(@NonNull String str, @NonNull List<AdBreak> list, @NonNull List<Extension> list2) {
        this.a = str;
        this.b = list;
        this.c = list2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NonNull
    public final List<AdBreak> getAdBreaks() {
        return this.b;
    }

    @NonNull
    public final List<Extension> getExtensions() {
        return this.c;
    }

    @NonNull
    public final String getVersion() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeTypedList(this.c);
    }

    public Vmap(@NonNull Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.createTypedArrayList(AdBreak.CREATOR);
        this.c = parcel.createTypedArrayList(Extension.CREATOR);
    }
}
