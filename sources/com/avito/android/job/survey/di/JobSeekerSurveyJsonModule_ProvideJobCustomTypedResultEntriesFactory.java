package com.avito.android.job.survey.di;

import com.avito.android.util.CustomTypedResultEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class JobSeekerSurveyJsonModule_ProvideJobCustomTypedResultEntriesFactory implements Factory<Set<CustomTypedResultEntry>> {

    public static final class a {
        public static final JobSeekerSurveyJsonModule_ProvideJobCustomTypedResultEntriesFactory a = new JobSeekerSurveyJsonModule_ProvideJobCustomTypedResultEntriesFactory();
    }

    public static JobSeekerSurveyJsonModule_ProvideJobCustomTypedResultEntriesFactory create() {
        return a.a;
    }

    public static Set<CustomTypedResultEntry> provideJobCustomTypedResultEntries() {
        return (Set) Preconditions.checkNotNullFromProvides(JobSeekerSurveyJsonModule.provideJobCustomTypedResultEntries());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypedResultEntry> get() {
        return provideJobCustomTypedResultEntries();
    }
}
