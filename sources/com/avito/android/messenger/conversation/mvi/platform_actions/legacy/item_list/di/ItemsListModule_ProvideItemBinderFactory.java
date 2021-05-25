package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ItemsListModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<ItemsListSnippetBlueprint> a;

    public ItemsListModule_ProvideItemBinderFactory(Provider<ItemsListSnippetBlueprint> provider) {
        this.a = provider;
    }

    public static ItemsListModule_ProvideItemBinderFactory create(Provider<ItemsListSnippetBlueprint> provider) {
        return new ItemsListModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(ItemsListSnippetBlueprint itemsListSnippetBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(ItemsListModule.provideItemBinder(itemsListSnippetBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
