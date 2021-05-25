package com.avito.android.similar_adverts;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.rec.ScreenSource;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarAdvertsInteractorImpl_Factory implements Factory<SimilarAdvertsInteractorImpl> {
    public final Provider<AdvertDetailsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ScreenSource> c;

    public SimilarAdvertsInteractorImpl_Factory(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ScreenSource> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SimilarAdvertsInteractorImpl_Factory create(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ScreenSource> provider3) {
        return new SimilarAdvertsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SimilarAdvertsInteractorImpl newInstance(AdvertDetailsApi advertDetailsApi, SchedulersFactory3 schedulersFactory3, ScreenSource screenSource) {
        return new SimilarAdvertsInteractorImpl(advertDetailsApi, schedulersFactory3, screenSource);
    }

    @Override // javax.inject.Provider
    public SimilarAdvertsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
