package com.avito.android.booking.item.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DescriptionItemBlueprint_Factory implements Factory<DescriptionItemBlueprint> {
    public final Provider<DescriptionItemPresenter> a;

    public DescriptionItemBlueprint_Factory(Provider<DescriptionItemPresenter> provider) {
        this.a = provider;
    }

    public static DescriptionItemBlueprint_Factory create(Provider<DescriptionItemPresenter> provider) {
        return new DescriptionItemBlueprint_Factory(provider);
    }

    public static DescriptionItemBlueprint newInstance(DescriptionItemPresenter descriptionItemPresenter) {
        return new DescriptionItemBlueprint(descriptionItemPresenter);
    }

    @Override // javax.inject.Provider
    public DescriptionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
