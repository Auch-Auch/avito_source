package com.avito.android.job.interview;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class JobInterviewInvitationActivity_MembersInjector implements MembersInjector<JobInterviewInvitationActivity> {
    public final Provider<JobInterviewInvitationViewModel> a;

    public JobInterviewInvitationActivity_MembersInjector(Provider<JobInterviewInvitationViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<JobInterviewInvitationActivity> create(Provider<JobInterviewInvitationViewModel> provider) {
        return new JobInterviewInvitationActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.job.interview.JobInterviewInvitationActivity.viewModel")
    public static void injectViewModel(JobInterviewInvitationActivity jobInterviewInvitationActivity, JobInterviewInvitationViewModel jobInterviewInvitationViewModel) {
        jobInterviewInvitationActivity.viewModel = jobInterviewInvitationViewModel;
    }

    public void injectMembers(JobInterviewInvitationActivity jobInterviewInvitationActivity) {
        injectViewModel(jobInterviewInvitationActivity, this.a.get());
    }
}
