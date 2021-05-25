package com.avito.android.notification_center.landing.unified.divider;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedDividerBlueprint_Factory implements Factory<UnifiedDividerBlueprint> {
    public final Provider<UnifiedDividerPresenter> a;

    public UnifiedDividerBlueprint_Factory(Provider<UnifiedDividerPresenter> provider) {
        this.a = provider;
    }

    public static UnifiedDividerBlueprint_Factory create(Provider<UnifiedDividerPresenter> provider) {
        return new UnifiedDividerBlueprint_Factory(provider);
    }

    public static UnifiedDividerBlueprint newInstance(UnifiedDividerPresenter unifiedDividerPresenter) {
        return new UnifiedDividerBlueprint(unifiedDividerPresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedDividerBlueprint get() {
        return newInstance(this.a.get());
    }
}
