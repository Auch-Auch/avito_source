package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;
public final class zzapq implements MediationInterstitialAdapter {
    private Uri uri;
    private Activity zzdly;
    private MediationInterstitialListener zzdlz;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbbd.zzef("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbbd.zzef("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbbd.zzef("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdlz = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzbbd.zzfe("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbbd.zzfe("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdlz.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabu.zzk(context))) {
                zzbbd.zzfe("Default browser does not support custom tabs. Bailing out.");
                this.zzdlz.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbbd.zzfe("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdlz.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzdly = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdlz.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzayh.zzeaj.post(new zzaps(this, new AdOverlayInfoParcel(new zzd(build.intent), null, new zzapp(this), null, new zzbbg(0, 0, false))));
        zzp.zzkt().zzwf();
    }
}
