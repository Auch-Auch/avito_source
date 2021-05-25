package com.avito.android.notifications_settings;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsInteractorImpl_Factory implements Factory<NotificationsSettingsInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationsSettingsInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationsSettingsInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationsSettingsInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationsSettingsInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationsSettingsInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
