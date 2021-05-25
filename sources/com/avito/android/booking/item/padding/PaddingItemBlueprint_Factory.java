package com.avito.android.booking.item.padding;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaddingItemBlueprint_Factory implements Factory<PaddingItemBlueprint> {
    public final Provider<PaddingItemPresenter> a;

    public PaddingItemBlueprint_Factory(Provider<PaddingItemPresenter> provider) {
        this.a = provider;
    }

    public static PaddingItemBlueprint_Factory create(Provider<PaddingItemPresenter> provider) {
        return new PaddingItemBlueprint_Factory(provider);
    }

    public static PaddingItemBlueprint newInstance(PaddingItemPresenter paddingItemPresenter) {
        return new PaddingItemBlueprint(paddingItemPresenter);
    }

    @Override // javax.inject.Provider
    public PaddingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
