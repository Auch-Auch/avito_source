package com.avito.android.section;

import android.os.Bundle;
import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/avito/android/section/SectionItemPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/section/SectionItemView;", "Lcom/avito/android/section/SectionItem;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "", "invalidateState", "()V", "", "id", "", "firstCompletelyVisibleItemPosition", "lastVisibleItemPosition", "onCurrentPositionChanged", "(Ljava/lang/String;II)V", "sendAnalytics", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionItemPresenter extends ResponsiveItemPresenter<SectionItemView, SectionItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void viewAttached(@NotNull SectionItemPresenter sectionItemPresenter, @NotNull SectionItemView sectionItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewAttached(sectionItemPresenter, sectionItemView, i);
        }

        public static void viewDetached(@NotNull SectionItemPresenter sectionItemPresenter, @NotNull SectionItemView sectionItemView, int i) {
            Intrinsics.checkNotNullParameter(sectionItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewDetached(sectionItemPresenter, sectionItemView, i);
        }
    }

    void invalidateState();

    void onCurrentPositionChanged(@NotNull String str, int i, int i2);

    @NotNull
    Bundle onSaveState();

    void sendAnalytics();
}
