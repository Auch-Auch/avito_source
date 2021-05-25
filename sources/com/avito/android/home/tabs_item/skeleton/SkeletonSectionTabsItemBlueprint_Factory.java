package com.avito.android.home.tabs_item.skeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SkeletonSectionTabsItemBlueprint_Factory implements Factory<SkeletonSectionTabsItemBlueprint> {
    public final Provider<SkeletonPresenter> a;

    public SkeletonSectionTabsItemBlueprint_Factory(Provider<SkeletonPresenter> provider) {
        this.a = provider;
    }

    public static SkeletonSectionTabsItemBlueprint_Factory create(Provider<SkeletonPresenter> provider) {
        return new SkeletonSectionTabsItemBlueprint_Factory(provider);
    }

    public static SkeletonSectionTabsItemBlueprint newInstance(SkeletonPresenter skeletonPresenter) {
        return new SkeletonSectionTabsItemBlueprint(skeletonPresenter);
    }

    @Override // javax.inject.Provider
    public SkeletonSectionTabsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
