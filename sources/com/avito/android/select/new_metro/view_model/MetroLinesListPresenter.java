package com.avito.android.select.new_metro.view_model;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/new_metro/view_model/MetroLinesListPresenter;", "", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "line", "", "onLineStateChanged", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;)V", "", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;)Ljava/util/List;", "", "Ljava/util/List;", "listConsumer", "Lcom/avito/android/select/new_metro/ItemsHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/select/new_metro/ItemsHolder;", "itemsHolder", "getLinesList", "()Ljava/util/List;", "linesList", "", "linesSequence", "<init>", "(Lcom/avito/android/select/new_metro/ItemsHolder;Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroLinesListPresenter {
    public List<Item> a;
    public final ItemsHolder b;

    public static final class a extends Lambda implements Function1<Integer, MetroLineItem> {
        public final /* synthetic */ MetroLinesListPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroLinesListPresenter metroLinesListPresenter) {
            super(1);
            this.a = metroLinesListPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public MetroLineItem invoke(Integer num) {
            return this.a.b.getLinesByLineId().get(Integer.valueOf(num.intValue()));
        }
    }

    public static final class b extends Lambda implements Function1<MetroLineItem, Sequence<? extends Item>> {
        public final /* synthetic */ MetroLinesListPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MetroLinesListPresenter metroLinesListPresenter) {
            super(1);
            this.a = metroLinesListPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends Item> invoke(MetroLineItem metroLineItem) {
            MetroLineItem metroLineItem2 = metroLineItem;
            Intrinsics.checkNotNullParameter(metroLineItem2, "it");
            return metroLineItem2.isExpanded() ? SequencesKt___SequencesKt.plus(SequencesKt__SequencesKt.sequenceOf(metroLineItem2), (Iterable) this.a.a(metroLineItem2)) : SequencesKt__SequencesKt.sequenceOf(metroLineItem2);
        }
    }

    public MetroLinesListPresenter(@NotNull ItemsHolder itemsHolder, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(itemsHolder, "itemsHolder");
        Intrinsics.checkNotNullParameter(list, "linesSequence");
        this.b = itemsHolder;
        this.a = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.flatMap(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(list), new a(this)), new b(this)));
    }

    public final List<Item> a(MetroLineItem metroLineItem) {
        ArrayList arrayList = new ArrayList();
        MetroFilterItem metroFilterItem = this.b.getLineFiltersByLineId().get(Integer.valueOf(metroLineItem.getLineId()));
        if (metroFilterItem != null) {
            arrayList.add(metroFilterItem);
        }
        Iterator<T> it = metroLineItem.getStationIds().iterator();
        while (it.hasNext()) {
            MetroStationItem metroStationItem = this.b.getStationsByStationId().get(Integer.valueOf(it.next().intValue()));
            if (metroStationItem != null) {
                arrayList.add(metroStationItem);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Item> getLinesList() {
        return this.a;
    }

    public final void onLineStateChanged(@NotNull MetroLineItem metroLineItem) {
        Intrinsics.checkNotNullParameter(metroLineItem, "line");
        Iterator<Item> it = this.a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == metroLineItem.getId()) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            List<Item> list = this.a;
            ArrayList arrayList = new ArrayList();
            int i2 = i + 1;
            int i3 = i2;
            while (i3 < list.size() && !(list.get(i3) instanceof MetroLineItem)) {
                arrayList.add(list.get(i3));
                i3++;
            }
            list.removeAll(arrayList);
            if (metroLineItem.isExpanded()) {
                this.a.addAll(i2, a(metroLineItem));
            }
        }
    }
}
