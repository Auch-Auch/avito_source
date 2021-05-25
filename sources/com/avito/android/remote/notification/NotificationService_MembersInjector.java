package com.avito.android.remote.notification;

import com.avito.android.service.SafeServiceStarter;
import com.avito.android.service.ServiceCountdownHandler;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationService_MembersInjector implements MembersInjector<NotificationService> {
    public final Provider<NotificationServiceInteractor> a;
    public final Provider<ServiceCountdownHandler> b;
    public final Provider<SafeServiceStarter> c;

    public NotificationService_MembersInjector(Provider<NotificationServiceInteractor> provider, Provider<ServiceCountdownHandler> provider2, Provider<SafeServiceStarter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<NotificationService> create(Provider<NotificationServiceInteractor> provider, Provider<ServiceCountdownHandler> provider2, Provider<SafeServiceStarter> provider3) {
        return new NotificationService_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.NotificationService.countdownHandler")
    public static void injectCountdownHandler(NotificationService notificationService, ServiceCountdownHandler serviceCountdownHandler) {
        notificationService.countdownHandler = serviceCountdownHandler;
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.NotificationService.interactor")
    public static void injectInteractor(NotificationService notificationService, NotificationServiceInteractor notificationServiceInteractor) {
        notificationService.interactor = notificationServiceInteractor;
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.NotificationService.safeStarter")
    public static void injectSafeStarter(NotificationService notificationService, SafeServiceStarter safeServiceStarter) {
        notificationService.safeStarter = safeServiceStarter;
    }

    public void injectMembers(NotificationService notificationService) {
        injectInteractor(notificationService, this.a.get());
        injectCountdownHandler(notificationService, this.b.get());
        injectSafeStarter(notificationService, this.c.get());
    }
}
