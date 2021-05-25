package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();
    @SafeParcelable.Field(id = 2)
    public final boolean zzbor;
    @SafeParcelable.Field(id = 3)
    public final boolean zzbos;
    @SafeParcelable.Field(id = 4)
    private final String zzbot;
    @SafeParcelable.Field(id = 5)
    public final boolean zzbou;
    @SafeParcelable.Field(id = 6)
    public final float zzbov;
    @SafeParcelable.Field(id = 7)
    public final int zzbow;
    @SafeParcelable.Field(id = 8)
    public final boolean zzbox;
    @SafeParcelable.Field(id = 9)
    public final boolean zzboy;
    @SafeParcelable.Field(id = 10)
    public final boolean zzboz;

    public zzi(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z7) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z7);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbor);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbos);
        SafeParcelWriter.writeString(parcel, 4, this.zzbot, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbou);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbov);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbow);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbox);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzboy);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzboz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) boolean z5, @SafeParcelable.Param(id = 10) boolean z7) {
        this.zzbor = z;
        this.zzbos = z2;
        this.zzbot = str;
        this.zzbou = z3;
        this.zzbov = f;
        this.zzbow = i;
        this.zzbox = z4;
        this.zzboy = z5;
        this.zzboz = z7;
    }
}
