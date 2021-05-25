package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.PaymentsPlanHeaderProvider;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.UserAgentProvider;
import com.avito.android.remote.interceptor.AppHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import com.avito.android.remote.interceptor.FixedDeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.UserAgentProviderImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/di/module/HeaderProvidersModule;", "", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "provideDeviceIdHeaderProvider", "(Lcom/avito/android/remote/DeviceIdProvider;)Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "Lcom/avito/android/remote/PaymentsPlanHeaderProvider;", "providePaymentsPlanHeaderProvider", "()Lcom/avito/android/remote/PaymentsPlanHeaderProvider;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "provideSupportFeaturesHeaderProvider", "(Lcom/avito/android/Features;)Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "Lcom/avito/android/remote/UserAgentProvider;", "userAgentProvider", "Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "provideUserAgentHeaderProvider", "(Lcom/avito/android/remote/UserAgentProvider;)Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/remote/interceptor/AppHeaderProvider;", "provideAppHeaderProvider", "(Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/remote/interceptor/AppHeaderProvider;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "provideDateHeaderProvider", "(Lcom/avito/android/server_time/TimeSource;)Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "Lcom/avito/android/preferences/FingerprintStorage;", "storage", "Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;", "provideFingerprintHeaderProvider", "(Lcom/avito/android/preferences/FingerprintStorage;)Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;", "<init>", "()V", "Bindings", "api_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public class HeaderProvidersModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/HeaderProvidersModule$Bindings;", "", "Lcom/avito/android/util/UserAgentProviderImpl;", "impl", "Lcom/avito/android/remote/UserAgentProvider;", "bindUserAgentProvider", "(Lcom/avito/android/util/UserAgentProviderImpl;)Lcom/avito/android/remote/UserAgentProvider;", "api_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Reusable
        @Binds
        @NotNull
        UserAgentProvider bindUserAgentProvider(@NotNull UserAgentProviderImpl userAgentProviderImpl);
    }

    @Provides
    @Reusable
    @NotNull
    public final AppHeaderProvider provideAppHeaderProvider(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new AppHeaderProvider();
    }

    @Provides
    @Reusable
    @NotNull
    public final DateHeaderProvider provideDateHeaderProvider(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return new DateHeaderProvider(timeSource);
    }

    @Provides
    @Reusable
    @NotNull
    public DeviceIdHeaderProvider provideDeviceIdHeaderProvider(@NotNull DeviceIdProvider deviceIdProvider) {
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        return new FixedDeviceIdHeaderProvider(deviceIdProvider.getValue());
    }

    @Provides
    @Reusable
    @NotNull
    public final FingerprintHeaderProvider provideFingerprintHeaderProvider(@NotNull FingerprintStorage fingerprintStorage) {
        Intrinsics.checkNotNullParameter(fingerprintStorage, "storage");
        return new FingerprintHeaderProvider(fingerprintStorage);
    }

    @Provides
    @Reusable
    @NotNull
    public PaymentsPlanHeaderProvider providePaymentsPlanHeaderProvider() {
        return new PaymentsPlanHeaderProvider("");
    }

    @Provides
    @Reusable
    @NotNull
    public final SupportFeaturesHeaderProvider provideSupportFeaturesHeaderProvider(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return new SupportFeaturesHeaderProvider(features);
    }

    @Provides
    @Reusable
    @NotNull
    public UserAgentHeaderProvider provideUserAgentHeaderProvider(@NotNull UserAgentProvider userAgentProvider) {
        Intrinsics.checkNotNullParameter(userAgentProvider, "userAgentProvider");
        return new UserAgentHeaderProvider(userAgentProvider);
    }
}
