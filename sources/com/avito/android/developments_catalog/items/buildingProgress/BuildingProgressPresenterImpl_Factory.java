package com.avito.android.developments_catalog.items.buildingProgress;

import dagger.internal.Factory;
public final class BuildingProgressPresenterImpl_Factory implements Factory<BuildingProgressPresenterImpl> {

    public static final class a {
        public static final BuildingProgressPresenterImpl_Factory a = new BuildingProgressPresenterImpl_Factory();
    }

    public static BuildingProgressPresenterImpl_Factory create() {
        return a.a;
    }

    public static BuildingProgressPresenterImpl newInstance() {
        return new BuildingProgressPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BuildingProgressPresenterImpl get() {
        return newInstance();
    }
}
