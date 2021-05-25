package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ItemsListModule_ProvideItemsListPresenterFactory implements Factory<ItemsListPresenter> {
    public final Provider<ChannelFragment> a;
    public final Provider<ViewModelFactory> b;

    public ItemsListModule_ProvideItemsListPresenterFactory(Provider<ChannelFragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ItemsListModule_ProvideItemsListPresenterFactory create(Provider<ChannelFragment> provider, Provider<ViewModelFactory> provider2) {
        return new ItemsListModule_ProvideItemsListPresenterFactory(provider, provider2);
    }

    public static ItemsListPresenter provideItemsListPresenter(ChannelFragment channelFragment, ViewModelFactory viewModelFactory) {
        return (ItemsListPresenter) Preconditions.checkNotNullFromProvides(ItemsListModule.provideItemsListPresenter(channelFragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ItemsListPresenter get() {
        return provideItemsListPresenter(this.a.get(), this.b.get());
    }
}
