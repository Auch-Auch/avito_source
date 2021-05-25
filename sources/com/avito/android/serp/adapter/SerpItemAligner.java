package com.avito.android.serp.adapter;

import com.avito.konveyor.data_source.DataSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemAligner;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "lastPosition", "getAligningShiftItemIndex", "(Lcom/avito/konveyor/data_source/DataSource;I)I", "", "items", "(Ljava/util/List;I)I", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpItemAligner {
    int getAligningShiftItemIndex(@NotNull DataSource<? extends SpannedItem> dataSource, int i);

    int getAligningShiftItemIndex(@NotNull List<? extends SpannedItem> list, int i);
}
