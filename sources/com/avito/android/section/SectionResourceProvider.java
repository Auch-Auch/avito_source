package com.avito.android.section;

import com.avito.android.home.ColumnsCountProvider;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/avito/android/section/SectionResourceProvider;", "Lcom/avito/android/home/ColumnsCountProvider;", "", "getCropPx", "()I", "cropPx", "getPaddingPx", "paddingPx", "getDefaultItemWidthPx", "defaultItemWidthPx", "getContentPaddingPx", "contentPaddingPx", "", "isVerticalShortcutsAsCard", "()Z", "getColumnsOffsetPx", "columnsOffsetPx", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionResourceProvider extends ColumnsCountProvider {
    int getColumnsOffsetPx();

    int getContentPaddingPx();

    int getCropPx();

    int getDefaultItemWidthPx();

    int getPaddingPx();

    boolean isVerticalShortcutsAsCard();
}
