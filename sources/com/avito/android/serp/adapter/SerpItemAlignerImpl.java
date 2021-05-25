package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemAlignerImpl;", "Lcom/avito/android/serp/adapter/SerpItemAligner;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "lastPosition", "getAligningShiftItemIndex", "(Lcom/avito/konveyor/data_source/DataSource;I)I", "", "items", "(Ljava/util/List;I)I", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "positionProvider", "<init>", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemAlignerImpl implements SerpItemAligner {
    public final SpannedGridPositionProvider a;

    @Inject
    public SerpItemAlignerImpl(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "positionProvider");
        this.a = spannedGridPositionProvider;
    }

    @Override // com.avito.android.serp.adapter.SerpItemAligner
    public int getAligningShiftItemIndex(@NotNull DataSource<? extends SpannedItem> dataSource, int i) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a.onDataSourceChanged(dataSource);
        int rowForPosition = this.a.getRowForPosition(i);
        if (rowForPosition == 0) {
            return 0;
        }
        int i2 = rowForPosition;
        while (i2 == rowForPosition) {
            i--;
            if (this.a.getRowForPosition(i) != rowForPosition) {
                i++;
                i2 = -1;
            }
        }
        return i;
    }

    @Override // com.avito.android.serp.adapter.SerpItemAligner
    public int getAligningShiftItemIndex(@NotNull List<? extends SpannedItem> list, int i) {
        Intrinsics.checkNotNullParameter(list, "items");
        return getAligningShiftItemIndex(new ListDataSource(list), i);
    }
}
