package com.avito.android.job.survey.di;

import com.avito.android.job.JobApi;
import com.avito.android.job.survey.SurveyFormInteractor;
import com.avito.android.job.survey.di.SeekerSurveyModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SeekerSurveyModule_Declarations_ProvideSurveyFormInteractorFactory implements Factory<SurveyFormInteractor> {
    public final Provider<JobApi> a;

    public SeekerSurveyModule_Declarations_ProvideSurveyFormInteractorFactory(Provider<JobApi> provider) {
        this.a = provider;
    }

    public static SeekerSurveyModule_Declarations_ProvideSurveyFormInteractorFactory create(Provider<JobApi> provider) {
        return new SeekerSurveyModule_Declarations_ProvideSurveyFormInteractorFactory(provider);
    }

    public static SurveyFormInteractor provideSurveyFormInteractor(JobApi jobApi) {
        return (SurveyFormInteractor) Preconditions.checkNotNullFromProvides(SeekerSurveyModule.Declarations.provideSurveyFormInteractor(jobApi));
    }

    @Override // javax.inject.Provider
    public SurveyFormInteractor get() {
        return provideSurveyFormInteractor(this.a.get());
    }
}
