package com.avito.android.advert_core.short_term_rent;

import com.avito.android.analytics.Analytics;
import com.avito.android.profile.ProfileInfoStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertStrBlockAnalyticsInteractorImpl_Factory implements Factory<AdvertStrBlockAnalyticsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<ProfileInfoStorage> b;
    public final Provider<Analytics> c;

    public AdvertStrBlockAnalyticsInteractorImpl_Factory(Provider<String> provider, Provider<ProfileInfoStorage> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertStrBlockAnalyticsInteractorImpl_Factory create(Provider<String> provider, Provider<ProfileInfoStorage> provider2, Provider<Analytics> provider3) {
        return new AdvertStrBlockAnalyticsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertStrBlockAnalyticsInteractorImpl newInstance(String str, ProfileInfoStorage profileInfoStorage, Analytics analytics) {
        return new AdvertStrBlockAnalyticsInteractorImpl(str, profileInfoStorage, analytics);
    }

    @Override // javax.inject.Provider
    public AdvertStrBlockAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
