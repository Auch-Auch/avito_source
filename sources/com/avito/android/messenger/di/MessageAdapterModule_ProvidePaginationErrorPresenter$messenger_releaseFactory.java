package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorPresenter;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePaginationErrorPresenter$messenger_releaseFactory implements Factory<PaginationErrorPresenter> {
    public final MessageAdapterModule a;
    public final Provider<PaginationErrorView.Listener> b;

    public MessageAdapterModule_ProvidePaginationErrorPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PaginationErrorView.Listener> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePaginationErrorPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PaginationErrorView.Listener> provider) {
        return new MessageAdapterModule_ProvidePaginationErrorPresenter$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PaginationErrorPresenter providePaginationErrorPresenter$messenger_release(MessageAdapterModule messageAdapterModule, Lazy<PaginationErrorView.Listener> lazy) {
        return (PaginationErrorPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePaginationErrorPresenter$messenger_release(lazy));
    }

    @Override // javax.inject.Provider
    public PaginationErrorPresenter get() {
        return providePaginationErrorPresenter$messenger_release(this.a, DoubleCheck.lazy(this.b));
    }
}
