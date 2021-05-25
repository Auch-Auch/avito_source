package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractor;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR@\u0010\u0014\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\r0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "", "context", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "", "requestReview", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/remote/RatingApi;", "ratingApi", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getReviewRequestEvents", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "reviewRequestEvents", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class RequestReviewInteractorImpl implements RequestReviewInteractor {
    public final BehaviorRelay<RequestReviewInteractor.State> a = BehaviorRelay.createDefault(RequestReviewInteractor.State.Empty.INSTANCE);
    public final RatingApi b;

    public static final class a<T> implements Consumer<TypedResult<Unit>> {
        public final /* synthetic */ RequestReviewInteractorImpl a;

        public a(RequestReviewInteractorImpl requestReviewInteractorImpl) {
            this.a = requestReviewInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.getReviewRequestEvents().accept(RequestReviewInteractor.State.Success.INSTANCE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.getReviewRequestEvents().accept(RequestReviewInteractor.State.Error.INSTANCE);
            }
        }
    }

    @Inject
    public RequestReviewInteractorImpl(@NotNull RatingApi ratingApi) {
        Intrinsics.checkNotNullParameter(ratingApi, "ratingApi");
        this.b = ratingApi;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractor
    @NotNull
    public Observable<TypedResult<Unit>> requestReview(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "context");
        Observable<TypedResult<Unit>> doOnNext = InteropKt.toV2(this.b.requestReview(str)).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "ratingApi.requestReview(…          }\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewInteractor
    public BehaviorRelay<RequestReviewInteractor.State> getReviewRequestEvents() {
        return this.a;
    }
}
