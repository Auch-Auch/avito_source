package com.avito.android.notifications_settings;

import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
import kotlin.Unit;
public final class NotificationsSettingsPresenterImpl_Factory implements Factory<NotificationsSettingsPresenterImpl> {
    public final Provider<NotificationsSettingsInteractor> a;
    public final Provider<NotificationsSettingsConverter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<Relay<Unit>> e;
    public final Provider<Relay<NotificationsSettingsToggleItem>> f;
    public final Provider<Consumer<NotificationSettingsChangeEvent>> g;
    public final Provider<Kundle> h;

    public NotificationsSettingsPresenterImpl_Factory(Provider<NotificationsSettingsInteractor> provider, Provider<NotificationsSettingsConverter> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<Relay<Unit>> provider5, Provider<Relay<NotificationsSettingsToggleItem>> provider6, Provider<Consumer<NotificationSettingsChangeEvent>> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static NotificationsSettingsPresenterImpl_Factory create(Provider<NotificationsSettingsInteractor> provider, Provider<NotificationsSettingsConverter> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<Relay<Unit>> provider5, Provider<Relay<NotificationsSettingsToggleItem>> provider6, Provider<Consumer<NotificationSettingsChangeEvent>> provider7, Provider<Kundle> provider8) {
        return new NotificationsSettingsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static NotificationsSettingsPresenterImpl newInstance(NotificationsSettingsInteractor notificationsSettingsInteractor, NotificationsSettingsConverter notificationsSettingsConverter, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, Relay<Unit> relay, Relay<NotificationsSettingsToggleItem> relay2, Consumer<NotificationSettingsChangeEvent> consumer, Kundle kundle) {
        return new NotificationsSettingsPresenterImpl(notificationsSettingsInteractor, notificationsSettingsConverter, schedulersFactory, adapterPresenter, relay, relay2, consumer, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
