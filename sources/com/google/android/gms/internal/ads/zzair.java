package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
public final class zzair extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzair> CREATOR = new zzaiu();
    @SafeParcelable.VersionField(id = 1000)
    public final int versionCode;
    @SafeParcelable.Field(id = 3)
    public final int zzbnk;
    @SafeParcelable.Field(id = 1)
    public final int zzdfk;
    @SafeParcelable.Field(id = 2)
    public final String zzdfl;

    public zzair(zzajd zzajd) {
        this(2, 1, zzajd.zzsz(), zzajd.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdfk);
        SafeParcelWriter.writeString(parcel, 2, this.zzdfl, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnk);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzair(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.versionCode = i;
        this.zzdfk = i2;
        this.zzdfl = str;
        this.zzbnk = i3;
    }
}
