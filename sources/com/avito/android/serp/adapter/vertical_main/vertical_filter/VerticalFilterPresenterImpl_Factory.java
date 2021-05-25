package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.analytics.Analytics;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalFilterPresenterImpl_Factory implements Factory<VerticalFilterPresenterImpl> {
    public final Provider<VerticalFilterInteractor> a;
    public final Provider<Analytics> b;
    public final Provider<InlineFiltersDialogItemConverter> c;
    public final Provider<VerticalSearchFilterResourceProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<VerticalFilterState> f;

    public VerticalFilterPresenterImpl_Factory(Provider<VerticalFilterInteractor> provider, Provider<Analytics> provider2, Provider<InlineFiltersDialogItemConverter> provider3, Provider<VerticalSearchFilterResourceProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<VerticalFilterState> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static VerticalFilterPresenterImpl_Factory create(Provider<VerticalFilterInteractor> provider, Provider<Analytics> provider2, Provider<InlineFiltersDialogItemConverter> provider3, Provider<VerticalSearchFilterResourceProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<VerticalFilterState> provider6) {
        return new VerticalFilterPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static VerticalFilterPresenterImpl newInstance(VerticalFilterInteractor verticalFilterInteractor, Analytics analytics, InlineFiltersDialogItemConverter inlineFiltersDialogItemConverter, VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider, SchedulersFactory3 schedulersFactory3, VerticalFilterState verticalFilterState) {
        return new VerticalFilterPresenterImpl(verticalFilterInteractor, analytics, inlineFiltersDialogItemConverter, verticalSearchFilterResourceProvider, schedulersFactory3, verticalFilterState);
    }

    @Override // javax.inject.Provider
    public VerticalFilterPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
