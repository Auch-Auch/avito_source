package com.avito.android.ui.adapter;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/ui/adapter/GridPositionProvider;", "", "", VKApiConst.POSITION, "getRowForPosition", "(I)I", "getRows", "()I", "getColumnsCount", "setColumnsCount", "(I)V", "columnsCount", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public interface GridPositionProvider {
    int getColumnsCount();

    int getRowForPosition(int i);

    int getRows();

    void setColumnsCount(int i);
}
