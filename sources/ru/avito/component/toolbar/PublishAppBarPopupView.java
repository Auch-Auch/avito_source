package ru.avito.component.toolbar;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b(\u0010.J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0015¨\u0006/"}, d2 = {"Lru/avito/component/toolbar/PublishAppBarPopupView;", "Landroid/widget/LinearLayout;", "", "w", "h", "oldw", "oldh", "", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroidx/appcompat/widget/AppCompatTextView;", g.a, "Landroidx/appcompat/widget/AppCompatTextView;", "getDescriptionTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "descriptionTextView", "d", "I", "tailPadding", "f", "getTitleTextView", "titleTextView", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "tailPaint", "c", "innerPadding", "Landroid/graphics/RectF;", AuthSource.SEND_ABUSE, "Landroid/graphics/RectF;", "tailRect", AuthSource.BOOKING_ORDER, "tailSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAppBarPopupView extends LinearLayout {
    public RectF a;
    public final int b;
    public final int c;
    public final int d;
    public final Paint e;
    @NotNull
    public final AppCompatTextView f;
    @NotNull
    public final AppCompatTextView g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishAppBarPopupView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_size);
        this.b = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.c = context3.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_inner_vertical_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.d = context4.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.gray84));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.e = paint;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f = appCompatTextView;
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
        this.g = appCompatTextView2;
        setOrientation(1);
        TextViews.setTextAppearanceCompat(appCompatTextView, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body_Inverse_Bold);
        TextViews.setTextAppearanceCompat(appCompatTextView2, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body);
        Context context6 = appCompatTextView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "descriptionTextView.context");
        appCompatTextView2.setTextColor(Contexts.getColorStateListCompat(context6, com.avito.android.lib.design.R.color.design_text_color_white_selector));
        addView(appCompatTextView);
        addView(appCompatTextView2);
    }

    @NotNull
    public final AppCompatTextView getDescriptionTextView() {
        return this.g;
    }

    @NotNull
    public final AppCompatTextView getTitleTextView() {
        return this.f;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = this.a;
        if (rectF != null) {
            canvas.save();
            canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
            canvas.drawRect(rectF, this.e);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f2 = ((float) this.b) / 2.0f;
        float width = ((float) (getWidth() - this.d)) - f2;
        float strokeWidth = (float) (this.c + ((int) this.e.getStrokeWidth()));
        this.a = new RectF(width - f2, strokeWidth - f2, width + f2, strokeWidth + f2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishAppBarPopupView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_size);
        this.b = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.c = context3.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_inner_vertical_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.d = context4.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.gray84));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.e = paint;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f = appCompatTextView;
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
        this.g = appCompatTextView2;
        setOrientation(1);
        TextViews.setTextAppearanceCompat(appCompatTextView, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body_Inverse_Bold);
        TextViews.setTextAppearanceCompat(appCompatTextView2, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body);
        Context context6 = appCompatTextView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "descriptionTextView.context");
        appCompatTextView2.setTextColor(Contexts.getColorStateListCompat(context6, com.avito.android.lib.design.R.color.design_text_color_white_selector));
        addView(appCompatTextView);
        addView(appCompatTextView2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishAppBarPopupView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_size);
        this.b = dimensionPixelSize;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.c = context3.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_inner_vertical_padding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.d = context4.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_tail_padding);
        Paint paint = new Paint();
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        paint.setColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.gray84));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(((float) dimensionPixelSize) / 2.0f);
        Unit unit = Unit.INSTANCE;
        this.e = paint;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f = appCompatTextView;
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
        this.g = appCompatTextView2;
        setOrientation(1);
        TextViews.setTextAppearanceCompat(appCompatTextView, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body_Inverse_Bold);
        TextViews.setTextAppearanceCompat(appCompatTextView2, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body);
        Context context6 = appCompatTextView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "descriptionTextView.context");
        appCompatTextView2.setTextColor(Contexts.getColorStateListCompat(context6, com.avito.android.lib.design.R.color.design_text_color_white_selector));
        addView(appCompatTextView);
        addView(appCompatTextView2);
    }
}
