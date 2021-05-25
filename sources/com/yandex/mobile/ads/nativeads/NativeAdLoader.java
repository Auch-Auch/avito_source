package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.af;
import com.yandex.mobile.ads.impl.ag;
import com.yandex.mobile.ads.impl.rf;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration;
public class NativeAdLoader {
    @NonNull
    public final Context a;
    @NonNull
    private final v b;

    public interface OnImageAdLoadListener extends OnLoadListener {
        void onImageAdLoaded(@NonNull NativeImageAd nativeImageAd);
    }

    public interface OnLoadListener {
        void onAdFailedToLoad(@NonNull AdRequestError adRequestError);

        void onAppInstallAdLoaded(@NonNull NativeAppInstallAd nativeAppInstallAd);

        void onContentAdLoaded(@NonNull NativeContentAd nativeContentAd);
    }

    public NativeAdLoader(Context context, String str) {
        this(context, new NativeAdLoaderConfiguration.Builder(str, true).setImageSizes("small").build());
    }

    public void cancelLoading() {
        this.b.a();
    }

    public void loadAd(AdRequest adRequest) {
        this.b.a(adRequest, new rf(this.a), af.AD, ag.AD);
    }

    public void setNativeAdLoadListener(@Nullable OnImageAdLoadListener onImageAdLoadListener) {
        this.b.a((OnLoadListener) onImageAdLoadListener);
    }

    public void setOnLoadListener(@Nullable OnLoadListener onLoadListener) {
        this.b.a(onLoadListener);
    }

    public NativeAdLoader(@NonNull Context context, @NonNull NativeAdLoaderConfiguration nativeAdLoaderConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        x xVar = new x(context);
        v vVar = new v(applicationContext, nativeAdLoaderConfiguration, xVar);
        this.b = vVar;
        xVar.a(vVar.s());
    }
}
