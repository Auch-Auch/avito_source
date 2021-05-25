package com.avito.android.section.title;

import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/avito/android/section/title/SectionTitleItemPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/section/title/SectionTitleItemView;", "Lcom/avito/android/section/title/SectionTitleItem;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionTitleItemPresenter extends ResponsiveItemPresenter<SectionTitleItemView, SectionTitleItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void viewAttached(@NotNull SectionTitleItemPresenter sectionTitleItemPresenter, @NotNull SectionTitleItemView sectionTitleItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionTitleItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewAttached(sectionTitleItemPresenter, sectionTitleItemView, i);
        }

        public static void viewDetached(@NotNull SectionTitleItemPresenter sectionTitleItemPresenter, @NotNull SectionTitleItemView sectionTitleItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionTitleItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewDetached(sectionTitleItemPresenter, sectionTitleItemView, i);
        }
    }
}
