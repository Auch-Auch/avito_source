package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.serp.ad.BannerInfo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class DfpCreditBannerLoaderImpl$innerLoadBanner$1<T> implements ObservableOnSubscribe<DfpCreditInfo> {
    public final /* synthetic */ DfpCreditBannerLoaderImpl a;
    public final /* synthetic */ DfpBannerItem b;
    public final /* synthetic */ AdvertDetails c;
    public final /* synthetic */ BannerInfo d;

    public static final class a implements NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {
        public final /* synthetic */ DfpCreditBannerLoaderImpl$innerLoadBanner$1 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(DfpCreditBannerLoaderImpl$innerLoadBanner$1 dfpCreditBannerLoaderImpl$innerLoadBanner$1, ObservableEmitter observableEmitter) {
            this.a = dfpCreditBannerLoaderImpl$innerLoadBanner$1;
            this.b = observableEmitter;
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl = this.a.a;
            ObservableEmitter observableEmitter = this.b;
            Intrinsics.checkNotNullExpressionValue(nativeCustomTemplateAd, "it");
            DfpCreditBannerLoaderImpl$innerLoadBanner$1 dfpCreditBannerLoaderImpl$innerLoadBanner$1 = this.a;
            DfpCreditBannerLoaderImpl.access$tryCreateCreditInfoAdvert(dfpCreditBannerLoaderImpl, observableEmitter, nativeCustomTemplateAd, dfpCreditBannerLoaderImpl$innerLoadBanner$1.c, dfpCreditBannerLoaderImpl$innerLoadBanner$1.d);
        }
    }

    public DfpCreditBannerLoaderImpl$innerLoadBanner$1(DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl, DfpBannerItem dfpBannerItem, AdvertDetails advertDetails, BannerInfo bannerInfo) {
        this.a = dfpCreditBannerLoaderImpl;
        this.b = dfpBannerItem;
        this.c = advertDetails;
        this.d = bannerInfo;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(@NotNull final ObservableEmitter<DfpCreditInfo> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        new AdLoader.Builder(this.a.a, this.b.getId()).forCustomTemplateAd("11766987", new a(this, observableEmitter), null).withAdListener(new AdListener(this) { // from class: com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoaderImpl$innerLoadBanner$1.2
            public final /* synthetic */ DfpCreditBannerLoaderImpl$innerLoadBanner$1 a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.a.a.d;
                DfpCreditBannerLoaderImpl$innerLoadBanner$1 dfpCreditBannerLoaderImpl$innerLoadBanner$1 = this.a;
                advertDetailsAnalyticsInteractor.sendCreditBannerLoadingFailed(dfpCreditBannerLoaderImpl$innerLoadBanner$1.d, dfpCreditBannerLoaderImpl$innerLoadBanner$1.c, Integer.valueOf(i));
                observableEmitter.tryOnError(new DfpCreditBannerLoader.DfpCreditLoadingException(i));
            }
        }).withNativeAdOptions(DfpCreditBannerLoaderImpl.access$createNativeAdOptions(this.a)).build().loadAd(DfpCreditBannerLoaderImpl.access$toAdRequest(this.a, this.b));
    }
}
