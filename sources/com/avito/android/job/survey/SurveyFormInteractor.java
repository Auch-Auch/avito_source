package com.avito.android.job.survey;

import com.avito.android.job.JobApi;
import com.avito.android.job.survey.remote.model.JobSeekerSurveyFormResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/job/survey/SurveyFormInteractor;", "", "", "jobApplyId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse;", "createSurvey", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "surveyId", "formId", "value", "saveForm", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/JobApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/JobApi;", "jobApi", "<init>", "(Lcom/avito/android/job/JobApi;)V", "survey_release"}, k = 1, mv = {1, 4, 2})
public final class SurveyFormInteractor {
    public final JobApi a;

    public SurveyFormInteractor(@NotNull JobApi jobApi) {
        Intrinsics.checkNotNullParameter(jobApi, "jobApi");
        this.a = jobApi;
    }

    @NotNull
    public final Observable<TypedResult<JobSeekerSurveyFormResponse>> createSurvey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        return this.a.createSurvey(str);
    }

    @NotNull
    public final Observable<TypedResult<JobSeekerSurveyFormResponse>> saveForm(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "formId");
        Intrinsics.checkNotNullParameter(str2, "value");
        return this.a.saveForm(i, str, str2);
    }
}
