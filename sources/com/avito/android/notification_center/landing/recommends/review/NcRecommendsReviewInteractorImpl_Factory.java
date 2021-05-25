package com.avito.android.notification_center.landing.recommends.review;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewInteractorImpl_Factory implements Factory<NcRecommendsReviewInteractorImpl> {
    public final Provider<String> a;
    public final Provider<NotificationsApi> b;
    public final Provider<SchedulersFactory> c;

    public NcRecommendsReviewInteractorImpl_Factory(Provider<String> provider, Provider<NotificationsApi> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static NcRecommendsReviewInteractorImpl_Factory create(Provider<String> provider, Provider<NotificationsApi> provider2, Provider<SchedulersFactory> provider3) {
        return new NcRecommendsReviewInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static NcRecommendsReviewInteractorImpl newInstance(String str, NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NcRecommendsReviewInteractorImpl(str, notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
