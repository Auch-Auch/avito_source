package com.avito.android.serp.adapter.snippet;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SnippetBlueprint_Factory implements Factory<SnippetBlueprint> {
    public final Provider<SnippetPresenter> a;

    public SnippetBlueprint_Factory(Provider<SnippetPresenter> provider) {
        this.a = provider;
    }

    public static SnippetBlueprint_Factory create(Provider<SnippetPresenter> provider) {
        return new SnippetBlueprint_Factory(provider);
    }

    public static SnippetBlueprint newInstance(SnippetPresenter snippetPresenter) {
        return new SnippetBlueprint(snippetPresenter);
    }

    @Override // javax.inject.Provider
    public SnippetBlueprint get() {
        return newInstance(this.a.get());
    }
}
