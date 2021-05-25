package com.avito.android.serp.ad;

import android.content.Context;
import android.location.Location;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.YandexPassbackEvent;
import com.avito.android.analytics.event.YandexRequestEvent;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageBannerImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.YandexBannerItem;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.util.SchedulersFactory3;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.nativeads.NativeAdLoader;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.NativeImageAd;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/ad/YandexBannerLoaderImpl;", "Lcom/avito/android/serp/ad/YandexBannerLoader;", "Lcom/avito/android/remote/model/YandexBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/YandexBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeGenericAd;", "loadBanner", "(Lcom/avito/android/remote/model/YandexBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexBannerLoaderImpl implements YandexBannerLoader {
    public final Context a;
    public final SchedulersFactory3 b;
    public final Analytics c;

    public static final class a implements NativeAdLoader.OnImageAdLoadListener {
        public final ObservableEmitter<? super YandexBanner<? extends NativeGenericAd>> a;

        public a(@NotNull ObservableEmitter<? super YandexBanner<? extends NativeGenericAd>> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a = observableEmitter;
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdLoader.OnLoadListener
        public void onAdFailedToLoad(@NotNull AdRequestError adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "error");
            this.a.tryOnError(new YandexBannerLoader.YandexBannerLoadingException(adRequestError.getCode(), adRequestError.getDescription()));
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdLoader.OnLoadListener
        public void onAppInstallAdLoaded(@NotNull NativeAppInstallAd nativeAppInstallAd) {
            Intrinsics.checkNotNullParameter(nativeAppInstallAd, "appInstallAd");
            ObservableEmitter<? super YandexBanner<? extends NativeGenericAd>> observableEmitter = this.a;
            observableEmitter.onNext(new YandexAppInstallBannerImpl(nativeAppInstallAd));
            observableEmitter.onComplete();
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdLoader.OnLoadListener
        public void onContentAdLoaded(@NotNull NativeContentAd nativeContentAd) {
            Intrinsics.checkNotNullParameter(nativeContentAd, "contentAd");
            ObservableEmitter<? super YandexBanner<? extends NativeGenericAd>> observableEmitter = this.a;
            observableEmitter.onNext(new YandexContentBannerImpl(nativeContentAd));
            observableEmitter.onComplete();
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdLoader.OnImageAdLoadListener
        public void onImageAdLoaded(@NotNull NativeImageAd nativeImageAd) {
            Intrinsics.checkNotNullParameter(nativeImageAd, "imageAd");
            ObservableEmitter<? super YandexBanner<? extends NativeGenericAd>> observableEmitter = this.a;
            observableEmitter.onNext(new AdfoxImageBannerImpl(nativeImageAd));
            observableEmitter.onComplete();
        }
    }

    public static final class b<T> implements ObservableOnSubscribe<YandexBanner<? extends NativeGenericAd>> {
        public final /* synthetic */ YandexBannerLoaderImpl a;
        public final /* synthetic */ YandexBannerItem b;

        public static final class a implements Cancellable {
            public final /* synthetic */ NativeAdLoader a;

            public a(NativeAdLoader nativeAdLoader) {
                this.a = nativeAdLoader;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.setNativeAdLoadListener(null);
                this.a.cancelLoading();
            }
        }

        public b(YandexBannerLoaderImpl yandexBannerLoaderImpl, YandexBannerItem yandexBannerItem) {
            this.a = yandexBannerLoaderImpl;
            this.b = yandexBannerItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<com.avito.android.serp.ad.YandexBanner<com.yandex.mobile.ads.nativeads.NativeGenericAd>>] */
        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<YandexBanner<? extends NativeGenericAd>> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            NativeAdLoader nativeAdLoader = new NativeAdLoader(this.a.a, YandexBannerLoaderImpl.access$createConfiguration(this.a, this.b));
            nativeAdLoader.setNativeAdLoadListener(new a(observableEmitter));
            nativeAdLoader.loadAd(YandexBannerLoaderImpl.access$toAdRequest(this.a, this.b));
            observableEmitter.setCancellable(new a(nativeAdLoader));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ YandexBannerLoaderImpl a;
        public final /* synthetic */ YandexBannerItem b;
        public final /* synthetic */ boolean c;

        public c(YandexBannerLoaderImpl yandexBannerLoaderImpl, YandexBannerItem yandexBannerItem, boolean z) {
            this.a = yandexBannerLoaderImpl;
            this.b = yandexBannerItem;
            this.c = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            if (th instanceof YandexBannerLoader.YandexBannerLoadingException) {
                this.a.c.track(new YandexPassbackEvent((String) this.b.getId(), this.b.getStatId(), this.c));
            }
        }
    }

    @Inject
    public YandexBannerLoaderImpl(@NotNull Context context, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = schedulersFactory3;
        this.c = analytics;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    public static final NativeAdLoaderConfiguration access$createConfiguration(YandexBannerLoaderImpl yandexBannerLoaderImpl, YandexBannerItem yandexBannerItem) {
        Objects.requireNonNull(yandexBannerLoaderImpl);
        NativeAdLoaderConfiguration build = new NativeAdLoaderConfiguration.Builder((String) yandexBannerItem.getId(), false).setImageSizes("small", "medium").build();
        Intrinsics.checkNotNullExpressionValue(build, "NativeAdLoaderConfigurat…IUM)\n            .build()");
        return build;
    }

    public static final AdRequest access$toAdRequest(YandexBannerLoaderImpl yandexBannerLoaderImpl, YandexBannerItem yandexBannerItem) {
        Objects.requireNonNull(yandexBannerLoaderImpl);
        AdRequest.Builder withContextTags = AdRequest.builder().withContextTags(yandexBannerItem.getContextTags());
        Intrinsics.checkNotNullExpressionValue(withContextTags, "AdRequest.builder()\n    …hContextTags(contextTags)");
        Coordinates location = yandexBannerItem.getLocation();
        if (location != null) {
            Location location2 = new Location("");
            location2.setLongitude(location.getLongitude());
            location2.setLatitude(location.getLatitude());
            withContextTags.withLocation(location2);
        }
        String query = yandexBannerItem.getQuery();
        if (!(query == null || query.length() == 0)) {
            String query2 = yandexBannerItem.getQuery();
            Intrinsics.checkNotNull(query2);
            withContextTags.withContextQuery(query2);
        }
        Map<String, String> mutableMapOf = r.mutableMapOf(TuplesKt.to("stat_id", yandexBannerItem.getStatId()));
        String hash = yandexBannerItem.getHash();
        if (hash != null) {
            mutableMapOf.put("crpt", hash);
        }
        Map<String, String> params = yandexBannerItem.getParams();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                mutableMapOf.put(entry.getKey(), entry.getValue());
            }
        }
        withContextTags.withParameters(mutableMapOf);
        AdRequest build = withContextTags.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // com.avito.android.serp.ad.YandexBannerLoader
    @NotNull
    public Observable<YandexBanner<NativeGenericAd>> loadBanner(@NotNull YandexBannerItem yandexBannerItem, boolean z) {
        Intrinsics.checkNotNullParameter(yandexBannerItem, "banner");
        this.c.track(new YandexRequestEvent((String) yandexBannerItem.getId(), yandexBannerItem.getStatId(), z));
        Observable<YandexBanner<NativeGenericAd>> doOnError = Observable.create(new b(this, yandexBannerItem)).observeOn(this.b.io()).doOnError(new c(this, yandexBannerItem, z));
        Intrinsics.checkNotNullExpressionValue(doOnError, "Observable.create { emit…          }\n            }");
        return doOnError;
    }
}
