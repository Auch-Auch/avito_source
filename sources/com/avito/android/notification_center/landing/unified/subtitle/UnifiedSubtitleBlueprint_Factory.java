package com.avito.android.notification_center.landing.unified.subtitle;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedSubtitleBlueprint_Factory implements Factory<UnifiedSubtitleBlueprint> {
    public final Provider<UnifiedSubtitlePresenter> a;

    public UnifiedSubtitleBlueprint_Factory(Provider<UnifiedSubtitlePresenter> provider) {
        this.a = provider;
    }

    public static UnifiedSubtitleBlueprint_Factory create(Provider<UnifiedSubtitlePresenter> provider) {
        return new UnifiedSubtitleBlueprint_Factory(provider);
    }

    public static UnifiedSubtitleBlueprint newInstance(UnifiedSubtitlePresenter unifiedSubtitlePresenter) {
        return new UnifiedSubtitleBlueprint(unifiedSubtitlePresenter);
    }

    @Override // javax.inject.Provider
    public UnifiedSubtitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
