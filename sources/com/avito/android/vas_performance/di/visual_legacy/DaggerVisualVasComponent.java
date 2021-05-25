package com.avito.android.vas_performance.di.visual_legacy;

import com.avito.android.analytics.Analytics;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.di.visual_legacy.VisualVasComponent;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment_MembersInjector;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemBlueprint;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenter;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenterImpl_Factory;
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
public final class DaggerVisualVasComponent implements VisualVasComponent {
    public final VisualVasDependencies a;
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<Set<ItemBlueprint<?, ?>>> d = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<VisualVasItemPresenter> e = DoubleCheck.provider(VisualVasItemPresenterImpl_Factory.create());
    public Provider<AttributedTextFormatter> f;
    public Provider<VisualVasItemBlueprint> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<Set<ItemBlueprint<?, ?>>> i;
    public Provider<ItemBinder> j;
    public Provider<AdapterPresenter> k;

    public static final class b implements VisualVasComponent.Builder {
        public VisualVasDependencies a;
        public VasListModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasComponent.Builder
        public VisualVasComponent build() {
            Preconditions.checkBuilderRequirement(this.a, VisualVasDependencies.class);
            if (this.b == null) {
                this.b = new VasListModule();
            }
            return new DaggerVisualVasComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasComponent.Builder
        public VisualVasComponent.Builder dependencies(VisualVasDependencies visualVasDependencies) {
            this.a = (VisualVasDependencies) Preconditions.checkNotNull(visualVasDependencies);
            return this;
        }

        @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasComponent.Builder
        public VisualVasComponent.Builder module(VasListModule vasListModule) {
            this.b = (VasListModule) Preconditions.checkNotNull(vasListModule);
            return this;
        }
    }

    public DaggerVisualVasComponent(VasListModule vasListModule, VisualVasDependencies visualVasDependencies, a aVar) {
        this.a = visualVasDependencies;
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(VasListModule_ProvideHeaderPresenterFactory.create(vasListModule));
        this.b = provider;
        this.c = DoubleCheck.provider(VasListModule_ProvideHeaderBlueprintFactory.create(vasListModule, provider));
        Provider<AttributedTextFormatter> provider2 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.f = provider2;
        VisualVasItemBlueprint_Factory create = VisualVasItemBlueprint_Factory.create(this.e, provider2);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        SetFactory build = SetFactory.builder(2, 1).addProvider(this.c).addCollectionProvider(this.d).addProvider(this.h).build();
        this.i = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.j = provider3;
        this.k = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
    }

    public static VisualVasComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasComponent
    public void inject(LegacyVisualVasFragment legacyVisualVasFragment) {
        LegacyVisualVasFragment_MembersInjector.injectItemBinder(legacyVisualVasFragment, this.j.get());
        LegacyVisualVasFragment_MembersInjector.injectAdapterPresenter(legacyVisualVasFragment, this.k.get());
        LegacyVisualVasFragment_MembersInjector.injectItemPresenterSet(legacyVisualVasFragment, SetBuilder.newSetBuilder(2).add(this.e.get()).add(this.b.get()).build());
        LegacyVisualVasFragment_MembersInjector.injectViewModel(legacyVisualVasFragment, (LegacyVisualVasViewModel) Preconditions.checkNotNullFromComponent(this.a.visualVasViewModel()));
        LegacyVisualVasFragment_MembersInjector.injectAnalytics(legacyVisualVasFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        LegacyVisualVasFragment_MembersInjector.injectTracker(legacyVisualVasFragment, (VisualVasTracker) Preconditions.checkNotNullFromComponent(this.a.visualVasTracker()));
    }
}
