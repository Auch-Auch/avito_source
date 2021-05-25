package com.avito.android.serp.adapter.snippet;

import com.avito.android.serp.adapter.snippet.SnippetPresenter;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Pair;
public final class SnippetPresenter_Impl_Factory implements Factory<SnippetPresenter.Impl> {
    public final Provider<Relay<Pair<SnippetItem, Integer>>> a;
    public final Provider<Relay<Pair<SnippetItem, Integer>>> b;
    public final Provider<Relay<Pair<SnippetItem, Boolean>>> c;

    public SnippetPresenter_Impl_Factory(Provider<Relay<Pair<SnippetItem, Integer>>> provider, Provider<Relay<Pair<SnippetItem, Integer>>> provider2, Provider<Relay<Pair<SnippetItem, Boolean>>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SnippetPresenter_Impl_Factory create(Provider<Relay<Pair<SnippetItem, Integer>>> provider, Provider<Relay<Pair<SnippetItem, Integer>>> provider2, Provider<Relay<Pair<SnippetItem, Boolean>>> provider3) {
        return new SnippetPresenter_Impl_Factory(provider, provider2, provider3);
    }

    public static SnippetPresenter.Impl newInstance(Relay<Pair<SnippetItem, Integer>> relay, Relay<Pair<SnippetItem, Integer>> relay2, Relay<Pair<SnippetItem, Boolean>> relay3) {
        return new SnippetPresenter.Impl(relay, relay2, relay3);
    }

    @Override // javax.inject.Provider
    public SnippetPresenter.Impl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
