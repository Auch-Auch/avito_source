package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
@KeepForSdk
@KeepName
public final class BinderWrapper implements Parcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zza();
    private IBinder zza;

    @KeepForSdk
    public BinderWrapper(@RecentlyNonNull IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.Parcelable
    @RecentlyNonNull
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        parcel.writeStrongBinder(this.zza);
    }

    private BinderWrapper(Parcel parcel) {
        this.zza = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, zza zza2) {
        this(parcel);
    }
}
