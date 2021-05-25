package com.avito.android.lib.design.tooltip;

import android.content.Context;
import com.avito.android.lib.design.R;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", "", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public interface AnchorPosition {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(AnchorPosition anchorPosition, Context context, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = R.attr.tooltip;
                }
                if ((i3 & 4) != 0) {
                    i2 = R.style.Design_Widget_Tooltip;
                }
                anchorPosition.init(context, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    int calculateDefaultAnchorPosition(int i, int i2);

    void init(@NotNull Context context, int i, int i2);
}
