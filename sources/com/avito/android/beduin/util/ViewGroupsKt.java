package com.avito.android.beduin.util;

import android.graphics.Paint;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.avito.android.beduin.core.model.BedionContainerIndent;
import com.avito.android.beduin.core.model.container.BeduinContainerBackground;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.color.ColorFormatter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroid/view/ViewGroup;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "background", "", "setupBackground", "(Landroid/view/ViewGroup;Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;)V", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "padding", "setupPadding", "(Landroid/view/ViewGroup;Lcom/avito/android/beduin/core/model/BedionContainerIndent;)V", "margin", "setupMargin", "beduin_release"}, k = 2, mv = {1, 4, 2})
public final class ViewGroupsKt {
    public static final void setupBackground(@NotNull ViewGroup viewGroup, @Nullable BeduinContainerBackground beduinContainerBackground) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$setupBackground");
        if (beduinContainerBackground != null) {
            Integer cornerRadius = beduinContainerBackground.getCornerRadius();
            UniversalColor color = beduinContainerBackground.getColor();
            if (cornerRadius != null && color != null) {
                ShapeAppearanceModel build = new ShapeAppearanceModel().toBuilder().setAllCorners(0, (float) ViewSizeKt.getDp(cornerRadius.intValue())).build();
                Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel()\n …\n                .build()");
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
                materialShapeDrawable.setTint(ColorFormatter.INSTANCE.formatColor(viewGroup.getContext(), color));
                materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
                ViewCompat.setBackground(viewGroup, materialShapeDrawable);
            } else if (color != null) {
                viewGroup.setBackgroundColor(ColorFormatter.INSTANCE.formatColor(viewGroup.getContext(), color));
            }
        }
    }

    public static final void setupMargin(@NotNull ViewGroup viewGroup, @Nullable BedionContainerIndent bedionContainerIndent) {
        Integer all;
        Integer bottom;
        Integer top;
        Integer right;
        Integer left;
        Intrinsics.checkNotNullParameter(viewGroup, "$this$setupMargin");
        if (!(bedionContainerIndent == null || (left = bedionContainerIndent.getLeft()) == null)) {
            Views.changeMargin$default(viewGroup, ViewSizeKt.getDp(left.intValue()), 0, 0, 0, 14, null);
        }
        if (!(bedionContainerIndent == null || (right = bedionContainerIndent.getRight()) == null)) {
            Views.changeMargin$default(viewGroup, 0, 0, ViewSizeKt.getDp(right.intValue()), 0, 11, null);
        }
        if (!(bedionContainerIndent == null || (top = bedionContainerIndent.getTop()) == null)) {
            Views.changeMargin$default(viewGroup, 0, ViewSizeKt.getDp(top.intValue()), 0, 0, 13, null);
        }
        if (!(bedionContainerIndent == null || (bottom = bedionContainerIndent.getBottom()) == null)) {
            Views.changeMargin$default(viewGroup, 0, 0, 0, ViewSizeKt.getDp(bottom.intValue()), 7, null);
        }
        if (bedionContainerIndent != null && (all = bedionContainerIndent.getAll()) != null) {
            int intValue = all.intValue();
            Views.changeMargin(viewGroup, ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue));
        }
    }

    public static final void setupPadding(@NotNull ViewGroup viewGroup, @Nullable BedionContainerIndent bedionContainerIndent) {
        Integer all;
        Integer bottom;
        Integer top;
        Integer right;
        Integer left;
        Intrinsics.checkNotNullParameter(viewGroup, "$this$setupPadding");
        if (!(bedionContainerIndent == null || (left = bedionContainerIndent.getLeft()) == null)) {
            viewGroup.setPadding(ViewSizeKt.getDp(left.intValue()), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        if (!(bedionContainerIndent == null || (right = bedionContainerIndent.getRight()) == null)) {
            viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), ViewSizeKt.getDp(right.intValue()), viewGroup.getPaddingBottom());
        }
        if (!(bedionContainerIndent == null || (top = bedionContainerIndent.getTop()) == null)) {
            viewGroup.setPadding(viewGroup.getPaddingLeft(), ViewSizeKt.getDp(top.intValue()), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        if (!(bedionContainerIndent == null || (bottom = bedionContainerIndent.getBottom()) == null)) {
            viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), ViewSizeKt.getDp(bottom.intValue()));
        }
        if (bedionContainerIndent != null && (all = bedionContainerIndent.getAll()) != null) {
            int intValue = all.intValue();
            viewGroup.setPadding(ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue), ViewSizeKt.getDp(intValue));
        }
    }
}
