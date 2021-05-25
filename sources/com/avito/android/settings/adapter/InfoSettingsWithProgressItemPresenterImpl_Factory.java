package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class InfoSettingsWithProgressItemPresenterImpl_Factory implements Factory<InfoSettingsWithProgressItemPresenterImpl> {
    public final Provider<Consumer<String>> a;

    public InfoSettingsWithProgressItemPresenterImpl_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static InfoSettingsWithProgressItemPresenterImpl_Factory create(Provider<Consumer<String>> provider) {
        return new InfoSettingsWithProgressItemPresenterImpl_Factory(provider);
    }

    public static InfoSettingsWithProgressItemPresenterImpl newInstance(Consumer<String> consumer) {
        return new InfoSettingsWithProgressItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public InfoSettingsWithProgressItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
