package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
@VisibleForTesting
public final class zzdqr implements zzdqu {
    private static final zzcf.zza zzhjo = ((zzcf.zza) ((zzegp) zzcf.zza.zzaq().zzw(ExifInterface.LONGITUDE_EAST).zzbfx()));

    @Override // com.google.android.gms.internal.ads.zzdqu
    public final zzcf.zza zzavl() {
        return zzhjo;
    }

    @Override // com.google.android.gms.internal.ads.zzdqu
    public final zzcf.zza zzcj(Context context) throws PackageManager.NameNotFoundException {
        return zzdqi.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }
}
