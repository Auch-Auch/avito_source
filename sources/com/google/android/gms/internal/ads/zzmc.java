package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
public final class zzmc implements Parcelable {
    public static final Parcelable.Creator<zzmc> CREATOR = new zzme();
    private final zza[] zzbda;

    public interface zza extends Parcelable {
    }

    public zzmc(List<? extends zza> list) {
        zza[] zzaArr = new zza[list.size()];
        this.zzbda = zzaArr;
        list.toArray(zzaArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzmc.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbda, ((zzmc) obj).zzbda);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(this.zzbda);
    }

    public final int length() {
        return this.zzbda.length;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbda.length);
        for (zza zza2 : this.zzbda) {
            parcel.writeParcelable(zza2, 0);
        }
    }

    public final zza zzba(int i) {
        return this.zzbda[i];
    }

    public zzmc(Parcel parcel) {
        this.zzbda = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.zzbda;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }
}
