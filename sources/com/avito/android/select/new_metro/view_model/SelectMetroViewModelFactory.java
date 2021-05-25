package com.avito.android.select.new_metro.view_model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.metro_lines.MetroLine;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.remote.model.metro_lines.MetroStation;
import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.SelectMetroParams;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.util.SchedulersFactory3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulerFactory", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "c", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "analytics", "Lcom/avito/android/select/new_metro/ItemsHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/android/select/new_metro/ItemsHolder;", "itemsHolder", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "d", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "params", "<init>", "(Lcom/avito/android/select/new_metro/ItemsHolder;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;Lcom/avito/android/select/new_metro/SelectMetroParams;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroViewModelFactory implements ViewModelProvider.Factory {
    public final ItemsHolder a;
    public final SchedulersFactory3 b;
    public final SelectMetroAnalytics c;
    public final SelectMetroParams d;

    @Inject
    public SelectMetroViewModelFactory(@NotNull ItemsHolder itemsHolder, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SelectMetroAnalytics selectMetroAnalytics, @NotNull SelectMetroParams selectMetroParams) {
        Intrinsics.checkNotNullParameter(itemsHolder, "itemsHolder");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulerFactory");
        Intrinsics.checkNotNullParameter(selectMetroAnalytics, "analytics");
        Intrinsics.checkNotNullParameter(selectMetroParams, "params");
        this.a = itemsHolder;
        this.b = schedulersFactory3;
        this.c = selectMetroAnalytics;
        this.d = selectMetroParams;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List<MetroLine> lines;
        List<MetroStation> stations;
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (Intrinsics.areEqual(cls, SelectMetroViewModel.class)) {
            ItemsHolder itemsHolder = this.a;
            MetroResponseBody metroWithLines = this.d.getMetroWithLines();
            if (metroWithLines == null || (stations = metroWithLines.getStations()) == null) {
                arrayList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(stations, 10));
                Iterator<T> it = stations.iterator();
                while (it.hasNext()) {
                    arrayList3.add(Integer.valueOf(it.next().getId()));
                }
                arrayList = arrayList3;
            }
            MetroResponseBody metroWithLines2 = this.d.getMetroWithLines();
            if (metroWithLines2 == null || (lines = metroWithLines2.getLines()) == null) {
                arrayList2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(lines, 10));
                Iterator<T> it2 = lines.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(Integer.valueOf(it2.next().getId()));
                }
                arrayList2 = arrayList4;
            }
            return new SelectMetroViewModel(itemsHolder, this.b, this.c, this.d.getLocationId(), this.d.getCategoryId(), arrayList, arrayList2);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
