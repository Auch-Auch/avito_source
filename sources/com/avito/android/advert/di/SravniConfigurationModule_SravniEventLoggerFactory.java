package com.avito.android.advert.di;

import com.avito.android.advert_core.analytics.broker.SravniAnalyticsEventLogger;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SravniConfigurationModule_SravniEventLoggerFactory implements Factory<SravniAnalyticsEventLogger> {

    public static final class a {
        public static final SravniConfigurationModule_SravniEventLoggerFactory a = new SravniConfigurationModule_SravniEventLoggerFactory();
    }

    public static SravniConfigurationModule_SravniEventLoggerFactory create() {
        return a.a;
    }

    public static SravniAnalyticsEventLogger sravniEventLogger() {
        return (SravniAnalyticsEventLogger) Preconditions.checkNotNullFromProvides(SravniConfigurationModule.INSTANCE.sravniEventLogger());
    }

    @Override // javax.inject.Provider
    public SravniAnalyticsEventLogger get() {
        return sravniEventLogger();
    }
}
