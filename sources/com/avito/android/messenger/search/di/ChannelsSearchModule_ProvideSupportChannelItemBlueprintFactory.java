package com.avito.android.messenger.search.di;

import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsSearchModule_ProvideSupportChannelItemBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<SupportChannelItemPresenter> a;

    public ChannelsSearchModule_ProvideSupportChannelItemBlueprintFactory(Provider<SupportChannelItemPresenter> provider) {
        this.a = provider;
    }

    public static ChannelsSearchModule_ProvideSupportChannelItemBlueprintFactory create(Provider<SupportChannelItemPresenter> provider) {
        return new ChannelsSearchModule_ProvideSupportChannelItemBlueprintFactory(provider);
    }

    public static ItemBlueprint<?, ?> provideSupportChannelItemBlueprint(SupportChannelItemPresenter supportChannelItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.provideSupportChannelItemBlueprint(supportChannelItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideSupportChannelItemBlueprint(this.a.get());
    }
}
