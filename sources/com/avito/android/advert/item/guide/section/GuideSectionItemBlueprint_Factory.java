package com.avito.android.advert.item.guide.section;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class GuideSectionItemBlueprint_Factory implements Factory<GuideSectionItemBlueprint> {
    public final Provider<GuideSectionItemPresenter> a;

    public GuideSectionItemBlueprint_Factory(Provider<GuideSectionItemPresenter> provider) {
        this.a = provider;
    }

    public static GuideSectionItemBlueprint_Factory create(Provider<GuideSectionItemPresenter> provider) {
        return new GuideSectionItemBlueprint_Factory(provider);
    }

    public static GuideSectionItemBlueprint newInstance(GuideSectionItemPresenter guideSectionItemPresenter) {
        return new GuideSectionItemBlueprint(guideSectionItemPresenter);
    }

    @Override // javax.inject.Provider
    public GuideSectionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
