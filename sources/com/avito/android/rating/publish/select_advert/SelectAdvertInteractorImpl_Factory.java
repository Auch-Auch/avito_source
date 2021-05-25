package com.avito.android.rating.publish.select_advert;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectAdvertInteractorImpl_Factory implements Factory<SelectAdvertInteractorImpl> {
    public final Provider<String> a;
    public final Provider<RatingApi> b;
    public final Provider<SchedulersFactory3> c;

    public SelectAdvertInteractorImpl_Factory(Provider<String> provider, Provider<RatingApi> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SelectAdvertInteractorImpl_Factory create(Provider<String> provider, Provider<RatingApi> provider2, Provider<SchedulersFactory3> provider3) {
        return new SelectAdvertInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SelectAdvertInteractorImpl newInstance(String str, RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new SelectAdvertInteractorImpl(str, ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SelectAdvertInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
