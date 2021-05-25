package com.avito.android.job.survey.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerActivity;
import com.avito.android.job.JobApi;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.job.survey.SurveyFormInteractor;
import com.avito.android.job.survey.SurveyFormViewModelFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/job/survey/di/SeekerSurveyModule;", "", "Lcom/avito/android/job/survey/SurveyFormViewModelFactory;", "factory", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "provideViewModel", "(Lcom/avito/android/job/survey/SurveyFormViewModelFactory;Landroidx/appcompat/app/AppCompatActivity;)Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "<init>", "()V", "Declarations", "survey_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SeekerSurveyModule {
    @NotNull
    public static final SeekerSurveyModule INSTANCE = new SeekerSurveyModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/job/survey/di/SeekerSurveyModule$Declarations;", "", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/job/survey/SurveyFormInteractor;", "surveyFormInteractor", "Lcom/avito/android/job/survey/SurveyFormViewModelFactory;", "bindViewModuleFactory", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/job/survey/SurveyFormInteractor;)Lcom/avito/android/job/survey/SurveyFormViewModelFactory;", "Lcom/avito/android/job/JobApi;", "jobApi", "provideSurveyFormInteractor", "(Lcom/avito/android/job/JobApi;)Lcom/avito/android/job/survey/SurveyFormInteractor;", "<init>", "()V", "survey_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static final class Declarations {
        @NotNull
        public static final Declarations INSTANCE = new Declarations();

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final SurveyFormViewModelFactory bindViewModuleFactory(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull SurveyFormInteractor surveyFormInteractor) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
            Intrinsics.checkNotNullParameter(surveyFormInteractor, "surveyFormInteractor");
            return new SurveyFormViewModelFactory(schedulersFactory3, surveyFormInteractor);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final SurveyFormInteractor provideSurveyFormInteractor(@NotNull JobApi jobApi) {
            Intrinsics.checkNotNullParameter(jobApi, "jobApi");
            return new SurveyFormInteractor(jobApi);
        }
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final JobSeekerSurveyFormViewModel provideViewModel(@NotNull SurveyFormViewModelFactory surveyFormViewModelFactory, @NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(surveyFormViewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        ViewModel viewModel = ViewModelProviders.of(appCompatActivity, surveyFormViewModelFactory).get(JobSeekerSurveyFormViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…ormViewModel::class.java)");
        return (JobSeekerSurveyFormViewModel) viewModel;
    }
}
