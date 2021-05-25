package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "AdDataParcelCreator")
public final class zzuu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuu> CREATOR = new zzux();
    @SafeParcelable.Field(id = 1)
    public final String zzcgo;
    @SafeParcelable.Field(id = 2)
    public final String zzcgp;

    @SafeParcelable.Constructor
    public zzuu(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzcgo = str;
        this.zzcgp = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcgo, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
