package com.avito.android.job.cv_packages;

import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class JobCvPackagesActivity_MembersInjector implements MembersInjector<JobCvPackagesActivity> {
    public final Provider<JobCvPackagesViewModel> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;

    public JobCvPackagesActivity_MembersInjector(Provider<JobCvPackagesViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<JobCvPackagesActivity> create(Provider<JobCvPackagesViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3) {
        return new JobCvPackagesActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.job.cv_packages.JobCvPackagesActivity.adapter")
    public static void injectAdapter(JobCvPackagesActivity jobCvPackagesActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        jobCvPackagesActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.job.cv_packages.JobCvPackagesActivity.adapterPresenter")
    public static void injectAdapterPresenter(JobCvPackagesActivity jobCvPackagesActivity, AdapterPresenter adapterPresenter) {
        jobCvPackagesActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.job.cv_packages.JobCvPackagesActivity.viewModel")
    public static void injectViewModel(JobCvPackagesActivity jobCvPackagesActivity, JobCvPackagesViewModel jobCvPackagesViewModel) {
        jobCvPackagesActivity.viewModel = jobCvPackagesViewModel;
    }

    public void injectMembers(JobCvPackagesActivity jobCvPackagesActivity) {
        injectViewModel(jobCvPackagesActivity, this.a.get());
        injectAdapter(jobCvPackagesActivity, this.b.get());
        injectAdapterPresenter(jobCvPackagesActivity, this.c.get());
    }
}
