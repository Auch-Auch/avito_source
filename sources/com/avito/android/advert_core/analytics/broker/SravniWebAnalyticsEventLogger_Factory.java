package com.avito.android.advert_core.analytics.broker;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SravniWebAnalyticsEventLogger_Factory implements Factory<SravniWebAnalyticsEventLogger> {
    public final Provider<CreditBrokerFlowEventLogger> a;

    public SravniWebAnalyticsEventLogger_Factory(Provider<CreditBrokerFlowEventLogger> provider) {
        this.a = provider;
    }

    public static SravniWebAnalyticsEventLogger_Factory create(Provider<CreditBrokerFlowEventLogger> provider) {
        return new SravniWebAnalyticsEventLogger_Factory(provider);
    }

    public static SravniWebAnalyticsEventLogger newInstance(CreditBrokerFlowEventLogger creditBrokerFlowEventLogger) {
        return new SravniWebAnalyticsEventLogger(creditBrokerFlowEventLogger);
    }

    @Override // javax.inject.Provider
    public SravniWebAnalyticsEventLogger get() {
        return newInstance(this.a.get());
    }
}
