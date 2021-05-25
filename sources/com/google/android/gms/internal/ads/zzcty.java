package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
public abstract class zzcty<AdT> implements zzcre<AdT> {
    private static Bundle zzn(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public abstract zzdvt<AdT> zza(zzdln zzdln, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        return !TextUtils.isEmpty(zzdkx.zzhar.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<AdT> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        String optString = zzdkx.zzhar.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdln zzdln = zzdlj.zzhbp.zzfqn;
        zzdlp zzgt = new zzdlp().zzc(zzdln).zzgt(optString);
        Bundle zzn = zzn(zzdln.zzhbu.zzchc);
        Bundle zzn2 = zzn(zzn.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzn2.putInt("gw", 1);
        String optString2 = zzdkx.zzhar.optString("mad_hac", null);
        if (optString2 != null) {
            zzn2.putString("mad_hac", optString2);
        }
        String optString3 = zzdkx.zzhar.optString("adJson", null);
        if (optString3 != null) {
            zzn2.putString("_ad", optString3);
        }
        zzn2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdkx.zzhau.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdkx.zzhau.optString(next, null);
            if (next != null) {
                zzn2.putString(next, optString4);
            }
        }
        zzn.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzn2);
        zzvc zzvc = zzdln.zzhbu;
        zzdln zzasu = zzgt.zzh(new zzvc(zzvc.versionCode, zzvc.zzcgv, zzn2, zzvc.zzcgw, zzvc.zzcgx, zzvc.zzcgy, zzvc.zzadj, zzvc.zzbnu, zzvc.zzcgz, zzvc.zzcha, zzvc.zznb, zzvc.zzchb, zzn, zzvc.zzchd, zzvc.zzche, zzvc.zzchf, zzvc.zzchg, zzvc.zzchh, zzvc.zzchi, zzvc.zzadk, zzvc.zzadl, zzvc.zzchj)).zzasu();
        Bundle bundle = new Bundle();
        zzdkz zzdkz = zzdlj.zzhbq.zzhbn;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzdkz.zzdiv));
        bundle2.putInt("refresh_interval", zzdkz.zzhbe);
        bundle2.putString("gws_query_id", zzdkz.zzdsg);
        bundle.putBundle("parent_common_config", bundle2);
        Bundle y1 = a.y1("initial_ad_unit_id", zzdlj.zzhbp.zzfqn.zzhbv);
        y1.putString("allocation_id", zzdkx.zzdjo);
        y1.putStringArrayList("click_urls", new ArrayList<>(zzdkx.zzdis));
        y1.putStringArrayList("imp_urls", new ArrayList<>(zzdkx.zzdit));
        y1.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzdkx.zzdru));
        y1.putStringArrayList("fill_urls", new ArrayList<>(zzdkx.zzhak));
        y1.putStringArrayList("video_start_urls", new ArrayList<>(zzdkx.zzdsi));
        y1.putStringArrayList("video_reward_urls", new ArrayList<>(zzdkx.zzdsj));
        y1.putStringArrayList("video_complete_urls", new ArrayList<>(zzdkx.zzhaj));
        y1.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdkx.zzdjz);
        y1.putString("valid_from_timestamp", zzdkx.zzdka);
        y1.putBoolean("is_closable_area_disabled", zzdkx.zzboz);
        if (zzdkx.zzdsh != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("rb_amount", zzdkx.zzdsh.zzdva);
            bundle3.putString("rb_type", zzdkx.zzdsh.type);
            y1.putParcelableArray("rewards", new Bundle[]{bundle3});
        }
        bundle.putBundle("parent_ad_config", y1);
        return zza(zzasu, bundle);
    }
}
