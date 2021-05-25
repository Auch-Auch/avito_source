package com.avito.android.fees.refactor.di;

import android.app.Activity;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment_MembersInjector;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.refactor.PackageClickListener;
import com.avito.android.fees.refactor.PackageFeeViewModel;
import com.avito.android.fees.refactor.PackageFeeViewModelFactory;
import com.avito.android.fees.refactor.PackageItemConverter;
import com.avito.android.fees.refactor.PackageSelectionListener;
import com.avito.android.fees.refactor.di.PackageFeesComponent;
import com.avito.android.fees.refactor.item.PackageFeeBlueprint;
import com.avito.android.fees.refactor.item.PackageFeeBlueprint_Factory;
import com.avito.android.fees.refactor.item.PackageItemPresenter;
import com.avito.android.fees.refactor.item.PackageItemPresenter_Factory;
import com.avito.android.fees.refactor.item.header.HeaderItemBlueprint;
import com.avito.android.fees.refactor.item.header.HeaderItemBlueprint_Factory;
import com.avito.android.fees.refactor.item.header.HeaderItemPresenter_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.DialogRouter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerPackageFeesComponent implements PackageFeesComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PackageItemConverter> b;
    public Provider<PackageApplyInteractor> c;
    public Provider<PackageFeeViewModelFactory> d;
    public Provider<PackageFeeViewModel> e;
    public Provider<PackageClickListener> f;
    public Provider<PackageSelectionListener> g;
    public Provider<PackageItemPresenter> h;
    public Provider<PackageFeeBlueprint> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<HeaderItemBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<Set<ItemBlueprint<?, ?>>> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<Activity> p;
    public Provider<DialogRouter> q;

    public static final class b implements PackageFeesComponent.Builder {
        public PackageFeesDependencies a;
        public PackageFeesModule b;
        public Activity c;

        public b(a aVar) {
        }

        @Override // com.avito.android.fees.refactor.di.PackageFeesComponent.Builder
        public PackageFeesComponent.Builder activity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.fees.refactor.di.PackageFeesComponent.Builder
        public PackageFeesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PackageFeesDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PackageFeesModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerPackageFeesComponent(this.b, this.a, this.c, null);
        }

        @Override // com.avito.android.fees.refactor.di.PackageFeesComponent.Builder
        public PackageFeesComponent.Builder dependencies(PackageFeesDependencies packageFeesDependencies) {
            this.a = (PackageFeesDependencies) Preconditions.checkNotNull(packageFeesDependencies);
            return this;
        }

        @Override // com.avito.android.fees.refactor.di.PackageFeesComponent.Builder
        public PackageFeesComponent.Builder module(PackageFeesModule packageFeesModule) {
            this.b = (PackageFeesModule) Preconditions.checkNotNull(packageFeesModule);
            return this;
        }
    }

    public static class c implements Provider<PackageApplyInteractor> {
        public final PackageFeesDependencies a;

        public c(PackageFeesDependencies packageFeesDependencies) {
            this.a = packageFeesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PackageApplyInteractor get() {
            return (PackageApplyInteractor) Preconditions.checkNotNullFromComponent(this.a.packageApplyInteractor());
        }
    }

    public DaggerPackageFeesComponent(PackageFeesModule packageFeesModule, PackageFeesDependencies packageFeesDependencies, Activity activity, a aVar) {
        Provider<PackageItemConverter> provider = DoubleCheck.provider(PackageFeesModule_ProvidePackageItemConverterFactory.create(packageFeesModule));
        this.b = provider;
        c cVar = new c(packageFeesDependencies);
        this.c = cVar;
        Provider<PackageFeeViewModelFactory> provider2 = DoubleCheck.provider(PackageFeesModule_ProvidePackageFeeViewModelFactoryFactory.create(packageFeesModule, provider, cVar));
        this.d = provider2;
        Provider<PackageFeeViewModel> provider3 = DoubleCheck.provider(PackageFeesModule_ProvidePackageFeeViewModelFactory.create(packageFeesModule, provider2));
        this.e = provider3;
        this.f = DoubleCheck.provider(PackageFeesModule_ProvidePackageClickListenerFactory.create(packageFeesModule, provider3));
        Provider<PackageSelectionListener> provider4 = DoubleCheck.provider(PackageFeesModule_ProvidePackageSelectionListenerFactory.create(packageFeesModule));
        this.g = provider4;
        PackageItemPresenter_Factory create = PackageItemPresenter_Factory.create(this.f, provider4);
        this.h = create;
        PackageFeeBlueprint_Factory create2 = PackageFeeBlueprint_Factory.create(create);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
        HeaderItemBlueprint_Factory create3 = HeaderItemBlueprint_Factory.create(HeaderItemPresenter_Factory.create());
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(2, 1).addCollectionProvider(this.a).addProvider(this.j).addProvider(this.l).build();
        this.m = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.n = provider5;
        this.o = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        Factory create4 = InstanceFactory.create(activity);
        this.p = create4;
        this.q = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create4));
    }

    public static PackageFeesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.fees.refactor.di.PackageFeesComponent
    public void inject(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        MvvmPackageFeeFragment_MembersInjector.injectItemBinder(mvvmPackageFeeFragment, this.n.get());
        MvvmPackageFeeFragment_MembersInjector.injectAdapterPresenter(mvvmPackageFeeFragment, this.o.get());
        MvvmPackageFeeFragment_MembersInjector.injectViewModel(mvvmPackageFeeFragment, this.e.get());
        MvvmPackageFeeFragment_MembersInjector.injectDialogRouter(mvvmPackageFeeFragment, this.q.get());
    }
}
