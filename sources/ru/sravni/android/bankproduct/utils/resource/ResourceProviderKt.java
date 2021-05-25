package ru.sravni.android.bankproduct.utils.resource;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroid/widget/EditText;", "view", "", "drawable", "", "setBackgroundToEditText", "(Landroid/widget/EditText;I)V", "Landroidx/cardview/widget/CardView;", "color", "setBackgroundToCardView", "(Landroidx/cardview/widget/CardView;I)V", "Landroid/widget/ProgressBar;", "setProgressDrawableToProgressBar", "(Landroid/widget/ProgressBar;I)V", "Landroid/content/Context;", "context", "getColorFromThemeAttr", "(Landroid/content/Context;I)I", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ResourceProviderKt {
    @ColorInt
    public static final int getColorFromThemeAttr(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static final void setBackgroundToCardView(@NotNull CardView cardView, int i) {
        Intrinsics.checkParameterIsNotNull(cardView, "view");
        cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.getContext(), i));
    }

    public static final void setBackgroundToEditText(@NotNull EditText editText, int i) {
        Intrinsics.checkParameterIsNotNull(editText, "view");
        editText.setBackground(editText.getContext().getDrawable(i));
    }

    public static final void setProgressDrawableToProgressBar(@NotNull ProgressBar progressBar, int i) {
        Intrinsics.checkParameterIsNotNull(progressBar, "view");
        RectShape rectShape = new RectShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "backgroundDrawable.paint");
        paint.setColor(ContextCompat.getColor(progressBar.getContext(), i));
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(rectShape);
        Paint paint2 = shapeDrawable2.getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint2, "progressDrawable.paint");
        paint2.setColor(ContextCompat.getColor(progressBar.getContext(), R.color.white_sravni));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, new ClipDrawable(shapeDrawable2, GravityCompat.START, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        progressBar.setProgressDrawable(layerDrawable);
    }
}
