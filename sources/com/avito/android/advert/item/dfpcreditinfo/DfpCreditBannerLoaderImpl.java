package com.avito.android.advert.item.dfpcreditinfo;

import a2.g.r.g;
import android.content.Context;
import android.provider.Settings;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\nJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoaderImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "loadBanner", "(Lcom/avito/android/remote/model/AdvertDetails;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/DfpBannerItem;", "banner", "(Lcom/avito/android/remote/model/DfpBannerItem;Lcom/avito/android/remote/model/AdvertDetails;)Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "d", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/TinkoffCreditCalculatorTestGroup;", "h", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "tinkoffCreditCalculatorTestGroup", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "c", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/util/BuildInfo;", g.a, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "f", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "creditBrokerSessionProvider", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "e", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DfpCreditBannerLoaderImpl implements DfpCreditBannerLoader {
    public final Context a;
    public final SchedulersFactory3 b;
    public final AdvertDetailsApi c;
    public final AdvertDetailsAnalyticsInteractor d;
    public final CreditInfoResourcesProvider e;
    public final CreditBrokerSessionProvider f;
    public final BuildInfo g;
    public final SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DfpCreditInfo.Type.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[1] = 3;
            iArr[4] = 4;
            iArr[3] = 5;
        }
    }

    public static final class a<T, R> implements Function<TypedResult<DfpBannerItem>, ObservableSource<? extends DfpCreditInfo>> {
        public final /* synthetic */ DfpCreditBannerLoaderImpl a;
        public final /* synthetic */ AdvertDetails b;

        public a(DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl, AdvertDetails advertDetails) {
            this.a = dfpCreditBannerLoaderImpl;
            this.b = advertDetails;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends DfpCreditInfo> apply(TypedResult<DfpBannerItem> typedResult) {
            TypedResult<DfpBannerItem> typedResult2 = typedResult;
            if (!(typedResult2 instanceof TypedResult.OfResult)) {
                return Observable.just(new DfpCreditInfo.Empty());
            }
            return this.a.a((DfpBannerItem) ((TypedResult.OfResult) typedResult2).getResult(), this.b);
        }
    }

    @Inject
    public DfpCreditBannerLoaderImpl(@NotNull Context context, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdvertDetailsApi advertDetailsApi, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider, @NotNull CreditBrokerSessionProvider creditBrokerSessionProvider, @NotNull BuildInfo buildInfo, @NotNull SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> singleManuallyExposedAbTestGroup, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(creditBrokerSessionProvider, "creditBrokerSessionProvider");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "tinkoffCreditCalculatorTestGroup");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = schedulersFactory3;
        this.c = advertDetailsApi;
        this.d = advertDetailsAnalyticsInteractor;
        this.e = creditInfoResourcesProvider;
        this.f = creditBrokerSessionProvider;
        this.g = buildInfo;
        this.h = singleManuallyExposedAbTestGroup;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    public static final NativeAdOptions access$createNativeAdOptions(DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl) {
        Objects.requireNonNull(dfpCreditBannerLoaderImpl);
        return new NativeAdOptions.Builder().setRequestMultipleImages(false).setReturnUrlsForImageAssets(true).build();
    }

    public static final PublisherAdRequest access$toAdRequest(DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl, DfpBannerItem dfpBannerItem) {
        Objects.requireNonNull(dfpCreditBannerLoaderImpl);
        PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        if (dfpCreditBannerLoaderImpl.g.isDebug()) {
            builder.addTestDevice("B3EEABB8EE11C2BE770B684D95219ECB");
            builder.addTestDevice(Settings.Secure.getString(dfpCreditBannerLoaderImpl.a.getContentResolver(), "android_id"));
        }
        Map<String, Object> networkExtras = dfpBannerItem.getNetworkExtras();
        if (networkExtras != null) {
            for (Map.Entry<String, Object> entry : networkExtras.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof List) {
                    builder.addCustomTargeting(entry.getKey(), DfpCreditBannerLoaderKt.access$toStringList((List) value));
                } else {
                    builder.addCustomTargeting(entry.getKey(), value.toString());
                }
            }
        }
        return builder.build();
    }

    public static final void access$tryCreateCreditInfoAdvert(DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl, ObservableEmitter observableEmitter, NativeCustomTemplateAd nativeCustomTemplateAd, AdvertDetails advertDetails, BannerInfo bannerInfo) {
        DfpCreditInfo dfpCreditInfo;
        Objects.requireNonNull(dfpCreditBannerLoaderImpl);
        try {
            DfpCreditInfo.Type parseType = DfpCreditInfo.Companion.parseType(nativeCustomTemplateAd);
            DfpCreditConverter dfpCreditConverter = new DfpCreditConverter(null, 1, null);
            AdvertPrice price = advertDetails.getPrice();
            Double convertToNumber = dfpCreditConverter.convertToNumber(price != null ? price.getValue() : null);
            Intrinsics.checkNotNull(convertToNumber);
            int roundToInt = c.roundToInt(convertToNumber.doubleValue());
            NumberFormat instance = NumberFormat.getInstance(new Locale("ru", "RU"));
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            decimalFormatSymbols.setDecimalSeparator(',');
            DecimalFormat decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);
            decimalFormat.setGroupingUsed(false);
            int ordinal = parseType.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            dfpCreditBannerLoaderImpl.h.exposeIfNeeded();
                            Intrinsics.checkNotNullExpressionValue(instance, "priceFormatter");
                            dfpCreditInfo = new DfpCreditInfo.CreditCalculator.Tinkoff(nativeCustomTemplateAd, roundToInt, instance, decimalFormat, dfpCreditBannerLoaderImpl.e, dfpCreditBannerLoaderImpl.f);
                            dfpCreditBannerLoaderImpl.d.sendCreditBannerLoaded(bannerInfo, advertDetails);
                            observableEmitter.onNext(dfpCreditInfo == 1 ? 1 : 0);
                            observableEmitter.onComplete();
                        } else if (ordinal != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                Intrinsics.checkNotNullExpressionValue(instance, "priceFormatter");
                dfpCreditInfo = new DfpCreditInfo.CreditCalculator.Sravni(nativeCustomTemplateAd, roundToInt, instance, decimalFormat);
                dfpCreditBannerLoaderImpl.d.sendCreditBannerLoaded(bannerInfo, advertDetails);
                observableEmitter.onNext(dfpCreditInfo == 1 ? 1 : 0);
                observableEmitter.onComplete();
            }
            Intrinsics.checkNotNullExpressionValue(instance, "priceFormatter");
            DfpCreditInfo.Web web = new DfpCreditInfo.Web(nativeCustomTemplateAd, bannerInfo, roundToInt, instance);
            boolean isTinkoffTest = web.isTinkoffTest();
            dfpCreditInfo = web;
            if (isTinkoffTest) {
                dfpCreditBannerLoaderImpl.h.exposeIfNeeded();
                dfpCreditInfo = web;
            }
            dfpCreditBannerLoaderImpl.d.sendCreditBannerLoaded(bannerInfo, advertDetails);
            observableEmitter.onNext(dfpCreditInfo == 1 ? 1 : 0);
            observableEmitter.onComplete();
        } catch (Throwable unused) {
            dfpCreditBannerLoaderImpl.d.sendCreditBannerLoadingFailed(bannerInfo, advertDetails, null);
            observableEmitter.tryOnError(new DfpCreditBannerLoader.DfpCreditConvertException());
        }
    }

    public final Observable<DfpCreditInfo> a(DfpBannerItem dfpBannerItem, AdvertDetails advertDetails) {
        Observable<DfpCreditInfo> create = Observable.create(new DfpCreditBannerLoaderImpl$innerLoadBanner$1(this, dfpBannerItem, advertDetails, BannerInfo.Companion.from$default(BannerInfo.Companion, dfpBannerItem, null, 2, null)));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit….toAdRequest())\n        }");
        return create;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader
    @NotNull
    public Observable<DfpCreditInfo> loadBanner(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        return a2.b.a.a.a.a2(this.b, this.c.getCreditInfo(advertDetails.getId()).flatMap(new a(this, advertDetails)), "api.getCreditInfo(advert…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader
    @NotNull
    public Observable<DfpCreditInfo> loadBanner(@NotNull DfpBannerItem dfpBannerItem, @NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(dfpBannerItem, "banner");
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Observable<DfpCreditInfo> timeout = a(dfpBannerItem, advertDetails).timeout(2, TimeUnit.SECONDS, this.b.computation(), Observable.just(new DfpCreditInfo.Empty()));
        Intrinsics.checkNotNullExpressionValue(timeout, "innerLoadBanner(banner, …itInfo.Empty())\n        )");
        return timeout;
    }
}
