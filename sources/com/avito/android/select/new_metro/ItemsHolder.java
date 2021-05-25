package com.avito.android.select.new_metro;

import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItem;
import com.avito.android.select.new_metro.adapter.selected_stations.SelectedStationInfo;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R(\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001a0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/avito/android/select/new_metro/ItemsHolder;", "", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "stationItem", "Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "toSelectedStationInfo", "(Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;)Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "getSelectedStationsItem", "()Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "selectedStationsItem", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "getSelectOutputTypeItem", "()Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "selectOutputTypeItem", "", "", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "getLinesByLineId", "()Ljava/util/Map;", "linesByLineId", "getStationsByStationId", "stationsByStationId", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "getLineFiltersByLineId", "lineFiltersByLineId", "", "getAllFiltersByStationId", "allFiltersByStationId", "select_release"}, k = 1, mv = {1, 4, 2})
public interface ItemsHolder {
    @NotNull
    Map<Integer, Set<MetroFilterItem>> getAllFiltersByStationId();

    @NotNull
    Map<Integer, MetroFilterItem> getLineFiltersByLineId();

    @NotNull
    Map<Integer, MetroLineItem> getLinesByLineId();

    @NotNull
    MetroListOutputTypeItem getSelectOutputTypeItem();

    @NotNull
    MetroSelectedStationsItem getSelectedStationsItem();

    @NotNull
    Map<Integer, MetroStationItem> getStationsByStationId();

    @NotNull
    SelectedStationInfo toSelectedStationInfo(@NotNull MetroStationItem metroStationItem);
}
