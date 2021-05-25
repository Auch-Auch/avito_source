package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
public final class zzbcw extends zzbco {
    @Override // com.google.android.gms.internal.ads.zzbco
    @Nullable
    public final zzbcp zza(Context context, zzbde zzbde, int i, boolean z, zzabk zzabk, zzbdf zzbdf) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbdh zzbdh = new zzbdh(context, zzbde.zzzt(), zzbde.getRequestId(), zzabk, zzbde.zzzp());
        if (i == 2) {
            return new zzbdl(context, zzbdh, zzbde, z, zzbco.zza(zzbde), zzbdf);
        }
        return new zzbcc(context, z, zzbco.zza(zzbde), zzbdf, new zzbdh(context, zzbde.zzzt(), zzbde.getRequestId(), zzabk, zzbde.zzzp()));
    }
}
