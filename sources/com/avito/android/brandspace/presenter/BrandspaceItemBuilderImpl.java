package com.avito.android.brandspace.presenter;

import a2.a.a.w.c.i;
import com.avito.android.IdProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.brandspace.di.MarketplaceTabsMapper;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.brandspace.items.button.ButtonItem;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.carousel.CarouselItemKt;
import com.avito.android.brandspace.items.loading.LoadingItemKt;
import com.avito.android.brandspace.items.marketplace.categories.CategoryItem;
import com.avito.android.brandspace.items.news.NewsItemKt;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItem;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemKt;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemProperty;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemKt;
import com.avito.android.brandspace.items.text.TextItem;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemKt;
import com.avito.android.brandspace.presenter.mappers.BrandspaceElementMapper;
import com.avito.android.brandspace.remote.model.Brandspace;
import com.avito.android.brandspace.remote.model.BrandspaceElement;
import com.avito.android.brandspace.remote.model.BrandspaceSERPModule;
import com.avito.android.brandspace.remote.model.MarketplaceCategoryElement;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u00107\u001a\u000205\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u000e\b\u0001\u00104\u001a\b\u0012\u0004\u0012\u00020100¢\u0006\u0004\b<\u0010=J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ)\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR2\u0010'\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilderImpl;", "Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "Lcom/avito/android/brandspace/remote/model/Brandspace;", ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE, "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "build", "(Lcom/avito/android/brandspace/remote/model/Brandspace;)Lio/reactivex/rxjava3/core/Single;", "item", "", "isLastItemInBlock", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)Z", "items", "refresh", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "brandspaceAdverts", "addFilteredAdverts", "(Lcom/avito/android/brandspace/remote/model/Brandspace;Ljava/util/List;Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;)Ljava/util/List;", "removeFilteredAdverts", "(Ljava/util/List;)Ljava/util/List;", "singles", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItem;", "viewItems", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getLastBlockItemIds", "()Ljava/util/HashSet;", "setLastBlockItemIds", "(Ljava/util/HashSet;)V", "lastBlockItemIds", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "d", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "c", "Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "itemsMeasurer", "Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;", a2.g.r.g.a, "Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;", "marketplaceTabsModuleMapper", "Lcom/avito/android/IdProvider;", "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "e", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResourceProvider", "<init>", "(Lcom/avito/android/IdProvider;Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceItemBuilderImpl implements BrandspaceItemBuilder {
    @NotNull
    public HashSet<Long> a = new HashSet<>();
    public final IdProvider b;
    public final ItemsMeasurer c;
    public final FavoriteStatusResolver d;
    public final BrandspaceResourcesProvider e;
    public final SchedulersFactory3 f;
    public final BrandspaceElementMapper<MarketplaceTabsModule> g;

    public static final class a<T> implements Consumer<List<? extends BrandspaceItem>> {
        public final /* synthetic */ BrandspaceItemBuilderImpl a;
        public final /* synthetic */ List b;

        public a(BrandspaceItemBuilderImpl brandspaceItemBuilderImpl, List list) {
            this.a = brandspaceItemBuilderImpl;
            this.b = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends BrandspaceItem> list) {
            List<? extends BrandspaceItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            BrandspaceItem brandspaceItem = (BrandspaceItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list2);
            if (brandspaceItem != null) {
                Single.fromCallable(new a2.a.a.w.c.a(brandspaceItem, this)).subscribeOn(this.a.f.mainThread()).subscribe();
            }
        }
    }

    public static final class b<T, R> implements Function<Single<List<? extends BrandspaceItem>>, ObservableSource<? extends List<? extends BrandspaceItem>>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends BrandspaceItem>> apply(Single<List<? extends BrandspaceItem>> single) {
            return single.toObservable();
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<List<? extends BrandspaceItem>, List<? extends BrandspaceItem>, List<? extends BrandspaceItem>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public List<? extends BrandspaceItem> apply(List<? extends BrandspaceItem> list, List<? extends BrandspaceItem> list2) {
            List<? extends BrandspaceItem> list3 = list;
            List<? extends BrandspaceItem> list4 = list2;
            Intrinsics.checkNotNullExpressionValue(list3, "t1");
            Intrinsics.checkNotNullExpressionValue(list4, "t2");
            return CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) list4);
        }
    }

    public static final class d<T, R> implements Function<Single<? extends Object>, ObservableSource<? extends Object>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Object> apply(Single<? extends Object> single) {
            return single.toObservable();
        }
    }

    public static final class e<T> implements Supplier<List<? extends BrandspaceItem>> {
        public final /* synthetic */ BrandspaceItemBuilderImpl a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;

        public e(BrandspaceItemBuilderImpl brandspaceItemBuilderImpl, List list, List list2) {
            this.a = brandspaceItemBuilderImpl;
            this.b = list;
            this.c = list2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public List<? extends BrandspaceItem> get() {
            List<T> list = this.b;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                int i = 0;
                for (T t2 : t.getProperties()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    t2.setTopPadding(((ProductComparisonItemProperty) this.c.get(i)).getPrecalculatedTextHeight() + this.a.e.getPropertyTopPadding());
                    i = i2;
                }
                arrayList.add(Unit.INSTANCE);
            }
            return this.b;
        }
    }

    public static final class f<V> implements Callable<Unit> {
        public final /* synthetic */ BrandspaceItemBuilderImpl a;
        public final /* synthetic */ List b;

        public f(BrandspaceItemBuilderImpl brandspaceItemBuilderImpl, List list) {
            this.a = brandspaceItemBuilderImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Unit call() {
            this.a.d.resolveSync(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function<Unit, List<? extends BrandspaceItem>> {
        public final /* synthetic */ List a;

        public g(List list) {
            this.a = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends BrandspaceItem> apply(Unit unit) {
            return this.a;
        }
    }

    @Inject
    public BrandspaceItemBuilderImpl(@NotNull IdProvider idProvider, @NotNull ItemsMeasurer itemsMeasurer, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull SchedulersFactory3 schedulersFactory3, @MarketplaceTabsMapper @NotNull BrandspaceElementMapper<MarketplaceTabsModule> brandspaceElementMapper) {
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(itemsMeasurer, "itemsMeasurer");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(brandspaceElementMapper, "marketplaceTabsModuleMapper");
        this.b = idProvider;
        this.c = itemsMeasurer;
        this.d = favoriteStatusResolver;
        this.e = brandspaceResourcesProvider;
        this.f = schedulersFactory3;
        this.g = brandspaceElementMapper;
    }

    public static final CategoryItem access$createCategoryItem(BrandspaceItemBuilderImpl brandspaceItemBuilderImpl, MarketplaceCategoryElement marketplaceCategoryElement) {
        Objects.requireNonNull(brandspaceItemBuilderImpl);
        return new CategoryItem(brandspaceItemBuilderImpl.b.generateId(), BlockType.MARKETPLACE_CATEGORY, marketplaceCategoryElement.getImage(), marketplaceCategoryElement.getTitle(), marketplaceCategoryElement.getBgColor(), marketplaceCategoryElement.getAction());
    }

    public final Single<List<BrandspaceItem>> a(List<? extends Single<List<BrandspaceItem>>> list) {
        Object[] array = list.toArray(new Single[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Single[] singleArr = (Single[]) array;
        Single<List<BrandspaceItem>> reduce = Observable.fromArray((Single[]) Arrays.copyOf(singleArr, singleArr.length)).concatMapEager(b.a).reduce(CollectionsKt__CollectionsKt.emptyList(), c.a);
        Intrinsics.checkNotNullExpressionValue(reduce, "Observable.fromArray(*si…       t1 + t2\n        })");
        return reduce;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    @NotNull
    public List<BrandspaceItem> addFilteredAdverts(@NotNull Brandspace brandspace, @NotNull List<? extends BrandspaceItem> list, @NotNull BrandspaceAdverts brandspaceAdverts) {
        List list2;
        Intrinsics.checkNotNullParameter(brandspace, ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE);
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(brandspaceAdverts, "brandspaceAdverts");
        List<BrandspaceElement> elements = brandspace.getElements();
        if (elements == null) {
            elements = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (T t : elements) {
            if (t instanceof BrandspaceSERPModule) {
                arrayList.add(t);
            }
        }
        BrandspaceSERPModule brandspaceSERPModule = (BrandspaceSERPModule) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        if (brandspaceSERPModule == null) {
            return list;
        }
        ArrayList arrayList2 = new ArrayList();
        for (BrandspaceItem brandspaceItem : list) {
            if (LoadingItemKt.isFilteredAdvertsLoadingItem(brandspaceItem)) {
                getLastBlockItemIds().remove(Long.valueOf(brandspaceItem.getId()));
                List<BrandspaceAdvertItem> adverts = brandspaceAdverts.getAdverts();
                if (!adverts.isEmpty()) {
                    list2 = new ArrayList();
                    long generateId = this.b.generateId();
                    BlockType blockType = BlockType.BS_SERP;
                    list2.add(new TextItem(generateId, blockType, brandspaceSERPModule.getTitle(), 0, 8, null));
                    list2.addAll(adverts);
                    Action action = brandspaceSERPModule.getAction();
                    if (action != null) {
                        list2.add(new ButtonItem(this.b.generateId(), blockType, action.getTitle(), action.getDeepLink()));
                    }
                    BrandspaceItem brandspaceItem2 = (BrandspaceItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list2);
                    if (brandspaceItem2 != null) {
                        getLastBlockItemIds().add(Long.valueOf(brandspaceItem2.getId()));
                    }
                } else {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
            } else {
                list2 = t6.n.d.listOf(brandspaceItem);
            }
            h.addAll(arrayList2, list2);
        }
        return arrayList2;
    }

    public final Single<List<BrandspaceItem>> b(List<ProductComparisonItem> list) {
        List<ProductComparisonItemProperty> properties = ((ProductComparisonItem) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)).getProperties();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(properties, 10));
        Iterator<T> it = properties.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            if (name == null) {
                name = "";
            }
            arrayList.add(new ProductComparisonItemProperty(null, name, 0, 0, 0, 28, null));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getProperties().get(i));
            }
            linkedHashMap.put(valueOf, arrayList2);
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(this.c.measure((ProductComparisonItemProperty) it3.next()));
        }
        Object[] array = arrayList3.toArray(new Single[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array);
        spreadBuilder.add(this.c.measure(list));
        Collection<List<? extends TextMeasurableItem>> values = linkedHashMap.values();
        ArrayList arrayList4 = new ArrayList(t6.n.e.collectionSizeOrDefault(values, 10));
        for (List<? extends TextMeasurableItem> list2 : values) {
            arrayList4.add(this.c.measure(list2));
        }
        Object[] array2 = arrayList4.toArray(new Single[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array2);
        Single<List<BrandspaceItem>> single = Observable.fromArray((Single[]) spreadBuilder.toArray(new Single[spreadBuilder.size()])).concatMapEager(d.a).ignoreElements().toSingle(new e(this, list, arrayList));
        Intrinsics.checkNotNullExpressionValue(single, "Observable.fromArray(\n  …      viewItems\n        }");
        return single;
    }

    /* JADX WARNING: Removed duplicated region for block: B:223:0x09b1  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x09bd A[SYNTHETIC] */
    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Single<java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem>> build(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.remote.model.Brandspace r32) {
        /*
        // Method dump skipped, instructions count: 2502
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl.build(com.avito.android.brandspace.remote.model.Brandspace):io.reactivex.rxjava3.core.Single");
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    @NotNull
    public HashSet<Long> getLastBlockItemIds() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    public boolean isLastItemInBlock(@NotNull BrandspaceItem brandspaceItem) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "item");
        return getLastBlockItemIds().contains(Long.valueOf(brandspaceItem.getId()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    @NotNull
    public Single<List<BrandspaceItem>> refresh(@NotNull List<? extends BrandspaceItem> list) {
        Single<R> single;
        ArrayList i0 = a2.b.a.a.a.i0(list, "items");
        int i = 0;
        while (i < list.size()) {
            BrandspaceItem brandspaceItem = (BrandspaceItem) list.get(i);
            boolean z = brandspaceItem instanceof CarouselItem;
            if (z) {
                CarouselItem carouselItem = (CarouselItem) brandspaceItem;
                if (CarouselItemKt.isCategoryItemCarousel(carouselItem) || VideoGalleryItemKt.isVideoGalleryCarousel(carouselItem) || NewsItemKt.isNewsCarousel(carouselItem) || ProductDescriptionItemKt.isProductDescriptionCarousel(carouselItem)) {
                    List<BrandspaceItem> items = carouselItem.getItems();
                    ArrayList arrayList = new ArrayList();
                    for (T t : items) {
                        if (t instanceof TextMeasurableItem) {
                            arrayList.add(t);
                        }
                    }
                    single = this.c.measure(arrayList).map(new i(carouselItem));
                    Intrinsics.checkNotNullExpressionValue(single, "itemsMeasurer.measure(te…f(carouselItem)\n        }");
                    i0.add(single);
                    i++;
                }
            }
            if (z) {
                CarouselItem carouselItem2 = (CarouselItem) brandspaceItem;
                if (ProductComparisonItemKt.isProductComparisonCarousel(carouselItem2)) {
                    List<BrandspaceItem> items2 = carouselItem2.getItems();
                    Objects.requireNonNull(items2, "null cannot be cast to non-null type kotlin.collections.List<com.avito.android.brandspace.items.productcomparison.ProductComparisonItem>");
                    single = b(items2).map(new a2.a.a.w.c.h(carouselItem2));
                    Intrinsics.checkNotNullExpressionValue(single, "measureProductComparison…f(carouselItem)\n        }");
                    i0.add(single);
                    i++;
                }
            }
            if (brandspaceItem instanceof BrandspaceAdvertItem) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((BrandspaceAdvertItem) brandspaceItem);
                int size = list.size();
                for (int i2 = i + 1; i2 < size; i2++) {
                    BrandspaceItem brandspaceItem2 = (BrandspaceItem) list.get(i2);
                    if (!(brandspaceItem2 instanceof BrandspaceAdvertItem)) {
                        break;
                    }
                    mutableListOf.add(brandspaceItem2);
                    i++;
                }
                single = Single.fromCallable(new f(this, mutableListOf)).map(new g(mutableListOf));
            } else {
                single = Single.just(t6.n.d.listOf(brandspaceItem));
            }
            Intrinsics.checkNotNullExpressionValue(single, "if (modelItem is Brandsp…modelItem))\n            }");
            i0.add(single);
            i++;
        }
        return a(i0);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    @NotNull
    public List<BrandspaceItem> removeFilteredAdverts(@NotNull List<? extends BrandspaceItem> list) {
        ArrayList i0 = a2.b.a.a.a.i0(list, "items");
        for (T t : list) {
            if (!LoadingItemKt.isFilteredAdvertsLoadingItem(t)) {
                i0.add(t);
            }
        }
        return i0;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItemBuilder
    public void setLastBlockItemIds(@NotNull HashSet<Long> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.a = hashSet;
    }
}
