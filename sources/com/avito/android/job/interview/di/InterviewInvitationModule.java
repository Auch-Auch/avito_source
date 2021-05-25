package com.avito.android.job.interview.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/job/interview/di/InterviewInvitationModule;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/avito/android/job/interview/JobInterviewInvitationViewModel$Factory;", "factory", "Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "providerViewModel", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/avito/android/job/interview/JobInterviewInvitationViewModel$Factory;)Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class InterviewInvitationModule {
    @NotNull
    public static final InterviewInvitationModule INSTANCE = new InterviewInvitationModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final JobInterviewInvitationViewModel providerViewModel(@NotNull AppCompatActivity appCompatActivity, @NotNull JobInterviewInvitationViewModel.Factory factory) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = new ViewModelProvider(appCompatActivity, factory).get(JobInterviewInvitationViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…ionViewModel::class.java)");
        return (JobInterviewInvitationViewModel) viewModel;
    }
}
