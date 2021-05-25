package com.avito.android.favorite_sellers;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoriteSellersResult;
import com.avito.android.remote.model.FavoriteSellersResultItem;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersConverterImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "result", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "convert", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)Lio/reactivex/rxjava3/core/Single;", "convertSync", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)Ljava/util/List;", "Lcom/avito/android/remote/model/FavoriteSellersResultItem;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/FavoriteSellersResultItem;)Ljava/util/List;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "c", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "<init>", "(Lcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersConverterImpl implements FavoriteSellersConverter {
    public final SerpAdvertConverter a;
    public final FavoriteStatusResolver b;
    public final ViewedStatusResolver c;

    public static final class a<T, R> implements Function<FavoriteSellersResultItem, ObservableSource<? extends FavoriteSellersItem>> {
        public final /* synthetic */ FavoriteSellersConverterImpl a;

        public a(FavoriteSellersConverterImpl favoriteSellersConverterImpl) {
            this.a = favoriteSellersConverterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends FavoriteSellersItem> apply(FavoriteSellersResultItem favoriteSellersResultItem) {
            FavoriteSellersResultItem favoriteSellersResultItem2 = favoriteSellersResultItem;
            FavoriteSellersConverterImpl favoriteSellersConverterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(favoriteSellersResultItem2, "item");
            return Observables.toObservable(favoriteSellersConverterImpl.a(favoriteSellersResultItem2));
        }
    }

    @Inject
    public FavoriteSellersConverterImpl(@NotNull SerpAdvertConverter serpAdvertConverter, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        this.a = serpAdvertConverter;
        this.b = favoriteStatusResolver;
        this.c = viewedStatusResolver;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0200 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItem] */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00fb: APUT  
      (r4v15 com.avito.android.favorite_sellers.FavoriteSellersItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.favorite_sellers.adapter.seller.SellerItem : 0x00f8: CONSTRUCTOR  (r22v0 com.avito.android.favorite_sellers.adapter.seller.SellerItem) = 
      (r7v8 java.lang.String)
      (r8v3 java.lang.String)
      (r9v3 java.lang.String)
      (r10v2 java.lang.String)
      (r11v2 com.avito.android.remote.model.Image)
      (r12v5 boolean)
      (r13v11 boolean)
      (wrap: com.avito.android.deep_linking.links.DeepLink : 0x00e8: INVOKE  (r14v2 com.avito.android.deep_linking.links.DeepLink) = (r1v7 com.avito.android.remote.model.FavoriteSeller) type: VIRTUAL call: com.avito.android.remote.model.FavoriteSeller.getDeepLink():com.avito.android.deep_linking.links.DeepLink)
      false
      false
      (r17v2 java.lang.Boolean)
      false
      (wrap: java.lang.Boolean : 0x00ee: INVOKE  (r19v1 java.lang.Boolean) = (r1v7 com.avito.android.remote.model.FavoriteSeller) type: VIRTUAL call: com.avito.android.remote.model.FavoriteSeller.getHasNewItems():java.lang.Boolean)
      (2816 int)
      (null t6.r.a.j)
     call: com.avito.android.favorite_sellers.adapter.seller.SellerItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.avito.android.remote.model.Image, boolean, boolean, com.avito.android.deep_linking.links.DeepLink, boolean, boolean, java.lang.Boolean, boolean, java.lang.Boolean, int, t6.r.a.j):void type: CONSTRUCTOR)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.avito.android.favorite_sellers.FavoriteSellersItem> a(com.avito.android.remote.model.FavoriteSellersResultItem r24) {
        /*
        // Method dump skipped, instructions count: 594
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorite_sellers.FavoriteSellersConverterImpl.a(com.avito.android.remote.model.FavoriteSellersResultItem):java.util.List");
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersConverter
    @NotNull
    public Single<List<FavoriteSellersItem>> convert(@NotNull FavoriteSellersResult favoriteSellersResult) {
        Intrinsics.checkNotNullParameter(favoriteSellersResult, "result");
        List<FavoriteSellersResultItem> list = favoriteSellersResult.getList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Single<List<FavoriteSellersItem>> list2 = Observable.fromIterable(list).concatMap(new a(this)).toList();
        Intrinsics.checkNotNullExpressionValue(list2, "Observable.fromIterable(…) }\n            .toList()");
        return list2;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersConverter
    @NotNull
    public List<FavoriteSellersItem> convertSync(@NotNull FavoriteSellersResult favoriteSellersResult) {
        Intrinsics.checkNotNullParameter(favoriteSellersResult, "result");
        List<FavoriteSellersResultItem> list = favoriteSellersResult.getList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            h.addAll(arrayList, a(it.next()));
        }
        return arrayList;
    }
}
