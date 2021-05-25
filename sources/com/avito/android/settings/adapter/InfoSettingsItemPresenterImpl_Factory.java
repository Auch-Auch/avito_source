package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class InfoSettingsItemPresenterImpl_Factory implements Factory<InfoSettingsItemPresenterImpl> {
    public final Provider<Consumer<String>> a;

    public InfoSettingsItemPresenterImpl_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static InfoSettingsItemPresenterImpl_Factory create(Provider<Consumer<String>> provider) {
        return new InfoSettingsItemPresenterImpl_Factory(provider);
    }

    public static InfoSettingsItemPresenterImpl newInstance(Consumer<String> consumer) {
        return new InfoSettingsItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public InfoSettingsItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
