package com.avito.android.section.title_with_action;

import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.title.SectionTitleItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SectionTitleWithActionPresenterImpl_Factory implements Factory<SectionTitleWithActionPresenterImpl> {
    public final Provider<SectionTitleItemPresenter> a;
    public final Provider<SectionActionPresenter> b;

    public SectionTitleWithActionPresenterImpl_Factory(Provider<SectionTitleItemPresenter> provider, Provider<SectionActionPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SectionTitleWithActionPresenterImpl_Factory create(Provider<SectionTitleItemPresenter> provider, Provider<SectionActionPresenter> provider2) {
        return new SectionTitleWithActionPresenterImpl_Factory(provider, provider2);
    }

    public static SectionTitleWithActionPresenterImpl newInstance(SectionTitleItemPresenter sectionTitleItemPresenter, SectionActionPresenter sectionActionPresenter) {
        return new SectionTitleWithActionPresenterImpl(sectionTitleItemPresenter, sectionActionPresenter);
    }

    @Override // javax.inject.Provider
    public SectionTitleWithActionPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
