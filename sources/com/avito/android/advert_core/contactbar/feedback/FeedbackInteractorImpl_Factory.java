package com.avito.android.advert_core.contactbar.feedback;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackInteractorImpl_Factory implements Factory<FeedbackInteractorImpl> {
    public final Provider<AdvertDetailsApi> a;
    public final Provider<SchedulersFactory3> b;

    public FeedbackInteractorImpl_Factory(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FeedbackInteractorImpl_Factory create(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new FeedbackInteractorImpl_Factory(provider, provider2);
    }

    public static FeedbackInteractorImpl newInstance(AdvertDetailsApi advertDetailsApi, SchedulersFactory3 schedulersFactory3) {
        return new FeedbackInteractorImpl(advertDetailsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FeedbackInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
