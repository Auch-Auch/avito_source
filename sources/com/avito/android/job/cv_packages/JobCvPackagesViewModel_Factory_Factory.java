package com.avito.android.job.cv_packages;

import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class JobCvPackagesViewModel_Factory_Factory implements Factory<JobCvPackagesViewModel.Factory> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<CvPackagesInteractor> b;
    public final Provider<CvPackagesNavigator> c;
    public final Provider<String> d;

    public JobCvPackagesViewModel_Factory_Factory(Provider<SchedulersFactory3> provider, Provider<CvPackagesInteractor> provider2, Provider<CvPackagesNavigator> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static JobCvPackagesViewModel_Factory_Factory create(Provider<SchedulersFactory3> provider, Provider<CvPackagesInteractor> provider2, Provider<CvPackagesNavigator> provider3, Provider<String> provider4) {
        return new JobCvPackagesViewModel_Factory_Factory(provider, provider2, provider3, provider4);
    }

    public static JobCvPackagesViewModel.Factory newInstance(SchedulersFactory3 schedulersFactory3, CvPackagesInteractor cvPackagesInteractor, CvPackagesNavigator cvPackagesNavigator, String str) {
        return new JobCvPackagesViewModel.Factory(schedulersFactory3, cvPackagesInteractor, cvPackagesNavigator, str);
    }

    @Override // javax.inject.Provider
    public JobCvPackagesViewModel.Factory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
