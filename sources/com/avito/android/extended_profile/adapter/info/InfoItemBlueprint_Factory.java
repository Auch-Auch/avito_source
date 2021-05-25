package com.avito.android.extended_profile.adapter.info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoItemBlueprint_Factory implements Factory<InfoItemBlueprint> {
    public final Provider<InfoItemPresenter> a;
    public final Provider<Boolean> b;

    public InfoItemBlueprint_Factory(Provider<InfoItemPresenter> provider, Provider<Boolean> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InfoItemBlueprint_Factory create(Provider<InfoItemPresenter> provider, Provider<Boolean> provider2) {
        return new InfoItemBlueprint_Factory(provider, provider2);
    }

    public static InfoItemBlueprint newInstance(InfoItemPresenter infoItemPresenter, boolean z) {
        return new InfoItemBlueprint(infoItemPresenter, z);
    }

    @Override // javax.inject.Provider
    public InfoItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get().booleanValue());
    }
}
