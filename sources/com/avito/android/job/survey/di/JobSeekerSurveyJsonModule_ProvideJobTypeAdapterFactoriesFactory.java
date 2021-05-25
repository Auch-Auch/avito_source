package com.avito.android.job.survey.di;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class JobSeekerSurveyJsonModule_ProvideJobTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final JobSeekerSurveyJsonModule_ProvideJobTypeAdapterFactoriesFactory a = new JobSeekerSurveyJsonModule_ProvideJobTypeAdapterFactoriesFactory();
    }

    public static JobSeekerSurveyJsonModule_ProvideJobTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideJobTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(JobSeekerSurveyJsonModule.provideJobTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideJobTypeAdapterFactories();
    }
}
