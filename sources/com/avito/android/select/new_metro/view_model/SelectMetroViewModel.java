package com.avito.android.select.new_metro.view_model;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.RoutingAction;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.adapter.gap.MetroListGapItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItem;
import com.avito.android.select.new_metro.adapter.selected_stations.SelectedStationInfo;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010a\u001a\u00020@\u0012\b\u0010N\u001a\u0004\u0018\u00010@\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020@0?\u0012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020@0?¢\u0006\u0004\bn\u0010oJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0014J\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0014J!\u0010\u001f\u001a\u00020\u00042\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J3\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00104\u001a\u00020#*\u00020\u000b8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\"\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u00100R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020<0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010*R\"\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010*R\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020<0,8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00100R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001d0?8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bG\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001d0?8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010JR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020@0?8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b]\u0010JR\u0016\u0010a\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010cR%\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0,8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010.\u001a\u0004\bf\u00100R\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006p"}, d2 = {"Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "filter", "", "onFilterStateChanged", "(Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;)V", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "station", "onStationStateChanged", "(Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;)V", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "type", "onNewOutputTypeSelected", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;)V", "", "stationName", "onSearchTextChanged", "(Ljava/lang/String;)V", "onClearSelected", "()V", "onCancelClicked", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "line", "onLineStateChanged", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;)V", "onConfirmClicked", "onSelectedStationsItemChange", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "dataSource", "h", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "checkedItems", "", "shouldShowLineColor", "shouldCopyNotActualItems", g.a, "(Ljava/lang/Iterable;ZZ)Lcom/avito/konveyor/data_source/DataSource;", "Landroidx/lifecycle/MutableLiveData;", "k", "Landroidx/lifecycle/MutableLiveData;", "dropTextInternal", "Landroidx/lifecycle/LiveData;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/LiveData;", "getItems", "()Landroidx/lifecycle/LiveData;", "items", "f", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;)Z", "isByLines", "itemsInternal", "o", "getDropText", "dropText", "e", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "switcherItem", "Lcom/avito/android/select/new_metro/RoutingAction;", "j", "routingActionsInternal", "", "", "i", "selectedItemsInternal", "l", "getRoutingActions", "routingActions", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "filterSubscription", "()Ljava/util/List;", "stationItems", "t", "Ljava/lang/Integer;", "categoryId", "Ljava/util/List;", "stationsByAlphabet", "Lcom/avito/android/select/new_metro/ItemsHolder;", "p", "Lcom/avito/android/select/new_metro/ItemsHolder;", "itemsHolder", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "selectedStationsItem", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "r", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "analytics", "topItems", "c", "selectedStations", "s", "I", "locationId", "Lcom/avito/android/select/new_metro/view_model/MetroLinesListPresenter;", "Lcom/avito/android/select/new_metro/view_model/MetroLinesListPresenter;", "linesListPresenter", "n", "getSelectedItems", "selectedItems", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory3;", "schedulerFactory", "stationsByAlphabetSequence", "linesSequence", "<init>", "(Lcom/avito/android/select/new_metro/ItemsHolder;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;ILjava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroViewModel extends ViewModel {
    public final MetroLinesListPresenter c;
    public Disposable d;
    public MetroListOutputTypeItem e;
    public MetroSelectedStationsItem f;
    public final List<MetroStationItem> g;
    public final MutableLiveData<DataSource<Item>> h;
    public final MutableLiveData<List<Integer>> i;
    public final MutableLiveData<RoutingAction> j;
    public final MutableLiveData<Unit> k;
    @NotNull
    public final LiveData<RoutingAction> l;
    @NotNull
    public final LiveData<DataSource<Item>> m;
    @NotNull
    public final LiveData<List<Integer>> n;
    @NotNull
    public final LiveData<Unit> o;
    public final ItemsHolder p;
    public final SchedulersFactory3 q;
    public final SelectMetroAnalytics r;
    public final int s;
    public final Integer t;

    public static final class a<V> implements Callable<List<? extends MetroStationItem>> {
        public final /* synthetic */ SelectMetroViewModel a;
        public final /* synthetic */ Collection b;
        public final /* synthetic */ String c;

        public a(SelectMetroViewModel selectMetroViewModel, Collection collection, String str) {
            this.a = selectMetroViewModel;
            this.b = collection;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends MetroStationItem> call() {
            Collection collection = this.b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : collection) {
                if (StringsKt__StringsKt.contains((CharSequence) SelectMetroViewModel.access$removeDiacritics(this.a, ((MetroStationItem) obj).getStationName()), (CharSequence) SelectMetroViewModel.access$removeDiacritics(this.a, this.c), true)) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt___CollectionsKt.sortedWith(arrayList, new SelectMetroViewModel$onSearchTextChanged$1$$special$$inlined$sortedBy$1(this));
        }
    }

    public static final class b<T> implements Consumer<List<? extends MetroStationItem>> {
        public final /* synthetic */ SelectMetroViewModel a;

        public b(SelectMetroViewModel selectMetroViewModel) {
            this.a = selectMetroViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r12v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends MetroStationItem> list) {
            List<? extends MetroStationItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "list");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                MetroStationItem copy$default = MetroStationItem.copy$default(it.next(), null, null, null, 0, null, 31, null);
                copy$default.setSearchItem(true);
                arrayList.add(copy$default);
            }
            this.a.h.setValue(this.a.g(arrayList, true, false));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public SelectMetroViewModel(@NotNull ItemsHolder itemsHolder, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SelectMetroAnalytics selectMetroAnalytics, int i2, @Nullable Integer num, @NotNull List<Integer> list, @NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(itemsHolder, "itemsHolder");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulerFactory");
        Intrinsics.checkNotNullParameter(selectMetroAnalytics, "analytics");
        Intrinsics.checkNotNullParameter(list, "stationsByAlphabetSequence");
        Intrinsics.checkNotNullParameter(list2, "linesSequence");
        this.p = itemsHolder;
        this.q = schedulersFactory3;
        this.r = selectMetroAnalytics;
        this.s = i2;
        this.t = num;
        this.c = new MetroLinesListPresenter(itemsHolder, list2);
        this.e = itemsHolder.getSelectOutputTypeItem();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            MetroStationItem metroStationItem = this.p.getStationsByStationId().get(Integer.valueOf(it.next().intValue()));
            if (metroStationItem != null) {
                arrayList.add(metroStationItem);
            }
        }
        this.g = arrayList;
        MutableLiveData<DataSource<Item>> mutableLiveData = new MutableLiveData<>();
        this.h = mutableLiveData;
        MutableLiveData<List<Integer>> mutableLiveData2 = new MutableLiveData<>();
        this.i = mutableLiveData2;
        SingleLiveEvent singleLiveEvent = new SingleLiveEvent();
        this.j = singleLiveEvent;
        SingleLiveEvent singleLiveEvent2 = new SingleLiveEvent();
        this.k = singleLiveEvent2;
        this.l = singleLiveEvent;
        this.m = mutableLiveData;
        this.n = mutableLiveData2;
        this.o = singleLiveEvent2;
        this.f = this.p.getSelectedStationsItem();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(e());
        arrayList2.addAll(arrayList);
        if (!c().isEmpty()) {
            arrayList2.add(new MetroListGapItem(null, 0, 3, null));
        }
        mutableLiveData.setValue(new ListDataSource(arrayList2));
        this.r.trackOpenScreen(this.s, this.t, c());
        onNewOutputTypeSelected(this.e);
    }

    public static final boolean access$isFilterSelected(SelectMetroViewModel selectMetroViewModel, MetroFilterItem metroFilterItem, Set set) {
        Objects.requireNonNull(selectMetroViewModel);
        return set.containsAll(metroFilterItem.getStationIds());
    }

    public static final String access$removeDiacritics(SelectMetroViewModel selectMetroViewModel, CharSequence charSequence) {
        Objects.requireNonNull(selectMetroViewModel);
        Regex regex = new Regex("\\p{InCombiningDiacriticalMarks}+");
        String normalize = Normalizer.normalize(charSequence, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(normalize, "Normalizer.normalize(this, Normalizer.Form.NFD)");
        return regex.replace(normalize, "");
    }

    public final List<Integer> c() {
        Set<SelectedStationInfo> items = this.f.getItems();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getStationId()));
        }
        return arrayList;
    }

    public final List<Item> d() {
        return f(this.e) ? this.c.getLinesList() : this.g;
    }

    public final List<Item> e() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Item[]{this.f, this.e});
    }

    public final boolean f(MetroListOutputTypeItem metroListOutputTypeItem) {
        return metroListOutputTypeItem.getSelectedType() == MetroListOutputTypeItem.OutputType.ByLines;
    }

    public final DataSource<Item> g(Iterable<? extends Item> iterable, boolean z, boolean z2) {
        boolean z3;
        ArrayList arrayList = new ArrayList();
        Set set = CollectionsKt___CollectionsKt.toSet(c());
        Set set2 = SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.p.getLineFiltersByLineId().values()), new a2.a.a.m2.m.c.a(this, set)), a2.a.a.m2.m.c.b.a));
        Iterator<? extends Item> it = iterable.iterator();
        while (true) {
            boolean z4 = true;
            MetroStationItem metroStationItem = null;
            metroStationItem = null;
            metroStationItem = null;
            if (!it.hasNext()) {
                break;
            }
            Item item = (Item) it.next();
            if (item instanceof MetroStationItem) {
                MetroStationItem metroStationItem2 = (MetroStationItem) item;
                if (!set.contains(Integer.valueOf(metroStationItem2.getStationId()))) {
                    Set<MetroFilterItem> set3 = this.p.getAllFiltersByStationId().get(Integer.valueOf(metroStationItem2.getStationId()));
                    if (set3 != null && !set3.isEmpty()) {
                        Iterator<T> it2 = set3.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (set2.contains(Integer.valueOf(it2.next().getFilterId()))) {
                                    z3 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z3 = false;
                    if (!z3) {
                        z4 = false;
                    }
                }
                if (!(z4 == metroStationItem2.isChecked() && metroStationItem2.getShowLineColor() == z)) {
                    MetroStationItem copy$default = z2 ? MetroStationItem.copy$default(metroStationItem2, null, null, null, 0, null, 31, null) : metroStationItem2;
                    copy$default.setChecked(z4);
                    copy$default.setShowLineColor(z);
                    metroStationItem = copy$default;
                }
            } else if (item instanceof MetroFilterItem) {
                MetroFilterItem metroFilterItem = (MetroFilterItem) item;
                boolean contains = set2.contains(Integer.valueOf(metroFilterItem.getFilterId()));
                MetroFilterItem copy$default2 = z2 ? MetroFilterItem.copy$default(metroFilterItem, null, null, null, 0, 15, null) : metroFilterItem;
                copy$default2.setChecked(contains);
                metroStationItem = copy$default2;
            } else if ((item instanceof MetroSelectedStationsItem) && !((MetroSelectedStationsItem) item).hasSameContentAs(this.f)) {
                metroStationItem = this.f;
            }
            if (metroStationItem != null) {
                item = metroStationItem;
            }
            arrayList.add(item);
        }
        if (!set.isEmpty()) {
            arrayList.add(new MetroListGapItem(null, 0, 3, null));
        }
        return new ListDataSource(arrayList);
    }

    @NotNull
    public final LiveData<Unit> getDropText() {
        return this.o;
    }

    @NotNull
    public final LiveData<DataSource<Item>> getItems() {
        return this.m;
    }

    @NotNull
    public final LiveData<RoutingAction> getRoutingActions() {
        return this.l;
    }

    @NotNull
    public final LiveData<List<Integer>> getSelectedItems() {
        return this.n;
    }

    public final void h(DataSource<Item> dataSource) {
        if (dataSource == null) {
            dataSource = this.m.getValue();
        }
        if (dataSource != null) {
            this.h.setValue(g(DataSources.toIterableDataSource(dataSource), !f(this.e), true));
            this.i.setValue(c());
        }
    }

    public final void onCancelClicked() {
        this.r.trackCloseScreen(this.s, this.t, false, c());
        this.j.setValue(RoutingAction.CancelAction.INSTANCE);
    }

    public final void onClearSelected() {
        this.f = new MetroSelectedStationsItem(this.f.getStringId(), 0, false, null, 14, null);
        onNewOutputTypeSelected(this.e);
    }

    public final void onConfirmClicked() {
        this.r.trackCloseScreen(this.s, this.t, true, c());
        MutableLiveData<RoutingAction> mutableLiveData = this.j;
        List<Integer> c2 = c();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) c2).iterator();
        while (it.hasNext()) {
            MetroStationItem metroStationItem = this.p.getStationsByStationId().get(Integer.valueOf(((Number) it.next()).intValue()));
            if (metroStationItem != null) {
                arrayList.add(metroStationItem);
            }
        }
        mutableLiveData.setValue(new RoutingAction.ConfirmAction(arrayList));
    }

    public final void onFilterStateChanged(@NotNull MetroFilterItem metroFilterItem) {
        Intrinsics.checkNotNullParameter(metroFilterItem, "filter");
        this.f = new MetroSelectedStationsItem(this.f.getStringId(), 0, false, this.f.getItems(), 6, null);
        Iterator<T> it = metroFilterItem.getStationIds().iterator();
        while (it.hasNext()) {
            MetroStationItem metroStationItem = this.p.getStationsByStationId().get(Integer.valueOf(it.next().intValue()));
            if (metroStationItem != null) {
                if (metroFilterItem.isChecked()) {
                    this.f.add(this.p.toSelectedStationInfo(metroStationItem));
                } else {
                    this.f.remove(this.p.toSelectedStationInfo(metroStationItem));
                }
            }
        }
        h(null);
    }

    public final void onLineStateChanged(@NotNull MetroLineItem metroLineItem) {
        Intrinsics.checkNotNullParameter(metroLineItem, "line");
        this.c.onLineStateChanged(metroLineItem);
        this.h.setValue(g(CollectionsKt___CollectionsKt.plus((Collection) e(), (Iterable) d()), !f(this.e), false));
    }

    public final void onNewOutputTypeSelected(@NotNull MetroListOutputTypeItem metroListOutputTypeItem) {
        Intrinsics.checkNotNullParameter(metroListOutputTypeItem, "type");
        this.e = metroListOutputTypeItem;
        h(new ListDataSource(CollectionsKt___CollectionsKt.plus((Collection) e(), (Iterable) d())));
    }

    public final void onSearchTextChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stationName");
        Collection<MetroStationItem> values = this.p.getStationsByStationId().values();
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        if (str.length() == 0) {
            onNewOutputTypeSelected(this.e);
        } else {
            this.d = Single.fromCallable(new a(this, values, str)).subscribeOn(this.q.computation()).observeOn(this.q.mainThread()).subscribe(new b(this), c.a);
        }
    }

    public final void onSelectedStationsItemChange() {
        h(null);
    }

    public final void onStationStateChanged(@NotNull MetroStationItem metroStationItem) {
        Intrinsics.checkNotNullParameter(metroStationItem, "station");
        this.f = new MetroSelectedStationsItem(this.f.getStringId(), 0, false, this.f.getItems(), 6, null);
        if (metroStationItem.isChecked()) {
            this.f.add(this.p.toSelectedStationInfo(metroStationItem));
        } else {
            this.f.remove(this.p.toSelectedStationInfo(metroStationItem));
        }
        h(new ListDataSource(CollectionsKt___CollectionsKt.plus((Collection) e(), (Iterable) d())));
        this.k.setValue(Unit.INSTANCE);
    }
}
