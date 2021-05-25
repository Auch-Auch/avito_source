package com.avito.android.search.map;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchMapIntentFactoryImpl_Factory implements Factory<SearchMapIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public SearchMapIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static SearchMapIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new SearchMapIntentFactoryImpl_Factory(provider);
    }

    public static SearchMapIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new SearchMapIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public SearchMapIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
