package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
public final class zzzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzw> CREATOR = new zzzv();
    @SafeParcelable.Field(id = 1)
    private final int zzadj;
    @SafeParcelable.Field(id = 2)
    private final int zzadk;

    @SafeParcelable.Constructor
    public zzzw(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzadj = i;
        this.zzadk = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzadj);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzzw(RequestConfiguration requestConfiguration) {
        this.zzadj = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadk = requestConfiguration.getTagForUnderAgeOfConsent();
    }
}
