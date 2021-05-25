package com.avito.android.section.complementary;

import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ComplementaryTitleWithActionBlueprint_Factory implements Factory<ComplementaryTitleWithActionBlueprint> {
    public final Provider<SectionTitleWithActionPresenter> a;

    public ComplementaryTitleWithActionBlueprint_Factory(Provider<SectionTitleWithActionPresenter> provider) {
        this.a = provider;
    }

    public static ComplementaryTitleWithActionBlueprint_Factory create(Provider<SectionTitleWithActionPresenter> provider) {
        return new ComplementaryTitleWithActionBlueprint_Factory(provider);
    }

    public static ComplementaryTitleWithActionBlueprint newInstance(SectionTitleWithActionPresenter sectionTitleWithActionPresenter) {
        return new ComplementaryTitleWithActionBlueprint(sectionTitleWithActionPresenter);
    }

    @Override // javax.inject.Provider
    public ComplementaryTitleWithActionBlueprint get() {
        return newInstance(this.a.get());
    }
}
