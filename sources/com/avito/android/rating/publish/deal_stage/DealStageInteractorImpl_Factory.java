package com.avito.android.rating.publish.deal_stage;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DealStageInteractorImpl_Factory implements Factory<DealStageInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<SchedulersFactory3> b;

    public DealStageInteractorImpl_Factory(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DealStageInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        return new DealStageInteractorImpl_Factory(provider, provider2);
    }

    public static DealStageInteractorImpl newInstance(RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new DealStageInteractorImpl(ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public DealStageInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
