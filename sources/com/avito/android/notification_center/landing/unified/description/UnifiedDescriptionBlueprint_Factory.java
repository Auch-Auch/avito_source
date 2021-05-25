package com.avito.android.notification_center.landing.unified.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedDescriptionBlueprint_Factory implements Factory<UnifiedDescriptionBlueprint> {
    public final Provider<UnifiedDescriptionPresenter> a;

    public UnifiedDescriptionBlueprint_Factory(Provider<UnifiedDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static UnifiedDescriptionBlueprint_Factory create(Provider<UnifiedDescriptionPresenter> provider) {
        return new UnifiedDescriptionBlueprint_Factory(provider);
    }

    public static UnifiedDescriptionBlueprint newInstance(UnifiedDescriptionPresenter unifiedDescriptionPresenter) {
        return new UnifiedDescriptionBlueprint(unifiedDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedDescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
