package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzsj;
import com.google.android.gms.internal.ads.zzsn;
import com.google.android.gms.internal.ads.zzwu;
public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    public static abstract class AppOpenAdLoadCallback {
        @Deprecated
        public void onAppOpenAdFailedToLoad(int i) {
        }

        public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
        }

        public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
        }
    }

    public @interface AppOpenAdOrientation {
    }

    public static void load(Context context, String str, AdRequest adRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        new zzsn(context, str, adRequest.zzdp(), i, appOpenAdLoadCallback).zzms();
    }

    public abstract void zza(zzsj zzsj);

    public abstract zzwu zzdu();

    public static void load(Context context, String str, PublisherAdRequest publisherAdRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(publisherAdRequest, "PublisherAdRequest cannot be null.");
        new zzsn(context, str, publisherAdRequest.zzdp(), i, appOpenAdLoadCallback).zzms();
    }
}
