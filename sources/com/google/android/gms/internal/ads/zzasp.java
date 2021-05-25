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
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
public final class zzasp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasp> CREATOR = new zzaso();
    @SafeParcelable.Field(id = 3)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(id = 4)
    public final String packageName;
    @SafeParcelable.Field(id = 2)
    public final zzbbg zzdpq;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final PackageInfo zzdpx;
    @SafeParcelable.Field(id = 5)
    public final List<String> zzdqh;
    @SafeParcelable.Field(id = 7)
    public final String zzdqr;
    @SafeParcelable.Field(id = 1)
    public final Bundle zzdtd;
    @SafeParcelable.Field(id = 8)
    public final boolean zzdte;
    @SafeParcelable.Field(id = 9)
    public final String zzdtf;
    @Nullable
    @SafeParcelable.Field(id = 10)
    public zzdnd zzdtg;
    @Nullable
    @SafeParcelable.Field(id = 11)
    public String zzdth;

    @SafeParcelable.Constructor
    public zzasp(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbbg zzbbg, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @Nullable @SafeParcelable.Param(id = 6) PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) zzdnd zzdnd, @SafeParcelable.Param(id = 11) String str4) {
        this.zzdtd = bundle;
        this.zzdpq = zzbbg;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdqh = list;
        this.zzdpx = packageInfo;
        this.zzdqr = str2;
        this.zzdte = z;
        this.zzdtf = str3;
        this.zzdtg = zzdnd;
        this.zzdth = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdtd, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdpq, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdqh, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdpx, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdqr, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdte);
        SafeParcelWriter.writeString(parcel, 9, this.zzdtf, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdtg, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdth, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
