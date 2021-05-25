package com.avito.android.job.survey.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.job.survey.JobSeekerSurveyFormActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/job/survey/di/SeekerSurveyComponent;", "", "Lcom/avito/android/job/survey/JobSeekerSurveyFormActivity;", "jobSeekerSurveyFormActivity", "", "inject", "(Lcom/avito/android/job/survey/JobSeekerSurveyFormActivity;)V", "Builder", "survey_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SeekerSurveyDependencies.class}, modules = {SeekerSurveyModule.class})
@PerActivity
public interface SeekerSurveyComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/job/survey/di/SeekerSurveyComponent$Builder;", "", "Lcom/avito/android/job/survey/di/SeekerSurveyDependencies;", "dependencies", "(Lcom/avito/android/job/survey/di/SeekerSurveyDependencies;)Lcom/avito/android/job/survey/di/SeekerSurveyComponent$Builder;", "Lcom/avito/android/job/survey/di/SeekerSurveyModule;", "seekerSurveyModule", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/job/survey/di/SeekerSurveyModule;)Lcom/avito/android/job/survey/di/SeekerSurveyComponent$Builder;", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "(Landroidx/appcompat/app/AppCompatActivity;)Lcom/avito/android/job/survey/di/SeekerSurveyComponent$Builder;", "Lcom/avito/android/job/survey/di/SeekerSurveyComponent;", "build", "()Lcom/avito/android/job/survey/di/SeekerSurveyComponent;", "survey_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull AppCompatActivity appCompatActivity);

        @NotNull
        SeekerSurveyComponent build();

        @NotNull
        Builder dependencies(@NotNull SeekerSurveyDependencies seekerSurveyDependencies);

        @NotNull
        Builder module(@NotNull SeekerSurveyModule seekerSurveyModule);
    }

    void inject(@NotNull JobSeekerSurveyFormActivity jobSeekerSurveyFormActivity);
}
