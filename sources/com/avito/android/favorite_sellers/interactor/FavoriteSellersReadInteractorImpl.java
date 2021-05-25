package com.avito.android.favorite_sellers.interactor;

import android.net.Uri;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bJ{\u0010\u0012\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0010*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\u000b \u0010*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0010*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\u000b\u0018\u00010\n¢\u0006\u0002\b\u00110\n¢\u0006\u0002\b\u0011\"\u0004\b\u0000\u0010\t*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractorImpl;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "loadSubscribes", "()Lio/reactivex/rxjava3/core/Single;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "T", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "", "unauthorizedMessage", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "checkAuthorized", "(Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/account/AccountStateProvider;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/FavoriteSellersApi;", "c", "Lcom/avito/android/remote/FavoriteSellersApi;", "api", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/remote/FavoriteSellersApi;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersReadInteractorImpl implements FavoriteSellersReadInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TYPE = "favoriteSellers";
    public final SchedulersFactory3 a;
    public final AccountStateProvider b;
    public final FavoriteSellersApi c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractorImpl$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<Boolean, ObservableSource<? extends TypedResult<T>>> {
        public final /* synthetic */ Observable a;
        public final /* synthetic */ String b;

        public a(Observable observable, String str) {
            this.a = observable;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                return this.a;
            }
            return Observable.just(new TypedResult.OfError(new ErrorResult.Unauthorized(this.b)));
        }
    }

    public FavoriteSellersReadInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull FavoriteSellersApi favoriteSellersApi) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        this.a = schedulersFactory3;
        this.b = accountStateProvider;
        this.c = favoriteSellersApi;
    }

    public static /* synthetic */ Observable checkAuthorized$default(FavoriteSellersReadInteractorImpl favoriteSellersReadInteractorImpl, Observable observable, AccountStateProvider accountStateProvider, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return favoriteSellersReadInteractorImpl.checkAuthorized(observable, accountStateProvider, str);
    }

    public final <T> Observable<TypedResult<T>> checkAuthorized(@NotNull Observable<TypedResult<T>> observable, @NotNull AccountStateProvider accountStateProvider, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$checkAuthorized");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(str, "unauthorizedMessage");
        return accountStateProvider.currentAuthorized().flatMapObservable(new a(observable, str));
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes() {
        Observable checkAuthorized$default = checkAuthorized$default(this, a2.b.a.a.a.a2(this.a, this.c.getFavoriteSellers(), "api.getFavoriteSellers()…scribeOn(schedulers.io())"), this.b, null, 2, null);
        Intrinsics.checkNotNullExpressionValue(checkAuthorized$default, "api.getFavoriteSellers()…zed(accountStateProvider)");
        Single<FavoriteSellersLoadingResult> firstOrError = TypedObservablesKt.toTyped(checkAuthorized$default).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "api.getFavoriteSellers()…          .firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        FavoriteSellersApi favoriteSellersApi = this.c;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        Observable<TypedResult<FavoriteSellersLoadingResult>> subscribeOn = favoriteSellersApi.getFavoriteSellers(uri2).subscribeOn(this.a.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getFavoriteSellers(u…scribeOn(schedulers.io())");
        Single<FavoriteSellersLoadingResult> firstOrError = TypedObservablesKt.toTyped(subscribeOn).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "api.getFavoriteSellers(u…          .firstOrError()");
        return firstOrError;
    }
}
