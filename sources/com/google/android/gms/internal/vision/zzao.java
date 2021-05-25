package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    @SafeParcelable.Field(id = 6)
    private final float zzdv;
    @SafeParcelable.Field(id = 7)
    public final String zzej;
    @SafeParcelable.Field(id = 3)
    public final zzab zzep;
    @SafeParcelable.Field(id = 4)
    private final zzab zzeq;
    @SafeParcelable.Field(id = 5)
    public final String zzes;
    @SafeParcelable.Field(id = 2)
    private final zzal[] zzey;
    @SafeParcelable.Field(id = 8)
    private final boolean zzez;

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(id = 2) zzal[] zzalArr, @SafeParcelable.Param(id = 3) zzab zzab, @SafeParcelable.Param(id = 4) zzab zzab2, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z) {
        this.zzey = zzalArr;
        this.zzep = zzab;
        this.zzeq = zzab2;
        this.zzes = str;
        this.zzdv = f;
        this.zzej = str2;
        this.zzez = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzey, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzep, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzeq, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzes, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzdv);
        SafeParcelWriter.writeString(parcel, 7, this.zzej, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzez);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
