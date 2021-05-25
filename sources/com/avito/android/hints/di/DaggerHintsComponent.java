package com.avito.android.hints.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.hints.HintsDialogFragment;
import com.avito.android.hints.HintsDialogFragment_MembersInjector;
import com.avito.android.hints.di.HintsComponent;
import com.avito.android.hints.items.HintItemBlueprint;
import com.avito.android.hints.items.HintItemBlueprint_Factory;
import com.avito.android.hints.items.HintItemPresenter_Factory;
import com.avito.android.hints.remote.HintsApi;
import com.avito.android.hints.repository.HintsConverter;
import com.avito.android.hints.repository.HintsConverterImpl;
import com.avito.android.hints.repository.HintsConverterImpl_Factory;
import com.avito.android.hints.repository.HintsRepository;
import com.avito.android.hints.repository.HintsRepositoryImpl;
import com.avito.android.hints.repository.HintsRepositoryImpl_Factory;
import com.avito.android.hints.viewmodel.HintViewModelFactory;
import com.avito.android.hints.viewmodel.HintViewModelFactory_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerHintsComponent implements HintsComponent {
    public Provider<String> a;
    public Provider<HintsApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<HintsRepositoryImpl> d;
    public Provider<HintsRepository> e;
    public Provider<AttributedTextFormatter> f;
    public Provider<HintsConverterImpl> g;
    public Provider<HintsConverter> h;
    public Provider<HintViewModelFactory> i;
    public Provider<ViewModelProvider.Factory> j;
    public Provider<Set<ItemBlueprint<?, ?>>> k = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<HintItemBlueprint> l;
    public Provider<ItemBlueprint<?, ?>> m;
    public Provider<Set<ItemBlueprint<?, ?>>> n;
    public Provider<ItemBinder> o;
    public Provider<AdapterPresenter> p;

    public static final class b implements HintsComponent.Builder {
        public HintsDependencies a;
        public String b;
        public Resources c;

        public b(a aVar) {
        }

        @Override // com.avito.android.hints.di.HintsComponent.Builder
        public HintsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HintsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerHintsComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.hints.di.HintsComponent.Builder
        public HintsComponent.Builder dependencies(HintsDependencies hintsDependencies) {
            this.a = (HintsDependencies) Preconditions.checkNotNull(hintsDependencies);
            return this;
        }

        @Override // com.avito.android.hints.di.HintsComponent.Builder
        public HintsComponent.Builder hintType(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.hints.di.HintsComponent.Builder
        public HintsComponent.Builder resources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<HintsApi> {
        public final HintsDependencies a;

        public c(HintsDependencies hintsDependencies) {
            this.a = hintsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HintsApi get() {
            return (HintsApi) Preconditions.checkNotNullFromComponent(this.a.hintsApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final HintsDependencies a;

        public d(HintsDependencies hintsDependencies) {
            this.a = hintsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerHintsComponent(HintsDependencies hintsDependencies, String str, Resources resources, a aVar) {
        this.a = InstanceFactory.create(str);
        c cVar = new c(hintsDependencies);
        this.b = cVar;
        d dVar = new d(hintsDependencies);
        this.c = dVar;
        HintsRepositoryImpl_Factory create = HintsRepositoryImpl_Factory.create(cVar, dVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        Provider<AttributedTextFormatter> provider = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.f = provider;
        HintsConverterImpl_Factory create2 = HintsConverterImpl_Factory.create(provider);
        this.g = create2;
        Provider<HintsConverter> provider2 = DoubleCheck.provider(create2);
        this.h = provider2;
        HintViewModelFactory_Factory create3 = HintViewModelFactory_Factory.create(this.a, this.e, provider2);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        HintItemBlueprint_Factory create4 = HintItemBlueprint_Factory.create(HintItemPresenter_Factory.create());
        this.l = create4;
        this.m = DoubleCheck.provider(create4);
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.k).addProvider(this.m).build();
        this.n = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.o = provider3;
        this.p = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
    }

    public static HintsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.hints.di.HintsComponent
    public void inject(HintsDialogFragment hintsDialogFragment) {
        HintsDialogFragment_MembersInjector.injectViewModelFactory(hintsDialogFragment, this.j.get());
        HintsDialogFragment_MembersInjector.injectItemBinder(hintsDialogFragment, this.o.get());
        HintsDialogFragment_MembersInjector.injectAdapterPresenter(hintsDialogFragment, this.p.get());
    }
}
