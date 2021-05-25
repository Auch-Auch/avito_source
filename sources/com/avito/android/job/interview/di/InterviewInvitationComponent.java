package com.avito.android.job.interview.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.interview.JobInterviewInvitationActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {InterviewInvitationDependencies.class}, modules = {InterviewInvitationModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/job/interview/di/InterviewInvitationComponent;", "", "Lcom/avito/android/job/interview/JobInterviewInvitationActivity;", "activity", "", "inject", "(Lcom/avito/android/job/interview/JobInterviewInvitationActivity;)V", "Factory", "interview_release"}, k = 1, mv = {1, 4, 2})
public interface InterviewInvitationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/job/interview/di/InterviewInvitationComponent$Factory;", "", "Lcom/avito/android/job/interview/di/InterviewInvitationDependencies;", "dependencies", "", "jobApplyId", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/avito/android/job/interview/di/InterviewInvitationComponent;", "buildComponent", "(Lcom/avito/android/job/interview/di/InterviewInvitationDependencies;Ljava/lang/String;Landroidx/appcompat/app/AppCompatActivity;)Lcom/avito/android/job/interview/di/InterviewInvitationComponent;", "interview_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        InterviewInvitationComponent buildComponent(@NotNull InterviewInvitationDependencies interviewInvitationDependencies, @BindsInstance @NotNull String str, @BindsInstance @NotNull AppCompatActivity appCompatActivity);
    }

    void inject(@NotNull JobInterviewInvitationActivity jobInterviewInvitationActivity);
}
