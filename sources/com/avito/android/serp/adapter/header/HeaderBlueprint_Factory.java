package com.avito.android.serp.adapter.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HeaderBlueprint_Factory implements Factory<HeaderBlueprint> {
    public final Provider<HeaderPresenter> a;

    public HeaderBlueprint_Factory(Provider<HeaderPresenter> provider) {
        this.a = provider;
    }

    public static HeaderBlueprint_Factory create(Provider<HeaderPresenter> provider) {
        return new HeaderBlueprint_Factory(provider);
    }

    public static HeaderBlueprint newInstance(HeaderPresenter headerPresenter) {
        return new HeaderBlueprint(headerPresenter);
    }

    @Override // javax.inject.Provider
    public HeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
