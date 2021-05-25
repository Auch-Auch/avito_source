package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzvj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvj> CREATOR = new zzvi();
    @SafeParcelable.Field(id = 3)
    public final int height;
    @SafeParcelable.Field(id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(id = 6)
    public final int width;
    @SafeParcelable.Field(id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(id = 2)
    public final String zzacx;
    @SafeParcelable.Field(id = 9)
    public final boolean zzbrc;
    @SafeParcelable.Field(id = 5)
    public final boolean zzchn;
    @SafeParcelable.Field(id = 8)
    public final zzvj[] zzcho;
    @SafeParcelable.Field(id = 10)
    public final boolean zzchp;
    @SafeParcelable.Field(id = 11)
    public boolean zzchq;
    @SafeParcelable.Field(id = 12)
    public boolean zzchr;
    @SafeParcelable.Field(id = 13)
    private boolean zzchs;
    @SafeParcelable.Field(id = 14)
    public boolean zzcht;
    @SafeParcelable.Field(id = 15)
    public boolean zzchu;

    public zzvj() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvj zzpi() {
        return new zzvj("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false);
    }

    public static zzvj zzpj() {
        return new zzvj("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzvj zzpk() {
        return new zzvj("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false);
    }

    public static zzvj zzpl() {
        return new zzvj("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzacx, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzchn);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzcho, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrc);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchp);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchq);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzchr);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzchs);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzcht);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzchu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdSize zzpm() {
        return zzb.zza(this.width, this.height, this.zzacx);
    }

    public zzvj(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzvj(android.content.Context r14, com.google.android.gms.ads.AdSize[] r15) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    public zzvj(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzvj[] zzvjArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4, @SafeParcelable.Param(id = 12) boolean z5, @SafeParcelable.Param(id = 13) boolean z7, @SafeParcelable.Param(id = 14) boolean z8, @SafeParcelable.Param(id = 15) boolean z9) {
        this.zzacx = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzchn = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzcho = zzvjArr;
        this.zzbrc = z2;
        this.zzchp = z3;
        this.zzchq = z4;
        this.zzchr = z5;
        this.zzchs = z7;
        this.zzcht = z8;
        this.zzchu = z9;
    }
}
