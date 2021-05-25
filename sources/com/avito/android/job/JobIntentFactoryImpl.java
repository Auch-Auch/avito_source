package com.avito.android.job;

import android.app.Application;
import android.content.Intent;
import com.avito.android.JobIntentFactory;
import com.avito.android.job.cv_packages.JobCvPackagesActivityKt;
import com.avito.android.job.interview.JobInterviewInvitationActivity;
import com.avito.android.job.survey.JobSeekerSurveyFormActivityKt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/JobIntentFactoryImpl;", "Lcom/avito/android/JobIntentFactory;", "", "resumeId", "Landroid/content/Intent;", "getJobCvPackagesIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "jobApplyId", "getJobSeekerSurveyIntent", "getInterviewInvitationIntent", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "job_release"}, k = 1, mv = {1, 4, 2})
public class JobIntentFactoryImpl implements JobIntentFactory {
    public final Application a;

    @Inject
    public JobIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.JobIntentFactory
    @NotNull
    public Intent getInterviewInvitationIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        return JobInterviewInvitationActivity.Companion.getIntent(this.a, str);
    }

    @Override // com.avito.android.JobIntentFactory
    @NotNull
    public Intent getJobCvPackagesIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resumeId");
        return JobCvPackagesActivityKt.createCvPackagesActivityIntent(this.a, str);
    }

    @Override // com.avito.android.JobIntentFactory
    @NotNull
    public Intent getJobSeekerSurveyIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        return JobSeekerSurveyFormActivityKt.createSurveyFormActivityIntent(this.a, str);
    }
}
