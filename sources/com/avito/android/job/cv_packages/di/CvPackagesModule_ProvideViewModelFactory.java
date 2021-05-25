package com.avito.android.job.cv_packages.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CvPackagesModule_ProvideViewModelFactory implements Factory<JobCvPackagesViewModel> {
    public final Provider<AppCompatActivity> a;
    public final Provider<JobCvPackagesViewModel.Factory> b;

    public CvPackagesModule_ProvideViewModelFactory(Provider<AppCompatActivity> provider, Provider<JobCvPackagesViewModel.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CvPackagesModule_ProvideViewModelFactory create(Provider<AppCompatActivity> provider, Provider<JobCvPackagesViewModel.Factory> provider2) {
        return new CvPackagesModule_ProvideViewModelFactory(provider, provider2);
    }

    public static JobCvPackagesViewModel provideViewModel(AppCompatActivity appCompatActivity, JobCvPackagesViewModel.Factory factory) {
        return (JobCvPackagesViewModel) Preconditions.checkNotNullFromProvides(CvPackagesModule.provideViewModel(appCompatActivity, factory));
    }

    @Override // javax.inject.Provider
    public JobCvPackagesViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
