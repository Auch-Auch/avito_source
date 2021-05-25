package com.avito.android.search.map.view.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.GridLayoutNoLoaderAppendingHandlerKt;
import com.avito.android.ui.adapter.GridPositionProvider;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/map/view/adapter/GridAppendingRetryHandler;", "", "", VKApiConst.POSITION, "", "appendIfNeeded", "(I)V", "realCount", "", "isAppendingViewPosition", "(II)Z", "getCount", "(I)I", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "Lcom/avito/android/ui/adapter/GridPositionProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/GridPositionProvider;", "gridPositionProvider", "<init>", "(Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/ui/adapter/GridPositionProvider;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class GridAppendingRetryHandler {
    public final AppendingRetryListener a;
    public final GridPositionProvider b;

    public GridAppendingRetryHandler(@NotNull AppendingRetryListener appendingRetryListener, @NotNull GridPositionProvider gridPositionProvider) {
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        Intrinsics.checkNotNullParameter(gridPositionProvider, "gridPositionProvider");
        this.a = appendingRetryListener;
        this.b = gridPositionProvider;
    }

    public final void appendIfNeeded(int i) {
        if (this.a.getAppendingState() == AppendingState.CAN_LOAD) {
            int rows = this.b.getRows();
            int rowForPosition = this.b.getRowForPosition(i);
            if (rowForPosition == rows + -1 || GridLayoutNoLoaderAppendingHandlerKt.isRowToPrefetch(this.b.getColumnsCount(), rows, rowForPosition)) {
                this.a.onAppend();
            }
        }
    }

    public final int getCount(int i) {
        if (this.a.getAppendingState() == AppendingState.NONE || i <= 0) {
            return i;
        }
        int i2 = 0;
        int rows = this.b.getRows() - 1;
        int i3 = i - 1;
        while (i3 >= 0 && this.b.getRowForPosition(i3) == rows) {
            i2++;
            i3--;
        }
        return (i - i2) + 1;
    }

    public final boolean isAppendingViewPosition(int i, int i2) {
        return this.a.getAppendingState() != AppendingState.NONE && i == getCount(i2) - 1;
    }
}
