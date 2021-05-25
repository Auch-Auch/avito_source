package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzyf;
public final class ResponseInfo {
    private final zzyf zzadq;

    private ResponseInfo(zzyf zzyf) {
        this.zzadq = zzyf;
    }

    @Nullable
    public static ResponseInfo zza(@Nullable zzyf zzyf) {
        if (zzyf != null) {
            return new ResponseInfo(zzyf);
        }
        return null;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        try {
            return this.zzadq.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    @Nullable
    public final String getResponseId() {
        try {
            return this.zzadq.getResponseId();
        } catch (RemoteException e) {
            zzbbd.zzc("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }
}
