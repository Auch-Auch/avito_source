package com.avito.android.rating.publish.select_advert;

import android.net.Uri;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractorImpl;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/publish/SearchUserAdvertsResult;", "loadItems", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "hash", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Ljava/lang/String;Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectAdvertInteractorImpl implements SelectAdvertInteractor {
    public final String a;
    public final RatingApi b;
    public final SchedulersFactory3 c;

    @Inject
    public SelectAdvertInteractorImpl(@NotNull String str, @NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "hash");
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = str;
        this.b = ratingApi;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertInteractor
    @NotNull
    public Observable<SearchUserAdvertsResult> loadItems(@Nullable String str) {
        RatingApi ratingApi = this.b;
        String str2 = this.a;
        if (str == null) {
            str = "";
        }
        Observable<TypedResult<SearchUserAdvertsResult>> subscribeOn = ratingApi.searchUserAdverts(str2, str).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.searchUserAdverts(us…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertInteractor
    @NotNull
    public Observable<SearchUserAdvertsResult> loadItems(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        RatingApi ratingApi = this.b;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable<TypedResult<SearchUserAdvertsResult>> subscribeOn = ratingApi.searchUserAdverts(uri2).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.searchUserAdverts(ne…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
