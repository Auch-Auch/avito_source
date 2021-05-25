package com.avito.android.home.tabs_item.di;

import com.avito.android.home.tabs_item.skeleton.SkeletonPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory implements Factory<SkeletonPresenter> {
    public final SectionTabsItemModule a;

    public SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory(SectionTabsItemModule sectionTabsItemModule) {
        this.a = sectionTabsItemModule;
    }

    public static SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory create(SectionTabsItemModule sectionTabsItemModule) {
        return new SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory(sectionTabsItemModule);
    }

    public static SkeletonPresenter provideSkeletonSectionTabsItemPresenter(SectionTabsItemModule sectionTabsItemModule) {
        return (SkeletonPresenter) Preconditions.checkNotNullFromProvides(sectionTabsItemModule.provideSkeletonSectionTabsItemPresenter());
    }

    @Override // javax.inject.Provider
    public SkeletonPresenter get() {
        return provideSkeletonSectionTabsItemPresenter(this.a);
    }
}
