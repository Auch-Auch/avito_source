package com.avito.android.vas_performance.di.perfomance_legacy;

import com.avito.android.analytics.Analytics;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasComponent;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment_MembersInjector;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemBlueprint;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenter;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenterImpl_Factory;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemBlueprint;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenter;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenterImpl_Factory;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasBlueprint;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenter;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenterImpl_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerPerformanceVasComponent implements PerformanceVasComponent {
    public final PerformanceVasDependencies a;
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<Set<ItemBlueprint<?, ?>>> d = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<TabsItemPresenter> e;
    public Provider<TabsItemBlueprint> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<PerformanceVasItemPresenter> h;
    public Provider<AttributedTextFormatter> i;
    public Provider<PerformanceVasBlueprint> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<InfoActionItemPresenter> l;
    public Provider<InfoActionItemBlueprint> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<Set<ItemBlueprint<?, ?>>> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;

    public static final class b implements PerformanceVasComponent.Builder {
        public PerformanceVasDependencies a;
        public ListModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasComponent.Builder
        public PerformanceVasComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PerformanceVasDependencies.class);
            if (this.b == null) {
                this.b = new ListModule();
            }
            return new DaggerPerformanceVasComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasComponent.Builder
        public PerformanceVasComponent.Builder dependencies(PerformanceVasDependencies performanceVasDependencies) {
            this.a = (PerformanceVasDependencies) Preconditions.checkNotNull(performanceVasDependencies);
            return this;
        }

        @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasComponent.Builder
        public PerformanceVasComponent.Builder module(ListModule listModule) {
            this.b = (ListModule) Preconditions.checkNotNull(listModule);
            return this;
        }
    }

    public DaggerPerformanceVasComponent(ListModule listModule, PerformanceVasDependencies performanceVasDependencies, a aVar) {
        this.a = performanceVasDependencies;
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(ListModule_ProvideHeaderPresenterFactory.create(listModule));
        this.b = provider;
        this.c = DoubleCheck.provider(ListModule_ProvideHeaderBlueprintFactory.create(listModule, provider));
        Provider<TabsItemPresenter> provider2 = DoubleCheck.provider(TabsItemPresenterImpl_Factory.create());
        this.e = provider2;
        TabsItemBlueprint_Factory create = TabsItemBlueprint_Factory.create(provider2);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = DoubleCheck.provider(PerformanceVasItemPresenterImpl_Factory.create());
        Provider<AttributedTextFormatter> provider3 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.i = provider3;
        PerformanceVasBlueprint_Factory create2 = PerformanceVasBlueprint_Factory.create(this.h, provider3);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        Provider<InfoActionItemPresenter> provider4 = DoubleCheck.provider(InfoActionItemPresenterImpl_Factory.create());
        this.l = provider4;
        InfoActionItemBlueprint_Factory create3 = InfoActionItemBlueprint_Factory.create(provider4);
        this.m = create3;
        this.n = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.c).addCollectionProvider(this.d).addProvider(this.g).addProvider(this.k).addProvider(this.n).build();
        this.o = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.p = provider5;
        this.q = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
    }

    public static PerformanceVasComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasComponent
    public void inject(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        LegacyPerformanceVasFragment_MembersInjector.injectItemBinder(legacyPerformanceVasFragment, this.p.get());
        LegacyPerformanceVasFragment_MembersInjector.injectAdapterPresenter(legacyPerformanceVasFragment, this.q.get());
        LegacyPerformanceVasFragment_MembersInjector.injectViewModel(legacyPerformanceVasFragment, (LegacyPerformanceVasViewModel) Preconditions.checkNotNullFromComponent(this.a.legacyPerformanceVasViewModel()));
        LegacyPerformanceVasFragment_MembersInjector.injectItemPresenterSet(legacyPerformanceVasFragment, SetBuilder.newSetBuilder(4).add(this.e.get()).add(this.h.get()).add(this.l.get()).add(this.b.get()).build());
        LegacyPerformanceVasFragment_MembersInjector.injectAnalytics(legacyPerformanceVasFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        LegacyPerformanceVasFragment_MembersInjector.injectTracker(legacyPerformanceVasFragment, (PerformanceVasTracker) Preconditions.checkNotNullFromComponent(this.a.performanceVasTracker()));
        LegacyPerformanceVasFragment_MembersInjector.injectDeepLinkIntentFactory(legacyPerformanceVasFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
    }
}
