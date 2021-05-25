package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "AdErrorParcelCreator")
public final class zzuw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuw> CREATOR = new zzuz();
    @SafeParcelable.Field(id = 1)
    public final int errorCode;
    @SafeParcelable.Field(id = 2)
    public final String zzcgr;
    @SafeParcelable.Field(id = 3)
    public final String zzcgs;
    @Nullable
    @SafeParcelable.Field(id = 4)
    private final zzuw zzcgt;

    @SafeParcelable.Constructor
    public zzuw(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) zzuw zzuw) {
        this.errorCode = i;
        this.zzcgr = str;
        this.zzcgs = str2;
        this.zzcgt = zzuw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgr, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcgs, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcgt, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zzpf() {
        zzuw zzuw = this.zzcgt;
        return new AdError(this.errorCode, this.zzcgr, this.zzcgs, zzuw == null ? null : new AdError(zzuw.errorCode, zzuw.zzcgr, zzuw.zzcgs));
    }

    public final LoadAdError zzpg() {
        zzuw zzuw = this.zzcgt;
        return new LoadAdError(this.errorCode, this.zzcgr, this.zzcgs, zzuw == null ? null : new AdError(zzuw.errorCode, zzuw.zzcgr, zzuw.zzcgs), null);
    }
}
