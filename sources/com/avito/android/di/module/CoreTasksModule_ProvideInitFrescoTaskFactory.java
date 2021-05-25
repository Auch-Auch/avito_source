package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.app.task.InitFrescoTask;
import com.avito.android.connection_quality.BandwidthSamplerRequestListener;
import com.avito.android.image_loader.fresco.FrescoMemoryTrimmableRegistry;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ForegroundStatusCallbacks;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideInitFrescoTaskFactory implements Factory<InitFrescoTask> {
    public final Provider<BuildInfo> a;
    public final Provider<BandwidthSamplerRequestListener> b;
    public final Provider<FrescoMemoryTrimmableRegistry> c;
    public final Provider<ForegroundStatusCallbacks> d;
    public final Provider<OkHttpNetworkFetcher> e;
    public final Provider<Features> f;
    public final Provider<StartupAnalyticsTracker> g;

    public CoreTasksModule_ProvideInitFrescoTaskFactory(Provider<BuildInfo> provider, Provider<BandwidthSamplerRequestListener> provider2, Provider<FrescoMemoryTrimmableRegistry> provider3, Provider<ForegroundStatusCallbacks> provider4, Provider<OkHttpNetworkFetcher> provider5, Provider<Features> provider6, Provider<StartupAnalyticsTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static CoreTasksModule_ProvideInitFrescoTaskFactory create(Provider<BuildInfo> provider, Provider<BandwidthSamplerRequestListener> provider2, Provider<FrescoMemoryTrimmableRegistry> provider3, Provider<ForegroundStatusCallbacks> provider4, Provider<OkHttpNetworkFetcher> provider5, Provider<Features> provider6, Provider<StartupAnalyticsTracker> provider7) {
        return new CoreTasksModule_ProvideInitFrescoTaskFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static InitFrescoTask provideInitFrescoTask(BuildInfo buildInfo, BandwidthSamplerRequestListener bandwidthSamplerRequestListener, FrescoMemoryTrimmableRegistry frescoMemoryTrimmableRegistry, ForegroundStatusCallbacks foregroundStatusCallbacks, OkHttpNetworkFetcher okHttpNetworkFetcher, Features features, StartupAnalyticsTracker startupAnalyticsTracker) {
        return (InitFrescoTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideInitFrescoTask(buildInfo, bandwidthSamplerRequestListener, frescoMemoryTrimmableRegistry, foregroundStatusCallbacks, okHttpNetworkFetcher, features, startupAnalyticsTracker));
    }

    @Override // javax.inject.Provider
    public InitFrescoTask get() {
        return provideInitFrescoTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
