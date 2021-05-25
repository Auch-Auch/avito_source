package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ItemsListModule_ProvideItemsListSnippetPresenterFactory implements Factory<ItemsListSnippetPresenter> {
    public final Provider<ItemsListPresenter> a;

    public ItemsListModule_ProvideItemsListSnippetPresenterFactory(Provider<ItemsListPresenter> provider) {
        this.a = provider;
    }

    public static ItemsListModule_ProvideItemsListSnippetPresenterFactory create(Provider<ItemsListPresenter> provider) {
        return new ItemsListModule_ProvideItemsListSnippetPresenterFactory(provider);
    }

    public static ItemsListSnippetPresenter provideItemsListSnippetPresenter(Lazy<ItemsListPresenter> lazy) {
        return (ItemsListSnippetPresenter) Preconditions.checkNotNullFromProvides(ItemsListModule.provideItemsListSnippetPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public ItemsListSnippetPresenter get() {
        return provideItemsListSnippetPresenter(DoubleCheck.lazy(this.a));
    }
}
