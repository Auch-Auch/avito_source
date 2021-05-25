package com.avito.android.push;

import com.avito.android.NotificationWorkFactory;
import com.avito.android.remote.notification.NotificationSystemSettingsLogger;
import com.avito.android.service.SafeServiceStarter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessagingServiceDelegate_Factory implements Factory<MessagingServiceDelegate> {
    public final Provider<MessagingInteractor> a;
    public final Provider<NotificationSystemSettingsLogger> b;
    public final Provider<SafeServiceStarter> c;
    public final Provider<NotificationWorkFactory> d;
    public final Provider<CallPushHandler> e;

    public MessagingServiceDelegate_Factory(Provider<MessagingInteractor> provider, Provider<NotificationSystemSettingsLogger> provider2, Provider<SafeServiceStarter> provider3, Provider<NotificationWorkFactory> provider4, Provider<CallPushHandler> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessagingServiceDelegate_Factory create(Provider<MessagingInteractor> provider, Provider<NotificationSystemSettingsLogger> provider2, Provider<SafeServiceStarter> provider3, Provider<NotificationWorkFactory> provider4, Provider<CallPushHandler> provider5) {
        return new MessagingServiceDelegate_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessagingServiceDelegate newInstance(MessagingInteractor messagingInteractor, NotificationSystemSettingsLogger notificationSystemSettingsLogger, SafeServiceStarter safeServiceStarter, NotificationWorkFactory notificationWorkFactory, CallPushHandler callPushHandler) {
        return new MessagingServiceDelegate(messagingInteractor, notificationSystemSettingsLogger, safeServiceStarter, notificationWorkFactory, callPushHandler);
    }

    @Override // javax.inject.Provider
    public MessagingServiceDelegate get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
