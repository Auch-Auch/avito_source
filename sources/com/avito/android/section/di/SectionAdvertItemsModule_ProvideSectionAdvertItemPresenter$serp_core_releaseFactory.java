package com.avito.android.section.di;

import com.avito.android.section.item.SectionAdvertItemPresenter;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.serp.adapter.AdvertItemListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory implements Factory<SectionAdvertItemPresenter> {
    public final Provider<AdvertItemListener> a;
    public final Provider<SectionItemWidthProvider> b;

    public SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory(Provider<AdvertItemListener> provider, Provider<SectionItemWidthProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory create(Provider<AdvertItemListener> provider, Provider<SectionItemWidthProvider> provider2) {
        return new SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory(provider, provider2);
    }

    public static SectionAdvertItemPresenter provideSectionAdvertItemPresenter$serp_core_release(Lazy<AdvertItemListener> lazy, SectionItemWidthProvider sectionItemWidthProvider) {
        return (SectionAdvertItemPresenter) Preconditions.checkNotNullFromProvides(SectionAdvertItemsModule.provideSectionAdvertItemPresenter$serp_core_release(lazy, sectionItemWidthProvider));
    }

    @Override // javax.inject.Provider
    public SectionAdvertItemPresenter get() {
        return provideSectionAdvertItemPresenter$serp_core_release(DoubleCheck.lazy(this.a), this.b.get());
    }
}
