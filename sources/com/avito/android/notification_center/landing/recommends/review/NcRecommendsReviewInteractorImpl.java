package com.avito.android.notification_center.landing.recommends.review;

import com.avito.android.notification_center.landing.recommends.review.di.Id;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedbackResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractorImpl;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;", "", AvatarStatus.REVIEW, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedbackResult;", "send", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/NotificationsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/NotificationsApi;", "api", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewInteractorImpl implements NcRecommendsReviewInteractor {
    public final String a;
    public final NotificationsApi b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<TypedResult<NcRecommendsFeedbackResult>, LoadingState<? super NcRecommendsFeedbackResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super NcRecommendsFeedbackResult> apply(TypedResult<NcRecommendsFeedbackResult> typedResult) {
            TypedResult<NcRecommendsFeedbackResult> typedResult2 = typedResult;
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
    public NcRecommendsReviewInteractorImpl(@Id @NotNull String str, @NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = notificationsApi;
        this.c = schedulersFactory;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractor
    @NotNull
    public Observable<LoadingState<NcRecommendsFeedbackResult>> send(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AvatarStatus.REVIEW);
        Observable<LoadingState<NcRecommendsFeedbackResult>> startWith = InteropKt.toV2(this.b.getNcRecommendsFeedbackResultWithReview(this.a, str)).subscribeOn(this.c.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getNcRecommendsFeedb…ith(LoadingState.Loading)");
        return startWith;
    }
}
