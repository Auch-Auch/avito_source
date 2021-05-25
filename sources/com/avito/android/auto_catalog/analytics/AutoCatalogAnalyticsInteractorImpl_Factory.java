package com.avito.android.auto_catalog.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.auto_catalog.AutoCatalogData;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoCatalogAnalyticsInteractorImpl_Factory implements Factory<AutoCatalogAnalyticsInteractorImpl> {
    public final Provider<AutoCatalogData> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<Analytics> d;

    public AutoCatalogAnalyticsInteractorImpl_Factory(Provider<AutoCatalogData> provider, Provider<String> provider2, Provider<String> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AutoCatalogAnalyticsInteractorImpl_Factory create(Provider<AutoCatalogData> provider, Provider<String> provider2, Provider<String> provider3, Provider<Analytics> provider4) {
        return new AutoCatalogAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AutoCatalogAnalyticsInteractorImpl newInstance(AutoCatalogData autoCatalogData, String str, String str2, Analytics analytics) {
        return new AutoCatalogAnalyticsInteractorImpl(autoCatalogData, str, str2, analytics);
    }

    @Override // javax.inject.Provider
    public AutoCatalogAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
