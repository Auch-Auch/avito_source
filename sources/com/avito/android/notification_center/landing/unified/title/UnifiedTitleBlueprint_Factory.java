package com.avito.android.notification_center.landing.unified.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedTitleBlueprint_Factory implements Factory<UnifiedTitleBlueprint> {
    public final Provider<UnifiedTitlePresenter> a;

    public UnifiedTitleBlueprint_Factory(Provider<UnifiedTitlePresenter> provider) {
        this.a = provider;
    }

    public static UnifiedTitleBlueprint_Factory create(Provider<UnifiedTitlePresenter> provider) {
        return new UnifiedTitleBlueprint_Factory(provider);
    }

    public static UnifiedTitleBlueprint newInstance(UnifiedTitlePresenter unifiedTitlePresenter) {
        return new UnifiedTitleBlueprint(unifiedTitlePresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
