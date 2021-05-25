package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "TextModuleDataCreator")
@SafeParcelable.Reserved({1})
public final class TextModuleData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TextModuleData> CREATOR = new zzj();
    @SafeParcelable.Field(id = 2)
    private String zzfg;
    @SafeParcelable.Field(id = 3)
    private String zzfh;

    @SafeParcelable.Constructor
    public TextModuleData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zzfg = str;
        this.zzfh = str2;
    }

    public final String getBody() {
        return this.zzfh;
    }

    public final String getHeader() {
        return this.zzfg;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzfg, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzfh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public TextModuleData() {
    }
}
