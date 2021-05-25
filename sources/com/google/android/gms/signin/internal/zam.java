package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zas;
@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zal();
    @SafeParcelable.VersionField(id = 1)
    private final int zaa;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zab;
    @Nullable
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    private final zas zac;

    @SafeParcelable.Constructor
    public zam(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @Nullable @SafeParcelable.Param(id = 3) zas zas) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zas;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    @Nullable
    public final zas zab() {
        return this.zac;
    }

    public zam(int i) {
        this(new ConnectionResult(8, null), null);
    }

    private zam(ConnectionResult connectionResult, @Nullable zas zas) {
        this(1, connectionResult, null);
    }
}
