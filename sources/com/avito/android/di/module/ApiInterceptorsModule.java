package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.remote.PaymentsPlanHeaderProvider;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.ApiAnalyticsInterceptor;
import com.avito.android.remote.interceptor.ApiAnalyticsInterceptorImpl;
import com.avito.android.remote.interceptor.AppHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DateInterceptor;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.HeadersInterceptor;
import com.avito.android.remote.interceptor.InfomodelBranchHeaderProvider;
import com.avito.android.remote.interceptor.SchemaCheckHeaderProvider;
import com.avito.android.remote.interceptor.ServerTimeInterceptor;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.RandomKeyProvider;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJW\u00103\u001a\u0002022\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/avito/android/di/module/ApiInterceptorsModule;", "", "Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "supportFeaturesHeaderProvider", "Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;", "provideSupportedFeaturesInterceptor", "(Lcom/avito/android/remote/SupportFeaturesHeaderProvider;)Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;", "Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "userAgentHeaderProvider", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "provideUserAgentInterceptor", "(Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;)Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptor;", "provideApiAnalyticsInterceptor", "(Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptor;", "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "dateHeaderProvider", "Lcom/avito/android/remote/interceptor/DateInterceptor;", "provideDateInterceptor", "(Lcom/avito/android/remote/interceptor/DateHeaderProvider;)Lcom/avito/android/remote/interceptor/DateInterceptor;", "Lio/reactivex/functions/Consumer;", "", "timeDiffObserver", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/remote/interceptor/ServerTimeInterceptor;", "provideServerTimeInterceptor", "(Lio/reactivex/functions/Consumer;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/remote/interceptor/ServerTimeInterceptor;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "deviceIdHeaderProvider", "Lcom/avito/android/remote/interceptor/AppHeaderProvider;", "appHeaderProvider", "Lcom/avito/android/remote/interceptor/SchemaCheckHeaderProvider;", "schemaCheckHeaderProvider", "Lcom/avito/android/remote/interceptor/InfomodelBranchHeaderProvider;", "infomodelBranchHeaderProvider", "Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;", "fingerprintHeaderProvider", "Lcom/avito/android/remote/PaymentsPlanHeaderProvider;", "paymentPlanHeaderProvider", "Lcom/avito/android/remote/interceptor/GeoHeaderProvider;", "geoHeaderProvider", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "messengerInfoProvider", "Lcom/avito/android/remote/interceptor/HeadersInterceptor;", "provideHeadersInterceptor", "(Lcom/avito/android/Features;Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;Lcom/avito/android/remote/interceptor/AppHeaderProvider;Lcom/avito/android/remote/interceptor/SchemaCheckHeaderProvider;Lcom/avito/android/remote/interceptor/InfomodelBranchHeaderProvider;Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;Lcom/avito/android/remote/PaymentsPlanHeaderProvider;Lcom/avito/android/remote/interceptor/GeoHeaderProvider;Lcom/avito/android/messenger/service/MessengerInfoProvider;)Lcom/avito/android/remote/interceptor/HeadersInterceptor;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {HeaderProvidersModule.class})
public final class ApiInterceptorsModule {
    @Provides
    @Reusable
    @NotNull
    public final ApiAnalyticsInterceptor provideApiAnalyticsInterceptor(@NotNull RandomKeyProvider randomKeyProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new ApiAnalyticsInterceptorImpl(analytics, randomKeyProvider);
    }

    @Provides
    @NotNull
    public final DateInterceptor provideDateInterceptor(@NotNull DateHeaderProvider dateHeaderProvider) {
        Intrinsics.checkNotNullParameter(dateHeaderProvider, "dateHeaderProvider");
        return new DateInterceptor(dateHeaderProvider);
    }

    @Provides
    @Reusable
    @NotNull
    public final HeadersInterceptor provideHeadersInterceptor(@NotNull Features features, @NotNull DeviceIdHeaderProvider deviceIdHeaderProvider, @NotNull AppHeaderProvider appHeaderProvider, @NotNull SchemaCheckHeaderProvider schemaCheckHeaderProvider, @NotNull InfomodelBranchHeaderProvider infomodelBranchHeaderProvider, @NotNull FingerprintHeaderProvider fingerprintHeaderProvider, @NotNull PaymentsPlanHeaderProvider paymentsPlanHeaderProvider, @NotNull GeoHeaderProvider geoHeaderProvider, @NotNull MessengerInfoProvider messengerInfoProvider) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(deviceIdHeaderProvider, "deviceIdHeaderProvider");
        Intrinsics.checkNotNullParameter(appHeaderProvider, "appHeaderProvider");
        Intrinsics.checkNotNullParameter(schemaCheckHeaderProvider, "schemaCheckHeaderProvider");
        Intrinsics.checkNotNullParameter(infomodelBranchHeaderProvider, "infomodelBranchHeaderProvider");
        Intrinsics.checkNotNullParameter(fingerprintHeaderProvider, "fingerprintHeaderProvider");
        Intrinsics.checkNotNullParameter(paymentsPlanHeaderProvider, "paymentPlanHeaderProvider");
        Intrinsics.checkNotNullParameter(geoHeaderProvider, "geoHeaderProvider");
        Intrinsics.checkNotNullParameter(messengerInfoProvider, "messengerInfoProvider");
        HttpUrl.Companion companion = HttpUrl.Companion;
        String host = companion.get(features.getApiUrl().getValue()).host();
        String host2 = companion.get(messengerInfoProvider.provideEndpoint()).host();
        ArrayList arrayList = new ArrayList();
        arrayList.add(appHeaderProvider);
        arrayList.add(deviceIdHeaderProvider);
        arrayList.add(geoHeaderProvider);
        arrayList.add(schemaCheckHeaderProvider);
        arrayList.add(infomodelBranchHeaderProvider);
        arrayList.add(paymentsPlanHeaderProvider);
        arrayList.add(fingerprintHeaderProvider);
        return new HeadersInterceptor(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{host, host2}), arrayList);
    }

    @Provides
    @Reusable
    @NotNull
    public final ServerTimeInterceptor provideServerTimeInterceptor(@NotNull Consumer<Long> consumer, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(consumer, "timeDiffObserver");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new ServerTimeInterceptor(consumer, TimeSource.DEFAULT, buildInfo.isDebug());
    }

    @Provides
    @Reusable
    @NotNull
    public final SupportedFeaturesInterceptor provideSupportedFeaturesInterceptor(@NotNull SupportFeaturesHeaderProvider supportFeaturesHeaderProvider) {
        Intrinsics.checkNotNullParameter(supportFeaturesHeaderProvider, "supportFeaturesHeaderProvider");
        return new SupportedFeaturesInterceptor(supportFeaturesHeaderProvider);
    }

    @Provides
    @Reusable
    @NotNull
    public final UserAgentInterceptor provideUserAgentInterceptor(@NotNull UserAgentHeaderProvider userAgentHeaderProvider) {
        Intrinsics.checkNotNullParameter(userAgentHeaderProvider, "userAgentHeaderProvider");
        return new UserAgentInterceptor(userAgentHeaderProvider);
    }
}
