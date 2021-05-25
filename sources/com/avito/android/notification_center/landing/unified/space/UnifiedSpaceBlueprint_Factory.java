package com.avito.android.notification_center.landing.unified.space;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedSpaceBlueprint_Factory implements Factory<UnifiedSpaceBlueprint> {
    public final Provider<UnifiedSpacePresenter> a;

    public UnifiedSpaceBlueprint_Factory(Provider<UnifiedSpacePresenter> provider) {
        this.a = provider;
    }

    public static UnifiedSpaceBlueprint_Factory create(Provider<UnifiedSpacePresenter> provider) {
        return new UnifiedSpaceBlueprint_Factory(provider);
    }

    public static UnifiedSpaceBlueprint newInstance(UnifiedSpacePresenter unifiedSpacePresenter) {
        return new UnifiedSpaceBlueprint(unifiedSpacePresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedSpaceBlueprint get() {
        return newInstance(this.a.get());
    }
}
