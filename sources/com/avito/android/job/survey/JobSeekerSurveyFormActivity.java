package com.avito.android.job.survey;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.JobSeekerSaveFormLink;
import com.avito.android.deep_linking.links.JobSeekerSurveyCompletedLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.job.survey.di.DaggerSeekerSurveyComponent;
import com.avito.android.job.survey.di.SeekerSurveyDependencies;
import com.avito.android.job.survey.di.SeekerSurveyModule;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0006R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "Lcom/avito/android/job/survey/JobSeekerSurveyFormView;", "jobSeekerSurveyFormView", "Lcom/avito/android/job/survey/JobSeekerSurveyFormView;", "getJobSeekerSurveyFormView", "()Lcom/avito/android/job/survey/JobSeekerSurveyFormView;", "setJobSeekerSurveyFormView", "(Lcom/avito/android/job/survey/JobSeekerSurveyFormView;)V", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "jobSeekerSurveyFormViewModel", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "getJobSeekerSurveyFormViewModel", "()Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "setJobSeekerSurveyFormViewModel", "(Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;)V", "<init>", "()V", "survey_release"}, k = 1, mv = {1, 4, 2})
public final class JobSeekerSurveyFormActivity extends BaseActivity {
    public JobSeekerSurveyFormView jobSeekerSurveyFormView;
    @Inject
    public JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                JobSeekerSurveyFormView jobSeekerSurveyFormView = ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView();
                Intrinsics.checkNotNullExpressionValue(str2, "message");
                jobSeekerSurveyFormView.showErrorMessageSnackbar(str2);
            } else if (i == 1) {
                String str3 = str;
                JobSeekerSurveyFormView jobSeekerSurveyFormView2 = ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView();
                Intrinsics.checkNotNullExpressionValue(str3, "value");
                jobSeekerSurveyFormView2.setValue(str3);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Observer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                JobSeekerSurveyFormView jobSeekerSurveyFormView = ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView();
                Intrinsics.checkNotNullExpressionValue(bool2, "value");
                jobSeekerSurveyFormView.setRefreshButtonLoadingState(bool2.booleanValue());
            } else if (i == 1) {
                Boolean bool3 = bool;
                JobSeekerSurveyFormView jobSeekerSurveyFormView2 = ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView();
                Intrinsics.checkNotNullExpressionValue(bool3, "it");
                jobSeekerSurveyFormView2.setButtonLoading(bool3.booleanValue());
                ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView().setFormEnabled(!bool3.booleanValue());
            } else if (i == 2) {
                Boolean bool4 = bool;
                JobSeekerSurveyFormView jobSeekerSurveyFormView3 = ((JobSeekerSurveyFormActivity) this.b).getJobSeekerSurveyFormView();
                Intrinsics.checkNotNullExpressionValue(bool4, "it");
                jobSeekerSurveyFormView3.setButtonEnabled(bool4.booleanValue());
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ JobSeekerSurveyFormActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity) {
            super(1);
            this.a = jobSeekerSurveyFormActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a.getJobSeekerSurveyFormViewModel().setValue(str2);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JobSeekerSurveyFormActivity a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity, String str) {
            super(0);
            this.a = jobSeekerSurveyFormActivity;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getJobSeekerSurveyFormViewModel().recreateSurvey(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements Observer<JobSeekerSurveyFormViewModel.ViewState> {
        public final /* synthetic */ JobSeekerSurveyFormActivity a;

        public f(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity) {
            this.a = jobSeekerSurveyFormActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(JobSeekerSurveyFormViewModel.ViewState viewState) {
            JobSeekerSurveyFormViewModel.ViewState viewState2 = viewState;
            if (viewState2 instanceof JobSeekerSurveyFormViewModel.ViewState.FormViewState) {
                this.a.getJobSeekerSurveyFormView().renderForm((JobSeekerSurveyFormViewModel.ViewState.FormViewState) viewState2);
            } else if (viewState2 instanceof JobSeekerSurveyFormViewModel.ViewState.Loading) {
                this.a.getJobSeekerSurveyFormView().showLoading();
            } else if (viewState2 instanceof JobSeekerSurveyFormViewModel.ViewState.Error) {
                this.a.getJobSeekerSurveyFormView().showError(((JobSeekerSurveyFormViewModel.ViewState.Error) viewState2).getMessage());
            }
        }
    }

    public static final class g<T> implements Observer<DeepLink> {
        public final /* synthetic */ JobSeekerSurveyFormActivity a;

        public g(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity) {
            this.a = jobSeekerSurveyFormActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "deeplink");
            JobSeekerSurveyFormActivity.access$handleDeeplink(jobSeekerSurveyFormActivity, deepLink2);
        }
    }

    public static final void access$handleDeeplink(JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity, DeepLink deepLink) {
        Objects.requireNonNull(jobSeekerSurveyFormActivity);
        if (deepLink instanceof JobSeekerSaveFormLink) {
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel2 = jobSeekerSurveyFormActivity.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel2.onSaveButtonClick();
        } else if (deepLink instanceof JobSeekerSurveyCompletedLink) {
            jobSeekerSurveyFormActivity.finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.job_seeker_survey_form_activity;
    }

    @NotNull
    public final JobSeekerSurveyFormView getJobSeekerSurveyFormView() {
        JobSeekerSurveyFormView jobSeekerSurveyFormView2 = this.jobSeekerSurveyFormView;
        if (jobSeekerSurveyFormView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormView");
        }
        return jobSeekerSurveyFormView2;
    }

    @NotNull
    public final JobSeekerSurveyFormViewModel getJobSeekerSurveyFormViewModel() {
        JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel2 = this.jobSeekerSurveyFormViewModel;
        if (jobSeekerSurveyFormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
        }
        return jobSeekerSurveyFormViewModel2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("EXTRA_JOB_APPLY_ID");
        if (stringExtra != null) {
            View findViewById = findViewById(16908290);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
            this.jobSeekerSurveyFormView = new JobSeekerSurveyFormView(findViewById, new c(this), new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.job.survey.JobSeekerSurveyFormActivity.d
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(DeepLink deepLink) {
                    DeepLink deepLink2 = deepLink;
                    Intrinsics.checkNotNullParameter(deepLink2, "p1");
                    JobSeekerSurveyFormActivity.access$handleDeeplink((JobSeekerSurveyFormActivity) this.receiver, deepLink2);
                    return Unit.INSTANCE;
                }
            }, new e(this, stringExtra));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel2 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel2.getViewStateLiveData().observe(this, new f(this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel3 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel3.getValueLiveData().observe(this, new a(1, this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel4 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel4.getRefreshButtonLoadingStateLiveData().observe(this, new b(0, this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel5 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel5.getButtonLoadingStateLiveData().observe(this, new b(1, this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel6 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel6.getButtonEnabledStateLiveData().observe(this, new b(2, this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel7 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel7.getDeepLinkLiveData().observe(this, new g(this));
            JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel8 = this.jobSeekerSurveyFormViewModel;
            if (jobSeekerSurveyFormViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
            }
            jobSeekerSurveyFormViewModel8.getToastLiveData().observe(this, new a(0, this));
            if (bundle == null) {
                JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel9 = this.jobSeekerSurveyFormViewModel;
                if (jobSeekerSurveyFormViewModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
                }
                jobSeekerSurveyFormViewModel9.createSurvey(stringExtra);
                return;
            }
            return;
        }
        throw new IllegalStateException("intent.getStringExtra(EXTRA_JOB_APPLY_ID) must not be null");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel2 = this.jobSeekerSurveyFormViewModel;
        if (jobSeekerSurveyFormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jobSeekerSurveyFormViewModel");
        }
        jobSeekerSurveyFormViewModel2.onSaveState();
    }

    public final void setJobSeekerSurveyFormView(@NotNull JobSeekerSurveyFormView jobSeekerSurveyFormView2) {
        Intrinsics.checkNotNullParameter(jobSeekerSurveyFormView2, "<set-?>");
        this.jobSeekerSurveyFormView = jobSeekerSurveyFormView2;
    }

    public final void setJobSeekerSurveyFormViewModel(@NotNull JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel2) {
        Intrinsics.checkNotNullParameter(jobSeekerSurveyFormViewModel2, "<set-?>");
        this.jobSeekerSurveyFormViewModel = jobSeekerSurveyFormViewModel2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerSeekerSurveyComponent.builder().module(SeekerSurveyModule.INSTANCE).dependencies((SeekerSurveyDependencies) ComponentDependenciesKt.getDependencies(SeekerSurveyDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).activity(this).build().inject(this);
        return true;
    }
}
