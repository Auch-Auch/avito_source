package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzatz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatz> CREATOR = new zzaty();
    @SafeParcelable.Field(id = 3)
    public final String zzbuo;
    @SafeParcelable.Field(id = 2)
    public final zzvc zzdpw;

    @SafeParcelable.Constructor
    public zzatz(@SafeParcelable.Param(id = 2) zzvc zzvc, @SafeParcelable.Param(id = 3) String str) {
        this.zzdpw = zzvc;
        this.zzbuo = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdpw, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbuo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
