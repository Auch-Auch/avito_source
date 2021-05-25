package com.avito.android.serp.adapter.warning;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpWarningItemBlueprint_Factory implements Factory<SerpWarningItemBlueprint> {
    public final Provider<SerpWarningItemPresenter> a;

    public SerpWarningItemBlueprint_Factory(Provider<SerpWarningItemPresenter> provider) {
        this.a = provider;
    }

    public static SerpWarningItemBlueprint_Factory create(Provider<SerpWarningItemPresenter> provider) {
        return new SerpWarningItemBlueprint_Factory(provider);
    }

    public static SerpWarningItemBlueprint newInstance(SerpWarningItemPresenter serpWarningItemPresenter) {
        return new SerpWarningItemBlueprint(serpWarningItemPresenter);
    }

    @Override // javax.inject.Provider
    public SerpWarningItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
