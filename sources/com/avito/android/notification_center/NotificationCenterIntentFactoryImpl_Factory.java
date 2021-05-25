package com.avito.android.notification_center;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterIntentFactoryImpl_Factory implements Factory<NotificationCenterIntentFactoryImpl> {
    public final Provider<Application> a;

    public NotificationCenterIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static NotificationCenterIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new NotificationCenterIntentFactoryImpl_Factory(provider);
    }

    public static NotificationCenterIntentFactoryImpl newInstance(Application application) {
        return new NotificationCenterIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public NotificationCenterIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
