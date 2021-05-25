package com.avito.android.section;

import com.avito.android.remote.model.section.SectionDisplaying;
import com.avito.android.section.action.SectionActionItem;
import com.avito.android.section.title.SectionTitleItem;
import com.avito.android.serp.adapter.PersistableSerpItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/section/SectionItem;", "Lcom/avito/android/section/title/SectionTitleItem;", "Lcom/avito/android/section/action/SectionActionItem;", "Lcom/avito/android/remote/model/section/SectionDisplaying;", "getDisplaying", "()Lcom/avito/android/remote/model/section/SectionDisplaying;", "displaying", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "getItems", "()Ljava/util/List;", "items", "", "getContext", "()Ljava/lang/String;", "context", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionItem extends SectionTitleItem, SectionActionItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean getHasStablePosition(@NotNull SectionItem sectionItem) {
            return SectionTitleItem.DefaultImpls.getHasStablePosition(sectionItem);
        }

        public static long getId(@NotNull SectionItem sectionItem) {
            return SectionTitleItem.DefaultImpls.getId(sectionItem);
        }
    }

    @Nullable
    String getContext();

    @Nullable
    SectionDisplaying getDisplaying();

    @NotNull
    List<PersistableSerpItem> getItems();
}
