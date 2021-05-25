package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.SortedSet;
import javax.inject.Provider;
import kotlin.Pair;
public final class ChannelsListModule_ProvideChannelsLastMessageProviderFactory implements Factory<ChannelsLastMessageProvider> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> c;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> d;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> e;

    public ChannelsListModule_ProvideChannelsLastMessageProviderFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider3, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider4, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ChannelsListModule_ProvideChannelsLastMessageProviderFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider3, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider4, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider5) {
        return new ChannelsListModule_ProvideChannelsLastMessageProviderFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ChannelsLastMessageProvider provideChannelsLastMessageProvider(ViewModelFactory viewModelFactory, Fragment fragment, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        return (ChannelsLastMessageProvider) Preconditions.checkNotNullFromProvides(ChannelsListModule.INSTANCE.provideChannelsLastMessageProvider(viewModelFactory, fragment, pair, pair2, pair3));
    }

    @Override // javax.inject.Provider
    public ChannelsLastMessageProvider get() {
        return provideChannelsLastMessageProvider(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
