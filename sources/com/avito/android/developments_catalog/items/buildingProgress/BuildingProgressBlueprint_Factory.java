package com.avito.android.developments_catalog.items.buildingProgress;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BuildingProgressBlueprint_Factory implements Factory<BuildingProgressBlueprint> {
    public final Provider<BuildingProgressPresenter> a;

    public BuildingProgressBlueprint_Factory(Provider<BuildingProgressPresenter> provider) {
        this.a = provider;
    }

    public static BuildingProgressBlueprint_Factory create(Provider<BuildingProgressPresenter> provider) {
        return new BuildingProgressBlueprint_Factory(provider);
    }

    public static BuildingProgressBlueprint newInstance(BuildingProgressPresenter buildingProgressPresenter) {
        return new BuildingProgressBlueprint(buildingProgressPresenter);
    }

    @Override // javax.inject.Provider
    public BuildingProgressBlueprint get() {
        return newInstance(this.a.get());
    }
}
