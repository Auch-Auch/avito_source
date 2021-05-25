package com.avito.android.section.action;

import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import com.avito.android.section.SectionRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/section/action/SectionActionPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/section/action/SectionActionItemView;", "Lcom/avito/android/section/action/SectionActionItem;", "Lcom/avito/android/section/SectionRouter;", "router", "", "attachRouter", "(Lcom/avito/android/section/SectionRouter;)V", "detachRouter", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionActionPresenter extends ResponsiveItemPresenter<SectionActionItemView, SectionActionItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void viewAttached(@NotNull SectionActionPresenter sectionActionPresenter, @NotNull SectionActionItemView sectionActionItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionActionItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewAttached(sectionActionPresenter, sectionActionItemView, i);
        }

        public static void viewDetached(@NotNull SectionActionPresenter sectionActionPresenter, @NotNull SectionActionItemView sectionActionItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionActionItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewDetached(sectionActionPresenter, sectionActionItemView, i);
        }
    }

    void attachRouter(@NotNull SectionRouter sectionRouter);

    void detachRouter();
}
