package com.avito.android.serp.adapter.rich_snippets;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class RichSnippetStateProviderProxy_Factory implements Factory<RichSnippetStateProviderProxy> {
    public final Provider<Set<RichSnippetStateProvider>> a;

    public RichSnippetStateProviderProxy_Factory(Provider<Set<RichSnippetStateProvider>> provider) {
        this.a = provider;
    }

    public static RichSnippetStateProviderProxy_Factory create(Provider<Set<RichSnippetStateProvider>> provider) {
        return new RichSnippetStateProviderProxy_Factory(provider);
    }

    public static RichSnippetStateProviderProxy newInstance(Set<RichSnippetStateProvider> set) {
        return new RichSnippetStateProviderProxy(set);
    }

    @Override // javax.inject.Provider
    public RichSnippetStateProviderProxy get() {
        return newInstance(this.a.get());
    }
}
