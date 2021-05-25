package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorListenerFactory implements Factory<UpdateFolderTagsLinkProcessorListener> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvideUpdateFolderTagsLinkProcessorListenerFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static UpdateFolderTagsLinkProcessorListener provideUpdateFolderTagsLinkProcessorListener(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (UpdateFolderTagsLinkProcessorListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideUpdateFolderTagsLinkProcessorListener(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public UpdateFolderTagsLinkProcessorListener get() {
        return provideUpdateFolderTagsLinkProcessorListener(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
