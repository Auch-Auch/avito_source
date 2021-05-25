package com.avito.android.section;

import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.section.title.SectionTitleItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SectionItemPresenterImpl_Factory implements Factory<SectionItemPresenterImpl> {
    public final Provider<SectionTitleItemPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<Bundle> c;

    public SectionItemPresenterImpl_Factory(Provider<SectionTitleItemPresenter> provider, Provider<Analytics> provider2, Provider<Bundle> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SectionItemPresenterImpl_Factory create(Provider<SectionTitleItemPresenter> provider, Provider<Analytics> provider2, Provider<Bundle> provider3) {
        return new SectionItemPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static SectionItemPresenterImpl newInstance(SectionTitleItemPresenter sectionTitleItemPresenter, Analytics analytics, Bundle bundle) {
        return new SectionItemPresenterImpl(sectionTitleItemPresenter, analytics, bundle);
    }

    @Override // javax.inject.Provider
    public SectionItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
