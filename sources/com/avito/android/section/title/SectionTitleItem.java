package com.avito.android.section.title;

import com.avito.android.serp.adapter.PersistableSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/section/title/SectionTitleItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getTitle", "title", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionTitleItem extends PersistableSerpItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean getHasStablePosition(@NotNull SectionTitleItem sectionTitleItem) {
            return PersistableSerpItem.DefaultImpls.getHasStablePosition(sectionTitleItem);
        }

        public static long getId(@NotNull SectionTitleItem sectionTitleItem) {
            return PersistableSerpItem.DefaultImpls.getId(sectionTitleItem);
        }
    }

    @Nullable
    String getSubtitle();

    @Nullable
    String getTitle();
}
