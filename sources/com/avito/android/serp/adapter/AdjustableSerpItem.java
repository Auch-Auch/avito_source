package com.avito.android.serp.adapter;

import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/AdjustableSerpItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "getFullSize", "()Z", "setFullSize", "(Z)V", "fullSize", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdjustableSerpItem extends ViewTypeSerpItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull AdjustableSerpItem adjustableSerpItem) {
            return ViewTypeSerpItem.DefaultImpls.getId(adjustableSerpItem);
        }
    }

    boolean getFullSize();

    void setFullSize(boolean z);
}
