package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zze();
    @SafeParcelable.Field(id = 4)
    public String zza;
    @SafeParcelable.Field(id = 5)
    public IBinder zzb;
    @SafeParcelable.Field(id = 6)
    public Scope[] zzc;
    @SafeParcelable.Field(id = 7)
    public Bundle zzd;
    @Nullable
    @SafeParcelable.Field(id = 8)
    public Account zze;
    @SafeParcelable.Field(id = 10)
    public Feature[] zzf;
    @SafeParcelable.Field(id = 11)
    public Feature[] zzg;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    public boolean zzh;
    @SafeParcelable.VersionField(id = 1)
    private final int zzi;
    @SafeParcelable.Field(id = 2)
    private final int zzj;
    @SafeParcelable.Field(id = 3)
    private int zzk;
    @SafeParcelable.Field(id = 12)
    private boolean zzl;
    @SafeParcelable.Field(defaultValue = "0", id = 13)
    private int zzm;

    public GetServiceRequest(@RecentlyNonNull int i) {
        this.zzi = 5;
        this.zzk = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzj = i;
        this.zzl = true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzj);
        SafeParcelWriter.writeInt(parcel, 3, this.zzk);
        SafeParcelWriter.writeString(parcel, 4, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzc, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zze, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzf, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z, @SafeParcelable.Param(id = 13) int i4, @SafeParcelable.Param(id = 14) boolean z2) {
        this.zzi = i;
        this.zzj = i2;
        this.zzk = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zza = "com.google.android.gms";
        } else {
            this.zza = str;
        }
        if (i < 2) {
            this.zze = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzb = iBinder;
            this.zze = account;
        }
        this.zzc = scopeArr;
        this.zzd = bundle;
        this.zzf = featureArr;
        this.zzg = featureArr2;
        this.zzl = z;
        this.zzm = i4;
        this.zzh = z2;
    }
}
