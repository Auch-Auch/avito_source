package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.SortedSet;
import javax.inject.Provider;
import kotlin.Pair;
public final class ChannelsListModule_ProvideChannelsListInteractorFactory implements Factory<ChannelsListInteractor> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> c;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> d;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> e;

    public ChannelsListModule_ProvideChannelsListInteractorFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider3, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider4, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ChannelsListModule_ProvideChannelsListInteractorFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider3, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider4, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider5) {
        return new ChannelsListModule_ProvideChannelsListInteractorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ChannelsListInteractor provideChannelsListInteractor(ViewModelFactory viewModelFactory, Fragment fragment, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3) {
        return (ChannelsListInteractor) Preconditions.checkNotNullFromProvides(ChannelsListModule.INSTANCE.provideChannelsListInteractor(viewModelFactory, fragment, pair, pair2, pair3));
    }

    @Override // javax.inject.Provider
    public ChannelsListInteractor get() {
        return provideChannelsListInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
