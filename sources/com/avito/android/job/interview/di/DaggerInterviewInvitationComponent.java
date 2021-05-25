package com.avito.android.job.interview.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.job.JobApi;
import com.avito.android.job.interview.JobInterviewInvitationActivity;
import com.avito.android.job.interview.JobInterviewInvitationActivity_MembersInjector;
import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import com.avito.android.job.interview.di.InterviewInvitationComponent;
import com.avito.android.job.interview.domain.InterviewInvitationInteractor;
import com.avito.android.job.interview.domain.InterviewParamsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Preconditions;
public final class DaggerInterviewInvitationComponent implements InterviewInvitationComponent {
    public final AppCompatActivity a;
    public final InterviewInvitationDependencies b;
    public final String c;

    public static final class b implements InterviewInvitationComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.job.interview.di.InterviewInvitationComponent.Factory
        public InterviewInvitationComponent buildComponent(InterviewInvitationDependencies interviewInvitationDependencies, String str, AppCompatActivity appCompatActivity) {
            Preconditions.checkNotNull(interviewInvitationDependencies);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(appCompatActivity);
            return new DaggerInterviewInvitationComponent(interviewInvitationDependencies, str, appCompatActivity, null);
        }
    }

    public DaggerInterviewInvitationComponent(InterviewInvitationDependencies interviewInvitationDependencies, String str, AppCompatActivity appCompatActivity, a aVar) {
        this.a = appCompatActivity;
        this.b = interviewInvitationDependencies;
        this.c = str;
    }

    public static InterviewInvitationComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.job.interview.di.InterviewInvitationComponent
    public void inject(JobInterviewInvitationActivity jobInterviewInvitationActivity) {
        JobInterviewInvitationActivity_MembersInjector.injectViewModel(jobInterviewInvitationActivity, InterviewInvitationModule_ProviderViewModelFactory.providerViewModel(this.a, new JobInterviewInvitationViewModel.Factory((SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3()), new InterviewInvitationInteractor(new InterviewParamsConverter(), (JobApi) Preconditions.checkNotNullFromComponent(this.b.jobInterviewInvitationApi()), this.c))));
    }
}
