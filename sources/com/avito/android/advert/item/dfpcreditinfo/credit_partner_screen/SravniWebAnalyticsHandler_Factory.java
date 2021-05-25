package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SravniWebAnalyticsHandler_Factory implements Factory<SravniWebAnalyticsHandler> {
    public final Provider<SravniWebAnalyticsEventLogger> a;

    public SravniWebAnalyticsHandler_Factory(Provider<SravniWebAnalyticsEventLogger> provider) {
        this.a = provider;
    }

    public static SravniWebAnalyticsHandler_Factory create(Provider<SravniWebAnalyticsEventLogger> provider) {
        return new SravniWebAnalyticsHandler_Factory(provider);
    }

    public static SravniWebAnalyticsHandler newInstance(SravniWebAnalyticsEventLogger sravniWebAnalyticsEventLogger) {
        return new SravniWebAnalyticsHandler(sravniWebAnalyticsEventLogger);
    }

    @Override // javax.inject.Provider
    public SravniWebAnalyticsHandler get() {
        return newInstance(this.a.get());
    }
}
