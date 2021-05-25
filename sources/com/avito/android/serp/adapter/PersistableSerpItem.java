package com.avito.android.serp.adapter;

import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "", "getHasStablePosition", "()Z", "hasStablePosition", "isExternalAd", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface PersistableSerpItem extends ViewTypeSerpItem, PersistableSpannedItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean getHasStablePosition(@NotNull PersistableSerpItem persistableSerpItem) {
            return false;
        }

        public static long getId(@NotNull PersistableSerpItem persistableSerpItem) {
            return ViewTypeSerpItem.DefaultImpls.getId(persistableSerpItem);
        }
    }

    boolean getHasStablePosition();

    boolean isExternalAd();
}
