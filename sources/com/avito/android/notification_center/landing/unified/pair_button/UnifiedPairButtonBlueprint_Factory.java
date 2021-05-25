package com.avito.android.notification_center.landing.unified.pair_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedPairButtonBlueprint_Factory implements Factory<UnifiedPairButtonBlueprint> {
    public final Provider<UnifiedPairButtonPresenter> a;

    public UnifiedPairButtonBlueprint_Factory(Provider<UnifiedPairButtonPresenter> provider) {
        this.a = provider;
    }

    public static UnifiedPairButtonBlueprint_Factory create(Provider<UnifiedPairButtonPresenter> provider) {
        return new UnifiedPairButtonBlueprint_Factory(provider);
    }

    public static UnifiedPairButtonBlueprint newInstance(UnifiedPairButtonPresenter unifiedPairButtonPresenter) {
        return new UnifiedPairButtonBlueprint(unifiedPairButtonPresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedPairButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
