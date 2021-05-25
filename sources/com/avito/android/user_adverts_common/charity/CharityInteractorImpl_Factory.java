package com.avito.android.user_adverts_common.charity;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CharityInteractorImpl_Factory implements Factory<CharityInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<UserAdvertsCommonApi> b;
    public final Provider<CurrentUserIdProvider> c;
    public final Provider<Analytics> d;

    public CharityInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<UserAdvertsCommonApi> provider2, Provider<CurrentUserIdProvider> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CharityInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<UserAdvertsCommonApi> provider2, Provider<CurrentUserIdProvider> provider3, Provider<Analytics> provider4) {
        return new CharityInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CharityInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, UserAdvertsCommonApi userAdvertsCommonApi, CurrentUserIdProvider currentUserIdProvider, Analytics analytics) {
        return new CharityInteractorImpl(schedulersFactory3, userAdvertsCommonApi, currentUserIdProvider, analytics);
    }

    @Override // javax.inject.Provider
    public CharityInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
