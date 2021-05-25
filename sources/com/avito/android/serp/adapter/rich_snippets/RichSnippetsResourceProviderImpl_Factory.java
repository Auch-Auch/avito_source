package com.avito.android.serp.adapter.rich_snippets;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RichSnippetsResourceProviderImpl_Factory implements Factory<RichSnippetsResourceProviderImpl> {
    public final Provider<Resources> a;

    public RichSnippetsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static RichSnippetsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new RichSnippetsResourceProviderImpl_Factory(provider);
    }

    public static RichSnippetsResourceProviderImpl newInstance(Resources resources) {
        return new RichSnippetsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public RichSnippetsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
