package com.avito.android.job.survey;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class JobSeekerSurveyFormActivity_MembersInjector implements MembersInjector<JobSeekerSurveyFormActivity> {
    public final Provider<JobSeekerSurveyFormViewModel> a;

    public JobSeekerSurveyFormActivity_MembersInjector(Provider<JobSeekerSurveyFormViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<JobSeekerSurveyFormActivity> create(Provider<JobSeekerSurveyFormViewModel> provider) {
        return new JobSeekerSurveyFormActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.job.survey.JobSeekerSurveyFormActivity.jobSeekerSurveyFormViewModel")
    public static void injectJobSeekerSurveyFormViewModel(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity, JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
        jobSeekerSurveyFormActivity.jobSeekerSurveyFormViewModel = jobSeekerSurveyFormViewModel;
    }

    public void injectMembers(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity) {
        injectJobSeekerSurveyFormViewModel(jobSeekerSurveyFormActivity, this.a.get());
    }
}
