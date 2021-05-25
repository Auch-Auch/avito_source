package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdResponseParcelCreator")
public final class zzary extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzary> CREATOR = new zzasb();
    @SafeParcelable.Field(id = 5)
    private final int errorCode;
    @SafeParcelable.Field(id = 12)
    private final int orientation;
    @SafeParcelable.Field(id = 1)
    private final int versionCode;
    @Nullable
    @SafeParcelable.Field(id = 37)
    private final zzasa zzbod;
    @SafeParcelable.Field(id = 49)
    private final boolean zzboy;
    @SafeParcelable.Field(id = 53)
    private final boolean zzboz;
    @SafeParcelable.Field(id = 23)
    private final boolean zzbrc;
    @SafeParcelable.Field(id = 31)
    private final boolean zzchp;
    @SafeParcelable.Field(id = 32)
    private final boolean zzchq;
    @SafeParcelable.Field(id = 4)
    private final List<String> zzdis;
    @SafeParcelable.Field(id = 6)
    private final List<String> zzdit;
    @SafeParcelable.Field(id = 52)
    private final List<String> zzdiu;
    @SafeParcelable.Field(id = 40)
    private final List<String> zzdiw;
    @SafeParcelable.Field(id = 42)
    private final boolean zzdix;
    @SafeParcelable.Field(id = 11)
    private final long zzdiz;
    @SafeParcelable.Field(id = 2)
    private final String zzdos;
    @SafeParcelable.Field(id = 24)
    private final boolean zzdqd;
    @SafeParcelable.Field(id = 38)
    private final boolean zzdqq;
    @Nullable
    @SafeParcelable.Field(id = 39)
    private String zzdqr;
    @SafeParcelable.Field(id = 47)
    private final boolean zzdrd;
    @SafeParcelable.Field(id = 3)
    private String zzdrq;
    @SafeParcelable.Field(id = 7)
    private final long zzdrr;
    @SafeParcelable.Field(id = 8)
    private final boolean zzdrs;
    @SafeParcelable.Field(id = 9)
    private final long zzdrt;
    @SafeParcelable.Field(id = 10)
    private final List<String> zzdru;
    @SafeParcelable.Field(id = 13)
    private final String zzdrv;
    @SafeParcelable.Field(id = 14)
    private final long zzdrw;
    @SafeParcelable.Field(id = 15)
    private final String zzdrx;
    @SafeParcelable.Field(id = 18)
    private final boolean zzdry;
    @SafeParcelable.Field(id = 19)
    private final String zzdrz;
    @SafeParcelable.Field(id = 21)
    private final String zzdsa;
    @SafeParcelable.Field(id = 22)
    private final boolean zzdsb;
    @SafeParcelable.Field(id = 25)
    private final boolean zzdsc;
    @SafeParcelable.Field(id = 26)
    private final boolean zzdsd;
    @SafeParcelable.Field(id = 28)
    private zzask zzdse;
    @SafeParcelable.Field(id = 29)
    private String zzdsf;
    @SafeParcelable.Field(id = 30)
    private final String zzdsg;
    @Nullable
    @SafeParcelable.Field(id = 33)
    private final zzaue zzdsh;
    @Nullable
    @SafeParcelable.Field(id = 34)
    private final List<String> zzdsi;
    @Nullable
    @SafeParcelable.Field(id = 35)
    private final List<String> zzdsj;
    @SafeParcelable.Field(id = 36)
    private final boolean zzdsk;
    @Nullable
    @SafeParcelable.Field(id = 43)
    private final String zzdsl;
    @Nullable
    @SafeParcelable.Field(id = 44)
    private final zzavt zzdsm;
    @Nullable
    @SafeParcelable.Field(id = 45)
    private final String zzdsn;
    @SafeParcelable.Field(id = 46)
    private final boolean zzdso;
    @SafeParcelable.Field(id = 48)
    private Bundle zzdsp;
    @SafeParcelable.Field(id = 50)
    private final int zzdsq;
    @SafeParcelable.Field(id = 51)
    private final boolean zzdsr;
    @Nullable
    @SafeParcelable.Field(id = 54)
    private final String zzdss;
    @Nullable
    @SafeParcelable.Field(id = 55)
    private String zzdst;
    @SafeParcelable.Field(id = 56)
    private boolean zzdsu;
    @SafeParcelable.Field(id = 57)
    private boolean zzdsv;

    @SafeParcelable.Constructor
    public zzary(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j4, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z7, @SafeParcelable.Param(id = 26) boolean z8, @SafeParcelable.Param(id = 28) zzask zzask, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z9, @SafeParcelable.Param(id = 32) boolean z10, @SafeParcelable.Param(id = 33) zzaue zzaue, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z11, @SafeParcelable.Param(id = 37) zzasa zzasa, @SafeParcelable.Param(id = 38) boolean z12, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z13, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzavt zzavt, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z14, @SafeParcelable.Param(id = 47) boolean z15, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z16, @SafeParcelable.Param(id = 50) int i4, @SafeParcelable.Param(id = 51) boolean z17, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z18, @SafeParcelable.Param(id = 54) String str12, @Nullable @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z19, @SafeParcelable.Param(id = 57) boolean z20) {
        zzasr zzasr;
        this.versionCode = i;
        this.zzdos = str;
        this.zzdrq = str2;
        List<String> list8 = null;
        this.zzdis = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdit = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdrr = j;
        this.zzdrs = z;
        this.zzdrt = j2;
        this.zzdru = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdiz = j3;
        this.orientation = i3;
        this.zzdrv = str3;
        this.zzdrw = j4;
        this.zzdrx = str4;
        this.zzdry = z2;
        this.zzdrz = str5;
        this.zzdsa = str6;
        this.zzdsb = z3;
        this.zzbrc = z4;
        this.zzdqd = z5;
        this.zzdsc = z7;
        this.zzdso = z14;
        this.zzdsd = z8;
        this.zzdse = zzask;
        this.zzdsf = str7;
        this.zzdsg = str8;
        if (this.zzdrq == null && zzask != null && (zzasr = (zzasr) zzask.zza(zzasr.CREATOR)) != null && !TextUtils.isEmpty(zzasr.zzdti)) {
            this.zzdrq = zzasr.zzdti;
        }
        this.zzchp = z9;
        this.zzchq = z10;
        this.zzdsh = zzaue;
        this.zzdsi = list4;
        this.zzdsj = list5;
        this.zzdsk = z11;
        this.zzbod = zzasa;
        this.zzdqq = z12;
        this.zzdqr = str9;
        this.zzdiw = list6;
        this.zzdix = z13;
        this.zzdsl = str10;
        this.zzdsm = zzavt;
        this.zzdsn = str11;
        this.zzdrd = z15;
        this.zzdsp = bundle;
        this.zzboy = z16;
        this.zzdsq = i4;
        this.zzdsr = z17;
        this.zzdiu = list7 != null ? Collections.unmodifiableList(list7) : list8;
        this.zzboz = z18;
        this.zzdss = str12;
        this.zzdst = str13;
        this.zzdsu = z19;
        this.zzdsv = z20;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdos, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdrq, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdis, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdit, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdrr);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdrs);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdrt);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdru, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdiz);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdrv, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdrw);
        SafeParcelWriter.writeString(parcel, 15, this.zzdrx, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdry);
        SafeParcelWriter.writeString(parcel, 19, this.zzdrz, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdsa, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdsb);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbrc);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdqd);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdsc);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdsd);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdse, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdsf, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzdsg, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzchp);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzchq);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdsh, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdsi, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdsj, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdsk);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzbod, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdqq);
        SafeParcelWriter.writeString(parcel, 39, this.zzdqr, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdiw, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdix);
        SafeParcelWriter.writeString(parcel, 43, this.zzdsl, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdsm, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdsn, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdso);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdrd);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdsp, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzboy);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdsq);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdsr);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdiu, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzboz);
        SafeParcelWriter.writeString(parcel, 54, this.zzdss, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdst, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdsu);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdsv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
