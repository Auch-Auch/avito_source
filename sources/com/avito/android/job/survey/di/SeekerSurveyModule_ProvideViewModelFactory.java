package com.avito.android.job.survey.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.job.survey.SurveyFormViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SeekerSurveyModule_ProvideViewModelFactory implements Factory<JobSeekerSurveyFormViewModel> {
    public final Provider<SurveyFormViewModelFactory> a;
    public final Provider<AppCompatActivity> b;

    public SeekerSurveyModule_ProvideViewModelFactory(Provider<SurveyFormViewModelFactory> provider, Provider<AppCompatActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SeekerSurveyModule_ProvideViewModelFactory create(Provider<SurveyFormViewModelFactory> provider, Provider<AppCompatActivity> provider2) {
        return new SeekerSurveyModule_ProvideViewModelFactory(provider, provider2);
    }

    public static JobSeekerSurveyFormViewModel provideViewModel(SurveyFormViewModelFactory surveyFormViewModelFactory, AppCompatActivity appCompatActivity) {
        return (JobSeekerSurveyFormViewModel) Preconditions.checkNotNullFromProvides(SeekerSurveyModule.provideViewModel(surveyFormViewModelFactory, appCompatActivity));
    }

    @Override // javax.inject.Provider
    public JobSeekerSurveyFormViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
