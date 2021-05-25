package com.avito.android.theme_settings;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.theme_settings.item.ThemeModeItemPresenter;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class ThemeSettingsFragment_MembersInjector implements MembersInjector<ThemeSettingsFragment> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ThemeSettingsViewModel> c;
    public final Provider<Set<ThemeModeItemPresenter>> d;
    public final Provider<SpannedGridPositionProvider> e;
    public final Provider<GridLayoutManager.SpanSizeLookup> f;
    public final Provider<SerpSpanProvider> g;

    public ThemeSettingsFragment_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<ThemeSettingsViewModel> provider3, Provider<Set<ThemeModeItemPresenter>> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<GridLayoutManager.SpanSizeLookup> provider6, Provider<SerpSpanProvider> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<ThemeSettingsFragment> create(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<ThemeSettingsViewModel> provider3, Provider<Set<ThemeModeItemPresenter>> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<GridLayoutManager.SpanSizeLookup> provider6, Provider<SerpSpanProvider> provider7) {
        return new ThemeSettingsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.adapterPresenter")
    public static void injectAdapterPresenter(ThemeSettingsFragment themeSettingsFragment, AdapterPresenter adapterPresenter) {
        themeSettingsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.gridPositionProvider")
    public static void injectGridPositionProvider(ThemeSettingsFragment themeSettingsFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        themeSettingsFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.itemPresenters")
    public static void injectItemPresenters(ThemeSettingsFragment themeSettingsFragment, Set<ThemeModeItemPresenter> set) {
        themeSettingsFragment.itemPresenters = set;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(ThemeSettingsFragment themeSettingsFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        themeSettingsFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.serpSpanProvider")
    public static void injectSerpSpanProvider(ThemeSettingsFragment themeSettingsFragment, SerpSpanProvider serpSpanProvider) {
        themeSettingsFragment.serpSpanProvider = serpSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(ThemeSettingsFragment themeSettingsFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        themeSettingsFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.theme_settings.ThemeSettingsFragment.viewModel")
    public static void injectViewModel(ThemeSettingsFragment themeSettingsFragment, ThemeSettingsViewModel themeSettingsViewModel) {
        themeSettingsFragment.viewModel = themeSettingsViewModel;
    }

    public void injectMembers(ThemeSettingsFragment themeSettingsFragment) {
        injectRecyclerAdapter(themeSettingsFragment, this.a.get());
        injectAdapterPresenter(themeSettingsFragment, this.b.get());
        injectViewModel(themeSettingsFragment, this.c.get());
        injectItemPresenters(themeSettingsFragment, this.d.get());
        injectGridPositionProvider(themeSettingsFragment, this.e.get());
        injectSpanSizeLookup(themeSettingsFragment, this.f.get());
        injectSerpSpanProvider(themeSettingsFragment, this.g.get());
    }
}
