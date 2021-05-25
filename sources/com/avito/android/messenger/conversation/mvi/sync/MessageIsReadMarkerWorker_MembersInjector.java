package com.avito.android.messenger.conversation.mvi.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MessageIsReadMarkerWorker_MembersInjector implements MembersInjector<MessageIsReadMarkerWorker> {
    public final Provider<MessageIsReadMarker> a;

    public MessageIsReadMarkerWorker_MembersInjector(Provider<MessageIsReadMarker> provider) {
        this.a = provider;
    }

    public static MembersInjector<MessageIsReadMarkerWorker> create(Provider<MessageIsReadMarker> provider) {
        return new MessageIsReadMarkerWorker_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerWorker.marker")
    public static void injectMarker(MessageIsReadMarkerWorker messageIsReadMarkerWorker, MessageIsReadMarker messageIsReadMarker) {
        messageIsReadMarkerWorker.marker = messageIsReadMarker;
    }

    public void injectMembers(MessageIsReadMarkerWorker messageIsReadMarkerWorker) {
        injectMarker(messageIsReadMarkerWorker, this.a.get());
    }
}
