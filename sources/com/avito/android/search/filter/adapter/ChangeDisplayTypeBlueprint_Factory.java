package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChangeDisplayTypeBlueprint_Factory implements Factory<ChangeDisplayTypeBlueprint> {
    public final Provider<ChangeDisplayTypePresenter> a;

    public ChangeDisplayTypeBlueprint_Factory(Provider<ChangeDisplayTypePresenter> provider) {
        this.a = provider;
    }

    public static ChangeDisplayTypeBlueprint_Factory create(Provider<ChangeDisplayTypePresenter> provider) {
        return new ChangeDisplayTypeBlueprint_Factory(provider);
    }

    public static ChangeDisplayTypeBlueprint newInstance(ChangeDisplayTypePresenter changeDisplayTypePresenter) {
        return new ChangeDisplayTypeBlueprint(changeDisplayTypePresenter);
    }

    @Override // javax.inject.Provider
    public ChangeDisplayTypeBlueprint get() {
        return newInstance(this.a.get());
    }
}
