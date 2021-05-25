package com.avito.android.search.map.view;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/AdvertsSheetClipper;", "", "Landroid/view/View;", "view", "container", "", "clip", "(Landroid/view/View;Landroid/view/View;)V", "invalidate", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertsSheetClipper {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void clip$default(AdvertsSheetClipper advertsSheetClipper, View view, View view2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    view2 = null;
                }
                advertsSheetClipper.clip(view, view2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clip");
        }
    }

    void clip(@NotNull View view, @Nullable View view2);

    void invalidate();
}
