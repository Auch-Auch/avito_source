package com.avito.android.serp.ad;

import android.content.Context;
import android.provider.Settings;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.DfpRequestEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.util.BuildInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/serp/ad/DfpBannerLoaderImpl;", "Lcom/avito/android/serp/ad/DfpBannerLoader;", "Lcom/avito/android/remote/model/DfpBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/DfpBanner;", "loadBanner", "(Lcom/avito/android/remote/model/DfpBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpBannerLoaderImpl implements DfpBannerLoader {
    public final Context a;
    public final Analytics b;
    public final BuildInfo c;
    public final Features d;

    @Inject
    public DfpBannerLoaderImpl(@NotNull Context context, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = analytics;
        this.c = buildInfo;
        this.d = features;
        this.a = context.getApplicationContext();
    }

    public static final NativeAdOptions access$createNativeAdOptions(DfpBannerLoaderImpl dfpBannerLoaderImpl) {
        Objects.requireNonNull(dfpBannerLoaderImpl);
        return new NativeAdOptions.Builder().setRequestMultipleImages(false).setReturnUrlsForImageAssets(true).build();
    }

    public static final PublisherAdRequest access$toAdRequest(DfpBannerLoaderImpl dfpBannerLoaderImpl, DfpBannerItem dfpBannerItem) {
        Objects.requireNonNull(dfpBannerLoaderImpl);
        PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        if (dfpBannerLoaderImpl.c.isDebug()) {
            builder.addTestDevice("B3EEABB8EE11C2BE770B684D95219ECB");
            Context context = dfpBannerLoaderImpl.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            builder.addTestDevice(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        }
        Map<String, Object> networkExtras = dfpBannerItem.getNetworkExtras();
        if (networkExtras != null) {
            for (Map.Entry<String, Object> entry : networkExtras.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof List) {
                    builder.addCustomTargeting(entry.getKey(), DfpBannerLoaderKt.access$toStringList((List) value));
                } else {
                    builder.addCustomTargeting(entry.getKey(), value.toString());
                }
            }
        }
        return builder.build();
    }

    @Override // com.avito.android.serp.ad.DfpBannerLoader
    @NotNull
    public Observable<DfpBanner> loadBanner(@NotNull DfpBannerItem dfpBannerItem, boolean z) {
        Intrinsics.checkNotNullParameter(dfpBannerItem, "banner");
        this.b.track(new DfpRequestEvent(dfpBannerItem.getId(), dfpBannerItem.getNetworkExtras(), z));
        Observable<DfpBanner> create = Observable.create(new DfpBannerLoaderImpl$loadBanner$1(this, dfpBannerItem, this.d.getDfpMediaView().invoke().booleanValue(), new AdEventListenerHolder(), z));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit….toAdRequest())\n        }");
        return create;
    }
}
