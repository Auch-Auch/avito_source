package com.avito.android.job.survey.remote;

import com.avito.android.job.survey.remote.model.Field;
import com.avito.android.job.survey.remote.model.JobSeekerSurveyFormResponse;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.avito.android.util.CustomTypedResultEntry;
import com.google.gson.TypeAdapterFactory;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/gson/TypeAdapterFactory;", "createJobSeekerSurveyResponseTypeAdapterFactory", "()Lcom/google/gson/TypeAdapterFactory;", "Lcom/avito/android/util/CustomTypedResultEntry;", "createJobSeekerSurveyResponseCustomTypedResultEntry", "()Lcom/avito/android/util/CustomTypedResultEntry;", "job_release"}, k = 2, mv = {1, 4, 2})
public final class TypeAdaptersKt {
    @NotNull
    public static final CustomTypedResultEntry createJobSeekerSurveyResponseCustomTypedResultEntry() {
        return new CustomTypedResultEntry(JobSeekerSurveyFormResponse.class, r.mapOf(TuplesKt.to("nextStep", JobSeekerSurveyFormResponse.NextStep.class), TuplesKt.to("completed", JobSeekerSurveyFormResponse.Completed.class)));
    }

    @NotNull
    public static final TypeAdapterFactory createJobSeekerSurveyResponseTypeAdapterFactory() {
        return OptimalRuntimeTypeAdapterFactory.Companion.of(Field.class).registerSubtype(Field.RadioGroupField.class, "radioGroup").registerSubtype(Field.TextAreaField.class, "textArea");
    }
}
