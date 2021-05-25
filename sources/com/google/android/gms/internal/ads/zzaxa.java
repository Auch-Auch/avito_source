package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
public final class zzaxa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaxa> CREATOR = new zzaxd();
    @SafeParcelable.Field(id = 2)
    public final String zzbqx;
    @SafeParcelable.Field(id = 1)
    @Deprecated
    public final String zzbuo;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    public final zzvj zzdxj;
    @SafeParcelable.Field(id = 4)
    public final zzvc zzdxk;

    @SafeParcelable.Constructor
    public zzaxa(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzvj zzvj, @SafeParcelable.Param(id = 4) zzvc zzvc) {
        this.zzbuo = str;
        this.zzbqx = str2;
        this.zzdxj = zzvj;
        this.zzdxk = zzvc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbuo, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbqx, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdxj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdxk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
