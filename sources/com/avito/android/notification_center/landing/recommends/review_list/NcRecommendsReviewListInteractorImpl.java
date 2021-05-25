package com.avito.android.notification_center.landing.recommends.review_list;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedback;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractorImpl;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedback;", "load", "()Lio/reactivex/Observable;", "", "reasonId", "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedbackResult;", "send", "(Ljava/lang/String;)Lio/reactivex/Observable;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "id", "Lcom/avito/android/remote/NotificationsApi;", "c", "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", AuthSource.BOOKING_ORDER, "I", ContextActionHandler.MethodCall.REACTION, "<init>", "(Ljava/lang/String;ILcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewListInteractorImpl implements NcRecommendsReviewListInteractor {
    public final String a;
    public final int b;
    public final NotificationsApi c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<TypedResult<NcRecommendsFeedback>, LoadingState<? super NcRecommendsFeedback>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super NcRecommendsFeedback> apply(TypedResult<NcRecommendsFeedback> typedResult) {
            TypedResult<NcRecommendsFeedback> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<TypedResult<NcRecommendsFeedbackResult>, LoadingState<? super NcRecommendsFeedbackResult>> {
        public static final b a = new b();

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
    public NcRecommendsReviewListInteractorImpl(@NotNull String str, int i, @NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = i;
        this.c = notificationsApi;
        this.d = schedulersFactory;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractor
    @NotNull
    public Observable<LoadingState<NcRecommendsFeedback>> load() {
        Observable<LoadingState<NcRecommendsFeedback>> startWith = InteropKt.toV2(this.c.getNcRecommendsFeedback(this.a, this.b)).subscribeOn(this.d.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getNcRecommendsFeedb…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractor
    @NotNull
    public Observable<LoadingState<NcRecommendsFeedbackResult>> send(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reasonId");
        Observable<LoadingState<NcRecommendsFeedbackResult>> startWith = InteropKt.toV2(this.c.getNcRecommendsFeedbackResultWithId(this.a, str)).subscribeOn(this.d.io()).map(b.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getNcRecommendsFeedb…ith(LoadingState.Loading)");
        return startWith;
    }
}
