package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MessageAdapterModule_ProvidePaginationInProgressPresenter$messenger_releaseFactory implements Factory<PaginationInProgressPresenter> {
    public final MessageAdapterModule a;

    public MessageAdapterModule_ProvidePaginationInProgressPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule) {
        this.a = messageAdapterModule;
    }

    public static MessageAdapterModule_ProvidePaginationInProgressPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule) {
        return new MessageAdapterModule_ProvidePaginationInProgressPresenter$messenger_releaseFactory(messageAdapterModule);
    }

    public static PaginationInProgressPresenter providePaginationInProgressPresenter$messenger_release(MessageAdapterModule messageAdapterModule) {
        return (PaginationInProgressPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePaginationInProgressPresenter$messenger_release());
    }

    @Override // javax.inject.Provider
    public PaginationInProgressPresenter get() {
        return providePaginationInProgressPresenter$messenger_release(this.a);
    }
}
