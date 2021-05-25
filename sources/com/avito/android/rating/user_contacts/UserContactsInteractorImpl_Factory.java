package com.avito.android.rating.user_contacts;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserContactsInteractorImpl_Factory implements Factory<UserContactsInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<String> b;
    public final Provider<SchedulersFactory3> c;

    public UserContactsInteractorImpl_Factory(Provider<RatingApi> provider, Provider<String> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserContactsInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<String> provider2, Provider<SchedulersFactory3> provider3) {
        return new UserContactsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UserContactsInteractorImpl newInstance(RatingApi ratingApi, String str, SchedulersFactory3 schedulersFactory3) {
        return new UserContactsInteractorImpl(ratingApi, str, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public UserContactsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
