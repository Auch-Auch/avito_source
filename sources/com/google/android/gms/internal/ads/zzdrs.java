package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "ProgramRequestCreator")
public final class zzdrs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdrs> CREATOR = new zzdrr();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 3)
    private final String zzhjd;
    @SafeParcelable.Field(id = 4)
    private final String zzhje;
    @SafeParcelable.Field(id = 2)
    private final int zzhjf;
    @SafeParcelable.Field(id = 5)
    private final int zzhku;

    @SafeParcelable.Constructor
    public zzdrs(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.versionCode = i;
        this.zzhjf = i2;
        this.zzhjd = str;
        this.zzhje = str2;
        this.zzhku = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhjf);
        SafeParcelWriter.writeString(parcel, 3, this.zzhjd, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhje, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhku);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdrs(int i, zzgo zzgo, String str, String str2) {
        this(1, i, zzgo.zzv(), str, str2);
    }
}
