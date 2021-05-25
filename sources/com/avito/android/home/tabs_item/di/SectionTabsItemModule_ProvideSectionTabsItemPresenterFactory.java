package com.avito.android.home.tabs_item.di;

import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory implements Factory<SectionTabsItemPresenter> {
    public final SectionTabsItemModule a;

    public SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory(SectionTabsItemModule sectionTabsItemModule) {
        this.a = sectionTabsItemModule;
    }

    public static SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory create(SectionTabsItemModule sectionTabsItemModule) {
        return new SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory(sectionTabsItemModule);
    }

    public static SectionTabsItemPresenter provideSectionTabsItemPresenter(SectionTabsItemModule sectionTabsItemModule) {
        return (SectionTabsItemPresenter) Preconditions.checkNotNullFromProvides(sectionTabsItemModule.provideSectionTabsItemPresenter());
    }

    @Override // javax.inject.Provider
    public SectionTabsItemPresenter get() {
        return provideSectionTabsItemPresenter(this.a);
    }
}
