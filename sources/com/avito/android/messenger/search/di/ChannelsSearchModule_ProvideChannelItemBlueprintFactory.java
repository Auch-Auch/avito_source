package com.avito.android.messenger.search.di;

import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsSearchModule_ProvideChannelItemBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<ChannelItemPresenter> a;

    public ChannelsSearchModule_ProvideChannelItemBlueprintFactory(Provider<ChannelItemPresenter> provider) {
        this.a = provider;
    }

    public static ChannelsSearchModule_ProvideChannelItemBlueprintFactory create(Provider<ChannelItemPresenter> provider) {
        return new ChannelsSearchModule_ProvideChannelItemBlueprintFactory(provider);
    }

    public static ItemBlueprint<?, ?> provideChannelItemBlueprint(ChannelItemPresenter channelItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.provideChannelItemBlueprint(channelItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideChannelItemBlueprint(this.a.get());
    }
}
