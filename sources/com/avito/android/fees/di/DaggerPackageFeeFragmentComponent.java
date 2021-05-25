package com.avito.android.fees.di;

import com.avito.android.fees.PackageFeeFragment;
import com.avito.android.fees.PackageFeeFragment_MembersInjector;
import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.PackageFeePresenter;
import com.avito.android.fees.di.PackageFeeFragmentComponent;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPackageFeeFragmentComponent implements PackageFeeFragmentComponent {
    public Provider<FeesApi> a;
    public Provider<PackageFeeInteractor> b;
    public Provider<SchedulersFactory> c;
    public Provider<ErrorFormatter> d;
    public Provider<PackageFeePresenter> e;

    public static final class b implements PackageFeeFragmentComponent.Builder {
        public PackageFeeFragmentModule a;
        public PackageFeeComponentDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.fees.di.PackageFeeFragmentComponent.Builder
        public PackageFeeFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PackageFeeFragmentModule.class);
            Preconditions.checkBuilderRequirement(this.b, PackageFeeComponentDependencies.class);
            return new DaggerPackageFeeFragmentComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.fees.di.PackageFeeFragmentComponent.Builder
        public PackageFeeFragmentComponent.Builder dependencies(PackageFeeComponentDependencies packageFeeComponentDependencies) {
            this.b = (PackageFeeComponentDependencies) Preconditions.checkNotNull(packageFeeComponentDependencies);
            return this;
        }

        @Override // com.avito.android.fees.di.PackageFeeFragmentComponent.Builder
        public PackageFeeFragmentComponent.Builder packageFeeFragmentModule(PackageFeeFragmentModule packageFeeFragmentModule) {
            this.a = (PackageFeeFragmentModule) Preconditions.checkNotNull(packageFeeFragmentModule);
            return this;
        }
    }

    public static class c implements Provider<FeesApi> {
        public final PackageFeeComponentDependencies a;

        public c(PackageFeeComponentDependencies packageFeeComponentDependencies) {
            this.a = packageFeeComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FeesApi get() {
            return (FeesApi) Preconditions.checkNotNullFromComponent(this.a.feesApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PackageFeeComponentDependencies a;

        public d(PackageFeeComponentDependencies packageFeeComponentDependencies) {
            this.a = packageFeeComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPackageFeeFragmentComponent(PackageFeeFragmentModule packageFeeFragmentModule, PackageFeeComponentDependencies packageFeeComponentDependencies, a aVar) {
        c cVar = new c(packageFeeComponentDependencies);
        this.a = cVar;
        this.b = DoubleCheck.provider(PackageFeeFragmentModule_ProvidePackageFeeInteractorFactory.create(packageFeeFragmentModule, cVar));
        this.c = new d(packageFeeComponentDependencies);
        Provider<ErrorFormatter> provider = DoubleCheck.provider(PackageFeeFragmentModule_ProvideErrorFormatterFactory.create(packageFeeFragmentModule));
        this.d = provider;
        this.e = DoubleCheck.provider(PackageFeeFragmentModule_ProvidePresenterFactory.create(packageFeeFragmentModule, this.b, this.c, provider));
    }

    public static PackageFeeFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.fees.di.PackageFeeFragmentComponent
    public void inject(PackageFeeFragment packageFeeFragment) {
        PackageFeeFragment_MembersInjector.injectPackageFeePresenter(packageFeeFragment, this.e.get());
    }
}
