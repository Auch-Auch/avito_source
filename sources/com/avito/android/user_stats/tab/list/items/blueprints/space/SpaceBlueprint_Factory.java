package com.avito.android.user_stats.tab.list.items.blueprints.space;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpaceBlueprint_Factory implements Factory<SpaceBlueprint> {
    public final Provider<SpaceItemPresenter> a;

    public SpaceBlueprint_Factory(Provider<SpaceItemPresenter> provider) {
        this.a = provider;
    }

    public static SpaceBlueprint_Factory create(Provider<SpaceItemPresenter> provider) {
        return new SpaceBlueprint_Factory(provider);
    }

    public static SpaceBlueprint newInstance(SpaceItemPresenter spaceItemPresenter) {
        return new SpaceBlueprint(spaceItemPresenter);
    }

    @Override // javax.inject.Provider
    public SpaceBlueprint get() {
        return newInstance(this.a.get());
    }
}
