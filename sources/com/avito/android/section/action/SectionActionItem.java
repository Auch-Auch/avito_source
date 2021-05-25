package com.avito.android.section.action;

import com.avito.android.remote.model.Action;
import com.avito.android.serp.adapter.PersistableSerpItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/section/action/SectionActionItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionActionItem extends PersistableSerpItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean getHasStablePosition(@NotNull SectionActionItem sectionActionItem) {
            return PersistableSerpItem.DefaultImpls.getHasStablePosition(sectionActionItem);
        }

        public static long getId(@NotNull SectionActionItem sectionActionItem) {
            return PersistableSerpItem.DefaultImpls.getId(sectionActionItem);
        }
    }

    @Nullable
    Action getAction();
}
