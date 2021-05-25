package com.avito.android.di.module;

import com.avito.android.util.AvitoBuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class AdjustTokenModule_ProvideAdjustDefaultTrackerFactory implements Factory<String> {
    public final Provider<AvitoBuildInfo> a;

    public AdjustTokenModule_ProvideAdjustDefaultTrackerFactory(Provider<AvitoBuildInfo> provider) {
        this.a = provider;
    }

    public static AdjustTokenModule_ProvideAdjustDefaultTrackerFactory create(Provider<AvitoBuildInfo> provider) {
        return new AdjustTokenModule_ProvideAdjustDefaultTrackerFactory(provider);
    }

    @Nullable
    public static String provideAdjustDefaultTracker(AvitoBuildInfo avitoBuildInfo) {
        return AdjustTokenModule.provideAdjustDefaultTracker(avitoBuildInfo);
    }

    @Override // javax.inject.Provider
    @Nullable
    public String get() {
        return provideAdjustDefaultTracker(this.a.get());
    }
}
