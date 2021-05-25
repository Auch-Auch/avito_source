package com.avito.android.notification_center.landing.feedback;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Unit;
public final class NotificationCenterLandingFeedbackPresenterImpl_Factory implements Factory<NotificationCenterLandingFeedbackPresenterImpl> {
    public final Provider<String> a;
    public final Provider<NotificationCenterLandingFeedbackInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;
    public final Provider<PublishRelay<Unit>> e;
    public final Provider<Kundle> f;

    public NotificationCenterLandingFeedbackPresenterImpl_Factory(Provider<String> provider, Provider<NotificationCenterLandingFeedbackInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<PublishRelay<Unit>> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static NotificationCenterLandingFeedbackPresenterImpl_Factory create(Provider<String> provider, Provider<NotificationCenterLandingFeedbackInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<PublishRelay<Unit>> provider5, Provider<Kundle> provider6) {
        return new NotificationCenterLandingFeedbackPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NotificationCenterLandingFeedbackPresenterImpl newInstance(String str, NotificationCenterLandingFeedbackInteractor notificationCenterLandingFeedbackInteractor, SchedulersFactory schedulersFactory, Analytics analytics, PublishRelay<Unit> publishRelay, Kundle kundle) {
        return new NotificationCenterLandingFeedbackPresenterImpl(str, notificationCenterLandingFeedbackInteractor, schedulersFactory, analytics, publishRelay, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingFeedbackPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
