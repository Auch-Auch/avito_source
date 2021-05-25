package com.avito.android.job.interview;

import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import com.avito.android.job.interview.domain.InterviewInvitationInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class JobInterviewInvitationViewModel_Factory_Factory implements Factory<JobInterviewInvitationViewModel.Factory> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<InterviewInvitationInteractor> b;

    public JobInterviewInvitationViewModel_Factory_Factory(Provider<SchedulersFactory3> provider, Provider<InterviewInvitationInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static JobInterviewInvitationViewModel_Factory_Factory create(Provider<SchedulersFactory3> provider, Provider<InterviewInvitationInteractor> provider2) {
        return new JobInterviewInvitationViewModel_Factory_Factory(provider, provider2);
    }

    public static JobInterviewInvitationViewModel.Factory newInstance(SchedulersFactory3 schedulersFactory3, InterviewInvitationInteractor interviewInvitationInteractor) {
        return new JobInterviewInvitationViewModel.Factory(schedulersFactory3, interviewInvitationInteractor);
    }

    @Override // javax.inject.Provider
    public JobInterviewInvitationViewModel.Factory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
