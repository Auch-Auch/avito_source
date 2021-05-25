package com.avito.android.vas_discount.ui.items.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DescriptionItemBlueprint_Factory implements Factory<DescriptionItemBlueprint> {
    public final Provider<DescriptionPresenter> a;

    public DescriptionItemBlueprint_Factory(Provider<DescriptionPresenter> provider) {
        this.a = provider;
    }

    public static DescriptionItemBlueprint_Factory create(Provider<DescriptionPresenter> provider) {
        return new DescriptionItemBlueprint_Factory(provider);
    }

    public static DescriptionItemBlueprint newInstance(DescriptionPresenter descriptionPresenter) {
        return new DescriptionItemBlueprint(descriptionPresenter);
    }

    @Override // javax.inject.Provider
    public DescriptionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
