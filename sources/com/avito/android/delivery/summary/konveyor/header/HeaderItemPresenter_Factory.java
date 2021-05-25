package com.avito.android.delivery.summary.konveyor.header;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class HeaderItemPresenter_Factory implements Factory<HeaderItemPresenter> {
    public final Provider<Consumer<String>> a;

    public HeaderItemPresenter_Factory(Provider<Consumer<String>> provider) {
        this.a = provider;
    }

    public static HeaderItemPresenter_Factory create(Provider<Consumer<String>> provider) {
        return new HeaderItemPresenter_Factory(provider);
    }

    public static HeaderItemPresenter newInstance(Consumer<String> consumer) {
        return new HeaderItemPresenter(consumer);
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenter get() {
        return newInstance(this.a.get());
    }
}
