package com.avito.android.notification_center.landing.unified.image;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedImageBlueprint_Factory implements Factory<UnifiedImageBlueprint> {
    public final Provider<UnifiedImagePresenter> a;

    public UnifiedImageBlueprint_Factory(Provider<UnifiedImagePresenter> provider) {
        this.a = provider;
    }

    public static UnifiedImageBlueprint_Factory create(Provider<UnifiedImagePresenter> provider) {
        return new UnifiedImageBlueprint_Factory(provider);
    }

    public static UnifiedImageBlueprint newInstance(UnifiedImagePresenter unifiedImagePresenter) {
        return new UnifiedImageBlueprint(unifiedImagePresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedImageBlueprint get() {
        return newInstance(this.a.get());
    }
}
