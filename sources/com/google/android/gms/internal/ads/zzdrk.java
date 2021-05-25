package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzcf;
@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzdrk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdrk> CREATOR = new zzdrj();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzcf.zza zzhki = null;
    private byte[] zzhkj;

    @SafeParcelable.Constructor
    public zzdrk(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhkj = bArr;
        zzavv();
    }

    private final void zzavv() {
        zzcf.zza zza = this.zzhki;
        if (zza == null && this.zzhkj != null) {
            return;
        }
        if (zza != null && this.zzhkj == null) {
            return;
        }
        if (zza != null && this.zzhkj != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zza == null && this.zzhkj == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzhkj;
        if (bArr == null) {
            bArr = this.zzhki.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzcf.zza zzavu() {
        if (!(this.zzhki != null)) {
            try {
                this.zzhki = zzcf.zza.zza(this.zzhkj, zzegc.zzbey());
                this.zzhkj = null;
            } catch (zzegz e) {
                throw new IllegalStateException(e);
            }
        }
        zzavv();
        return this.zzhki;
    }
}
