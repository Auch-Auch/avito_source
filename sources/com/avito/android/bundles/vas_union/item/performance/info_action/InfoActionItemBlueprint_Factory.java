package com.avito.android.bundles.vas_union.item.performance.info_action;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoActionItemBlueprint_Factory implements Factory<InfoActionItemBlueprint> {
    public final Provider<InfoActionItemPresenter> a;

    public InfoActionItemBlueprint_Factory(Provider<InfoActionItemPresenter> provider) {
        this.a = provider;
    }

    public static InfoActionItemBlueprint_Factory create(Provider<InfoActionItemPresenter> provider) {
        return new InfoActionItemBlueprint_Factory(provider);
    }

    public static InfoActionItemBlueprint newInstance(InfoActionItemPresenter infoActionItemPresenter) {
        return new InfoActionItemBlueprint(infoActionItemPresenter);
    }

    @Override // javax.inject.Provider
    public InfoActionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
