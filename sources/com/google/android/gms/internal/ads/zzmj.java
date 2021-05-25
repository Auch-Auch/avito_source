package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmc;
public abstract class zzmj implements zzmc.zza {
    public final String zzagt;

    public zzmj(String str) {
        this.zzagt = (String) zzoz.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
