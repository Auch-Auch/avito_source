package com.avito.android.serp;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b:\u0010;J9\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\t\"\b\b\u0000\u0010\u0010*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/serp/SerpItemProcessorImpl;", "Lcom/avito/android/serp/SerpItemProcessor;", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "", "columns", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "convert", "(Ljava/util/List;ILcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "convertSync", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/util/List;", "Lcom/avito/conveyor_item/Item;", "T", "serpElements", "", "resolveItemsSync", "(Ljava/util/List;)V", "sortAndAdjust", "(Ljava/util/List;I)Lio/reactivex/rxjava3/core/Observable;", "sortAndAdjustSync", "(Ljava/util/List;I)Ljava/util/List;", "sort", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "f", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedResolver", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Z", "getHideSeenBadge", "()Z", "setHideSeenBadge", "(Z)V", "hideSeenBadge", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "itemConverter", "Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "c", "Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "itemSorter", "Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;", "d", "Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;", "sizeAdjuster", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "e", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "<init>", "(Lcom/avito/android/serp/adapter/SerpElementItemConverter;Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemProcessorImpl implements SerpItemProcessor {
    public boolean a;
    public final SerpElementItemConverter b;
    public final SerpItemSorter c;
    public final SerpItemSizeAdjuster d;
    public final FavoriteStatusResolver e;
    public final ViewedStatusResolver f;
    public final SchedulersFactory3 g;

    public static final class a<V> implements Callable<List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ SerpItemProcessorImpl a;
        public final /* synthetic */ List b;
        public final /* synthetic */ SerpDisplayType c;
        public final /* synthetic */ int d;

        public a(SerpItemProcessorImpl serpItemProcessorImpl, List list, SerpDisplayType serpDisplayType, int i) {
            this.a = serpItemProcessorImpl;
            this.b = list;
            this.c = serpDisplayType;
            this.d = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends ViewTypeSerpItem> call() {
            SerpItemProcessorImpl serpItemProcessorImpl = this.a;
            return SerpItemProcessorImpl.access$resolveStatus(serpItemProcessorImpl, SerpItemProcessorImpl.access$adjustHeight(serpItemProcessorImpl, SerpItemProcessorImpl.access$sortItems(serpItemProcessorImpl, SerpItemProcessorImpl.access$convert(serpItemProcessorImpl, this.b, this.c), this.d), this.d));
        }
    }

    public static final class b<V> implements Callable<List<? extends T>> {
        public final /* synthetic */ SerpItemProcessorImpl a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        public b(SerpItemProcessorImpl serpItemProcessorImpl, List list, int i) {
            this.a = serpItemProcessorImpl;
            this.b = list;
            this.c = i;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            SerpItemProcessorImpl serpItemProcessorImpl = this.a;
            return SerpItemProcessorImpl.access$resolveStatus(serpItemProcessorImpl, SerpItemProcessorImpl.access$adjustHeight(serpItemProcessorImpl, SerpItemProcessorImpl.access$sortItems(serpItemProcessorImpl, this.b, this.c), this.c));
        }
    }

    public SerpItemProcessorImpl(@NotNull SerpElementItemConverter serpElementItemConverter, @NotNull SerpItemSorter serpItemSorter, @NotNull SerpItemSizeAdjuster serpItemSizeAdjuster, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(serpElementItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(serpItemSorter, "itemSorter");
        Intrinsics.checkNotNullParameter(serpItemSizeAdjuster, "sizeAdjuster");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedResolver");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.b = serpElementItemConverter;
        this.c = serpItemSorter;
        this.d = serpItemSizeAdjuster;
        this.e = favoriteStatusResolver;
        this.f = viewedStatusResolver;
        this.g = schedulersFactory3;
    }

    public static final List access$adjustHeight(SerpItemProcessorImpl serpItemProcessorImpl, List list, int i) {
        return serpItemProcessorImpl.d.adjust(list, i);
    }

    public static final List access$convert(SerpItemProcessorImpl serpItemProcessorImpl, List list, SerpDisplayType serpDisplayType) {
        return serpItemProcessorImpl.b.convert(list, serpDisplayType);
    }

    public static final List access$resolveStatus(SerpItemProcessorImpl serpItemProcessorImpl, List list) {
        serpItemProcessorImpl.e.resolveSync(list);
        if (!serpItemProcessorImpl.getHideSeenBadge()) {
            serpItemProcessorImpl.f.resolveSync(list);
        }
        return list;
    }

    public static final List access$sortItems(SerpItemProcessorImpl serpItemProcessorImpl, List list, int i) {
        return serpItemProcessorImpl.c.sort(list, i);
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    @NotNull
    public Observable<List<ViewTypeSerpItem>> convert(@NotNull List<? extends SerpElement> list, int i, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Observable<List<ViewTypeSerpItem>> subscribeOn = Observable.fromCallable(new a(this, list, serpDisplayType, i)).subscribeOn(this.g.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.fromCallable …schedulers.computation())");
        return subscribeOn;
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    @NotNull
    public List<ViewTypeSerpItem> convertSync(@NotNull List<? extends SerpElement> list, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        List<ViewTypeSerpItem> convert = this.b.convert(list, serpDisplayType);
        resolveItemsSync(convert);
        return convert;
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    public boolean getHideSeenBadge() {
        return this.a;
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    public <T extends Item> void resolveItemsSync(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "serpElements");
        this.e.resolveSync(list);
        if (!getHideSeenBadge()) {
            this.f.resolveSync(list);
        }
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    public void setHideSeenBadge(boolean z) {
        this.a = z;
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    @NotNull
    public <T extends ViewTypeSerpItem> List<T> sort(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this.c.sort(list, i);
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    @NotNull
    public <T extends ViewTypeSerpItem> Observable<List<T>> sortAndAdjust(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        Observable<List<T>> subscribeOn = Observable.fromCallable(new b(this, list, i)).subscribeOn(this.g.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.fromCallable …schedulers.computation())");
        return subscribeOn;
    }

    @Override // com.avito.android.serp.SerpItemProcessor
    @NotNull
    public <T extends ViewTypeSerpItem> List<T> sortAndAdjustSync(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this.d.adjust(this.c.sort(list, i), i);
    }
}
