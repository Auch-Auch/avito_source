package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePaginationInProgressBlueprint$messenger_releaseFactory implements Factory<PaginationInProgressBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PaginationInProgressPresenter> b;

    public MessageAdapterModule_ProvidePaginationInProgressBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PaginationInProgressPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePaginationInProgressBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PaginationInProgressPresenter> provider) {
        return new MessageAdapterModule_ProvidePaginationInProgressBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PaginationInProgressBlueprint providePaginationInProgressBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PaginationInProgressPresenter paginationInProgressPresenter) {
        return (PaginationInProgressBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePaginationInProgressBlueprint$messenger_release(paginationInProgressPresenter));
    }

    @Override // javax.inject.Provider
    public PaginationInProgressBlueprint get() {
        return providePaginationInProgressBlueprint$messenger_release(this.a, this.b.get());
    }
}
