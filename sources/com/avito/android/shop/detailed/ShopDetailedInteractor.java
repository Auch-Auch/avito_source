package com.avito.android.shop.detailed;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.util.Kundle;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "", "", "query", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "shouldRefreshPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "loadShopAdvertsData", "(Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "", "getFiltersCount", "(Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "data", "", "refreshSubscriptionState", "(Lcom/avito/android/shop/detailed/ShopDetailedData;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopDetailedInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadShopAdvertsData$default(ShopDetailedInteractor shopDetailedInteractor, String str, SerpDisplayType serpDisplayType, SearchParams searchParams, boolean z, int i, Object obj) {
            ShopDetailedInteractor shopDetailedInteractor2;
            boolean z2;
            if (obj == null) {
                SerpDisplayType serpDisplayType2 = null;
                String str2 = (i & 1) != 0 ? null : str;
                if ((i & 2) == 0) {
                    serpDisplayType2 = serpDisplayType;
                }
                SearchParams searchParams2 = (i & 4) != 0 ? new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null) : searchParams;
                if ((i & 8) != 0) {
                    z2 = false;
                    shopDetailedInteractor2 = shopDetailedInteractor;
                } else {
                    shopDetailedInteractor2 = shopDetailedInteractor;
                    z2 = z;
                }
                return shopDetailedInteractor2.loadShopAdvertsData(str2, serpDisplayType2, searchParams2, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadShopAdvertsData");
        }
    }

    @NotNull
    Observable<Integer> getFiltersCount(@NotNull SearchParams searchParams);

    @NotNull
    Observable<ShopDetailedData> loadShopAdvertsData(@Nullable String str, @Nullable SerpDisplayType serpDisplayType, @NotNull SearchParams searchParams, boolean z);

    @NotNull
    Kundle onSaveState();

    void refreshSubscriptionState(@NotNull ShopDetailedData shopDetailedData);
}
