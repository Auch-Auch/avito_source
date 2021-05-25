package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SelectSettingsItemPresenterImpl_Factory implements Factory<SelectSettingsItemPresenterImpl> {
    public final Provider<Consumer<String>> a;

    public SelectSettingsItemPresenterImpl_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static SelectSettingsItemPresenterImpl_Factory create(Provider<Consumer<String>> provider) {
        return new SelectSettingsItemPresenterImpl_Factory(provider);
    }

    public static SelectSettingsItemPresenterImpl newInstance(Consumer<String> consumer) {
        return new SelectSettingsItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SelectSettingsItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
