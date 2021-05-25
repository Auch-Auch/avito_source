package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "PoolConfigurationCreator")
public final class zzdnd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdnd> CREATOR = new zzdni();
    private final zzdng[] zzhee;
    private final int[] zzhef;
    private final int[] zzheg;
    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzheh;
    public final zzdng zzhei;
    @SafeParcelable.Field(id = 2)
    public final int zzhej;
    @SafeParcelable.Field(id = 3)
    public final int zzhek;
    @SafeParcelable.Field(id = 4)
    public final int zzhel;
    @SafeParcelable.Field(id = 5)
    public final String zzhem;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzhen;
    public final int zzheo;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzhep;
    private final int zzheq;
    @Nullable
    public final Context zzvr;

    private zzdnd(@Nullable Context context, zzdng zzdng, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzhee = zzdng.values();
        this.zzhef = zzdnf.zzatv();
        this.zzheg = zzdnf.zzatw();
        this.zzvr = context;
        this.zzheh = zzdng.ordinal();
        this.zzhei = zzdng;
        this.zzhej = i;
        this.zzhek = i2;
        this.zzhel = i3;
        this.zzhem = str;
        if ("oldest".equals(str2)) {
            i4 = zzdnf.zzhet;
        } else if ("lru".equals(str2) || !"lfu".equals(str2)) {
            i4 = zzdnf.zzheu;
        } else {
            i4 = zzdnf.zzhev;
        }
        this.zzheo = i4;
        this.zzhen = i4 - 1;
        "onAdClosed".equals(str3);
        int i5 = zzdnf.zzhex;
        this.zzheq = i5;
        this.zzhep = i5 - 1;
    }

    public static zzdnd zza(zzdng zzdng, Context context) {
        if (zzdng == zzdng.Rewarded) {
            return new zzdnd(context, zzdng, ((Integer) zzwe.zzpu().zzd(zzaat.zzcwe)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwk)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwm)).intValue(), (String) zzwe.zzpu().zzd(zzaat.zzcwo), (String) zzwe.zzpu().zzd(zzaat.zzcwg), (String) zzwe.zzpu().zzd(zzaat.zzcwi));
        } else if (zzdng == zzdng.Interstitial) {
            return new zzdnd(context, zzdng, ((Integer) zzwe.zzpu().zzd(zzaat.zzcwf)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwl)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwn)).intValue(), (String) zzwe.zzpu().zzd(zzaat.zzcwp), (String) zzwe.zzpu().zzd(zzaat.zzcwh), (String) zzwe.zzpu().zzd(zzaat.zzcwj));
        } else if (zzdng != zzdng.AppOpen) {
            return null;
        } else {
            return new zzdnd(context, zzdng, ((Integer) zzwe.zzpu().zzd(zzaat.zzcws)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwu)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaat.zzcwv)).intValue(), (String) zzwe.zzpu().zzd(zzaat.zzcwq), (String) zzwe.zzpu().zzd(zzaat.zzcwr), (String) zzwe.zzpu().zzd(zzaat.zzcwt));
        }
    }

    public static boolean zzatt() {
        return ((Boolean) zzwe.zzpu().zzd(zzaat.zzcwd)).booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzheh);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhej);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhek);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhel);
        SafeParcelWriter.writeString(parcel, 5, this.zzhem, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhen);
        SafeParcelWriter.writeInt(parcel, 7, this.zzhep);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzdnd(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) int i6) {
        zzdng[] values = zzdng.values();
        this.zzhee = values;
        int[] zzatv = zzdnf.zzatv();
        this.zzhef = zzatv;
        int[] zzatw = zzdnf.zzatw();
        this.zzheg = zzatw;
        this.zzvr = null;
        this.zzheh = i;
        this.zzhei = values[i];
        this.zzhej = i2;
        this.zzhek = i3;
        this.zzhel = i4;
        this.zzhem = str;
        this.zzhen = i5;
        this.zzheo = zzatv[i5];
        this.zzhep = i6;
        this.zzheq = zzatw[i6];
    }
}
