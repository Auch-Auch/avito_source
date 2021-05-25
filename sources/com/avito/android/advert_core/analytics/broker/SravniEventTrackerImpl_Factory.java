package com.avito.android.advert_core.analytics.broker;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SravniEventTrackerImpl_Factory implements Factory<SravniEventTrackerImpl> {
    public final Provider<SravniAnalyticsEventLogger> a;
    public final Provider<CreditBrokerFlowEventLogger> b;

    public SravniEventTrackerImpl_Factory(Provider<SravniAnalyticsEventLogger> provider, Provider<CreditBrokerFlowEventLogger> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SravniEventTrackerImpl_Factory create(Provider<SravniAnalyticsEventLogger> provider, Provider<CreditBrokerFlowEventLogger> provider2) {
        return new SravniEventTrackerImpl_Factory(provider, provider2);
    }

    public static SravniEventTrackerImpl newInstance(SravniAnalyticsEventLogger sravniAnalyticsEventLogger, CreditBrokerFlowEventLogger creditBrokerFlowEventLogger) {
        return new SravniEventTrackerImpl(sravniAnalyticsEventLogger, creditBrokerFlowEventLogger);
    }

    @Override // javax.inject.Provider
    public SravniEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
