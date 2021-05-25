package com.avito.android.di.module;

import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.provider.api.ApiEventObserver;
import com.avito.android.analytics.provider.api.ApiEventTracker;
import com.avito.android.analytics.provider.api.ApiEventTrackerImpl;
import com.avito.android.analytics.remote.AnalyticsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/module/ApiAnalyticsModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "provideApiEventTracker", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "tracker", "Ldagger/Lazy;", "Lcom/avito/android/analytics/remote/AnalyticsApi;", "apiLazy", "Lcom/avito/android/analytics/EventObserver;", "provideApiEventObserver", "(Lcom/avito/android/analytics/provider/api/ApiEventTracker;Ldagger/Lazy;)Lcom/avito/android/analytics/EventObserver;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ApiAnalyticsModule {
    @NotNull
    public static final ApiAnalyticsModule INSTANCE = new ApiAnalyticsModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final EventObserver provideApiEventObserver(@NotNull ApiEventTracker apiEventTracker, @NotNull Lazy<AnalyticsApi> lazy) {
        Intrinsics.checkNotNullParameter(apiEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(lazy, "apiLazy");
        return new ApiEventObserver(apiEventTracker, lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final ApiEventTracker provideApiEventTracker(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ApiEventTrackerImpl(schedulersFactory);
    }
}
