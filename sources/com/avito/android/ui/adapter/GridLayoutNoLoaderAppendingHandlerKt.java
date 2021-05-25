package com.avito.android.ui.adapter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "columnsCount", "rowsCount", "row", "", "isRowToPrefetch", "(III)Z", "appending-list_release"}, k = 2, mv = {1, 4, 2})
public final class GridLayoutNoLoaderAppendingHandlerKt {
    public static final boolean isRowToPrefetch(int i, int i2, int i3) {
        return i3 == i2 - ((10 / i) + 1);
    }
}
