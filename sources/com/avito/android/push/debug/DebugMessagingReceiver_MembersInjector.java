package com.avito.android.push.debug;

import com.avito.android.push.MessagingServiceDelegate;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DebugMessagingReceiver_MembersInjector implements MembersInjector<DebugMessagingReceiver> {
    public final Provider<MessagingServiceDelegate> a;

    public DebugMessagingReceiver_MembersInjector(Provider<MessagingServiceDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<DebugMessagingReceiver> create(Provider<MessagingServiceDelegate> provider) {
        return new DebugMessagingReceiver_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.push.debug.DebugMessagingReceiver.delegate")
    public static void injectDelegate(DebugMessagingReceiver debugMessagingReceiver, MessagingServiceDelegate messagingServiceDelegate) {
        debugMessagingReceiver.delegate = messagingServiceDelegate;
    }

    public void injectMembers(DebugMessagingReceiver debugMessagingReceiver) {
        injectDelegate(debugMessagingReceiver, this.a.get());
    }
}
