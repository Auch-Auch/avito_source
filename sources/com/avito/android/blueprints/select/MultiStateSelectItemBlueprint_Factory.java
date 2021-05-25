package com.avito.android.blueprints.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiStateSelectItemBlueprint_Factory implements Factory<MultiStateSelectItemBlueprint> {
    public final Provider<MultiStateSelectItemPresenter> a;

    public MultiStateSelectItemBlueprint_Factory(Provider<MultiStateSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static MultiStateSelectItemBlueprint_Factory create(Provider<MultiStateSelectItemPresenter> provider) {
        return new MultiStateSelectItemBlueprint_Factory(provider);
    }

    public static MultiStateSelectItemBlueprint newInstance(MultiStateSelectItemPresenter multiStateSelectItemPresenter) {
        return new MultiStateSelectItemBlueprint(multiStateSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public MultiStateSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
