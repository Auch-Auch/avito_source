package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public final class zzczn implements zzdek<Bundle> {
    private final zzdln zzfqn;

    public zzczn(zzdln zzdln) {
        Preconditions.checkNotNull(zzdln, "the targeting must not be null");
        this.zzfqn = zzdln;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdln zzdln = this.zzfqn;
        zzvc zzvc = zzdln.zzhbu;
        bundle2.putString("slotname", zzdln.zzhbv);
        boolean z = true;
        int i = zzczm.zzgdc[this.zzfqn.zzhcb.zzhbf - 1];
        if (i == 1) {
            bundle2.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle2.putBoolean("is_rewarded_interstitial", true);
        }
        zzdlu.zza(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzvc.zzcgv)), zzvc.zzcgv != -1);
        zzdlu.zza(bundle2, AppLinkData.ARGUMENTS_EXTRAS_KEY, zzvc.extras);
        zzdlu.zza(bundle2, "cust_gender", Integer.valueOf(zzvc.zzcgw), zzvc.zzcgw != -1);
        zzdlu.zza(bundle2, "kw", zzvc.zzcgx);
        zzdlu.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzvc.zzadj), zzvc.zzadj != -1);
        boolean z2 = zzvc.zzcgy;
        if (z2) {
            bundle2.putBoolean("test_request", z2);
        }
        zzdlu.zza(bundle2, "d_imp_hdr", (Integer) 1, zzvc.versionCode >= 2 && zzvc.zzbnu);
        String str = zzvc.zzcgz;
        zzdlu.zza(bundle2, "ppid", str, zzvc.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzvc.zznb;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong("long", valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdlu.zza(bundle2, "url", zzvc.zzchb);
        zzdlu.zza(bundle2, "neighboring_content_urls", zzvc.zzchj);
        zzdlu.zza(bundle2, "custom_targeting", zzvc.zzchd);
        zzdlu.zza(bundle2, "category_exclusions", zzvc.zzche);
        zzdlu.zza(bundle2, "request_agent", zzvc.zzchf);
        zzdlu.zza(bundle2, "request_pkg", zzvc.zzchg);
        zzdlu.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzvc.zzchh), zzvc.versionCode >= 7);
        if (zzvc.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzvc.zzadk);
            if (zzvc.zzadk == -1) {
                z = false;
            }
            zzdlu.zza(bundle2, "tag_for_under_age_of_consent", valueOf5, z);
            zzdlu.zza(bundle2, "max_ad_content_rating", zzvc.zzadl);
        }
    }
}
