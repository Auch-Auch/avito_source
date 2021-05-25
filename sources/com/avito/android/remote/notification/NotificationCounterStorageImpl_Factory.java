package com.avito.android.remote.notification;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCounterStorageImpl_Factory implements Factory<NotificationCounterStorageImpl> {
    public final Provider<Preferences> a;

    public NotificationCounterStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static NotificationCounterStorageImpl_Factory create(Provider<Preferences> provider) {
        return new NotificationCounterStorageImpl_Factory(provider);
    }

    public static NotificationCounterStorageImpl newInstance(Preferences preferences) {
        return new NotificationCounterStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public NotificationCounterStorageImpl get() {
        return newInstance(this.a.get());
    }
}
