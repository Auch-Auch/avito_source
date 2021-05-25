package com.avito.android.job.survey.di;

import com.avito.android.di.module.StreamGson;
import com.avito.android.job.survey.remote.TypeAdaptersKt;
import com.avito.android.util.CustomTypedResultEntry;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/job/survey/di/JobSeekerSurveyJsonModule;", "", "", "Lcom/google/gson/TypeAdapterFactory;", "provideJobTypeAdapterFactories", "()Ljava/util/Set;", "Lcom/avito/android/util/CustomTypedResultEntry;", "provideJobCustomTypedResultEntries", "<init>", "()V", "job_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class JobSeekerSurveyJsonModule {
    @NotNull
    public static final JobSeekerSurveyJsonModule INSTANCE = new JobSeekerSurveyJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<CustomTypedResultEntry> provideJobCustomTypedResultEntries() {
        return x.setOf(TypeAdaptersKt.createJobSeekerSurveyResponseCustomTypedResultEntry());
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideJobTypeAdapterFactories() {
        return x.setOf(TypeAdaptersKt.createJobSeekerSurveyResponseTypeAdapterFactory());
    }
}
