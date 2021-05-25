package com.avito.android.serp.adapter.empty_placeholder;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptyPlaceholderItemPresenterImpl_Factory implements Factory<EmptyPlaceholderItemPresenterImpl> {
    public final Provider<EmptyPlaceholderItemListener> a;

    public EmptyPlaceholderItemPresenterImpl_Factory(Provider<EmptyPlaceholderItemListener> provider) {
        this.a = provider;
    }

    public static EmptyPlaceholderItemPresenterImpl_Factory create(Provider<EmptyPlaceholderItemListener> provider) {
        return new EmptyPlaceholderItemPresenterImpl_Factory(provider);
    }

    public static EmptyPlaceholderItemPresenterImpl newInstance(Lazy<EmptyPlaceholderItemListener> lazy) {
        return new EmptyPlaceholderItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public EmptyPlaceholderItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
