package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ListItemPresenterImpl_Factory implements Factory<ListItemPresenterImpl> {
    public final Provider<Consumer<String>> a;

    public ListItemPresenterImpl_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static ListItemPresenterImpl_Factory create(Provider<Consumer<String>> provider) {
        return new ListItemPresenterImpl_Factory(provider);
    }

    public static ListItemPresenterImpl newInstance(Consumer<String> consumer) {
        return new ListItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ListItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
