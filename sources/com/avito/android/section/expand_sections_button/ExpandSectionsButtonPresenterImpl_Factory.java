package com.avito.android.section.expand_sections_button;

import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.title.SectionTitleItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExpandSectionsButtonPresenterImpl_Factory implements Factory<ExpandSectionsButtonPresenterImpl> {
    public final Provider<SectionTitleItemPresenter> a;
    public final Provider<SectionActionPresenter> b;
    public final Provider<ExpandComplementarySectionsListener> c;

    public ExpandSectionsButtonPresenterImpl_Factory(Provider<SectionTitleItemPresenter> provider, Provider<SectionActionPresenter> provider2, Provider<ExpandComplementarySectionsListener> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ExpandSectionsButtonPresenterImpl_Factory create(Provider<SectionTitleItemPresenter> provider, Provider<SectionActionPresenter> provider2, Provider<ExpandComplementarySectionsListener> provider3) {
        return new ExpandSectionsButtonPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static ExpandSectionsButtonPresenterImpl newInstance(SectionTitleItemPresenter sectionTitleItemPresenter, SectionActionPresenter sectionActionPresenter, ExpandComplementarySectionsListener expandComplementarySectionsListener) {
        return new ExpandSectionsButtonPresenterImpl(sectionTitleItemPresenter, sectionActionPresenter, expandComplementarySectionsListener);
    }

    @Override // javax.inject.Provider
    public ExpandSectionsButtonPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
