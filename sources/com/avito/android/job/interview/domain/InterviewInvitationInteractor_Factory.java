package com.avito.android.job.interview.domain;

import com.avito.android.job.JobApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InterviewInvitationInteractor_Factory implements Factory<InterviewInvitationInteractor> {
    public final Provider<InterviewParamsConverter> a;
    public final Provider<JobApi> b;
    public final Provider<String> c;

    public InterviewInvitationInteractor_Factory(Provider<InterviewParamsConverter> provider, Provider<JobApi> provider2, Provider<String> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static InterviewInvitationInteractor_Factory create(Provider<InterviewParamsConverter> provider, Provider<JobApi> provider2, Provider<String> provider3) {
        return new InterviewInvitationInteractor_Factory(provider, provider2, provider3);
    }

    public static InterviewInvitationInteractor newInstance(InterviewParamsConverter interviewParamsConverter, JobApi jobApi, String str) {
        return new InterviewInvitationInteractor(interviewParamsConverter, jobApi, str);
    }

    @Override // javax.inject.Provider
    public InterviewInvitationInteractor get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
