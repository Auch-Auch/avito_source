package com.avito.android.advert_stats.item.hint;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HintItemBlueprint_Factory implements Factory<HintItemBlueprint> {
    public final Provider<HintItemPresenter> a;

    public HintItemBlueprint_Factory(Provider<HintItemPresenter> provider) {
        this.a = provider;
    }

    public static HintItemBlueprint_Factory create(Provider<HintItemPresenter> provider) {
        return new HintItemBlueprint_Factory(provider);
    }

    public static HintItemBlueprint newInstance(HintItemPresenter hintItemPresenter) {
        return new HintItemBlueprint(hintItemPresenter);
    }

    @Override // javax.inject.Provider
    public HintItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
