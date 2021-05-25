package com.avito.android.job.cv_packages.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.job.JobApi;
import com.avito.android.job.cv_packages.CvPackagesInteractor;
import com.avito.android.job.cv_packages.CvPackagesInteractor_Factory;
import com.avito.android.job.cv_packages.CvPackagesNavigator;
import com.avito.android.job.cv_packages.CvPackagesNavigator_Factory;
import com.avito.android.job.cv_packages.JobCvPackagesActivity;
import com.avito.android.job.cv_packages.JobCvPackagesActivity_MembersInjector;
import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import com.avito.android.job.cv_packages.JobCvPackagesViewModel_Factory_Factory;
import com.avito.android.job.cv_packages.di.CvPackagesComponent;
import com.avito.android.job.cv_packages.item.PackageBlueprint;
import com.avito.android.job.cv_packages.item.PackagePresenter_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCvPackagesComponent implements CvPackagesComponent {
    public final AppCompatActivity a;
    public final CvPackagesDependencies b;
    public final String c;
    public Provider<AppCompatActivity> d;
    public Provider<DeepLinkIntentFactory> e;
    public Provider<CvPackagesNavigator> f;
    public Provider<SchedulersFactory3> g;
    public Provider<JobApi> h;
    public Provider<CvPackagesInteractor> i;
    public Provider<String> j;
    public Provider<JobCvPackagesViewModel.Factory> k;
    public Provider<JobCvPackagesViewModel> l;
    public Provider<PackageBlueprint> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<SimpleRecyclerAdapter> p;

    public static final class b implements CvPackagesComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.job.cv_packages.di.CvPackagesComponent.Factory
        public CvPackagesComponent build(CvPackagesDependencies cvPackagesDependencies, AppCompatActivity appCompatActivity, String str) {
            Preconditions.checkNotNull(cvPackagesDependencies);
            Preconditions.checkNotNull(appCompatActivity);
            Preconditions.checkNotNull(str);
            return new DaggerCvPackagesComponent(cvPackagesDependencies, appCompatActivity, str, null);
        }
    }

    public static class c implements Provider<DeepLinkIntentFactory> {
        public final CvPackagesDependencies a;

        public c(CvPackagesDependencies cvPackagesDependencies) {
            this.a = cvPackagesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class d implements Provider<JobApi> {
        public final CvPackagesDependencies a;

        public d(CvPackagesDependencies cvPackagesDependencies) {
            this.a = cvPackagesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public JobApi get() {
            return (JobApi) Preconditions.checkNotNullFromComponent(this.a.jobInterviewInvitationApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final CvPackagesDependencies a;

        public e(CvPackagesDependencies cvPackagesDependencies) {
            this.a = cvPackagesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerCvPackagesComponent(CvPackagesDependencies cvPackagesDependencies, AppCompatActivity appCompatActivity, String str, a aVar) {
        this.a = appCompatActivity;
        this.b = cvPackagesDependencies;
        this.c = str;
        Factory create = InstanceFactory.create(appCompatActivity);
        this.d = create;
        c cVar = new c(cvPackagesDependencies);
        this.e = cVar;
        this.f = DoubleCheck.provider(CvPackagesNavigator_Factory.create(create, cVar));
        this.g = new e(cvPackagesDependencies);
        d dVar = new d(cvPackagesDependencies);
        this.h = dVar;
        this.i = CvPackagesInteractor_Factory.create(dVar);
        Factory create2 = InstanceFactory.create(str);
        this.j = create2;
        JobCvPackagesViewModel_Factory_Factory create3 = JobCvPackagesViewModel_Factory_Factory.create(this.g, this.i, this.f, create2);
        this.k = create3;
        this.l = CvPackagesModule_ProvideViewModelFactory.create(this.d, create3);
        Provider<PackageBlueprint> provider = DoubleCheck.provider(CvPackagesModule_ProvidePackageBlueprintFactory.create(PackagePresenter_Factory.create(), this.l));
        this.m = provider;
        Provider<ItemBinder> provider2 = DoubleCheck.provider(CvPackagesModule_ProvideItemBinderFactory.create(provider));
        this.n = provider2;
        Provider<AdapterPresenter> provider3 = DoubleCheck.provider(CvPackagesModule_ProvideAdapterPresenterFactory.create(provider2));
        this.o = provider3;
        this.p = DoubleCheck.provider(CvPackagesModule_ProvideSimpleRecyclerAdapterFactory.create(provider3, this.n));
    }

    public static CvPackagesComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.job.cv_packages.di.CvPackagesComponent
    public void inject(JobCvPackagesActivity jobCvPackagesActivity) {
        JobCvPackagesActivity_MembersInjector.injectViewModel(jobCvPackagesActivity, CvPackagesModule_ProvideViewModelFactory.provideViewModel(this.a, new JobCvPackagesViewModel.Factory((SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3()), new CvPackagesInteractor((JobApi) Preconditions.checkNotNullFromComponent(this.b.jobInterviewInvitationApi())), this.f.get(), this.c)));
        JobCvPackagesActivity_MembersInjector.injectAdapter(jobCvPackagesActivity, this.p.get());
        JobCvPackagesActivity_MembersInjector.injectAdapterPresenter(jobCvPackagesActivity, this.o.get());
    }
}
