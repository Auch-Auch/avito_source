package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetBlueprint;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ItemsListModule_ProvideItemsListSnippetBlueprintFactory implements Factory<ItemsListSnippetBlueprint> {
    public final Provider<ItemsListSnippetPresenter> a;

    public ItemsListModule_ProvideItemsListSnippetBlueprintFactory(Provider<ItemsListSnippetPresenter> provider) {
        this.a = provider;
    }

    public static ItemsListModule_ProvideItemsListSnippetBlueprintFactory create(Provider<ItemsListSnippetPresenter> provider) {
        return new ItemsListModule_ProvideItemsListSnippetBlueprintFactory(provider);
    }

    public static ItemsListSnippetBlueprint provideItemsListSnippetBlueprint(ItemsListSnippetPresenter itemsListSnippetPresenter) {
        return (ItemsListSnippetBlueprint) Preconditions.checkNotNullFromProvides(ItemsListModule.provideItemsListSnippetBlueprint(itemsListSnippetPresenter));
    }

    @Override // javax.inject.Provider
    public ItemsListSnippetBlueprint get() {
        return provideItemsListSnippetBlueprint(this.a.get());
    }
}
