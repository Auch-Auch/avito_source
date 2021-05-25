package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePaginationErrorBlueprint$messenger_releaseFactory implements Factory<PaginationErrorBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PaginationErrorPresenter> b;

    public MessageAdapterModule_ProvidePaginationErrorBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PaginationErrorPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePaginationErrorBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PaginationErrorPresenter> provider) {
        return new MessageAdapterModule_ProvidePaginationErrorBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PaginationErrorBlueprint providePaginationErrorBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PaginationErrorPresenter paginationErrorPresenter) {
        return (PaginationErrorBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePaginationErrorBlueprint$messenger_release(paginationErrorPresenter));
    }

    @Override // javax.inject.Provider
    public PaginationErrorBlueprint get() {
        return providePaginationErrorBlueprint$messenger_release(this.a, this.b.get());
    }
}
