package com.avito.android.theme_settings.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.analytics.Analytics;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.theme_settings.ThemeSettingsFragment;
import com.avito.android.theme_settings.ThemeSettingsFragment_MembersInjector;
import com.avito.android.theme_settings.di.ThemeSettingsComponent;
import com.avito.android.theme_settings.item.switcher.SwitcherItemBlueprint;
import com.avito.android.theme_settings.item.switcher.SwitcherItemBlueprint_Factory;
import com.avito.android.theme_settings.item.switcher.SwitcherItemPresenter;
import com.avito.android.theme_settings.item.switcher.SwitcherItemPresenterImpl_Factory;
import com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemBlueprint;
import com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemBlueprint_Factory;
import com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemPresenter;
import com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemPresenterImpl_Factory;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProviderImpl;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProviderImpl_Factory;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsConverter;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsConverterImpl;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsConverterImpl_Factory;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModelFactory;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModelFactory_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerThemeSettingsComponent implements ThemeSettingsComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<ThemeCheckmarkItemPresenter> b;
    public Provider<ThemeCheckmarkItemBlueprint> c;
    public Provider<ItemBlueprint<?, ?>> d;
    public Provider<SwitcherItemPresenter> e;
    public Provider<SwitcherItemBlueprint> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<Set<ItemBlueprint<?, ?>>> h;
    public Provider<ItemBinder> i;
    public Provider<AdapterPresenter> j;
    public Provider<SimpleRecyclerAdapter> k;
    public Provider<Fragment> l;
    public Provider<DarkThemeManager> m;
    public Provider<Context> n;
    public Provider<ThemeSettingsResourceProviderImpl> o;
    public Provider<ThemeSettingsResourceProvider> p;
    public Provider<ThemeSettingsConverterImpl> q;
    public Provider<ThemeSettingsConverter> r;
    public Provider<Analytics> s;
    public Provider<ThemeSettingsViewModelFactory> t;
    public Provider<ViewModelProvider.Factory> u;
    public Provider<ThemeSettingsViewModel> v;
    public Provider<SpannedGridPositionProvider> w;
    public Provider<SerpSpanProvider> x;
    public Provider<GridLayoutManager.SpanSizeLookup> y;

    public static final class b implements ThemeSettingsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.theme_settings.di.ThemeSettingsComponent.Factory
        public ThemeSettingsComponent create(Fragment fragment, Context context, ThemeSettingsDependencies themeSettingsDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(themeSettingsDependencies);
            return new DaggerThemeSettingsComponent(themeSettingsDependencies, fragment, context, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final ThemeSettingsDependencies a;

        public c(ThemeSettingsDependencies themeSettingsDependencies) {
            this.a = themeSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DarkThemeManager> {
        public final ThemeSettingsDependencies a;

        public d(ThemeSettingsDependencies themeSettingsDependencies) {
            this.a = themeSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DarkThemeManager get() {
            return (DarkThemeManager) Preconditions.checkNotNullFromComponent(this.a.darkThemeManager());
        }
    }

    public DaggerThemeSettingsComponent(ThemeSettingsDependencies themeSettingsDependencies, Fragment fragment, Context context, a aVar) {
        Provider<ThemeCheckmarkItemPresenter> provider = DoubleCheck.provider(ThemeCheckmarkItemPresenterImpl_Factory.create());
        this.b = provider;
        ThemeCheckmarkItemBlueprint_Factory create = ThemeCheckmarkItemBlueprint_Factory.create(provider);
        this.c = create;
        this.d = DoubleCheck.provider(create);
        Provider<SwitcherItemPresenter> provider2 = DoubleCheck.provider(SwitcherItemPresenterImpl_Factory.create());
        this.e = provider2;
        SwitcherItemBlueprint_Factory create2 = SwitcherItemBlueprint_Factory.create(provider2);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(2, 1).addCollectionProvider(this.a).addProvider(this.d).addProvider(this.g).build();
        this.h = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.i = provider3;
        Provider<AdapterPresenter> provider4 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
        this.j = provider4;
        this.k = DoubleCheck.provider(ThemeSettingsModule_ProvideSimpleRecyclerAdapterFactory.create(provider4, this.i));
        this.l = InstanceFactory.create(fragment);
        this.m = new d(themeSettingsDependencies);
        Factory create3 = InstanceFactory.create(context);
        this.n = create3;
        ThemeSettingsResourceProviderImpl_Factory create4 = ThemeSettingsResourceProviderImpl_Factory.create(create3);
        this.o = create4;
        Provider<ThemeSettingsResourceProvider> provider5 = DoubleCheck.provider(create4);
        this.p = provider5;
        ThemeSettingsConverterImpl_Factory create5 = ThemeSettingsConverterImpl_Factory.create(provider5);
        this.q = create5;
        Provider<ThemeSettingsConverter> provider6 = DoubleCheck.provider(create5);
        this.r = provider6;
        c cVar = new c(themeSettingsDependencies);
        this.s = cVar;
        ThemeSettingsViewModelFactory_Factory create6 = ThemeSettingsViewModelFactory_Factory.create(this.m, provider6, this.p, cVar);
        this.t = create6;
        Provider<ViewModelProvider.Factory> provider7 = DoubleCheck.provider(create6);
        this.u = provider7;
        this.v = DoubleCheck.provider(ThemeSettingsModule_ProvideViewModelFactory.create(this.l, provider7));
        Provider<SpannedGridPositionProvider> provider8 = DoubleCheck.provider(ThemeSettingsModule_ProvideGridPositionProvider$settings_releaseFactory.create());
        this.w = provider8;
        Provider<SerpSpanProvider> provider9 = DoubleCheck.provider(ThemeSettingsModule_ProvideSpanProvider$settings_releaseFactory.create(provider8));
        this.x = provider9;
        this.y = DoubleCheck.provider(ThemeSettingsModule_ProvideSpanLookup$settings_releaseFactory.create(provider9));
    }

    public static ThemeSettingsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.theme_settings.di.ThemeSettingsComponent
    public void inject(ThemeSettingsFragment themeSettingsFragment) {
        ThemeSettingsFragment_MembersInjector.injectRecyclerAdapter(themeSettingsFragment, this.k.get());
        ThemeSettingsFragment_MembersInjector.injectAdapterPresenter(themeSettingsFragment, this.j.get());
        ThemeSettingsFragment_MembersInjector.injectViewModel(themeSettingsFragment, this.v.get());
        ThemeSettingsFragment_MembersInjector.injectItemPresenters(themeSettingsFragment, SetBuilder.newSetBuilder(2).add(this.b.get()).add(this.e.get()).build());
        ThemeSettingsFragment_MembersInjector.injectGridPositionProvider(themeSettingsFragment, this.w.get());
        ThemeSettingsFragment_MembersInjector.injectSpanSizeLookup(themeSettingsFragment, this.y.get());
        ThemeSettingsFragment_MembersInjector.injectSerpSpanProvider(themeSettingsFragment, this.x.get());
    }
}
