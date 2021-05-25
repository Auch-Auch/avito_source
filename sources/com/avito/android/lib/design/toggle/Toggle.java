package com.avito.android.lib.design.toggle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/toggle/Toggle;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class Toggle extends AppCompatCheckBox implements AppearanceChangeableView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Toggle(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void access$set(Toggle toggle, TypedArray typedArray, int i, Function2 function2) {
        Objects.requireNonNull(toggle);
        function2.invoke(typedArray, Integer.valueOf(i));
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        Drawable drawable;
        Integer num;
        int[] iArr = {R.styleable.Toggle_toggle_icon, R.styleable.Toggle_toggle_backgroundColor, R.styleable.Toggle_toggle_borderColor};
        int i = 0;
        while (true) {
            drawable = null;
            if (i >= 3) {
                num = null;
                break;
            }
            int i2 = iArr[i];
            if (typedArray.hasValue(i2)) {
                num = Integer.valueOf(i2);
                break;
            }
            i++;
        }
        if (num != null) {
            num.intValue();
            Views.setBackgroundCompat(this, (Drawable) null);
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.Toggle_toggle_padding, 0);
            RoundStateDrawable invoke$default = RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, typedArray.getColorStateList(R.styleable.Toggle_toggle_backgroundColor), typedArray.getColorStateList(R.styleable.Toggle_toggle_backgroundRipple), typedArray.getDimensionPixelSize(R.styleable.Toggle_toggle_cornerRadius, 0), typedArray.getColorStateList(R.styleable.Toggle_toggle_borderColor), typedArray.getDimensionPixelSize(R.styleable.Toggle_toggle_borderWidth, 0), 0, 0, 96, null);
            Drawable drawable2 = typedArray.getDrawable(R.styleable.Toggle_toggle_icon);
            if (drawable2 != null) {
                drawable = DrawablesKt.wrapForTinting(drawable2, typedArray.getColorStateList(R.styleable.Toggle_toggle_iconColor));
            }
            Object[] array = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Drawable[]{invoke$default, drawable}).toArray(new Drawable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) array);
            layerDrawable.setLayerInset(0, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            layerDrawable.setLayerInset(1, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            Unit unit = Unit.INSTANCE;
            setButtonDrawable(layerDrawable);
        }
        int i3 = R.styleable.Toggle_toggle_width;
        if (typedArray.hasValue(i3)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(i3, 0);
            setMinWidth(dimensionPixelSize2);
            setMaxWidth(dimensionPixelSize2);
        }
        int i4 = R.styleable.Toggle_toggle_height;
        if (typedArray.hasValue(i4)) {
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(i4, 0);
            setMinHeight(dimensionPixelSize3);
            setMaxHeight(dimensionPixelSize3);
        }
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.Toggle);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Toggle(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Toggle(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Toggle, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
