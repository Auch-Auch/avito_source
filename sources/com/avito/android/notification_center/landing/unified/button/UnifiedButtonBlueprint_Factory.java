package com.avito.android.notification_center.landing.unified.button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedButtonBlueprint_Factory implements Factory<UnifiedButtonBlueprint> {
    public final Provider<UnifiedButtonPresenter> a;

    public UnifiedButtonBlueprint_Factory(Provider<UnifiedButtonPresenter> provider) {
        this.a = provider;
    }

    public static UnifiedButtonBlueprint_Factory create(Provider<UnifiedButtonPresenter> provider) {
        return new UnifiedButtonBlueprint_Factory(provider);
    }

    public static UnifiedButtonBlueprint newInstance(UnifiedButtonPresenter unifiedButtonPresenter) {
        return new UnifiedButtonBlueprint(unifiedButtonPresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
