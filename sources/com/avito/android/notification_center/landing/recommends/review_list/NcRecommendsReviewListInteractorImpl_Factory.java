package com.avito.android.notification_center.landing.recommends.review_list;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewListInteractorImpl_Factory implements Factory<NcRecommendsReviewListInteractorImpl> {
    public final Provider<String> a;
    public final Provider<Integer> b;
    public final Provider<NotificationsApi> c;
    public final Provider<SchedulersFactory> d;

    public NcRecommendsReviewListInteractorImpl_Factory(Provider<String> provider, Provider<Integer> provider2, Provider<NotificationsApi> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static NcRecommendsReviewListInteractorImpl_Factory create(Provider<String> provider, Provider<Integer> provider2, Provider<NotificationsApi> provider3, Provider<SchedulersFactory> provider4) {
        return new NcRecommendsReviewListInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static NcRecommendsReviewListInteractorImpl newInstance(String str, int i, NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NcRecommendsReviewListInteractorImpl(str, i, notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get().intValue(), this.c.get(), this.d.get());
    }
}
