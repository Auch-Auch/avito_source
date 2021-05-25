package com.avito.android.user_advert.soa_with_price.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceArguments;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResourceProvider;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResourceProviderImpl;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResourceProviderImpl_Factory;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment_MembersInjector;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceViewModelFactory;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemBlueprint;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemBlueprintImpl;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemBlueprintImpl_Factory;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenterImpl_Factory;
import com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerCloseReasonSheetDialogComponent implements CloseReasonSheetDialogComponent {
    public final CoreComponentDependencies a;
    public Provider<CloseReasonItemPresenter> b;
    public Provider<CloseReasonItemBlueprintImpl> c;
    public Provider<CloseReasonItemBlueprint> d;
    public Provider<ItemBinder> e;
    public Provider<AdapterPresenter> f;
    public Provider<RecyclerView.Adapter<BaseViewHolder>> g;
    public Provider<AttributedTextFormatter> h = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<SoaWithPriceArguments> i;
    public Provider<SchedulersFactory> j;
    public Provider<Resources> k;
    public Provider<SoaWithPriceResourceProviderImpl> l;
    public Provider<SoaWithPriceResourceProvider> m;
    public Provider<SoaWithPriceViewModelFactory> n;

    public static final class b implements CloseReasonSheetDialogComponent.Builder {
        public CoreComponentDependencies a;
        public SoaWithPriceArguments b;
        public Resources c;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent.Builder
        public CloseReasonSheetDialogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, SoaWithPriceArguments.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerCloseReasonSheetDialogComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent.Builder
        public CloseReasonSheetDialogComponent.Builder dependentOn(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }

        @Override // com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent.Builder
        public CloseReasonSheetDialogComponent.Builder withArguments(SoaWithPriceArguments soaWithPriceArguments) {
            this.b = (SoaWithPriceArguments) Preconditions.checkNotNull(soaWithPriceArguments);
            return this;
        }

        @Override // com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent.Builder
        public CloseReasonSheetDialogComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final CoreComponentDependencies a;

        public c(CoreComponentDependencies coreComponentDependencies) {
            this.a = coreComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCloseReasonSheetDialogComponent(CoreComponentDependencies coreComponentDependencies, SoaWithPriceArguments soaWithPriceArguments, Resources resources, a aVar) {
        this.a = coreComponentDependencies;
        Provider<CloseReasonItemPresenter> provider = DoubleCheck.provider(CloseReasonItemPresenterImpl_Factory.create());
        this.b = provider;
        CloseReasonItemBlueprintImpl_Factory create = CloseReasonItemBlueprintImpl_Factory.create(provider);
        this.c = create;
        Provider<CloseReasonItemBlueprint> provider2 = DoubleCheck.provider(create);
        this.d = provider2;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(CloseReasonSheetDialogModule_ProvideItemBinder$user_advert_releaseFactory.create(provider2));
        this.e = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(CloseReasonSheetDialogModule_ProvideAdapterPresenter$user_advert_releaseFactory.create(provider3));
        this.f = provider4;
        this.g = DoubleCheck.provider(CloseReasonSheetDialogModule_ProvideRecyclerAdapter$user_advert_releaseFactory.create(provider4, this.e));
        this.i = InstanceFactory.create(soaWithPriceArguments);
        this.j = new c(coreComponentDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.k = create2;
        SoaWithPriceResourceProviderImpl_Factory create3 = SoaWithPriceResourceProviderImpl_Factory.create(create2);
        this.l = create3;
        Provider<SoaWithPriceResourceProvider> provider5 = DoubleCheck.provider(create3);
        this.m = provider5;
        this.n = DoubleCheck.provider(CloseReasonSheetDialogModule_ProvideViewModelFactory$user_advert_releaseFactory.create(this.i, this.j, provider5));
    }

    public static CloseReasonSheetDialogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent
    public void inject(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment) {
        SoaWithPriceSheetDialogFragment_MembersInjector.injectAdapterPresenter(soaWithPriceSheetDialogFragment, this.f.get());
        SoaWithPriceSheetDialogFragment_MembersInjector.injectAdapter(soaWithPriceSheetDialogFragment, this.g.get());
        SoaWithPriceSheetDialogFragment_MembersInjector.injectItemPresenter(soaWithPriceSheetDialogFragment, this.b.get());
        SoaWithPriceSheetDialogFragment_MembersInjector.injectSchedulers(soaWithPriceSheetDialogFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        SoaWithPriceSheetDialogFragment_MembersInjector.injectAttributedTextFormatter(soaWithPriceSheetDialogFragment, this.h.get());
        SoaWithPriceSheetDialogFragment_MembersInjector.injectAnalytics(soaWithPriceSheetDialogFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SoaWithPriceSheetDialogFragment_MembersInjector.injectViewModelFactory(soaWithPriceSheetDialogFragment, this.n.get());
    }
}
