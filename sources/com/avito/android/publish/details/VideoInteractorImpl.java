package com.avito.android.publish.details;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VideoPreview;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/details/VideoInteractorImpl;", "Lcom/avito/android/publish/details/VideoInteractor;", "", "url", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/VideoPreview;", "getVideoPreview", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class VideoInteractorImpl implements VideoInteractor {
    public final PublishApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<VideoPreview>, LoadingState<? super VideoPreview>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super VideoPreview> apply(TypedResult<VideoPreview> typedResult) {
            TypedResult<VideoPreview> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public VideoInteractorImpl(@NotNull PublishApi publishApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = publishApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.publish.details.VideoInteractor
    @NotNull
    public Observable<LoadingState<VideoPreview>> getVideoPreview(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return a2.b.a.a.a.T1(this.b, InteropKt.toV2(this.a.getVideoPreview(str)).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).subscribeOn(this.b.io()), "publishApi\n            .…(schedulers.mainThread())");
    }
}
