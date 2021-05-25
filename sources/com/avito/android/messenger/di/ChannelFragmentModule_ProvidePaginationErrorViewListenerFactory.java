package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidePaginationErrorViewListenerFactory implements Factory<PaginationErrorView.Listener> {
    public final ChannelFragmentModule a;
    public final Provider<MessageListPresenter> b;

    public ChannelFragmentModule_ProvidePaginationErrorViewListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvidePaginationErrorViewListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        return new ChannelFragmentModule_ProvidePaginationErrorViewListenerFactory(channelFragmentModule, provider);
    }

    public static PaginationErrorView.Listener providePaginationErrorViewListener(ChannelFragmentModule channelFragmentModule, Lazy<MessageListPresenter> lazy) {
        return (PaginationErrorView.Listener) Preconditions.checkNotNullFromProvides(channelFragmentModule.providePaginationErrorViewListener(lazy));
    }

    @Override // javax.inject.Provider
    public PaginationErrorView.Listener get() {
        return providePaginationErrorViewListener(this.a, DoubleCheck.lazy(this.b));
    }
}
