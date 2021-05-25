package com.avito.android.messenger.conversation.mvi.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class IncompleteMessageLoadingWorker_MembersInjector implements MembersInjector<IncompleteMessageLoadingWorker> {
    public final Provider<IncompleteMessageBodyLoader> a;

    public IncompleteMessageLoadingWorker_MembersInjector(Provider<IncompleteMessageBodyLoader> provider) {
        this.a = provider;
    }

    public static MembersInjector<IncompleteMessageLoadingWorker> create(Provider<IncompleteMessageBodyLoader> provider) {
        return new IncompleteMessageLoadingWorker_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingWorker.loader")
    public static void injectLoader(IncompleteMessageLoadingWorker incompleteMessageLoadingWorker, IncompleteMessageBodyLoader incompleteMessageBodyLoader) {
        incompleteMessageLoadingWorker.loader = incompleteMessageBodyLoader;
    }

    public void injectMembers(IncompleteMessageLoadingWorker incompleteMessageLoadingWorker) {
        injectLoader(incompleteMessageLoadingWorker, this.a.get());
    }
}
