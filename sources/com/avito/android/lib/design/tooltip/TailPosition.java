package com.avito.android.lib.design.tooltip;

import android.annotation.SuppressLint;
import android.view.View;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TailPosition;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "Landroid/view/View;", "anchorView", "tooltipView", "Lkotlin/Pair;", "", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", Tracker.Events.CREATIVE_START, "end", "calculateDefaultTailPosition", "(II)I", "getTailSize", "()I", "tailSize", "getTailHeight", "tailHeight", "components_release"}, k = 1, mv = {1, 4, 2})
public interface TailPosition extends AnchorPosition {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static int getTailSize(@NotNull TailPosition tailPosition) {
            return (int) Math.sqrt(Math.pow(((double) tailPosition.getTailHeight()) * 2.0d, 2.0d) / ((double) 2));
        }
    }

    int calculateDefaultTailPosition(int i, int i2);

    @SuppressLint({"RtlHardcoded"})
    @NotNull
    Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2);

    int getTailHeight();

    int getTailSize();
}
