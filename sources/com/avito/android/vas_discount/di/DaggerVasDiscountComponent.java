package com.avito.android.vas_discount.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.DiscountApi;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_discount.DiscountActivityViewModelFactory;
import com.avito.android.vas_discount.VasDiscountActivity;
import com.avito.android.vas_discount.VasDiscountActivity_MembersInjector;
import com.avito.android.vas_discount.business.DiscountRepository;
import com.avito.android.vas_discount.business.DiscountRepositoryImpl;
import com.avito.android.vas_discount.business.DiscountRepositoryImpl_Factory;
import com.avito.android.vas_discount.di.VasDiscountComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerVasDiscountComponent implements VasDiscountComponent {
    public final DiscountDependencies a;
    public Provider<String> b;
    public Provider<DiscountApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<DiscountRepositoryImpl> e;
    public Provider<DiscountRepository> f;

    public static final class b implements VasDiscountComponent.Builder {
        public DiscountDependencies a;
        public DiscountModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.vas_discount.di.VasDiscountComponent.Builder
        public VasDiscountComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DiscountDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, DiscountModule.class);
            return new DaggerVasDiscountComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.vas_discount.di.VasDiscountComponent.Builder
        public VasDiscountComponent.Builder dependencies(DiscountDependencies discountDependencies) {
            this.a = (DiscountDependencies) Preconditions.checkNotNull(discountDependencies);
            return this;
        }

        @Override // com.avito.android.vas_discount.di.VasDiscountComponent.Builder
        public VasDiscountComponent.Builder module(DiscountModule discountModule) {
            this.b = (DiscountModule) Preconditions.checkNotNull(discountModule);
            return this;
        }
    }

    public static class c implements Provider<DiscountApi> {
        public final DiscountDependencies a;

        public c(DiscountDependencies discountDependencies) {
            this.a = discountDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DiscountApi get() {
            return (DiscountApi) Preconditions.checkNotNullFromComponent(this.a.discountApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final DiscountDependencies a;

        public d(DiscountDependencies discountDependencies) {
            this.a = discountDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerVasDiscountComponent(DiscountModule discountModule, DiscountDependencies discountDependencies, a aVar) {
        this.a = discountDependencies;
        this.b = DoubleCheck.provider(DiscountModule_ProvideDiscountContextFactory.create(discountModule));
        c cVar = new c(discountDependencies);
        this.c = cVar;
        d dVar = new d(discountDependencies);
        this.d = dVar;
        DiscountRepositoryImpl_Factory create = DiscountRepositoryImpl_Factory.create(cVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
    }

    public static VasDiscountComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.vas_discount.di.PickerDependencies
    public DeepLinkIntentFactory deeplinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
    }

    @Override // com.avito.android.vas_discount.di.PickerDependencies
    public String discountContext() {
        return this.b.get();
    }

    @Override // com.avito.android.vas_discount.di.VasDiscountComponent
    public void inject(VasDiscountActivity vasDiscountActivity) {
        VasDiscountActivity_MembersInjector.injectFactory(vasDiscountActivity, new DiscountActivityViewModelFactory(this.b.get(), this.f.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory())));
    }

    @Override // com.avito.android.vas_discount.di.PickerDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }
}
