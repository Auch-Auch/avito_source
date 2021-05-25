package com.avito.android.job.survey.di;

import com.avito.android.job.survey.SurveyFormInteractor;
import com.avito.android.job.survey.SurveyFormViewModelFactory;
import com.avito.android.job.survey.di.SeekerSurveyModule;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SeekerSurveyModule_Declarations_BindViewModuleFactoryFactory implements Factory<SurveyFormViewModelFactory> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<SurveyFormInteractor> b;

    public SeekerSurveyModule_Declarations_BindViewModuleFactoryFactory(Provider<SchedulersFactory3> provider, Provider<SurveyFormInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SurveyFormViewModelFactory bindViewModuleFactory(SchedulersFactory3 schedulersFactory3, SurveyFormInteractor surveyFormInteractor) {
        return (SurveyFormViewModelFactory) Preconditions.checkNotNullFromProvides(SeekerSurveyModule.Declarations.bindViewModuleFactory(schedulersFactory3, surveyFormInteractor));
    }

    public static SeekerSurveyModule_Declarations_BindViewModuleFactoryFactory create(Provider<SchedulersFactory3> provider, Provider<SurveyFormInteractor> provider2) {
        return new SeekerSurveyModule_Declarations_BindViewModuleFactoryFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public SurveyFormViewModelFactory get() {
        return bindViewModuleFactory(this.a.get(), this.b.get());
    }
}
