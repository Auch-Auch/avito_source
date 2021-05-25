package com.avito.android.rating.details;

import android.net.Uri;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.rating_details.RatingDetailsResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/details/ShopRatingDetailsInteractor;", "Lcom/avito/android/rating/details/RatingDetailsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/rating_details/RatingDetailsResult;", "getItems", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "c", "Ljava/lang/String;", "shopId", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRatingDetailsInteractor implements RatingDetailsInteractor {
    public final RatingApi a;
    public final SchedulersFactory3 b;
    public final String c;

    public static final class a<T, R> implements Function<TypedResult<RatingDetailsResult>, ObservableSource<? extends RatingDetailsResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends RatingDetailsResult> apply(TypedResult<RatingDetailsResult> typedResult) {
            TypedResult<RatingDetailsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public static final class b<T, R> implements Function<TypedResult<RatingDetailsResult>, ObservableSource<? extends RatingDetailsResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends RatingDetailsResult> apply(TypedResult<RatingDetailsResult> typedResult) {
            TypedResult<RatingDetailsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public ShopRatingDetailsInteractor(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull String str) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.a = ratingApi;
        this.b = schedulersFactory3;
        this.c = str;
    }

    @Override // com.avito.android.rating.details.RatingDetailsInteractor
    @NotNull
    public Observable<RatingDetailsResult> getItems() {
        Observable<R> flatMap = this.a.getShopRatingDetails(this.c).subscribeOn(this.b.io()).flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.getShopRatingDetails…it.toTypedObservable3() }");
        return flatMap;
    }

    @Override // com.avito.android.rating.details.RatingDetailsInteractor
    @NotNull
    public Observable<RatingDetailsResult> getItems(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        RatingApi ratingApi = this.a;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable<R> flatMap = ratingApi.getRatingDetails(uri2).subscribeOn(this.b.io()).flatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.getRatingDetails(nex…it.toTypedObservable3() }");
        return flatMap;
    }
}
