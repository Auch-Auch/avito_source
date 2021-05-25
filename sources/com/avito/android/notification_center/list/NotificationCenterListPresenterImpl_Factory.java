package com.avito.android.notification_center.list;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterCleaner;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.avito.android.notification_center.push.NcPushClicksInteractor;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterListPresenterImpl_Factory implements Factory<NotificationCenterListPresenterImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<NotificationCenterListInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<NotificationInteractor> d;
    public final Provider<NotificationCenterCounterMarker> e;
    public final Provider<NotificationCenterCounterCleaner> f;
    public final Provider<NcPushClicksInteractor> g;
    public final Provider<Analytics> h;
    public final Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> i;
    public final Provider<Kundle> j;

    public NotificationCenterListPresenterImpl_Factory(Provider<AdapterPresenter> provider, Provider<NotificationCenterListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<NotificationInteractor> provider4, Provider<NotificationCenterCounterMarker> provider5, Provider<NotificationCenterCounterCleaner> provider6, Provider<NcPushClicksInteractor> provider7, Provider<Analytics> provider8, Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> provider9, Provider<Kundle> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static NotificationCenterListPresenterImpl_Factory create(Provider<AdapterPresenter> provider, Provider<NotificationCenterListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<NotificationInteractor> provider4, Provider<NotificationCenterCounterMarker> provider5, Provider<NotificationCenterCounterCleaner> provider6, Provider<NcPushClicksInteractor> provider7, Provider<Analytics> provider8, Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> provider9, Provider<Kundle> provider10) {
        return new NotificationCenterListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static NotificationCenterListPresenterImpl newInstance(Lazy<AdapterPresenter> lazy, NotificationCenterListInteractor notificationCenterListInteractor, SchedulersFactory schedulersFactory, NotificationInteractor notificationInteractor, NotificationCenterCounterMarker notificationCenterCounterMarker, NotificationCenterCounterCleaner notificationCenterCounterCleaner, NcPushClicksInteractor ncPushClicksInteractor, Analytics analytics, PublishRelay<NotificationCenterListItem.ErrorSnippet> publishRelay, Kundle kundle) {
        return new NotificationCenterListPresenterImpl(lazy, notificationCenterListInteractor, schedulersFactory, notificationInteractor, notificationCenterCounterMarker, notificationCenterCounterCleaner, ncPushClicksInteractor, analytics, publishRelay, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationCenterListPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
