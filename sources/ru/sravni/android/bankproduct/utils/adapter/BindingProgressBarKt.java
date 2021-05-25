package ru.sravni.android.bankproduct.utils.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.resource.ResourceProviderKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/widget/ProgressBar;", "view", "", "colorTint", "", "bindSetIndeterminateAttrTint", "(Landroid/widget/ProgressBar;I)V", "bindSetIndeterminateResTint", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProgressBarKt {
    @BindingAdapter({"colorAttrTint"})
    public static final void bindSetIndeterminateAttrTint(@NotNull ProgressBar progressBar, int i) {
        Intrinsics.checkParameterIsNotNull(progressBar, "view");
        Context context = progressBar.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
        int colorFromThemeAttr = ResourceProviderKt.getColorFromThemeAttr(context, i);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        Intrinsics.checkExpressionValueIsNotNull(indeterminateDrawable, "view.indeterminateDrawable");
        indeterminateDrawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(colorFromThemeAttr, BlendModeCompat.SRC_IN));
    }

    @BindingAdapter({"colorResTint"})
    public static final void bindSetIndeterminateResTint(@NotNull ProgressBar progressBar, int i) {
        Intrinsics.checkParameterIsNotNull(progressBar, "view");
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        Intrinsics.checkExpressionValueIsNotNull(indeterminateDrawable, "view.indeterminateDrawable");
        indeterminateDrawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_IN));
    }
}
