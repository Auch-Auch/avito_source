package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "ExceptionParcelCreator")
public final class zzazl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazl> CREATOR = new zzazn();
    @SafeParcelable.Field(id = 2)
    public final int errorCode;
    @SafeParcelable.Field(id = 1)
    public final String zzacm;

    @SafeParcelable.Constructor
    public zzazl(@Nullable @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i) {
        this.zzacm = str == null ? "" : str;
        this.errorCode = i;
    }

    @Nullable
    public static zzazl zzc(Throwable th) {
        String str;
        zzuw zze = zzcmt.zze(th);
        if (zzdsw.zzas(th.getMessage())) {
            str = zze.zzcgr;
        } else {
            str = th.getMessage();
        }
        return new zzazl(str, zze.errorCode);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacm, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
