package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.enabler.RemoteFeatures;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.util.AvitoBuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticFeaturesModule_ProvideRemoteFeaturesFactory implements Factory<RemoteFeatures> {
    public final Provider<Context> a;
    public final Provider<AvitoBuildInfo> b;
    public final Provider<TogglesStorage> c;

    public AnalyticFeaturesModule_ProvideRemoteFeaturesFactory(Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<TogglesStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticFeaturesModule_ProvideRemoteFeaturesFactory create(Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<TogglesStorage> provider3) {
        return new AnalyticFeaturesModule_ProvideRemoteFeaturesFactory(provider, provider2, provider3);
    }

    public static RemoteFeatures provideRemoteFeatures(Context context, AvitoBuildInfo avitoBuildInfo, TogglesStorage togglesStorage) {
        return (RemoteFeatures) Preconditions.checkNotNullFromProvides(AnalyticFeaturesModule.provideRemoteFeatures(context, avitoBuildInfo, togglesStorage));
    }

    @Override // javax.inject.Provider
    public RemoteFeatures get() {
        return provideRemoteFeatures(this.a.get(), this.b.get(), this.c.get());
    }
}
