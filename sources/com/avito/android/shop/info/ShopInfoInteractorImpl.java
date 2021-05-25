package com.avito.android.shop.info;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.shop.ShopNotFoundError;
import com.avito.android.remote.shop.info.ShopInfo;
import com.avito.android.remote.shop.info.ShopInfoResult;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoInteractorImpl;", "Lcom/avito/android/shop/info/ShopInfoInteractor;", "", "shopId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/shop/info/ShopInfo;", "getInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/remote/ShopsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/shop/remote/ShopsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/avito/android/shop/remote/ShopsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopInfoInteractorImpl implements ShopInfoInteractor {
    public final ShopsApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TypedResult<ShopInfoResult>, LoadingState<? super ShopInfo>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ShopInfo> apply(TypedResult<ShopInfoResult> typedResult) {
            TypedResult<ShopInfoResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                ShopInfoResult shopInfoResult = (ShopInfoResult) ((TypedResult.OfResult) typedResult2).getResult();
                if (shopInfoResult instanceof ShopInfoResult.Ok) {
                    return new LoadingState.Loaded(((ShopInfoResult.Ok) shopInfoResult).getInfo());
                }
                if (shopInfoResult instanceof ShopInfoResult.NotFound) {
                    return new LoadingState.Error(new ShopNotFoundError(((ShopInfoResult.NotFound) shopInfoResult).getMessage()));
                }
                throw new NoWhenBranchMatchedException();
            } else if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public ShopInfoInteractorImpl(@NotNull ShopsApi shopsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = shopsApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.shop.info.ShopInfoInteractor
    @NotNull
    public Observable<LoadingState<ShopInfo>> getInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Observable<R> startWithItem = this.a.getShopInfo(str).subscribeOn(this.b.io()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "api.getShopInfo(shopId)\n…tem(LoadingState.Loading)");
        return startWithItem;
    }
}
