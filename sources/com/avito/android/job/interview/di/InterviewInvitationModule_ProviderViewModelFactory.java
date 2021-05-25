package com.avito.android.job.interview.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InterviewInvitationModule_ProviderViewModelFactory implements Factory<JobInterviewInvitationViewModel> {
    public final Provider<AppCompatActivity> a;
    public final Provider<JobInterviewInvitationViewModel.Factory> b;

    public InterviewInvitationModule_ProviderViewModelFactory(Provider<AppCompatActivity> provider, Provider<JobInterviewInvitationViewModel.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InterviewInvitationModule_ProviderViewModelFactory create(Provider<AppCompatActivity> provider, Provider<JobInterviewInvitationViewModel.Factory> provider2) {
        return new InterviewInvitationModule_ProviderViewModelFactory(provider, provider2);
    }

    public static JobInterviewInvitationViewModel providerViewModel(AppCompatActivity appCompatActivity, JobInterviewInvitationViewModel.Factory factory) {
        return (JobInterviewInvitationViewModel) Preconditions.checkNotNullFromProvides(InterviewInvitationModule.providerViewModel(appCompatActivity, factory));
    }

    @Override // javax.inject.Provider
    public JobInterviewInvitationViewModel get() {
        return providerViewModel(this.a.get(), this.b.get());
    }
}
