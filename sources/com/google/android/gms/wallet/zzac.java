package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "ProxyCardCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzae();
    @SafeParcelable.Field(id = 2)
    private String zzdq;
    @SafeParcelable.Field(id = 3)
    private String zzdr;
    @SafeParcelable.Field(id = 4)
    private int zzds;
    @SafeParcelable.Field(id = 5)
    private int zzdt;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) int i2) {
        this.zzdq = str;
        this.zzdr = str2;
        this.zzds = i;
        this.zzdt = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdq, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdr, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzds);
        SafeParcelWriter.writeInt(parcel, 5, this.zzdt);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
