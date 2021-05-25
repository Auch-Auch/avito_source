package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
public final class zzaht extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaht> CREATOR = new zzahw();
    @SafeParcelable.Field(id = 4)
    public final byte[] data;
    @SafeParcelable.Field(id = 3)
    public final int statusCode;
    @SafeParcelable.Field(id = 7)
    public final boolean zzan;
    @SafeParcelable.Field(id = 8)
    public final long zzao;
    @SafeParcelable.Field(id = 2)
    public final String zzcgr;
    @SafeParcelable.Field(id = 5)
    public final String[] zzdey;
    @SafeParcelable.Field(id = 6)
    public final String[] zzdez;
    @SafeParcelable.Field(id = 1)
    public final boolean zzdfa;

    @SafeParcelable.Constructor
    public zzaht(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) long j) {
        this.zzdfa = z;
        this.zzcgr = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdey = strArr;
        this.zzdez = strArr2;
        this.zzan = z2;
        this.zzao = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdfa);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgr, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdey, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdez, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzan);
        SafeParcelWriter.writeLong(parcel, 8, this.zzao);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
