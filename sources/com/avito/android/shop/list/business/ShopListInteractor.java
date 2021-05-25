package com.avito.android.shop.list.business;

import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006H&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/avito/android/shop/list/business/ShopListInteractor;", "", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "", "loadNextPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/shop/list/business/ShopListInfo;", "getShops", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/list/business/ShopLocation;", "getLocationInfo", "()Lio/reactivex/rxjava3/core/Observable;", "", "locationId", "getLocationInfoById", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "invalidate", "()V", "clearError", "canLoadMore", "()Z", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "hasCachedData", "getLocationChanges", "locationChanges", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListInteractor {
    boolean canLoadMore();

    void clearError();

    @NotNull
    Observable<ShopLocation> getLocationChanges();

    @NotNull
    Observable<LoadingState<ShopLocation>> getLocationInfo();

    @NotNull
    Observable<LoadingState<ShopLocation>> getLocationInfoById(@NotNull String str);

    @NotNull
    Observable<LoadingState<ShopListInfo>> getShops(@NotNull ShopsSearchParameters shopsSearchParameters, boolean z);

    boolean hasCachedData();

    void invalidate();

    @NotNull
    Kundle saveState();
}
