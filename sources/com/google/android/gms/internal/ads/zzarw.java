package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
public final class zzarw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarw> CREATOR = new zzarz();
    @SafeParcelable.Field(id = 6)
    private final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 11)
    private final zzbbg zzbpa;
    @SafeParcelable.Field(id = 4)
    private final zzvj zzbpb;
    @SafeParcelable.Field(id = 20)
    private final float zzbrw;
    @SafeParcelable.Field(id = 5)
    private final String zzbuo;
    @SafeParcelable.Field(id = 10)
    private final String zzciq;
    @SafeParcelable.Field(id = 42)
    private final boolean zzdix;
    @SafeParcelable.Field(id = 29)
    private final zzadm zzdla;
    @SafeParcelable.Field(id = 14)
    private final List<String> zzdlb;
    @SafeParcelable.Field(id = 18)
    private final int zzdng;
    @SafeParcelable.Field(id = 19)
    private final int zzdnh;
    @Nullable
    @SafeParcelable.Field(id = 2)
    private final Bundle zzdpv;
    @SafeParcelable.Field(id = 3)
    private final zzvc zzdpw;
    @Nullable
    @SafeParcelable.Field(id = 7)
    private final PackageInfo zzdpx;
    @SafeParcelable.Field(id = 8)
    private final String zzdpy;
    @SafeParcelable.Field(id = 9)
    private final String zzdpz;
    @SafeParcelable.Field(id = 12)
    private final Bundle zzdqa;
    @SafeParcelable.Field(id = 13)
    private final int zzdqb;
    @SafeParcelable.Field(id = 15)
    private final Bundle zzdqc;
    @SafeParcelable.Field(id = 16)
    private final boolean zzdqd;
    @SafeParcelable.Field(id = 21)
    private final String zzdqe;
    @SafeParcelable.Field(id = 25)
    private final long zzdqf;
    @SafeParcelable.Field(id = 26)
    private final String zzdqg;
    @Nullable
    @SafeParcelable.Field(id = 27)
    private final List<String> zzdqh;
    @SafeParcelable.Field(id = 28)
    private final String zzdqi;
    @SafeParcelable.Field(id = 30)
    private final List<String> zzdqj;
    @SafeParcelable.Field(id = 31)
    private final long zzdqk;
    @SafeParcelable.Field(id = 33)
    private final String zzdql;
    @SafeParcelable.Field(id = 34)
    private final float zzdqm;
    @SafeParcelable.Field(id = 35)
    private final int zzdqn;
    @SafeParcelable.Field(id = 36)
    private final int zzdqo;
    @SafeParcelable.Field(id = 37)
    private final boolean zzdqp;
    @SafeParcelable.Field(id = 38)
    private final boolean zzdqq;
    @SafeParcelable.Field(id = 39)
    private final String zzdqr;
    @SafeParcelable.Field(id = 40)
    private final boolean zzdqs;
    @SafeParcelable.Field(id = 41)
    private final String zzdqt;
    @SafeParcelable.Field(id = 43)
    private final int zzdqu;
    @SafeParcelable.Field(id = 44)
    private final Bundle zzdqv;
    @SafeParcelable.Field(id = 45)
    private final String zzdqw;
    @Nullable
    @SafeParcelable.Field(id = 46)
    private final zzym zzdqx;
    @SafeParcelable.Field(id = 47)
    private final boolean zzdqy;
    @SafeParcelable.Field(id = 48)
    private final Bundle zzdqz;
    @Nullable
    @SafeParcelable.Field(id = 49)
    private final String zzdra;
    @Nullable
    @SafeParcelable.Field(id = 50)
    private final String zzdrb;
    @Nullable
    @SafeParcelable.Field(id = 51)
    private final String zzdrc;
    @SafeParcelable.Field(id = 52)
    private final boolean zzdrd;
    @SafeParcelable.Field(id = 53)
    private final List<Integer> zzdre;
    @SafeParcelable.Field(id = 54)
    private final String zzdrf;
    @SafeParcelable.Field(id = 55)
    private final List<String> zzdrg;
    @SafeParcelable.Field(id = 56)
    private final int zzdrh;
    @SafeParcelable.Field(id = 57)
    private final boolean zzdri;
    @SafeParcelable.Field(id = 58)
    private final boolean zzdrj;
    @SafeParcelable.Field(id = 59)
    private final boolean zzdrk;
    @SafeParcelable.Field(id = 60)
    private final ArrayList<String> zzdrl;
    @SafeParcelable.Field(id = 61)
    private final String zzdrm;
    @SafeParcelable.Field(id = 63)
    private final zzair zzdrn;
    @Nullable
    @SafeParcelable.Field(id = 64)
    private final String zzdro;
    @SafeParcelable.Field(id = 65)
    private final Bundle zzdrp;

    @SafeParcelable.Constructor
    public zzarw(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzvc zzvc, @SafeParcelable.Param(id = 4) zzvj zzvj, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo2, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbbg zzbbg, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzadm zzadm, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f2, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzym zzym, @SafeParcelable.Param(id = 47) boolean z7, @SafeParcelable.Param(id = 48) Bundle bundle5, @Nullable @SafeParcelable.Param(id = 49) String str12, @Nullable @SafeParcelable.Param(id = 50) String str13, @Nullable @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z8, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z9, @SafeParcelable.Param(id = 58) boolean z10, @SafeParcelable.Param(id = 59) boolean z11, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzair zzair, @Nullable @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.versionCode = i;
        this.zzdpv = bundle;
        this.zzdpw = zzvc;
        this.zzbpb = zzvj;
        this.zzbuo = str;
        this.applicationInfo = applicationInfo2;
        this.zzdpx = packageInfo;
        this.zzdpy = str2;
        this.zzdpz = str3;
        this.zzciq = str4;
        this.zzbpa = zzbbg;
        this.zzdqa = bundle2;
        this.zzdqb = i2;
        this.zzdlb = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzdqj = list6;
        this.zzdqc = bundle3;
        this.zzdqd = z;
        this.zzdng = i3;
        this.zzdnh = i4;
        this.zzbrw = f;
        this.zzdqe = str5;
        this.zzdqf = j;
        this.zzdqg = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzdqh = list7;
        this.zzdqi = str7;
        this.zzdla = zzadm;
        this.zzdqk = j2;
        this.zzdql = str8;
        this.zzdqm = f2;
        this.zzdqs = z2;
        this.zzdqn = i5;
        this.zzdqo = i6;
        this.zzdqp = z3;
        this.zzdqq = z4;
        this.zzdqr = str9;
        this.zzdqt = str10;
        this.zzdix = z5;
        this.zzdqu = i7;
        this.zzdqv = bundle4;
        this.zzdqw = str11;
        this.zzdqx = zzym;
        this.zzdqy = z7;
        this.zzdqz = bundle5;
        this.zzdra = str12;
        this.zzdrb = str13;
        this.zzdrc = str14;
        this.zzdrd = z8;
        this.zzdre = list4;
        this.zzdrf = str15;
        this.zzdrg = list5;
        this.zzdrh = i8;
        this.zzdri = z9;
        this.zzdrj = z10;
        this.zzdrk = z11;
        this.zzdrl = arrayList;
        this.zzdrm = str16;
        this.zzdrn = zzair;
        this.zzdro = str17;
        this.zzdrp = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdpv, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdpw, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbpb, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbuo, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdpx, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdpy, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdpz, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzciq, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbpa, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdqa, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdqb);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdlb, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdqc, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdqd);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdng);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdnh);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbrw);
        SafeParcelWriter.writeString(parcel, 21, this.zzdqe, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdqf);
        SafeParcelWriter.writeString(parcel, 26, this.zzdqg, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdqh, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdqi, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdla, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdqj, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdqk);
        SafeParcelWriter.writeString(parcel, 33, this.zzdql, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdqm);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdqn);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdqo);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdqp);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdqq);
        SafeParcelWriter.writeString(parcel, 39, this.zzdqr, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdqs);
        SafeParcelWriter.writeString(parcel, 41, this.zzdqt, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdix);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdqu);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdqv, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdqw, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdqx, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdqy);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdqz, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdra, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdrb, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdrc, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdrd);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdre, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdrf, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdrg, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdrh);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdri);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdrj);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdrk);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdrl, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdrm, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdrn, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdro, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdrp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
