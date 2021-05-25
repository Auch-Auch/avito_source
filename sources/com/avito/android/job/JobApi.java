package com.avito.android.job;

import com.avito.android.job.cv_packages.CvPackagesResponse;
import com.avito.android.job.interview.JobInterviewInvitationResponse;
import com.avito.android.job.progress_bar.ProgressBarResponse;
import com.avito.android.job.survey.remote.model.JobSeekerSurveyFormResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\bJ;\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002H'¢\u0006\u0004\b\u0018\u0010\bJ=\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00050\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/job/JobApi;", "", "", "jobApplyId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse;", "createSurvey", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "surveyId", "formId", AnalyticFieldsName.field, "saveForm", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/interview/JobInterviewInvitationResponse;", "requestInvitationForm", "", "params", "", "invite", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "resumeId", "Lcom/avito/android/job/cv_packages/CvPackagesResponse;", "requestPackages", "vacancyId", "vacancyTitle", "locationId", "Lcom/avito/android/job/progress_bar/ProgressBarResponse;", "requestApplicationProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "job_release"}, k = 1, mv = {1, 4, 2})
public interface JobApi {
    @StreamParsing
    @NotNull
    @POST("1/job/survey/create/{jobApplyId}")
    Observable<TypedResult<JobSeekerSurveyFormResponse>> createSurvey(@Path("jobApplyId") @NotNull String str);

    @StreamParsing
    @NotNull
    @FormUrlEncoded
    @POST("2/job/interview/invite/{jobApplyId}")
    Observable<TypedResult<Unit>> invite(@Path("jobApplyId") @NotNull String str, @FieldMap @NotNull Map<String, String> map);

    @StreamParsing
    @GET("1/job/vacancy/progress")
    @NotNull
    Observable<TypedResult<ProgressBarResponse>> requestApplicationProgress(@NotNull @Query("vacancyId") String str, @NotNull @Query("vacancyTitle") String str2, @Nullable @Query("locationId") String str3);

    @StreamParsing
    @GET("2/job/interview/get-tpl/{jobApplyId}")
    @NotNull
    Observable<TypedResult<JobInterviewInvitationResponse>> requestInvitationForm(@Path("jobApplyId") @NotNull String str);

    @StreamParsing
    @GET("1/job/resume/packages/{resumeId}")
    @NotNull
    Observable<TypedResult<CvPackagesResponse>> requestPackages(@Path("resumeId") @NotNull String str);

    @StreamParsing
    @NotNull
    @FormUrlEncoded
    @POST("1/job/survey/forms/save")
    Observable<TypedResult<JobSeekerSurveyFormResponse>> saveForm(@Field("surveyId") int i, @Field("formId") @NotNull String str, @Field("value") @NotNull String str2);
}
