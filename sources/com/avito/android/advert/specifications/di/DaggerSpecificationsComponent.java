package com.avito.android.advert.specifications.di;

import com.avito.android.advert.specifications.SpecificationsFragment;
import com.avito.android.advert.specifications.SpecificationsFragment_MembersInjector;
import com.avito.android.advert.specifications.SpecificationsPresenter;
import com.avito.android.advert.specifications.SpecificationsPresenterImpl;
import com.avito.android.advert.specifications.SpecificationsPresenterImpl_Factory;
import com.avito.android.advert.specifications.di.SpecificationsComponent;
import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.advert_core.specifications.SpecificationsConverterImpl;
import com.avito.android.advert_core.specifications.SpecificationsConverterImpl_Factory;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSpecificationsComponent implements SpecificationsComponent {
    public Provider<ModelSpecifications> a;
    public Provider<DeviceMetrics> b;
    public Provider<LayoutTypeProvider> c;
    public Provider<SpecificationsConverterImpl> d;
    public Provider<SpecificationsConverter> e;
    public Provider<SpecificationsPresenterImpl> f;
    public Provider<SpecificationsPresenter> g;

    public static final class b implements SpecificationsComponent.Builder {
        public SpecificationsDependencies a;
        public ModelSpecifications b;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.specifications.di.SpecificationsComponent.Builder
        public SpecificationsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SpecificationsDependencies.class);
            return new DaggerSpecificationsComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.advert.specifications.di.SpecificationsComponent.Builder
        public SpecificationsComponent.Builder specifications(ModelSpecifications modelSpecifications) {
            this.b = modelSpecifications;
            return this;
        }

        @Override // com.avito.android.advert.specifications.di.SpecificationsComponent.Builder
        public SpecificationsComponent.Builder specificationsDependencies(SpecificationsDependencies specificationsDependencies) {
            this.a = (SpecificationsDependencies) Preconditions.checkNotNull(specificationsDependencies);
            return this;
        }
    }

    public static class c implements Provider<DeviceMetrics> {
        public final SpecificationsDependencies a;

        public c(SpecificationsDependencies specificationsDependencies) {
            this.a = specificationsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public DaggerSpecificationsComponent(SpecificationsDependencies specificationsDependencies, ModelSpecifications modelSpecifications, a aVar) {
        this.a = InstanceFactory.createNullable(modelSpecifications);
        c cVar = new c(specificationsDependencies);
        this.b = cVar;
        Provider<LayoutTypeProvider> provider = DoubleCheck.provider(SpecificationsModule_ProvideLayoutTypeProviderFactory.create(cVar));
        this.c = provider;
        SpecificationsConverterImpl_Factory create = SpecificationsConverterImpl_Factory.create(provider);
        this.d = create;
        Provider<SpecificationsConverter> provider2 = DoubleCheck.provider(create);
        this.e = provider2;
        SpecificationsPresenterImpl_Factory create2 = SpecificationsPresenterImpl_Factory.create(this.a, provider2);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
    }

    public static SpecificationsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.specifications.di.SpecificationsComponent
    public void inject(SpecificationsFragment specificationsFragment) {
        SpecificationsFragment_MembersInjector.injectPresenter(specificationsFragment, this.g.get());
    }
}
