package com.avito.android.similar_adverts.adapter;

import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarTitleWithActionBlueprint_Factory implements Factory<SimilarTitleWithActionBlueprint> {
    public final Provider<SectionTitleWithActionPresenter> a;

    public SimilarTitleWithActionBlueprint_Factory(Provider<SectionTitleWithActionPresenter> provider) {
        this.a = provider;
    }

    public static SimilarTitleWithActionBlueprint_Factory create(Provider<SectionTitleWithActionPresenter> provider) {
        return new SimilarTitleWithActionBlueprint_Factory(provider);
    }

    public static SimilarTitleWithActionBlueprint newInstance(SectionTitleWithActionPresenter sectionTitleWithActionPresenter) {
        return new SimilarTitleWithActionBlueprint(sectionTitleWithActionPresenter);
    }

    @Override // javax.inject.Provider
    public SimilarTitleWithActionBlueprint get() {
        return newInstance(this.a.get());
    }
}
