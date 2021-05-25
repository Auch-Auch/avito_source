package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.enabler.FetchRemoteTogglesStartUpTask;
import com.avito.android.enabler.RemoteFeatures;
import com.avito.android.enabler.RemoteFeaturesCrashlyticsMonitor;
import com.avito.android.enabler.RemoteFeaturesCrashlyticsMonitorImpl;
import com.avito.android.enabler.RemoteFeaturesLoadingMonitor;
import com.avito.android.enabler.RemoteFeaturesTouchMonitor;
import com.avito.android.enabler.RemoteTogglesFetcher;
import com.avito.android.enabler.RemoteTogglesFetcherImpl;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.remote.FeaturesApi;
import com.avito.android.util.AvitoBuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b&\u0010'J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010$\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/di/module/AnalyticFeaturesModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "Lcom/avito/android/enabler/TogglesStorage;", "togglesStorage", "Lcom/avito/android/enabler/RemoteFeatures;", "provideRemoteFeatures", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/enabler/TogglesStorage;)Lcom/avito/android/enabler/RemoteFeatures;", "Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;", "provideAnalyticFeatures", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/enabler/TogglesStorage;)Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;", "Lcom/avito/android/enabler/RemoteTogglesFetcher;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;", "touchMonitor", "Lcom/avito/android/enabler/FetchRemoteTogglesStartUpTask;", "provideFetchRemoteTogglesStartUpTask", "(Lcom/avito/android/enabler/RemoteTogglesFetcher;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;)Lcom/avito/android/enabler/FetchRemoteTogglesStartUpTask;", "Lcom/avito/android/remote/FeaturesApi;", "api", "storage", "Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;", "loadingMonitor", "provideFetchRemoteTogglesInteractor", "(Lcom/avito/android/remote/FeaturesApi;Lcom/avito/android/enabler/TogglesStorage;Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;)Lcom/avito/android/enabler/RemoteTogglesFetcher;", "analyticFeatures", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "crashlytics", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideRemoteFeaturesTouchMonitor", "(Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/AvitoBuildInfo;)Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;", "<init>", "()V", "Bindings", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class AnalyticFeaturesModule {
    @NotNull
    public static final AnalyticFeaturesModule INSTANCE = new AnalyticFeaturesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/AnalyticFeaturesModule$Bindings;", "", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitorImpl;", "monitor", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "bindRemoteFeaturesCrashlyticsMonitor", "(Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitorImpl;)Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Singleton
        @Binds
        @NotNull
        RemoteFeaturesCrashlyticsMonitor bindRemoteFeaturesCrashlyticsMonitor(@NotNull RemoteFeaturesCrashlyticsMonitorImpl remoteFeaturesCrashlyticsMonitorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AvitoAnalyticFeatures provideAnalyticFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull TogglesStorage togglesStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(togglesStorage, "togglesStorage");
        return new AvitoAnalyticFeatures(context, avitoBuildInfo, togglesStorage);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final RemoteTogglesFetcher provideFetchRemoteTogglesInteractor(@NotNull FeaturesApi featuresApi, @NotNull TogglesStorage togglesStorage, @NotNull RemoteFeaturesLoadingMonitor remoteFeaturesLoadingMonitor) {
        Intrinsics.checkNotNullParameter(featuresApi, "api");
        Intrinsics.checkNotNullParameter(togglesStorage, "storage");
        Intrinsics.checkNotNullParameter(remoteFeaturesLoadingMonitor, "loadingMonitor");
        return new RemoteTogglesFetcherImpl(featuresApi, togglesStorage, remoteFeaturesLoadingMonitor);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final FetchRemoteTogglesStartUpTask provideFetchRemoteTogglesStartUpTask(@NotNull RemoteTogglesFetcher remoteTogglesFetcher, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull RemoteFeaturesTouchMonitor remoteFeaturesTouchMonitor) {
        Intrinsics.checkNotNullParameter(remoteTogglesFetcher, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(remoteFeaturesTouchMonitor, "touchMonitor");
        return new FetchRemoteTogglesStartUpTask(remoteTogglesFetcher, remoteFeaturesTouchMonitor, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final RemoteFeatures provideRemoteFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull TogglesStorage togglesStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(togglesStorage, "togglesStorage");
        return new RemoteFeatures(context, avitoBuildInfo, togglesStorage);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final RemoteFeaturesTouchMonitor provideRemoteFeaturesTouchMonitor(@NotNull AvitoAnalyticFeatures avitoAnalyticFeatures, @NotNull SchedulersFactory schedulersFactory, @NotNull RemoteFeaturesCrashlyticsMonitor remoteFeaturesCrashlyticsMonitor, @NotNull Analytics analytics, @NotNull AvitoBuildInfo avitoBuildInfo) {
        Intrinsics.checkNotNullParameter(avitoAnalyticFeatures, "analyticFeatures");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(remoteFeaturesCrashlyticsMonitor, "crashlytics");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        return new RemoteFeaturesTouchMonitor(avitoAnalyticFeatures, analytics, remoteFeaturesCrashlyticsMonitor, schedulersFactory, avitoBuildInfo);
    }
}
