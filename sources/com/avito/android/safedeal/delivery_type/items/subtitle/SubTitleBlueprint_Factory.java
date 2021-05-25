package com.avito.android.safedeal.delivery_type.items.subtitle;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubTitleBlueprint_Factory implements Factory<SubTitleBlueprint> {
    public final Provider<SubTitlePresenter> a;

    public SubTitleBlueprint_Factory(Provider<SubTitlePresenter> provider) {
        this.a = provider;
    }

    public static SubTitleBlueprint_Factory create(Provider<SubTitlePresenter> provider) {
        return new SubTitleBlueprint_Factory(provider);
    }

    public static SubTitleBlueprint newInstance(SubTitlePresenter subTitlePresenter) {
        return new SubTitleBlueprint(subTitlePresenter);
    }

    @Override // javax.inject.Provider
    public SubTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
