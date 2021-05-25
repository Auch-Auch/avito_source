package com.avito.android.brandspace.items.textmeasurement;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B8\b\u0007\u0012%\u0010\u0016\u001a!\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0013\u0012\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0013¢\u0006\u0002\b\u00140\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\tJQ\u0010\u000f\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u0005¢\u0006\u0002\b\u000e0\u0005¢\u0006\u0002\b\u000e2\u0006\u0010\b\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R5\u0010\u0016\u001a!\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0013\u0012\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0013¢\u0006\u0002\b\u00140\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurerImpl;", "Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "items", "Lio/reactivex/rxjava3/core/Single;", "measure", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "item", "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "textItemMeasurer", "", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;)Lio/reactivex/rxjava3/core/Single;", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "Ljava/util/Map;", "textItemMeasurers", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulerFactory", "<init>", "(Ljava/util/Map;Lcom/avito/android/util/SchedulersFactory3;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsMeasurerImpl implements ItemsMeasurer {
    public final Map<Class<?>, Provider<TextItemMeasurer<?>>> a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TextMeasurableItem, ObservableSource<? extends Integer>> {
        public final /* synthetic */ ItemsMeasurerImpl a;

        public a(ItemsMeasurerImpl itemsMeasurerImpl) {
            this.a = itemsMeasurerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Integer> apply(TextMeasurableItem textMeasurableItem) {
            TextMeasurableItem textMeasurableItem2 = textMeasurableItem;
            TextItemMeasurer textItemMeasurer = (TextItemMeasurer) ((Provider) r.getValue(this.a.a, textMeasurableItem2.getClass())).get();
            ItemsMeasurerImpl itemsMeasurerImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(textMeasurableItem2, "item");
            Intrinsics.checkNotNullExpressionValue(textItemMeasurer, "textItemMeasurer");
            return itemsMeasurerImpl.a(textMeasurableItem2, textItemMeasurer).toObservable();
        }
    }

    public static final class b<T1, T2, R> implements BiFunction<Integer, Integer, Integer> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Integer apply(Integer num, Integer num2) {
            return Integer.valueOf(Math.max(num.intValue(), num2.intValue()));
        }
    }

    public static final class c<T, R> implements Function<Integer, List<? extends TextMeasurableItem>> {
        public final /* synthetic */ ItemsMeasurerImpl a;
        public final /* synthetic */ List b;

        public c(ItemsMeasurerImpl itemsMeasurerImpl, List list) {
            this.a = itemsMeasurerImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends TextMeasurableItem> apply(Integer num) {
            Integer num2 = num;
            for (T t : this.b) {
                ItemsMeasurerImpl itemsMeasurerImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(num2, "textHeight");
                ItemsMeasurerImpl.access$setItemHeight(itemsMeasurerImpl, t, num2.intValue());
            }
            return this.b;
        }
    }

    public static final class d<T, R> implements Function<Integer, TextMeasurableItem> {
        public final /* synthetic */ ItemsMeasurerImpl a;
        public final /* synthetic */ TextMeasurableItem b;

        public d(ItemsMeasurerImpl itemsMeasurerImpl, TextMeasurableItem textMeasurableItem) {
            this.a = itemsMeasurerImpl;
            this.b = textMeasurableItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TextMeasurableItem apply(Integer num) {
            Integer num2 = num;
            ItemsMeasurerImpl itemsMeasurerImpl = this.a;
            TextMeasurableItem textMeasurableItem = this.b;
            Intrinsics.checkNotNullExpressionValue(num2, "textHeight");
            ItemsMeasurerImpl.access$setItemHeight(itemsMeasurerImpl, textMeasurableItem, num2.intValue());
            return this.b;
        }
    }

    public static final class e<T, R> implements Function<TextMeasurableItem, Integer> {
        public final /* synthetic */ TextItemMeasurer a;

        public e(TextItemMeasurer textItemMeasurer) {
            this.a = textItemMeasurer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(TextMeasurableItem textMeasurableItem) {
            TextMeasurableItem textMeasurableItem2 = textMeasurableItem;
            TextItemMeasurer textItemMeasurer = this.a;
            Intrinsics.checkNotNullExpressionValue(textMeasurableItem2, "it");
            return Integer.valueOf(textItemMeasurer.measure(textMeasurableItem2).getSize().getHeight());
        }
    }

    @Inject
    public ItemsMeasurerImpl(@NotNull Map<Class<?>, Provider<TextItemMeasurer<?>>> map, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(map, "textItemMeasurers");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulerFactory");
        this.a = map;
        this.b = schedulersFactory3;
    }

    public static final void access$setItemHeight(ItemsMeasurerImpl itemsMeasurerImpl, TextMeasurableItem textMeasurableItem, int i) {
        textMeasurableItem.setPrecalculatedTextHeight(i);
        textMeasurableItem.setPrecalculatedMetricsHash(((TextItemMeasurer) ((Provider) r.getValue(itemsMeasurerImpl.a, textMeasurableItem.getClass())).get()).getMeasurerHash());
    }

    public final Single<Integer> a(TextMeasurableItem textMeasurableItem, TextItemMeasurer<?> textItemMeasurer) {
        if (textMeasurableItem.getPrecalculatedMetricsHash() != textItemMeasurer.getMeasurerHash()) {
            return Single.just(textMeasurableItem).subscribeOn(this.b.computation()).map(new e(textItemMeasurer));
        }
        return Single.just(Integer.valueOf(textMeasurableItem.getPrecalculatedTextHeight()));
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer
    @NotNull
    public Single<TextMeasurableItem> measure(@NotNull TextMeasurableItem textMeasurableItem) {
        Intrinsics.checkNotNullParameter(textMeasurableItem, "item");
        TextItemMeasurer<?> textItemMeasurer = (TextItemMeasurer) ((Provider) r.getValue(this.a, textMeasurableItem.getClass())).get();
        Intrinsics.checkNotNullExpressionValue(textItemMeasurer, "textItemMeasurer");
        Single<R> map = a(textMeasurableItem, textItemMeasurer).map(new d(this, textMeasurableItem));
        Intrinsics.checkNotNullExpressionValue(map, "measureItemIfNeeded(item…           item\n        }");
        return map;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer
    @NotNull
    public Single<List<TextMeasurableItem>> measure(@NotNull List<? extends TextMeasurableItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClass());
        }
        for (Class cls : CollectionsKt___CollectionsKt.distinct(arrayList)) {
            ((TextItemMeasurer) ((Provider) r.getValue(this.a, cls)).get()).prepare();
        }
        Object[] array = list.toArray(new TextMeasurableItem[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TextMeasurableItem[] textMeasurableItemArr = (TextMeasurableItem[]) array;
        Single<List<TextMeasurableItem>> map = Observable.fromArray((TextMeasurableItem[]) Arrays.copyOf(textMeasurableItemArr, textMeasurableItemArr.length)).flatMap(new a(this)).reduce(0, b.a).map(new c(this, list));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromArray(*it…      items\n            }");
        return map;
    }
}
