package com.avito.android.express_cv.new_cv;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "", "addCvPaddingsIfNeeded", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/avito/android/util/DeviceMetrics;)V", "express-cv_release"}, k = 2, mv = {1, 4, 2})
public final class NewCvFragmentKt {
    public static final void addCvPaddingsIfNeeded(@NotNull RecyclerView recyclerView, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$addCvPaddingsIfNeeded");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.publish_card_max);
        if (dimensionPixelSize != 0) {
            int displayWidth = (deviceMetrics.getDisplayWidth() - dimensionPixelSize) / 2;
            Views.changePadding$default(recyclerView, displayWidth, 0, displayWidth, 0, 10, null);
        }
    }
}
