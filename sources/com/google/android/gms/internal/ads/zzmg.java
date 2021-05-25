package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;
public final class zzmg extends zzmj {
    public static final Parcelable.Creator<zzmg> CREATOR = new zzmf();
    private final String description;
    private final String mimeType;
    private final int zzbdd;
    private final byte[] zzbde;

    public zzmg(String str, String str2, int i, byte[] bArr) {
        super(ApicFrame.ID);
        this.mimeType = str;
        this.description = null;
        this.zzbdd = 3;
        this.zzbde = bArr;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmg.class == obj.getClass()) {
            zzmg zzmg = (zzmg) obj;
            if (this.zzbdd == zzmg.zzbdd && zzpq.zza(this.mimeType, zzmg.mimeType) && zzpq.zza(this.description, zzmg.description) && Arrays.equals(this.zzbde, zzmg.zzbde)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = (this.zzbdd + 527) * 31;
        String str = this.mimeType;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return Arrays.hashCode(this.zzbde) + ((hashCode + i2) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbdd);
        parcel.writeByteArray(this.zzbde);
    }

    public zzmg(Parcel parcel) {
        super(ApicFrame.ID);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbdd = parcel.readInt();
        this.zzbde = parcel.createByteArray();
    }
}
