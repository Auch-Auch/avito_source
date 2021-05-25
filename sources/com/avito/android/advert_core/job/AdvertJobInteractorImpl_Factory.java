package com.avito.android.advert_core.job;

import com.avito.android.job.JobApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertJobInteractorImpl_Factory implements Factory<AdvertJobInteractorImpl> {
    public final Provider<JobApi> a;

    public AdvertJobInteractorImpl_Factory(Provider<JobApi> provider) {
        this.a = provider;
    }

    public static AdvertJobInteractorImpl_Factory create(Provider<JobApi> provider) {
        return new AdvertJobInteractorImpl_Factory(provider);
    }

    public static AdvertJobInteractorImpl newInstance(JobApi jobApi) {
        return new AdvertJobInteractorImpl(jobApi);
    }

    @Override // javax.inject.Provider
    public AdvertJobInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
