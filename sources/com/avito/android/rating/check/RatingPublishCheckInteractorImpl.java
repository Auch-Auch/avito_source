package com.avito.android.rating.check;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.rating.check.error.NotAuthorizedException;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/check/RatingPublishCheckInteractorImpl;", "Lcom/avito/android/rating/check/RatingPublishCheckInteractor;", "Lio/reactivex/rxjava3/core/Completable;", "checkRatingPublish", "()Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStatProvider", "Lcom/avito/android/rating/remote/RatingApi;", "c", "Lcom/avito/android/rating/remote/RatingApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "userKey", "<init>", "(Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishCheckInteractorImpl implements RatingPublishCheckInteractor {
    public final String a;
    public final AccountStateProvider b;
    public final RatingApi c;
    public final SchedulersFactory3 d;

    public static final class a<T, R> implements Function<Boolean, CompletableSource> {
        public final /* synthetic */ RatingPublishCheckInteractorImpl a;

        public a(RatingPublishCheckInteractorImpl ratingPublishCheckInteractorImpl) {
            this.a = ratingPublishCheckInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (!bool2.booleanValue()) {
                return Completable.error(new NotAuthorizedException());
            }
            Observable<TypedResult<Unit>> subscribeOn = this.a.c.checkRatingPublish(this.a.a).subscribeOn(this.a.d.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.checkRatingPublish(u…scribeOn(schedulers.io())");
            return TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        }
    }

    @Inject
    public RatingPublishCheckInteractorImpl(@NotNull String str, @NotNull AccountStateProvider accountStateProvider, @NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatProvider");
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = str;
        this.b = accountStateProvider;
        this.c = ratingApi;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckInteractor
    @NotNull
    public Completable checkRatingPublish() {
        Single<Boolean> firstOrError = this.b.authorized().firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "accountStatProvider.auth…          .firstOrError()");
        Single<Long> timer = Single.timer(350, TimeUnit.MILLISECONDS, this.d.computation());
        Intrinsics.checkNotNullExpressionValue(timer, "Single.timer(\n          …ation()\n                )");
        Single<R> zipWith = firstOrError.zipWith(timer, new BiFunction<Boolean, Long, R>() { // from class: com.avito.android.rating.check.RatingPublishCheckInteractorImpl$checkRatingPublish$$inlined$zipWith$1
            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(Boolean bool, Long l) {
                Intrinsics.checkExpressionValueIsNotNull(bool, "t");
                Intrinsics.checkExpressionValueIsNotNull(l, "u");
                return (R) bool;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        Completable flatMapCompletable = zipWith.flatMapCompletable(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "accountStatProvider.auth…          }\n            }");
        return flatMapCompletable;
    }
}
