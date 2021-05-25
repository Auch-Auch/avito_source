package com.avito.android.job.survey.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.JobApi;
import com.avito.android.job.survey.JobSeekerSurveyFormActivity;
import com.avito.android.job.survey.JobSeekerSurveyFormActivity_MembersInjector;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.job.survey.SurveyFormInteractor;
import com.avito.android.job.survey.SurveyFormViewModelFactory;
import com.avito.android.job.survey.di.SeekerSurveyComponent;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSeekerSurveyComponent implements SeekerSurveyComponent {
    public Provider<SchedulersFactory3> a;
    public Provider<JobApi> b;
    public Provider<SurveyFormInteractor> c;
    public Provider<SurveyFormViewModelFactory> d;
    public Provider<AppCompatActivity> e;
    public Provider<JobSeekerSurveyFormViewModel> f;

    public static final class b implements SeekerSurveyComponent.Builder {
        public SeekerSurveyDependencies a;
        public AppCompatActivity b;

        public b(a aVar) {
        }

        @Override // com.avito.android.job.survey.di.SeekerSurveyComponent.Builder
        public SeekerSurveyComponent.Builder activity(AppCompatActivity appCompatActivity) {
            this.b = (AppCompatActivity) Preconditions.checkNotNull(appCompatActivity);
            return this;
        }

        @Override // com.avito.android.job.survey.di.SeekerSurveyComponent.Builder
        public SeekerSurveyComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SeekerSurveyDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AppCompatActivity.class);
            return new DaggerSeekerSurveyComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.job.survey.di.SeekerSurveyComponent.Builder
        public SeekerSurveyComponent.Builder dependencies(SeekerSurveyDependencies seekerSurveyDependencies) {
            this.a = (SeekerSurveyDependencies) Preconditions.checkNotNull(seekerSurveyDependencies);
            return this;
        }

        @Override // com.avito.android.job.survey.di.SeekerSurveyComponent.Builder
        @Deprecated
        public SeekerSurveyComponent.Builder module(SeekerSurveyModule seekerSurveyModule) {
            Preconditions.checkNotNull(seekerSurveyModule);
            return this;
        }
    }

    public static class c implements Provider<JobApi> {
        public final SeekerSurveyDependencies a;

        public c(SeekerSurveyDependencies seekerSurveyDependencies) {
            this.a = seekerSurveyDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public JobApi get() {
            return (JobApi) Preconditions.checkNotNullFromComponent(this.a.jobSeekerSurveyApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final SeekerSurveyDependencies a;

        public d(SeekerSurveyDependencies seekerSurveyDependencies) {
            this.a = seekerSurveyDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerSeekerSurveyComponent(SeekerSurveyDependencies seekerSurveyDependencies, AppCompatActivity appCompatActivity, a aVar) {
        this.a = new d(seekerSurveyDependencies);
        c cVar = new c(seekerSurveyDependencies);
        this.b = cVar;
        Provider<SurveyFormInteractor> provider = DoubleCheck.provider(SeekerSurveyModule_Declarations_ProvideSurveyFormInteractorFactory.create(cVar));
        this.c = provider;
        this.d = DoubleCheck.provider(SeekerSurveyModule_Declarations_BindViewModuleFactoryFactory.create(this.a, provider));
        Factory create = InstanceFactory.create(appCompatActivity);
        this.e = create;
        this.f = DoubleCheck.provider(SeekerSurveyModule_ProvideViewModelFactory.create(this.d, create));
    }

    public static SeekerSurveyComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.job.survey.di.SeekerSurveyComponent
    public void inject(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity) {
        JobSeekerSurveyFormActivity_MembersInjector.injectJobSeekerSurveyFormViewModel(jobSeekerSurveyFormActivity, this.f.get());
    }
}
