package com.avito.android.di.module;

import dagger.internal.Factory;
public final class ScreenGraphiteAnalyticsModule_ProvideThresholdFactory implements Factory<Integer> {
    public final ScreenGraphiteAnalyticsModule a;

    public ScreenGraphiteAnalyticsModule_ProvideThresholdFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        this.a = screenGraphiteAnalyticsModule;
    }

    public static ScreenGraphiteAnalyticsModule_ProvideThresholdFactory create(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        return new ScreenGraphiteAnalyticsModule_ProvideThresholdFactory(screenGraphiteAnalyticsModule);
    }

    public static int provideThreshold(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        return screenGraphiteAnalyticsModule.provideThreshold();
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideThreshold(this.a));
    }
}
