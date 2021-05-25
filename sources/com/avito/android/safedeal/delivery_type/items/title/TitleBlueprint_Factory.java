package com.avito.android.safedeal.delivery_type.items.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitleBlueprint_Factory implements Factory<TitleBlueprint> {
    public final Provider<TitlePresenter> a;

    public TitleBlueprint_Factory(Provider<TitlePresenter> provider) {
        this.a = provider;
    }

    public static TitleBlueprint_Factory create(Provider<TitlePresenter> provider) {
        return new TitleBlueprint_Factory(provider);
    }

    public static TitleBlueprint newInstance(TitlePresenter titlePresenter) {
        return new TitleBlueprint(titlePresenter);
    }

    @Override // javax.inject.Provider
    public TitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
