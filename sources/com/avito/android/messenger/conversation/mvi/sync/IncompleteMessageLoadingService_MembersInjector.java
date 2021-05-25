package com.avito.android.messenger.conversation.mvi.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class IncompleteMessageLoadingService_MembersInjector implements MembersInjector<IncompleteMessageLoadingService> {
    public final Provider<IncompleteMessageBodyLoader> a;

    public IncompleteMessageLoadingService_MembersInjector(Provider<IncompleteMessageBodyLoader> provider) {
        this.a = provider;
    }

    public static MembersInjector<IncompleteMessageLoadingService> create(Provider<IncompleteMessageBodyLoader> provider) {
        return new IncompleteMessageLoadingService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageLoadingService.loader")
    public static void injectLoader(IncompleteMessageLoadingService incompleteMessageLoadingService, IncompleteMessageBodyLoader incompleteMessageBodyLoader) {
        incompleteMessageLoadingService.loader = incompleteMessageBodyLoader;
    }

    public void injectMembers(IncompleteMessageLoadingService incompleteMessageLoadingService) {
        injectLoader(incompleteMessageLoadingService, this.a.get());
    }
}
