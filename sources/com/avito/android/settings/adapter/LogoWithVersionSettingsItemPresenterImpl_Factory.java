package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class LogoWithVersionSettingsItemPresenterImpl_Factory implements Factory<LogoWithVersionSettingsItemPresenterImpl> {
    public final Provider<Consumer<String>> a;

    public LogoWithVersionSettingsItemPresenterImpl_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static LogoWithVersionSettingsItemPresenterImpl_Factory create(Provider<Consumer<String>> provider) {
        return new LogoWithVersionSettingsItemPresenterImpl_Factory(provider);
    }

    public static LogoWithVersionSettingsItemPresenterImpl newInstance(Consumer<String> consumer) {
        return new LogoWithVersionSettingsItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public LogoWithVersionSettingsItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
