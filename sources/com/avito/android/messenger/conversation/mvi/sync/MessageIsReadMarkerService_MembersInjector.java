package com.avito.android.messenger.conversation.mvi.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MessageIsReadMarkerService_MembersInjector implements MembersInjector<MessageIsReadMarkerService> {
    public final Provider<MessageIsReadMarker> a;

    public MessageIsReadMarkerService_MembersInjector(Provider<MessageIsReadMarker> provider) {
        this.a = provider;
    }

    public static MembersInjector<MessageIsReadMarkerService> create(Provider<MessageIsReadMarker> provider) {
        return new MessageIsReadMarkerService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerService.marker")
    public static void injectMarker(MessageIsReadMarkerService messageIsReadMarkerService, MessageIsReadMarker messageIsReadMarker) {
        messageIsReadMarkerService.marker = messageIsReadMarker;
    }

    public void injectMembers(MessageIsReadMarkerService messageIsReadMarkerService) {
        injectMarker(messageIsReadMarkerService, this.a.get());
    }
}
