package com.avito.android.section;

import com.avito.android.Features;
import com.avito.android.favorite_sellers.SellerCarouselItemConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellersCarousel;
import com.avito.android.remote.model.section.SectionDisplaying;
import com.avito.android.remote.model.section.SectionExpandButton;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.model.section.SectionTypeItem;
import com.avito.android.remote.model.section.SectionViewType;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonItem;
import com.avito.android.section.title_with_action.SectionTitleWithActionItem;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b1\u00102JK\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020\u0014*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/section/SectionItemConverterImpl;", "Lcom/avito/android/section/SectionItemConverter;", "", "Lcom/avito/android/remote/model/section/SectionTypeElement;", MessengerShareContentUtility.ELEMENTS, "", "columns", "", "isShop", "Lcom/avito/android/remote/model/section/SectionExpandButton;", "expandButton", "skipFilter", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "convert", "(Ljava/util/List;IZLcom/avito/android/remote/model/section/SectionExpandButton;Z)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/section/SectionTypeItem;", "element", "convertSectionTypeItem", "(Lcom/avito/android/remote/model/section/SectionTypeItem;IZZ)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/section/SectionTypeItem;IZZ)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/conveyor_item/Item;", "items", AuthSource.SEND_ABUSE, "(Ljava/util/List;)I", "Lcom/avito/android/section/SectionInsideItemsConverter;", "Lcom/avito/android/section/SectionInsideItemsConverter;", "itemConverter", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "d", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;", "Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;", "sellerCarouselItemConverter", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "c", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "<init>", "(Lcom/avito/android/section/SectionInsideItemsConverter;Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionItemConverterImpl implements SectionItemConverter {
    public final SectionInsideItemsConverter a;
    public final SellerCarouselItemConverter b;
    public final FavoriteStatusResolver c;
    public final ViewedStatusResolver d;
    public final SchedulersFactory3 e;
    public final Features f;

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<List<? extends PersistableSerpItem>, ObservableSource<? extends List<? extends PersistableSerpItem>>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public final ObservableSource<? extends List<? extends PersistableSerpItem>> apply(List<? extends PersistableSerpItem> list) {
            int i = this.a;
            if (i == 0) {
                List<? extends PersistableSerpItem> list2 = list;
                FavoriteStatusResolver favoriteStatusResolver = ((SectionItemConverterImpl) this.b).c;
                Intrinsics.checkNotNullExpressionValue(list2, "items");
                return favoriteStatusResolver.resolve(list2).onErrorReturn(new a2.a.a.l2.c(list2));
            } else if (i == 1) {
                List<? extends PersistableSerpItem> list3 = list;
                ViewedStatusResolver viewedStatusResolver = ((SectionItemConverterImpl) this.b).d;
                Intrinsics.checkNotNullExpressionValue(list3, "items");
                return viewedStatusResolver.resolve(list3).onErrorReturn(new a2.a.a.l2.d(list3));
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<SectionTypeElement, ObservableSource<? extends List<? extends PersistableSpannedItem>>> {
        public final /* synthetic */ SectionItemConverterImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public b(SectionItemConverterImpl sectionItemConverterImpl, int i, boolean z, boolean z2) {
            this.a = sectionItemConverterImpl;
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends PersistableSpannedItem>> apply(SectionTypeElement sectionTypeElement) {
            SectionTypeElement sectionTypeElement2 = sectionTypeElement;
            SectionItemConverterImpl sectionItemConverterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(sectionTypeElement2, "it");
            return SectionItemConverterImpl.access$convert(sectionItemConverterImpl, sectionTypeElement2, this.b, this.c, this.d);
        }
    }

    public static final class c<T, R> implements Function<List<? extends PersistableSpannedItem>, ObservableSource<? extends PersistableSpannedItem>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends PersistableSpannedItem> apply(List<? extends PersistableSpannedItem> list) {
            return Observable.fromIterable(list);
        }
    }

    public static final class d<T> implements Predicate<PersistableSpannedItem> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(PersistableSpannedItem persistableSpannedItem) {
            PersistableSpannedItem persistableSpannedItem2 = persistableSpannedItem;
            return !(persistableSpannedItem2 instanceof SectionItem) || (((SectionItem) persistableSpannedItem2).getItems().isEmpty() ^ true);
        }
    }

    public static final class e<T, R> implements Function<List<PersistableSpannedItem>, List<? extends PersistableSpannedItem>> {
        public final /* synthetic */ SectionItemConverterImpl a;
        public final /* synthetic */ SectionExpandButton b;

        public e(SectionItemConverterImpl sectionItemConverterImpl, SectionExpandButton sectionExpandButton) {
            this.a = sectionItemConverterImpl;
            this.b = sectionExpandButton;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends PersistableSpannedItem> apply(List<PersistableSpannedItem> list) {
            List<PersistableSpannedItem> list2 = list;
            if (this.b == null) {
                return list2;
            }
            SectionItemConverterImpl sectionItemConverterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return SectionItemConverterImpl.access$wrapWithExpandButton(sectionItemConverterImpl, list2, this.b);
        }
    }

    public static final class f<V> implements Callable<List<? extends PersistableSerpItem>> {
        public final /* synthetic */ SectionItemConverterImpl a;
        public final /* synthetic */ SectionTypeItem b;

        public f(SectionItemConverterImpl sectionItemConverterImpl, SectionTypeItem sectionTypeItem) {
            this.a = sectionItemConverterImpl;
            this.b = sectionTypeItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends PersistableSerpItem> call() {
            return this.a.a.convert(this.b.getItems());
        }
    }

    public static final class g<T, R> implements Function<List<? extends PersistableSerpItem>, List<? extends PersistableSpannedItem>> {
        public final /* synthetic */ SectionItemConverterImpl a;
        public final /* synthetic */ SectionTypeItem b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        public g(SectionItemConverterImpl sectionItemConverterImpl, SectionTypeItem sectionTypeItem, int i, boolean z, boolean z2) {
            this.a = sectionItemConverterImpl;
            this.b = sectionTypeItem;
            this.c = i;
            this.d = z;
            this.e = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends PersistableSpannedItem> apply(List<? extends PersistableSerpItem> list) {
            List<? extends PersistableSerpItem> list2 = list;
            if (SectionItemConverterImpl.access$isVerticalSection(this.a, this.b)) {
                SectionItemConverterImpl sectionItemConverterImpl = this.a;
                SectionTypeItem sectionTypeItem = this.b;
                Intrinsics.checkNotNullExpressionValue(list2, "items");
                return SectionItemConverterImpl.access$prepareCommonVerticalSection(sectionItemConverterImpl, sectionTypeItem, sectionItemConverterImpl.a(list2), this.c, this.b.getAction(), list2, this.d, this.e);
            }
            SectionItemConverterImpl sectionItemConverterImpl2 = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            return t6.n.d.listOf(new SectionAdapterItem(String.valueOf(sectionItemConverterImpl2.a(list2)), this.b.getTitle(), this.b.getSubtitle(), this.c, null, this.b.getAction(), list2, this.b.getContext(), this.b.getDisplaying(), 16, null));
        }
    }

    @Inject
    public SectionItemConverterImpl(@NotNull SectionInsideItemsConverter sectionInsideItemsConverter, @NotNull SellerCarouselItemConverter sellerCarouselItemConverter, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(sectionInsideItemsConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(sellerCarouselItemConverter, "sellerCarouselItemConverter");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = sectionInsideItemsConverter;
        this.b = sellerCarouselItemConverter;
        this.c = favoriteStatusResolver;
        this.d = viewedStatusResolver;
        this.e = schedulersFactory3;
        this.f = features;
    }

    public static final Observable access$convert(SectionItemConverterImpl sectionItemConverterImpl, SectionTypeElement sectionTypeElement, int i, boolean z, boolean z2) {
        Objects.requireNonNull(sectionItemConverterImpl);
        if (sectionTypeElement instanceof SectionTypeItem) {
            return sectionItemConverterImpl.b((SectionTypeItem) sectionTypeElement, i, z, z2);
        }
        if (!(sectionTypeElement instanceof RecommendedSellersCarousel)) {
            Observable empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
            return empty;
        } else if (sectionItemConverterImpl.f.getNewRecommendedSellersInAdvert().invoke().booleanValue()) {
            RecommendedSellersCarousel recommendedSellersCarousel = (RecommendedSellersCarousel) sectionTypeElement;
            StringBuilder L = a2.b.a.a.a.L("recommendation_carousel:");
            L.append(UUID.randomUUID());
            String sb = L.toString();
            Observable map = Observable.fromCallable(new a2.a.a.l2.a(sectionItemConverterImpl, recommendedSellersCarousel, sb)).map(new a2.a.a.l2.b(recommendedSellersCarousel, sb, i));
            Intrinsics.checkNotNullExpressionValue(map, "Observable.fromCallable …          )\n            }");
            return map;
        } else {
            Observable empty2 = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty2, "Observable.empty()");
            return empty2;
        }
    }

    public static final boolean access$isVerticalSection(SectionItemConverterImpl sectionItemConverterImpl, SectionTypeItem sectionTypeItem) {
        Objects.requireNonNull(sectionItemConverterImpl);
        SectionDisplaying displaying = sectionTypeItem.getDisplaying();
        return (displaying != null ? displaying.getListViewType() : null) == SectionViewType.VERTICAL;
    }

    public static final List access$prepareCommonVerticalSection(SectionItemConverterImpl sectionItemConverterImpl, SectionTypeItem sectionTypeItem, int i, int i2, Action action, List list, boolean z, boolean z2) {
        List list2;
        List list3;
        Objects.requireNonNull(sectionItemConverterImpl);
        if (z2) {
            list2 = list;
        } else {
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((PersistableSerpItem) obj).getSpanCount() > 1) {
                        arrayList.add(obj);
                    }
                }
                if (!(!arrayList.isEmpty())) {
                    list3 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                    if (z && list3.size() == 4 && i2 == 3) {
                        list3.remove(2);
                    }
                    list2 = list3;
                }
            }
            list3 = list;
            list2 = list3;
        }
        if (true ^ list2.isEmpty()) {
            return CollectionsKt___CollectionsKt.plus((Collection) t6.n.d.listOf(new SectionTitleWithActionItem(String.valueOf(i), sectionTypeItem.getTitle(), sectionTypeItem.getSubtitle(), i2, action, null, 32, null)), (Iterable) list2);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List access$wrapWithExpandButton(SectionItemConverterImpl sectionItemConverterImpl, List list, SectionExpandButton sectionExpandButton) {
        Objects.requireNonNull(sectionItemConverterImpl);
        if (list.isEmpty()) {
            return list;
        }
        Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        if (!(first instanceof SectionTitleWithActionItem)) {
            first = null;
        }
        SectionTitleWithActionItem sectionTitleWithActionItem = (SectionTitleWithActionItem) first;
        if (sectionTitleWithActionItem == null) {
            return list;
        }
        list.remove(0);
        ExpandSectionsButtonItem expandSectionsButtonItem = new ExpandSectionsButtonItem(sectionTitleWithActionItem, sectionExpandButton.getTitle(), list, false, 8, null);
        list.add(0, ExpandSectionsButtonItem.copy$default(expandSectionsButtonItem, null, null, CollectionsKt__CollectionsKt.emptyList(), true, 3, null));
        return t6.n.d.listOf(expandSectionsButtonItem);
    }

    public final int a(List<? extends Item> list) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += defpackage.c.a(it.next().getId());
        }
        return i;
    }

    public final Observable<List<PersistableSpannedItem>> b(SectionTypeItem sectionTypeItem, int i, boolean z, boolean z2) {
        Observable<List<PersistableSpannedItem>> map = Observable.fromCallable(new f(this, sectionTypeItem)).flatMap(new a(0, this)).flatMap(new a(1, this)).map(new g(this, sectionTypeItem, i, z, z2));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromCallable …)\n            }\n        }");
        return map;
    }

    @Override // com.avito.android.section.SectionItemConverter
    @NotNull
    public Single<List<PersistableSpannedItem>> convert(@NotNull List<? extends SectionTypeElement> list, int i, boolean z, @Nullable SectionExpandButton sectionExpandButton, boolean z2) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Single<List<PersistableSpannedItem>> subscribeOn = Observable.fromIterable(list).concatMap(new b(this, i, z, z2)).concatMap(c.a).filter(d.a).toList().map(new e(this, sectionExpandButton)).subscribeOn(this.e.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.fromIterable(…schedulers.computation())");
        return subscribeOn;
    }

    @Override // com.avito.android.section.SectionItemConverter
    @NotNull
    public Single<List<PersistableSpannedItem>> convertSectionTypeItem(@NotNull SectionTypeItem sectionTypeItem, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sectionTypeItem, "element");
        Single<List<PersistableSpannedItem>> subscribeOn = b(sectionTypeItem, i, z, z2).single(CollectionsKt__CollectionsKt.emptyList()).subscribeOn(this.e.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "element.toSectionAdapter…schedulers.computation())");
        return subscribeOn;
    }
}
