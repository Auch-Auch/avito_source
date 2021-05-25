package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzag();
    @SafeParcelable.Field(id = 7)
    private final float zzdv;
    @SafeParcelable.Field(id = 8)
    public final String zzej;
    @SafeParcelable.Field(id = 2)
    public final zzao[] zzeo;
    @SafeParcelable.Field(id = 3)
    public final zzab zzep;
    @SafeParcelable.Field(id = 4)
    private final zzab zzeq;
    @SafeParcelable.Field(id = 5)
    private final zzab zzer;
    @SafeParcelable.Field(id = 6)
    public final String zzes;
    @SafeParcelable.Field(id = 9)
    private final int zzet;
    @SafeParcelable.Field(id = 10)
    public final boolean zzeu;
    @SafeParcelable.Field(id = 11)
    public final int zzev;
    @SafeParcelable.Field(id = 12)
    public final int zzew;

    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 2) zzao[] zzaoArr, @SafeParcelable.Param(id = 3) zzab zzab, @SafeParcelable.Param(id = 4) zzab zzab2, @SafeParcelable.Param(id = 5) zzab zzab3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) float f, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3) {
        this.zzeo = zzaoArr;
        this.zzep = zzab;
        this.zzeq = zzab2;
        this.zzer = zzab3;
        this.zzes = str;
        this.zzdv = f;
        this.zzej = str2;
        this.zzet = i;
        this.zzeu = z;
        this.zzev = i2;
        this.zzew = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzeo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzep, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzeq, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzer, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzes, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdv);
        SafeParcelWriter.writeString(parcel, 8, this.zzej, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzet);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzeu);
        SafeParcelWriter.writeInt(parcel, 11, this.zzev);
        SafeParcelWriter.writeInt(parcel, 12, this.zzew);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
