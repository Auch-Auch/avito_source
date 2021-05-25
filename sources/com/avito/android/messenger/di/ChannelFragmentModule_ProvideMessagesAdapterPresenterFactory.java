package com.avito.android.messenger.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessagesAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final ChannelFragmentModule a;
    public final Provider<ItemBinder> b;

    public ChannelFragmentModule_ProvideMessagesAdapterPresenterFactory(ChannelFragmentModule channelFragmentModule, Provider<ItemBinder> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideMessagesAdapterPresenterFactory create(ChannelFragmentModule channelFragmentModule, Provider<ItemBinder> provider) {
        return new ChannelFragmentModule_ProvideMessagesAdapterPresenterFactory(channelFragmentModule, provider);
    }

    public static AdapterPresenter provideMessagesAdapterPresenter(ChannelFragmentModule channelFragmentModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessagesAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideMessagesAdapterPresenter(this.a, this.b.get());
    }
}
