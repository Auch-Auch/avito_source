package com.avito.android.job.cv_packages.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.job.JobApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/cv_packages/di/CvPackagesDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/job/JobApi;", "jobInterviewInvitationApi", "()Lcom/avito/android/job/JobApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public interface CvPackagesDependencies extends CoreComponentDependencies {
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @NotNull
    JobApi jobInterviewInvitationApi();
}
