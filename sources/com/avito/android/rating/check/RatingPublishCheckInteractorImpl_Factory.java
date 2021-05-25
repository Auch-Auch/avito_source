package com.avito.android.rating.check;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingPublishCheckInteractorImpl_Factory implements Factory<RatingPublishCheckInteractorImpl> {
    public final Provider<String> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<RatingApi> c;
    public final Provider<SchedulersFactory3> d;

    public RatingPublishCheckInteractorImpl_Factory(Provider<String> provider, Provider<AccountStateProvider> provider2, Provider<RatingApi> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static RatingPublishCheckInteractorImpl_Factory create(Provider<String> provider, Provider<AccountStateProvider> provider2, Provider<RatingApi> provider3, Provider<SchedulersFactory3> provider4) {
        return new RatingPublishCheckInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RatingPublishCheckInteractorImpl newInstance(String str, AccountStateProvider accountStateProvider, RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new RatingPublishCheckInteractorImpl(str, accountStateProvider, ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public RatingPublishCheckInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
