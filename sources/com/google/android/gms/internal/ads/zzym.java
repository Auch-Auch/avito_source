package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzym> CREATOR = new zzyp();
    @SafeParcelable.Field(id = 2)
    private final int zzcjb;

    @SafeParcelable.Constructor
    public zzym(@SafeParcelable.Param(id = 2) int i) {
        this.zzcjb = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzcjb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
