package com.avito.android.job.cv_packages;

import com.avito.android.job.JobApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CvPackagesInteractor_Factory implements Factory<CvPackagesInteractor> {
    public final Provider<JobApi> a;

    public CvPackagesInteractor_Factory(Provider<JobApi> provider) {
        this.a = provider;
    }

    public static CvPackagesInteractor_Factory create(Provider<JobApi> provider) {
        return new CvPackagesInteractor_Factory(provider);
    }

    public static CvPackagesInteractor newInstance(JobApi jobApi) {
        return new CvPackagesInteractor(jobApi);
    }

    @Override // javax.inject.Provider
    public CvPackagesInteractor get() {
        return newInstance(this.a.get());
    }
}
