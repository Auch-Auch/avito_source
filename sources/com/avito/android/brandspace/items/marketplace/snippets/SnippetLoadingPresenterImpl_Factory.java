package com.avito.android.brandspace.items.marketplace.snippets;

import dagger.internal.Factory;
public final class SnippetLoadingPresenterImpl_Factory implements Factory<SnippetLoadingPresenterImpl> {

    public static final class a {
        public static final SnippetLoadingPresenterImpl_Factory a = new SnippetLoadingPresenterImpl_Factory();
    }

    public static SnippetLoadingPresenterImpl_Factory create() {
        return a.a;
    }

    public static SnippetLoadingPresenterImpl newInstance() {
        return new SnippetLoadingPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SnippetLoadingPresenterImpl get() {
        return newInstance();
    }
}
