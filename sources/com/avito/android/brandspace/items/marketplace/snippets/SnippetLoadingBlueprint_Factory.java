package com.avito.android.brandspace.items.marketplace.snippets;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SnippetLoadingBlueprint_Factory implements Factory<SnippetLoadingBlueprint> {
    public final Provider<SnippetLoadingPresenter> a;

    public SnippetLoadingBlueprint_Factory(Provider<SnippetLoadingPresenter> provider) {
        this.a = provider;
    }

    public static SnippetLoadingBlueprint_Factory create(Provider<SnippetLoadingPresenter> provider) {
        return new SnippetLoadingBlueprint_Factory(provider);
    }

    public static SnippetLoadingBlueprint newInstance(SnippetLoadingPresenter snippetLoadingPresenter) {
        return new SnippetLoadingBlueprint(snippetLoadingPresenter);
    }

    @Override // javax.inject.Provider
    public SnippetLoadingBlueprint get() {
        return newInstance(this.a.get());
    }
}
