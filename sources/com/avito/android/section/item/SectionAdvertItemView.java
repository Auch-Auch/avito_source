package com.avito.android.section.item;

import com.avito.android.serp.adapter.AdvertListItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/section/item/SectionAdvertItemView;", "Lcom/avito/android/serp/adapter/AdvertListItemView;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionAdvertItemView extends AdvertListItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SectionAdvertItemView sectionAdvertItemView) {
            AdvertListItemView.DefaultImpls.onUnbind(sectionAdvertItemView);
        }
    }
}
