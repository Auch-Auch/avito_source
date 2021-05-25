package com.avito.android.job.survey.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.job.common.Action;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "NextStep", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse$NextStep;", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse$Completed;", "job_release"}, k = 1, mv = {1, 4, 2})
public abstract class JobSeekerSurveyFormResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse$Completed;", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "job_release"}, k = 1, mv = {1, 4, 2})
    public static final class Completed extends JobSeekerSurveyFormResponse {
        @SerializedName("deeplink")
        @NotNull
        private final DeepLink deeplink;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Completed(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.deeplink = deepLink;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.deeplink;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse$NextStep;", "Lcom/avito/android/job/survey/remote/model/JobSeekerSurveyFormResponse;", "", "surveyId", "I", "getSurveyId", "()I", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "Lcom/avito/android/job/common/Action;", "action", "Lcom/avito/android/job/common/Action;", "getAction", "()Lcom/avito/android/job/common/Action;", "title", "getTitle", "Lcom/avito/android/job/survey/remote/model/Field;", AnalyticFieldsName.field, "Lcom/avito/android/job/survey/remote/model/Field;", "getField", "()Lcom/avito/android/job/survey/remote/model/Field;", "formId", "getFormId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/job/survey/remote/model/Field;Lcom/avito/android/job/common/Action;)V", "job_release"}, k = 1, mv = {1, 4, 2})
    public static final class NextStep extends JobSeekerSurveyFormResponse {
        @SerializedName("action")
        @NotNull
        private final Action action;
        @SerializedName(AnalyticFieldsName.field)
        @NotNull
        private final Field field;
        @SerializedName("formId")
        @NotNull
        private final String formId;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("surveyId")
        private final int surveyId;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NextStep(@NotNull String str, int i, @NotNull String str2, @Nullable String str3, @NotNull Field field2, @NotNull Action action2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "formId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(field2, AnalyticFieldsName.field);
            Intrinsics.checkNotNullParameter(action2, "action");
            this.formId = str;
            this.surveyId = i;
            this.title = str2;
            this.subtitle = str3;
            this.field = field2;
            this.action = action2;
        }

        @NotNull
        public final Action getAction() {
            return this.action;
        }

        @NotNull
        public final Field getField() {
            return this.field;
        }

        @NotNull
        public final String getFormId() {
            return this.formId;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        public final int getSurveyId() {
            return this.surveyId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    public JobSeekerSurveyFormResponse() {
    }

    public JobSeekerSurveyFormResponse(j jVar) {
    }
}
