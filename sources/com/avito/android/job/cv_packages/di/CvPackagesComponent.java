package com.avito.android.job.cv_packages.di;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.job.cv_packages.JobCvPackagesActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/job/cv_packages/di/CvPackagesComponent;", "", "Lcom/avito/android/job/cv_packages/JobCvPackagesActivity;", "activity", "", "inject", "(Lcom/avito/android/job/cv_packages/JobCvPackagesActivity;)V", "Factory", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CvPackagesDependencies.class}, modules = {CvPackagesModule.class})
@PerActivity
public interface CvPackagesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/job/cv_packages/di/CvPackagesComponent$Factory;", "", "Lcom/avito/android/job/cv_packages/di/CvPackagesDependencies;", "dependencies", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "resumeId", "Lcom/avito/android/job/cv_packages/di/CvPackagesComponent;", "build", "(Lcom/avito/android/job/cv_packages/di/CvPackagesDependencies;Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;)Lcom/avito/android/job/cv_packages/di/CvPackagesComponent;", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        CvPackagesComponent build(@NotNull CvPackagesDependencies cvPackagesDependencies, @BindsInstance @NotNull AppCompatActivity appCompatActivity, @BindsInstance @ResumeIdQualifier @NotNull String str);
    }

    void inject(@NotNull JobCvPackagesActivity jobCvPackagesActivity);
}
