package com.avito.android.serp.ad;

import com.avito.android.analytics.event.DfpPassbackEvent;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class DfpBannerLoaderImpl$loadBanner$1<T> implements ObservableOnSubscribe<DfpBanner> {
    public final /* synthetic */ DfpBannerLoaderImpl a;
    public final /* synthetic */ DfpBannerItem b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ AdEventListenerHolder d;
    public final /* synthetic */ boolean e;

    public static final class a implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        public final /* synthetic */ DfpBannerLoaderImpl$loadBanner$1 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(DfpBannerLoaderImpl$loadBanner$1 dfpBannerLoaderImpl$loadBanner$1, ObservableEmitter observableEmitter) {
            this.a = dfpBannerLoaderImpl$loadBanner$1;
            this.b = observableEmitter;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            ObservableEmitter observableEmitter = this.b;
            Intrinsics.checkNotNullExpressionValue(unifiedNativeAd, "it");
            observableEmitter.onNext(new DfpBanner.DfpUnifiedBanner(unifiedNativeAd, this.a.d));
            observableEmitter.onComplete();
        }
    }

    public static final class b implements NativeAppInstallAd.OnAppInstallAdLoadedListener {
        public final /* synthetic */ DfpBannerLoaderImpl$loadBanner$1 a;
        public final /* synthetic */ ObservableEmitter b;

        public b(DfpBannerLoaderImpl$loadBanner$1 dfpBannerLoaderImpl$loadBanner$1, ObservableEmitter observableEmitter) {
            this.a = dfpBannerLoaderImpl$loadBanner$1;
            this.b = observableEmitter;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            ObservableEmitter observableEmitter = this.b;
            Intrinsics.checkNotNullExpressionValue(nativeAppInstallAd, "it");
            observableEmitter.onNext(new DfpBanner.DfpAppInstallBanner(nativeAppInstallAd, this.a.d));
            observableEmitter.onComplete();
        }
    }

    public static final class c implements NativeContentAd.OnContentAdLoadedListener {
        public final /* synthetic */ DfpBannerLoaderImpl$loadBanner$1 a;
        public final /* synthetic */ ObservableEmitter b;

        public c(DfpBannerLoaderImpl$loadBanner$1 dfpBannerLoaderImpl$loadBanner$1, ObservableEmitter observableEmitter) {
            this.a = dfpBannerLoaderImpl$loadBanner$1;
            this.b = observableEmitter;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            ObservableEmitter observableEmitter = this.b;
            Intrinsics.checkNotNullExpressionValue(nativeContentAd, "it");
            observableEmitter.onNext(new DfpBanner.DfpContentBanner(nativeContentAd, this.a.d));
            observableEmitter.onComplete();
        }
    }

    public DfpBannerLoaderImpl$loadBanner$1(DfpBannerLoaderImpl dfpBannerLoaderImpl, DfpBannerItem dfpBannerItem, boolean z, AdEventListenerHolder adEventListenerHolder, boolean z2) {
        this.a = dfpBannerLoaderImpl;
        this.b = dfpBannerItem;
        this.c = z;
        this.d = adEventListenerHolder;
        this.e = z2;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(@NotNull final ObservableEmitter<DfpBanner> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        AdLoader.Builder withNativeAdOptions = new AdLoader.Builder(this.a.a, this.b.getId()).withNativeAdOptions(DfpBannerLoaderImpl.access$createNativeAdOptions(this.a));
        if (this.c) {
            withNativeAdOptions.forUnifiedNativeAd(new a(this, observableEmitter));
        } else {
            withNativeAdOptions.forAppInstallAd(new b(this, observableEmitter)).forContentAd(new c(this, observableEmitter));
        }
        withNativeAdOptions.withAdListener(new AdListener(this) { // from class: com.avito.android.serp.ad.DfpBannerLoaderImpl$loadBanner$1.2
            public final /* synthetic */ DfpBannerLoaderImpl$loadBanner$1 a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                this.a.a.b.track(new DfpPassbackEvent(this.a.b.getId(), this.a.e));
                observableEmitter.tryOnError(new DfpBannerLoader.DfpBannerLoadingException(i));
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLeftApplication() {
                AdEventListener adEventListener = this.a.d.getAdEventListener();
                if (adEventListener != null) {
                    adEventListener.onAdClick();
                }
            }
        }).build().loadAd(DfpBannerLoaderImpl.access$toAdRequest(this.a, this.b));
    }
}
