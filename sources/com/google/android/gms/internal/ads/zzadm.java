package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzadm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzadm> CREATOR = new zzadl();
    @SafeParcelable.Field(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(id = 3)
    public final int zzbnj;
    @SafeParcelable.Field(id = 8)
    public final int zzbnk;
    @SafeParcelable.Field(id = 4)
    public final boolean zzbnl;
    @SafeParcelable.Field(id = 5)
    public final int zzbnm;
    @SafeParcelable.Field(id = 7)
    public final boolean zzbno;
    @SafeParcelable.Field(id = 2)
    public final boolean zzdcs;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final zzaac zzdct;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzadm(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaac(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjr(), nativeAdOptions.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdcs);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnj);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbnl);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbnm);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdct, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbno);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbnk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzadm(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) zzaac zzaac, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) int i4) {
        this.versionCode = i;
        this.zzdcs = z;
        this.zzbnj = i2;
        this.zzbnl = z2;
        this.zzbnm = i3;
        this.zzdct = zzaac;
        this.zzbno = z3;
        this.zzbnk = i4;
    }
}
