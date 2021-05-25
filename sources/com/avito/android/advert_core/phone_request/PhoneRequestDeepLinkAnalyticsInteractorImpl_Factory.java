package com.avito.android.advert_core.phone_request;

import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneRequestDeepLinkAnalyticsInteractorImpl_Factory implements Factory<PhoneRequestDeepLinkAnalyticsInteractorImpl> {
    public final Provider<PhoneRequestDeepLinkAnalyticsData> a;
    public final Provider<Analytics> b;

    public PhoneRequestDeepLinkAnalyticsInteractorImpl_Factory(Provider<PhoneRequestDeepLinkAnalyticsData> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhoneRequestDeepLinkAnalyticsInteractorImpl_Factory create(Provider<PhoneRequestDeepLinkAnalyticsData> provider, Provider<Analytics> provider2) {
        return new PhoneRequestDeepLinkAnalyticsInteractorImpl_Factory(provider, provider2);
    }

    public static PhoneRequestDeepLinkAnalyticsInteractorImpl newInstance(PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData, Analytics analytics) {
        return new PhoneRequestDeepLinkAnalyticsInteractorImpl(phoneRequestDeepLinkAnalyticsData, analytics);
    }

    @Override // javax.inject.Provider
    public PhoneRequestDeepLinkAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
