package com.avito.android.cart.summary.konveyor.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HeaderItemBlueprint_Factory implements Factory<HeaderItemBlueprint> {
    public final Provider<HeaderItemPresenter> a;

    public HeaderItemBlueprint_Factory(Provider<HeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static HeaderItemBlueprint_Factory create(Provider<HeaderItemPresenter> provider) {
        return new HeaderItemBlueprint_Factory(provider);
    }

    public static HeaderItemBlueprint newInstance(HeaderItemPresenter headerItemPresenter) {
        return new HeaderItemBlueprint(headerItemPresenter);
    }

    @Override // javax.inject.Provider
    public HeaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
