package com.avito.android.shop.detailed;

import a2.a.a.s2.b.f;
import a2.a.a.s2.b.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.remote.shop.detailed.ShopGold;
import com.avito.android.remote.shop.detailed.ShopRegular;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItem;
import com.avito.android.shop.detailed.item.NoItemsFoundItem;
import com.avito.android.shop.detailed.item.ShopRegularItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J;\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedItemsConverterImpl;", "Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "shopDetailedData", "", "isQueryEmpty", "isFiltersApplied", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "convertToItems", "(Lcom/avito/android/shop/detailed/ShopDetailedData;ZZLcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/adapter/SerpItem;", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", AuthSource.BOOKING_ORDER, "()I", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "d", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "e", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "c", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "itemConverter", "<init>", "(Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;Lcom/avito/android/serp/adapter/SerpElementItemConverter;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedItemsConverterImpl implements ShopDetailedItemsConverter {
    public SerpDisplayType a;
    public final ShopAdvertsResourceProvider b;
    public final SerpElementItemConverter c;
    public final FavoriteStatusResolver d;
    public final ViewedStatusResolver e;

    public static final class a<V> implements Callable<List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ ShopDetailedItemsConverterImpl a;
        public final /* synthetic */ List b;

        public a(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl, List list) {
            this.a = shopDetailedItemsConverterImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends ViewTypeSerpItem> call() {
            return this.a.c.convert(this.b, ShopDetailedItemsConverterImpl.access$getDisplayType(this.a));
        }
    }

    public static final class b<T, R> implements Function<List<? extends ViewTypeSerpItem>, ObservableSource<? extends List<? extends ViewTypeSerpItem>>> {
        public final /* synthetic */ ShopDetailedItemsConverterImpl a;

        public b(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl) {
            this.a = shopDetailedItemsConverterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends ViewTypeSerpItem>> apply(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            FavoriteStatusResolver favoriteStatusResolver = this.a.d;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return favoriteStatusResolver.resolve(list2);
        }
    }

    public static final class c<T, R> implements Function<List<? extends ViewTypeSerpItem>, ObservableSource<? extends List<? extends SerpItem>>> {
        public final /* synthetic */ ShopDetailedItemsConverterImpl a;

        public c(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl) {
            this.a = shopDetailedItemsConverterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends SerpItem>> apply(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            ViewedStatusResolver viewedStatusResolver = this.a.e;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return viewedStatusResolver.resolve(list2);
        }
    }

    @Inject
    public ShopDetailedItemsConverterImpl(@NotNull ShopAdvertsResourceProvider shopAdvertsResourceProvider, @NotNull SerpElementItemConverter serpElementItemConverter, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver) {
        Intrinsics.checkNotNullParameter(shopAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(serpElementItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        this.b = shopAdvertsResourceProvider;
        this.c = serpElementItemConverter;
        this.d = favoriteStatusResolver;
        this.e = viewedStatusResolver;
    }

    public static final NoItemsFoundItem access$createNoItemsFoundItem(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl) {
        return new NoItemsFoundItem("no_items_it", shopDetailedItemsConverterImpl.b());
    }

    public static final SpannedItem access$getCaptionCount(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl, int i) {
        return new AdvertsCountCaptionItem("adverts_count_caption_id", shopDetailedItemsConverterImpl.b(), shopDetailedItemsConverterImpl.b.getAdvertsCount(i));
    }

    public static final SpannedItem access$getCaptionNoAdverts(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl) {
        return new AdvertsCountCaptionItem("adverts_count_caption_id", shopDetailedItemsConverterImpl.b(), shopDetailedItemsConverterImpl.b.getNoAdverts());
    }

    public static final SerpDisplayType access$getDisplayType(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl) {
        SerpDisplayType serpDisplayType = shopDetailedItemsConverterImpl.a;
        return serpDisplayType != null ? serpDisplayType : SerpDisplayType.Grid;
    }

    public final Observable<List<SerpItem>> a(List<? extends SerpElement> list) {
        Observable<List<SerpItem>> flatMap = Observable.fromCallable(new a(this, list)).flatMap(new b(this)).flatMap(new c(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.fromCallable …tusResolver.resolve(it) }");
        return flatMap;
    }

    public final int b() {
        SerpDisplayType serpDisplayType = this.a;
        if (serpDisplayType == null) {
            serpDisplayType = SerpDisplayType.Grid;
        }
        if (serpDisplayType == SerpDisplayType.List) {
            return 1;
        }
        return this.b.getColumnsCount();
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedItemsConverter
    @NotNull
    public Observable<List<SpannedItem>> convertToItems(@NotNull ShopDetailedData shopDetailedData, boolean z, boolean z2, @NotNull SerpDisplayType serpDisplayType) {
        Observable observable;
        Observable<R> observable2;
        Intrinsics.checkNotNullParameter(shopDetailedData, "shopDetailedData");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.a = serpDisplayType;
        ShopElement shop = shopDetailedData.getShop();
        if (shop instanceof ShopGold) {
            observable = Observable.fromCallable(new f(this, (ShopGold) shop));
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.fromCallable …)\n            )\n        }");
        } else if (shop instanceof ShopRegular) {
            ShopRegular shopRegular = (ShopRegular) shop;
            observable = Observable.just(d.listOf(new ShopRegularItem(shopRegular.getId(), b(), shopRegular.getUserKey(), shopRegular.getName(), shopRegular.getSellerVerification(), shopRegular.getCategoryName(), shopRegular.getDescription(), shopRegular.getLogo(), shopRegular.getPhones(), shopRegular.getAddress(), shopRegular.getSite(), shopRegular.getRating(), shopRegular.getSubscribeInfo())));
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(\n       …)\n            )\n        )");
        } else {
            observable = Observable.error(new IllegalArgumentException("wrong shop type"));
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.error(Illegal…ption(\"wrong shop type\"))");
        }
        ShopElement shop2 = shopDetailedData.getShop();
        if (shop2 instanceof ShopGold) {
            ShopGold shopGold = (ShopGold) shop2;
            if (shopGold.getShowcase() != null) {
                ShopGold.Showcase showcase = shopGold.getShowcase();
                List<SerpElement> elements = showcase != null ? showcase.getElements() : null;
                if (elements == null) {
                    elements = CollectionsKt__CollectionsKt.emptyList();
                }
                observable2 = a(elements).map(new g(this, shop2));
                Intrinsics.checkNotNullExpressionValue(observable2, "convertElements(shop.sho…ption()\n                }");
                Observable<List<SpannedItem>> zip = Observable.zip(observable, observable2, a(shopDetailedData.getElements()), new Function3<T1, T2, T3, R>(this, shopDetailedData, z, z2) { // from class: com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl$convertToItems$$inlined$zip$1
                    public final /* synthetic */ ShopDetailedItemsConverterImpl a;
                    public final /* synthetic */ ShopDetailedData b;
                    public final /* synthetic */ boolean c;
                    public final /* synthetic */ boolean d;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // io.reactivex.rxjava3.functions.Function3
                    @NotNull
                    public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                        Intrinsics.checkParameterIsNotNull(t1, "t1");
                        Intrinsics.checkParameterIsNotNull(t2, "t2");
                        Intrinsics.checkParameterIsNotNull(t3, "t3");
                        T3 t32 = t3;
                        T2 t22 = t2;
                        R r = (R) new ArrayList();
                        r.addAll(t1);
                        if (!t32.isEmpty()) {
                            SpannedItem spannedItem = (SpannedItem) t22.orNull();
                            if (spannedItem != null) {
                                r.add(spannedItem);
                            }
                            r.add(ShopDetailedItemsConverterImpl.access$getCaptionCount(this.a, (int) this.b.getCount()));
                            r.addAll(t32);
                        } else {
                            if (!this.c || this.d) {
                                r.add(ShopDetailedItemsConverterImpl.access$createNoItemsFoundItem(this.a));
                            } else {
                                r.add(ShopDetailedItemsConverterImpl.access$getCaptionNoAdverts(this.a));
                            }
                            SpannedItem spannedItem2 = (SpannedItem) t22.orNull();
                            if (spannedItem2 != null) {
                                r.add(spannedItem2);
                            }
                        }
                        return r;
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
                return zip;
            }
        }
        observable2 = Observable.just(Option.None.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(observable2, "Observable.just(Option.None)");
        Observable<List<SpannedItem>> zip = Observable.zip(observable, observable2, a(shopDetailedData.getElements()), new Function3<T1, T2, T3, R>(this, shopDetailedData, z, z2) { // from class: com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl$convertToItems$$inlined$zip$1
            public final /* synthetic */ ShopDetailedItemsConverterImpl a;
            public final /* synthetic */ ShopDetailedData b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                T3 t32 = t3;
                T2 t22 = t2;
                R r = (R) new ArrayList();
                r.addAll(t1);
                if (!t32.isEmpty()) {
                    SpannedItem spannedItem = (SpannedItem) t22.orNull();
                    if (spannedItem != null) {
                        r.add(spannedItem);
                    }
                    r.add(ShopDetailedItemsConverterImpl.access$getCaptionCount(this.a, (int) this.b.getCount()));
                    r.addAll(t32);
                } else {
                    if (!this.c || this.d) {
                        r.add(ShopDetailedItemsConverterImpl.access$createNoItemsFoundItem(this.a));
                    } else {
                        r.add(ShopDetailedItemsConverterImpl.access$getCaptionNoAdverts(this.a));
                    }
                    SpannedItem spannedItem2 = (SpannedItem) t22.orNull();
                    if (spannedItem2 != null) {
                        r.add(spannedItem2);
                    }
                }
                return r;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
        return zip;
    }
}
