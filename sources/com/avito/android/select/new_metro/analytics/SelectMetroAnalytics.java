package com.avito.android.select.new_metro.analytics;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ7\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "", "", "locationId", "categoryId", "", "selectedMetro", "", "trackOpenScreen", "(ILjava/lang/Integer;Ljava/util/List;)V", "", "closedWithSave", "trackCloseScreen", "(ILjava/lang/Integer;ZLjava/util/List;)V", "dropSelected", "(ILjava/lang/Integer;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroAnalytics {
    void dropSelected(int i, @Nullable Integer num);

    void trackCloseScreen(int i, @Nullable Integer num, boolean z, @NotNull List<Integer> list);

    void trackOpenScreen(int i, @Nullable Integer num, @NotNull List<Integer> list);
}
