package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzvc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvc> CREATOR = new zzve();
    @SafeParcelable.Field(id = 3)
    public final Bundle extras;
    @SafeParcelable.Field(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(id = 7)
    public final int zzadj;
    @SafeParcelable.Field(id = 20)
    public final int zzadk;
    @Nullable
    @SafeParcelable.Field(id = 21)
    public final String zzadl;
    @SafeParcelable.Field(id = 8)
    public final boolean zzbnu;
    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzcgv;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzcgw;
    @SafeParcelable.Field(id = 5)
    public final List<String> zzcgx;
    @SafeParcelable.Field(id = 6)
    public final boolean zzcgy;
    @SafeParcelable.Field(id = 9)
    public final String zzcgz;
    @SafeParcelable.Field(id = 10)
    public final zzzy zzcha;
    @SafeParcelable.Field(id = 12)
    public final String zzchb;
    @SafeParcelable.Field(id = 13)
    public final Bundle zzchc;
    @SafeParcelable.Field(id = 14)
    public final Bundle zzchd;
    @SafeParcelable.Field(id = 15)
    public final List<String> zzche;
    @SafeParcelable.Field(id = 16)
    public final String zzchf;
    @SafeParcelable.Field(id = 17)
    public final String zzchg;
    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzchh;
    @Nullable
    @SafeParcelable.Field(id = 19)
    public final zzuu zzchi;
    @SafeParcelable.Field(id = 22)
    public final List<String> zzchj;
    @SafeParcelable.Field(id = 11)
    public final Location zznb;

    @SafeParcelable.Constructor
    public zzvc(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzzy zzzy, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzuu zzuu, @SafeParcelable.Param(id = 20) int i4, @Nullable @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 22) List<String> list3) {
        this.versionCode = i;
        this.zzcgv = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcgw = i2;
        this.zzcgx = list;
        this.zzcgy = z;
        this.zzadj = i3;
        this.zzbnu = z2;
        this.zzcgz = str;
        this.zzcha = zzzy;
        this.zznb = location;
        this.zzchb = str2;
        this.zzchc = bundle2 == null ? new Bundle() : bundle2;
        this.zzchd = bundle3;
        this.zzche = list2;
        this.zzchf = str3;
        this.zzchg = str4;
        this.zzchh = z3;
        this.zzchi = zzuu;
        this.zzadk = i4;
        this.zzadl = str5;
        this.zzchj = list3 == null ? new ArrayList<>() : list3;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvc = (zzvc) obj;
        if (this.versionCode != zzvc.versionCode || this.zzcgv != zzvc.zzcgv || !Objects.equal(this.extras, zzvc.extras) || this.zzcgw != zzvc.zzcgw || !Objects.equal(this.zzcgx, zzvc.zzcgx) || this.zzcgy != zzvc.zzcgy || this.zzadj != zzvc.zzadj || this.zzbnu != zzvc.zzbnu || !Objects.equal(this.zzcgz, zzvc.zzcgz) || !Objects.equal(this.zzcha, zzvc.zzcha) || !Objects.equal(this.zznb, zzvc.zznb) || !Objects.equal(this.zzchb, zzvc.zzchb) || !Objects.equal(this.zzchc, zzvc.zzchc) || !Objects.equal(this.zzchd, zzvc.zzchd) || !Objects.equal(this.zzche, zzvc.zzche) || !Objects.equal(this.zzchf, zzvc.zzchf) || !Objects.equal(this.zzchg, zzvc.zzchg) || this.zzchh != zzvc.zzchh || this.zzadk != zzvc.zzadk || !Objects.equal(this.zzadl, zzvc.zzadl) || !Objects.equal(this.zzchj, zzvc.zzchj)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcgv), this.extras, Integer.valueOf(this.zzcgw), this.zzcgx, Boolean.valueOf(this.zzcgy), Integer.valueOf(this.zzadj), Boolean.valueOf(this.zzbnu), this.zzcgz, this.zzcha, this.zznb, this.zzchb, this.zzchc, this.zzchd, this.zzche, this.zzchf, this.zzchg, Boolean.valueOf(this.zzchh), Integer.valueOf(this.zzadk), this.zzadl, this.zzchj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcgv);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcgw);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcgx, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcgy);
        SafeParcelWriter.writeInt(parcel, 7, this.zzadj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbnu);
        SafeParcelWriter.writeString(parcel, 9, this.zzcgz, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcha, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zznb, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzchb, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzchc, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzchd, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzche, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzchf, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzchg, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzchh);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzchi, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzadk);
        SafeParcelWriter.writeString(parcel, 21, this.zzadl, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzchj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
