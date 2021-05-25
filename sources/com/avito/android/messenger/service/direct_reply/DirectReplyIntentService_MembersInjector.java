package com.avito.android.messenger.service.direct_reply;

import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ServiceIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DirectReplyIntentService_MembersInjector implements MembersInjector<DirectReplyIntentService> {
    public final Provider<DirectReplyServiceDelegate> a;
    public final Provider<NotificationManagerCompat> b;
    public final Provider<ServiceIntentFactory> c;

    public DirectReplyIntentService_MembersInjector(Provider<DirectReplyServiceDelegate> provider, Provider<NotificationManagerCompat> provider2, Provider<ServiceIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<DirectReplyIntentService> create(Provider<DirectReplyServiceDelegate> provider, Provider<NotificationManagerCompat> provider2, Provider<ServiceIntentFactory> provider3) {
        return new DirectReplyIntentService_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.direct_reply.DirectReplyIntentService.delegate")
    public static void injectDelegate(DirectReplyIntentService directReplyIntentService, DirectReplyServiceDelegate directReplyServiceDelegate) {
        directReplyIntentService.delegate = directReplyServiceDelegate;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.direct_reply.DirectReplyIntentService.notificationManagerCompat")
    public static void injectNotificationManagerCompat(DirectReplyIntentService directReplyIntentService, NotificationManagerCompat notificationManagerCompat) {
        directReplyIntentService.notificationManagerCompat = notificationManagerCompat;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.direct_reply.DirectReplyIntentService.serviceIntentFactory")
    public static void injectServiceIntentFactory(DirectReplyIntentService directReplyIntentService, ServiceIntentFactory serviceIntentFactory) {
        directReplyIntentService.serviceIntentFactory = serviceIntentFactory;
    }

    public void injectMembers(DirectReplyIntentService directReplyIntentService) {
        injectDelegate(directReplyIntentService, this.a.get());
        injectNotificationManagerCompat(directReplyIntentService, this.b.get());
        injectServiceIntentFactory(directReplyIntentService, this.c.get());
    }
}
