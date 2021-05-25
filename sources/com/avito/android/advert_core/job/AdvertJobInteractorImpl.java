package com.avito.android.advert_core.job;

import com.avito.android.job.JobApi;
import com.avito.android.job.progress_bar.ProgressBarResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/job/AdvertJobInteractorImpl;", "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "", "vacancyId", "vacancyTitle", "vacancyLocationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/job/progress_bar/ProgressBarResponse;", "requestProgressData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/JobApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/JobApi;", "jobApi", "<init>", "(Lcom/avito/android/job/JobApi;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertJobInteractorImpl implements AdvertJobInteractor {
    public final JobApi a;

    @Inject
    public AdvertJobInteractorImpl(@NotNull JobApi jobApi) {
        Intrinsics.checkNotNullParameter(jobApi, "jobApi");
        this.a = jobApi;
    }

    @Override // com.avito.android.advert_core.job.AdvertJobInteractor
    @NotNull
    public Observable<TypedResult<ProgressBarResponse>> requestProgressData(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "vacancyId");
        Intrinsics.checkNotNullParameter(str2, "vacancyTitle");
        return this.a.requestApplicationProgress(str, str2, str3);
    }
}
