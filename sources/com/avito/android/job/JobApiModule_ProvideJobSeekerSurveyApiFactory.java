package com.avito.android.job;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class JobApiModule_ProvideJobSeekerSurveyApiFactory implements Factory<JobApi> {
    public final Provider<RetrofitFactory> a;

    public JobApiModule_ProvideJobSeekerSurveyApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static JobApiModule_ProvideJobSeekerSurveyApiFactory create(Provider<RetrofitFactory> provider) {
        return new JobApiModule_ProvideJobSeekerSurveyApiFactory(provider);
    }

    public static JobApi provideJobSeekerSurveyApi(RetrofitFactory retrofitFactory) {
        return (JobApi) Preconditions.checkNotNullFromProvides(JobApiModule.provideJobSeekerSurveyApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public JobApi get() {
        return provideJobSeekerSurveyApi(this.a.get());
    }
}
