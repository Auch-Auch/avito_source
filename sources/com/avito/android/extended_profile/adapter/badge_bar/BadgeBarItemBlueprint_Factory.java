package com.avito.android.extended_profile.adapter.badge_bar;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BadgeBarItemBlueprint_Factory implements Factory<BadgeBarItemBlueprint> {
    public final Provider<BadgeBarItemPresenter> a;

    public BadgeBarItemBlueprint_Factory(Provider<BadgeBarItemPresenter> provider) {
        this.a = provider;
    }

    public static BadgeBarItemBlueprint_Factory create(Provider<BadgeBarItemPresenter> provider) {
        return new BadgeBarItemBlueprint_Factory(provider);
    }

    public static BadgeBarItemBlueprint newInstance(BadgeBarItemPresenter badgeBarItemPresenter) {
        return new BadgeBarItemBlueprint(badgeBarItemPresenter);
    }

    @Override // javax.inject.Provider
    public BadgeBarItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
