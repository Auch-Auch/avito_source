package com.avito.android.push;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MessagingService_MembersInjector implements MembersInjector<MessagingService> {
    public final Provider<MessagingServiceDelegate> a;

    public MessagingService_MembersInjector(Provider<MessagingServiceDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<MessagingService> create(Provider<MessagingServiceDelegate> provider) {
        return new MessagingService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.push.MessagingService.delegate")
    public static void injectDelegate(MessagingService messagingService, MessagingServiceDelegate messagingServiceDelegate) {
        messagingService.delegate = messagingServiceDelegate;
    }

    public void injectMembers(MessagingService messagingService) {
        injectDelegate(messagingService, this.a.get());
    }
}
