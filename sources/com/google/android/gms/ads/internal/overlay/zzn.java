package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzut;
public final class zzn {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdow == 4 && adOverlayInfoParcel.zzdor == null) {
            zzut zzut = adOverlayInfoParcel.zzcgq;
            if (zzut != null) {
                zzut.onAdClicked();
            }
            zzp.zzkn();
            zzb.zza(context, adOverlayInfoParcel.zzdoq, adOverlayInfoParcel.zzdov);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbpa.zzeds);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzp.zzkp();
        zzayh.zza(context, intent);
    }
}
