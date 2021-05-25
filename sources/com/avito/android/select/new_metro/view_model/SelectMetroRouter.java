package com.avito.android.select.new_metro.view_model;

import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/select/new_metro/view_model/SelectMetroRouter;", "", "", "cancel", "()V", "", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "selected", "confirm", "(Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroRouter {
    void cancel();

    void confirm(@NotNull List<MetroStationItem> list);
}
