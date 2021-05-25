package com.avito.android.search.map.view;

import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getColumnsCount", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "()I", "getColumnsCountForList", "", "canSwitchDisplayType", "()Z", "hasShortcuts", "getSerpPaddingTop", "(Z)I", "serpSheet", "getBottomSheetPeekHeight", "getSearchBarHeight", "getShortcutsHeight", "", "getGradientOffset", "()F", "getMinHeightForPinAdverts", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SerpListResourcesProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ int getBottomSheetPeekHeight$default(SerpListResourcesProvider serpListResourcesProvider, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return serpListResourcesProvider.getBottomSheetPeekHeight(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBottomSheetPeekHeight");
        }
    }

    boolean canSwitchDisplayType();

    int getBottomSheetPeekHeight(boolean z);

    int getColumnsCount();

    int getColumnsCount(@NotNull SerpDisplayType serpDisplayType);

    int getColumnsCountForList();

    float getGradientOffset();

    int getMinHeightForPinAdverts();

    int getSearchBarHeight();

    int getSerpPaddingTop(boolean z);

    int getShortcutsHeight();
}
