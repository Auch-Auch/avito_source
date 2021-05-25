package com.avito.android.select.new_metro;

import a2.g.r.g;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.metro_lines.MetroLine;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.remote.model.metro_lines.MetroStation;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItem;
import com.avito.android.select.new_metro.adapter.selected_stations.SelectedStationInfo;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b03¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR)\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R)\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR/\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020*8V@\u0016X\u0002¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010-R)\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020/0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010¨\u00067"}, d2 = {"Lcom/avito/android/select/new_metro/MetroResponseToItemsConverter;", "Lcom/avito/android/select/new_metro/ItemsHolder;", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "stationItem", "Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "toSelectedStationInfo", "(Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;)Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "", "", "Lcom/avito/android/remote/model/metro_lines/MetroLine;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "linesById", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getStationsByStationId", "()Ljava/util/Map;", "stationsByStationId", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "d", "getLineFiltersByLineId", "lineFiltersByLineId", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "f", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "getSelectOutputTypeItem", "()Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "selectOutputTypeItem", "", "e", "getAllFiltersByStationId", "allFiltersByStationId", "", "i", "Ljava/lang/String;", "allStationsFilterName", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "h", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getData", "()Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "data", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", g.a, "getSelectedStationsItem", "()Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "selectedStationsItem", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "c", "getLinesByLineId", "linesByLineId", "", "initialSelectedStations", "<init>", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroResponseToItemsConverter implements ItemsHolder {
    public final Map<Integer, MetroLine> a;
    @NotNull
    public final Lazy b;
    @NotNull
    public final Lazy c;
    @NotNull
    public final Lazy d;
    @NotNull
    public final Lazy e;
    @NotNull
    public final MetroListOutputTypeItem f;
    @NotNull
    public final Lazy g;
    @NotNull
    public final MetroResponseBody h;
    public final String i;

    public static final class a extends Lambda implements Function0<Map<Integer, ? extends Set<? extends MetroFilterItem>>> {
        public final /* synthetic */ MetroResponseToItemsConverter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroResponseToItemsConverter metroResponseToItemsConverter) {
            super(0);
            this.a = metroResponseToItemsConverter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Integer, ? extends Set<? extends MetroFilterItem>> invoke() {
            List<MetroStation> stations = this.a.getData().getStations();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(stations, 10));
            for (T t : stations) {
                arrayList.add(new Pair(Integer.valueOf(t.getId()), MetroResponseToItemsConverter.access$getAllFilters(this.a, t)));
            }
            return r.toMap(arrayList);
        }
    }

    public static final class b extends Lambda implements Function0<Map<Integer, ? extends MetroFilterItem>> {
        public final /* synthetic */ MetroResponseToItemsConverter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MetroResponseToItemsConverter metroResponseToItemsConverter) {
            super(0);
            this.a = metroResponseToItemsConverter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Integer, ? extends MetroFilterItem> invoke() {
            List<MetroLine> lines = this.a.getData().getLines();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(lines, 10));
            for (T t : lines) {
                arrayList.add(new Pair(Integer.valueOf(t.getId()), MetroResponseToItemsConverter.access$buildAllStationFilter(this.a, t)));
            }
            return r.toMap(arrayList);
        }
    }

    public static final class c extends Lambda implements Function0<Map<Integer, ? extends MetroLineItem>> {
        public final /* synthetic */ MetroResponseToItemsConverter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MetroResponseToItemsConverter metroResponseToItemsConverter) {
            super(0);
            this.a = metroResponseToItemsConverter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Integer, ? extends MetroLineItem> invoke() {
            List<MetroLine> lines = this.a.getData().getLines();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(lines, 10));
            for (T t : lines) {
                arrayList.add(new Pair(Integer.valueOf(t.getId()), MetroResponseToItemsConverter.access$mapToLineItem(this.a, t)));
            }
            return r.toMap(arrayList);
        }
    }

    public static final class d extends Lambda implements Function0<MetroSelectedStationsItem> {
        public final /* synthetic */ MetroResponseToItemsConverter a;
        public final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MetroResponseToItemsConverter metroResponseToItemsConverter, List list) {
            super(0);
            this.a = metroResponseToItemsConverter;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MetroSelectedStationsItem invoke() {
            List<Number> list = this.b;
            ArrayList arrayList = new ArrayList();
            for (Number number : list) {
                MetroStationItem metroStationItem = this.a.getStationsByStationId().get(Integer.valueOf(number.intValue()));
                SelectedStationInfo selectedStationInfo = metroStationItem != null ? this.a.toSelectedStationInfo(metroStationItem) : null;
                if (selectedStationInfo != null) {
                    arrayList.add(selectedStationInfo);
                }
            }
            return new MetroSelectedStationsItem("SelectedStationsItem", 0, false, arrayList, 6, null);
        }
    }

    public static final class e extends Lambda implements Function0<Map<Integer, ? extends MetroStationItem>> {
        public final /* synthetic */ MetroResponseToItemsConverter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MetroResponseToItemsConverter metroResponseToItemsConverter) {
            super(0);
            this.a = metroResponseToItemsConverter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Integer, ? extends MetroStationItem> invoke() {
            List<MetroStation> stations = this.a.getData().getStations();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(stations, 10));
            for (T t : stations) {
                arrayList.add(new Pair(Integer.valueOf(t.getId()), MetroResponseToItemsConverter.access$mapToMetroStationItem(this.a, t)));
            }
            return r.toMap(arrayList);
        }
    }

    public MetroResponseToItemsConverter(@NotNull MetroResponseBody metroResponseBody, @NotNull String str, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(metroResponseBody, "data");
        Intrinsics.checkNotNullParameter(str, "allStationsFilterName");
        Intrinsics.checkNotNullParameter(list, "initialSelectedStations");
        this.h = metroResponseBody;
        this.i = str;
        List<MetroLine> lines = metroResponseBody.getLines();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(lines, 10));
        for (T t : lines) {
            arrayList.add(new Pair(Integer.valueOf(t.getId()), t));
        }
        this.a = r.toMap(arrayList);
        this.b = t6.c.lazy(new e(this));
        this.c = t6.c.lazy(new c(this));
        this.d = t6.c.lazy(new b(this));
        this.e = t6.c.lazy(new a(this));
        this.f = new MetroListOutputTypeItem("SwitcherItem", MetroListOutputTypeItem.OutputType.ByAlphabet);
        this.g = t6.c.lazy(new d(this, list));
    }

    public static final MetroFilterItem access$buildAllStationFilter(MetroResponseToItemsConverter metroResponseToItemsConverter, MetroLine metroLine) {
        Objects.requireNonNull(metroResponseToItemsConverter);
        StringBuilder L = a2.b.a.a.a.L("AllStationPrefix");
        L.append(metroLine.getId());
        return new MetroFilterItem(L.toString(), CollectionsKt___CollectionsKt.toSet(metroLine.getStationIds()), metroResponseToItemsConverter.i, metroLine.getId());
    }

    public static final Set access$getAllFilters(MetroResponseToItemsConverter metroResponseToItemsConverter, MetroStation metroStation) {
        Objects.requireNonNull(metroResponseToItemsConverter);
        List<Integer> lineIds = metroStation.getLineIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = lineIds.iterator();
        while (it.hasNext()) {
            MetroFilterItem metroFilterItem = metroResponseToItemsConverter.getLineFiltersByLineId().get(Integer.valueOf(it.next().intValue()));
            if (metroFilterItem != null) {
                arrayList.add(metroFilterItem);
            }
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    public static final MetroLineItem access$mapToLineItem(MetroResponseToItemsConverter metroResponseToItemsConverter, MetroLine metroLine) {
        Objects.requireNonNull(metroResponseToItemsConverter);
        StringBuilder L = a2.b.a.a.a.L("Line");
        L.append(metroLine.getId());
        return new MetroLineItem(metroLine.getName(), metroLine.getColor().getValue(), metroLine.getId(), metroLine.getStationIds(), L.toString());
    }

    public static final MetroStationItem access$mapToMetroStationItem(MetroResponseToItemsConverter metroResponseToItemsConverter, MetroStation metroStation) {
        Objects.requireNonNull(metroResponseToItemsConverter);
        String str = "Station" + metroStation.getId();
        List<Integer> lineIds = metroStation.getLineIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = lineIds.iterator();
        while (it.hasNext()) {
            MetroLine metroLine = metroResponseToItemsConverter.a.get(Integer.valueOf(it.next().intValue()));
            Color color = metroLine != null ? metroLine.getColor() : null;
            if (color != null) {
                arrayList.add(color);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder.append("● ", new ForegroundColorSpan(((Color) it2.next()).getValue()), 17);
        }
        return new MetroStationItem(str, metroStation.getLineIds(), spannableStringBuilder, metroStation.getId(), metroStation.getName());
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public Map<Integer, Set<MetroFilterItem>> getAllFiltersByStationId() {
        return (Map) this.e.getValue();
    }

    @NotNull
    public final MetroResponseBody getData() {
        return this.h;
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public Map<Integer, MetroFilterItem> getLineFiltersByLineId() {
        return (Map) this.d.getValue();
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public Map<Integer, MetroLineItem> getLinesByLineId() {
        return (Map) this.c.getValue();
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public MetroListOutputTypeItem getSelectOutputTypeItem() {
        return this.f;
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public MetroSelectedStationsItem getSelectedStationsItem() {
        return (MetroSelectedStationsItem) this.g.getValue();
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public Map<Integer, MetroStationItem> getStationsByStationId() {
        return (Map) this.b.getValue();
    }

    @Override // com.avito.android.select.new_metro.ItemsHolder
    @NotNull
    public SelectedStationInfo toSelectedStationInfo(@NotNull MetroStationItem metroStationItem) {
        Intrinsics.checkNotNullParameter(metroStationItem, "stationItem");
        return new SelectedStationInfo(metroStationItem.getStringId(), metroStationItem.getStationNameWithLineColor(), metroStationItem.getStationId());
    }
}
