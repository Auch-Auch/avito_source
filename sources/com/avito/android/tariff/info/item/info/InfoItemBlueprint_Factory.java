package com.avito.android.tariff.info.item.info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoItemBlueprint_Factory implements Factory<InfoItemBlueprint> {
    public final Provider<InfoItemPresenter> a;

    public InfoItemBlueprint_Factory(Provider<InfoItemPresenter> provider) {
        this.a = provider;
    }

    public static InfoItemBlueprint_Factory create(Provider<InfoItemPresenter> provider) {
        return new InfoItemBlueprint_Factory(provider);
    }

    public static InfoItemBlueprint newInstance(InfoItemPresenter infoItemPresenter) {
        return new InfoItemBlueprint(infoItemPresenter);
    }

    @Override // javax.inject.Provider
    public InfoItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
