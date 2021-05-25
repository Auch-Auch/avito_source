package com.avito.android.job.cv_packages;

import com.avito.android.job.JobApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/job/cv_packages/CvPackagesInteractor;", "", "", "resumeId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/job/cv_packages/CvPackagesResponse;", "requestPackagesInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/JobApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/JobApi;", "jobApi", "<init>", "(Lcom/avito/android/job/JobApi;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class CvPackagesInteractor {
    public final JobApi a;

    @Inject
    public CvPackagesInteractor(@NotNull JobApi jobApi) {
        Intrinsics.checkNotNullParameter(jobApi, "jobApi");
        this.a = jobApi;
    }

    @NotNull
    public final Observable<TypedResult<CvPackagesResponse>> requestPackagesInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resumeId");
        return this.a.requestPackages(str);
    }
}
