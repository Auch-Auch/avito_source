package com.avito.android.inline_filters;

import com.avito.android.analytics.Analytics;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
public final class InlineFiltersPresenterImpl_Factory implements Factory<InlineFiltersPresenterImpl> {
    public final Provider<InlineFiltersInteractor> a;
    public final Provider<ShortcutNavigationItemConverter> b;
    public final Provider<InlineFiltersDialogItemConverter> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<Analytics> e;
    public final Provider<SerpTracker> f;
    public final Provider<Kundle> g;

    public InlineFiltersPresenterImpl_Factory(Provider<InlineFiltersInteractor> provider, Provider<ShortcutNavigationItemConverter> provider2, Provider<InlineFiltersDialogItemConverter> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<SerpTracker> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static InlineFiltersPresenterImpl_Factory create(Provider<InlineFiltersInteractor> provider, Provider<ShortcutNavigationItemConverter> provider2, Provider<InlineFiltersDialogItemConverter> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<SerpTracker> provider6, Provider<Kundle> provider7) {
        return new InlineFiltersPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static InlineFiltersPresenterImpl newInstance(InlineFiltersInteractor inlineFiltersInteractor, ShortcutNavigationItemConverter shortcutNavigationItemConverter, InlineFiltersDialogItemConverter inlineFiltersDialogItemConverter, SchedulersFactory3 schedulersFactory3, Analytics analytics, SerpTracker serpTracker, Kundle kundle) {
        return new InlineFiltersPresenterImpl(inlineFiltersInteractor, shortcutNavigationItemConverter, inlineFiltersDialogItemConverter, schedulersFactory3, analytics, serpTracker, kundle);
    }

    @Override // javax.inject.Provider
    public InlineFiltersPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
