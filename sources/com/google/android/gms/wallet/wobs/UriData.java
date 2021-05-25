package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "UriDataCreator")
@SafeParcelable.Reserved({1})
public final class UriData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzl();
    @SafeParcelable.Field(id = 3)
    private String description;
    @SafeParcelable.Field(id = 2)
    private String zzfk;

    @SafeParcelable.Constructor
    public UriData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zzfk = str;
        this.description = str2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getUri() {
        return this.zzfk;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzfk, false);
        SafeParcelWriter.writeString(parcel, 3, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public UriData() {
    }
}
