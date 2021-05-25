package com.avito.android.advert_core.discount.item.information;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InformationItemBlueprint_Factory implements Factory<InformationItemBlueprint> {
    public final Provider<InformationItemPresenter> a;

    public InformationItemBlueprint_Factory(Provider<InformationItemPresenter> provider) {
        this.a = provider;
    }

    public static InformationItemBlueprint_Factory create(Provider<InformationItemPresenter> provider) {
        return new InformationItemBlueprint_Factory(provider);
    }

    public static InformationItemBlueprint newInstance(InformationItemPresenter informationItemPresenter) {
        return new InformationItemBlueprint(informationItemPresenter);
    }

    @Override // javax.inject.Provider
    public InformationItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
