package com.avito.android.favorite_sellers.interactor;

import android.net.Uri;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/SubscribersReadInteractor;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "loadSubscribes", "()Lio/reactivex/rxjava3/core/Single;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/FavoriteSellersApi;", "c", "Lcom/avito/android/remote/FavoriteSellersApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "userKey", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/FavoriteSellersApi;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribersReadInteractor implements FavoriteSellersReadInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TYPE = "subscribers";
    public final String a;
    public final SchedulersFactory3 b;
    public final FavoriteSellersApi c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/SubscribersReadInteractor$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public SubscribersReadInteractor(@NotNull String str, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteSellersApi favoriteSellersApi) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        this.a = str;
        this.b = schedulersFactory3;
        this.c = favoriteSellersApi;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes() {
        Observable<TypedResult<FavoriteSellersLoadingResult>> subscribeOn = this.c.getSubscribers(this.a).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getSubscribers(userK…scribeOn(schedulers.io())");
        Single<FavoriteSellersLoadingResult> firstOrError = TypedObservablesKt.toTyped(subscribeOn).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "api.getSubscribers(userK…          .firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        FavoriteSellersApi favoriteSellersApi = this.c;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        Observable<TypedResult<FavoriteSellersLoadingResult>> subscribeOn = favoriteSellersApi.getFavoriteSellers(uri2).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getFavoriteSellers(u…scribeOn(schedulers.io())");
        Single<FavoriteSellersLoadingResult> firstOrError = TypedObservablesKt.toTyped(subscribeOn).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "api.getFavoriteSellers(u…          .firstOrError()");
        return firstOrError;
    }
}
