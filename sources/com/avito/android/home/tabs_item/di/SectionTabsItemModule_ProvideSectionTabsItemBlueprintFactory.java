package com.avito.android.home.tabs_item.di;

import com.avito.android.home.tabs_item.SectionTabsItemBlueprint;
import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory implements Factory<SectionTabsItemBlueprint> {
    public final SectionTabsItemModule a;
    public final Provider<SectionTabsItemPresenter> b;
    public final Provider<Preferences> c;

    public SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory(SectionTabsItemModule sectionTabsItemModule, Provider<SectionTabsItemPresenter> provider, Provider<Preferences> provider2) {
        this.a = sectionTabsItemModule;
        this.b = provider;
        this.c = provider2;
    }

    public static SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory create(SectionTabsItemModule sectionTabsItemModule, Provider<SectionTabsItemPresenter> provider, Provider<Preferences> provider2) {
        return new SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory(sectionTabsItemModule, provider, provider2);
    }

    public static SectionTabsItemBlueprint provideSectionTabsItemBlueprint(SectionTabsItemModule sectionTabsItemModule, SectionTabsItemPresenter sectionTabsItemPresenter, Preferences preferences) {
        return (SectionTabsItemBlueprint) Preconditions.checkNotNullFromProvides(sectionTabsItemModule.provideSectionTabsItemBlueprint(sectionTabsItemPresenter, preferences));
    }

    @Override // javax.inject.Provider
    public SectionTabsItemBlueprint get() {
        return provideSectionTabsItemBlueprint(this.a, this.b.get(), this.c.get());
    }
}
