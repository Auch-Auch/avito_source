package com.avito.android.job.cv_packages.di;

import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import com.avito.android.job.cv_packages.item.PackageBlueprint;
import com.avito.android.job.cv_packages.item.PackagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CvPackagesModule_ProvidePackageBlueprintFactory implements Factory<PackageBlueprint> {
    public final Provider<PackagePresenter> a;
    public final Provider<JobCvPackagesViewModel> b;

    public CvPackagesModule_ProvidePackageBlueprintFactory(Provider<PackagePresenter> provider, Provider<JobCvPackagesViewModel> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CvPackagesModule_ProvidePackageBlueprintFactory create(Provider<PackagePresenter> provider, Provider<JobCvPackagesViewModel> provider2) {
        return new CvPackagesModule_ProvidePackageBlueprintFactory(provider, provider2);
    }

    public static PackageBlueprint providePackageBlueprint(PackagePresenter packagePresenter, JobCvPackagesViewModel jobCvPackagesViewModel) {
        return (PackageBlueprint) Preconditions.checkNotNullFromProvides(CvPackagesModule.providePackageBlueprint(packagePresenter, jobCvPackagesViewModel));
    }

    @Override // javax.inject.Provider
    public PackageBlueprint get() {
        return providePackageBlueprint(this.a.get(), this.b.get());
    }
}
