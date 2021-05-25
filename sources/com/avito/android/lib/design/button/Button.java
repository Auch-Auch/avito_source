package com.avito.android.lib.design.button;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.widget.ImageViewCompat;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002QPB\u0011\b\u0016\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LB\u001b\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\bK\u0010MB#\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\bK\u0010NB+\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\bK\u0010OJ\u0017\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0012J/\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00052\b\b\u0001\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0007J\u000f\u0010!\u001a\u00020\u0005H\u0003¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\"J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\"J-\u0010-\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00107R\u0016\u00109\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u00104R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010;R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010@R\u0016\u0010C\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010BR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010E¨\u0006R"}, d2 = {"Lcom/avito/android/lib/design/button/Button;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "resId", "", "setText", "(I)V", "", "text", "(Ljava/lang/CharSequence;)V", "setImageResource", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "(II)V", "", "withApplyIconColor", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)V", "isLoading", "setLoading", "(Z)V", "Lcom/avito/android/lib/design/button/Button$Alignment;", "alignment", "setAlignment", "(Lcom/avito/android/lib/design/button/Button$Alignment;)V", "isEllipsized", "()Z", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "c", "()V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", AuthSource.BOOKING_ORDER, "f", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "d", "(Landroid/util/AttributeSet;II)V", "Landroid/content/res/ColorStateList;", g.a, "Landroid/content/res/ColorStateList;", "iconColor", "e", "Z", "spinnerColorByTextColor", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageView", "iconColorByTextColor", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "j", "Lcom/avito/android/lib/design/button/Button$Alignment;", "Lcom/avito/android/lib/design/spinner/Spinner;", "Lcom/avito/android/lib/design/spinner/Spinner;", "spinner", "Landroid/widget/FrameLayout;", "container", "i", "I", "smallPadding", "h", "mediumPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "Alignment", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Button extends FrameLayout implements AppearanceChangeableView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final AvitoLayoutInflater.FactoryData k;
    public FrameLayout a;
    public final TextView b;
    public final ImageView c;
    public final Spinner d;
    public boolean e;
    public boolean f;
    public ColorStateList g;
    public int h;
    public int i;
    public Alignment j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/lib/design/button/Button$Alignment;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", "JUSTIFY", "components_release"}, k = 1, mv = {1, 4, 2})
    public enum Alignment {
        CENTER,
        JUSTIFY
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/button/Button$Companion;", "", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "factory", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "getFactory", "()Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AvitoLayoutInflater.FactoryData getFactory() {
            return Button.k;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Alignment.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
        }
    }

    static {
        AvitoLayoutInflater avitoLayoutInflater = AvitoLayoutInflater.INSTANCE;
        k = avitoLayoutInflater.create(avitoLayoutInflater.getAVITO_BUTTON(), a.a);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Button(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.j = Alignment.CENTER;
        LayoutInflater.from(getContext()).inflate(R.layout.design_button_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.container)");
        this.a = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.text_view);
        TextView textView = (TextView) findViewById2;
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R….TruncateAt.END\n        }");
        this.b = textView;
        View findViewById3 = findViewById(R.id.image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image_view)");
        this.c = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.spinner);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.spinner)");
        this.d = (Spinner) findViewById4;
        setClickable(true);
        setFocusable(true);
        this.h = getContext().getResources().getDimensionPixelSize(R.dimen.button_medium_padding);
        this.i = getContext().getResources().getDimensionPixelSize(R.dimen.button_small_padding);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.button_drawable_padding));
        f();
        e(this, null, 0, 0, 6);
    }

    public static /* synthetic */ void e(Button button, AttributeSet attributeSet, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        button.d(attributeSet, i2, i3);
    }

    public static /* synthetic */ void setImageDrawable$default(Button button, Drawable drawable, Drawable drawable2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            drawable = null;
        }
        if ((i2 & 2) != 0) {
            drawable2 = null;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        button.setImageDrawable(drawable, drawable2, z);
    }

    public static /* synthetic */ void setImageResource$default(Button button, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        button.setImageResource(i2, i3);
    }

    public final void a(TypedArray typedArray) {
        RoundStateDrawable roundStateDrawable;
        int i2 = R.styleable.DesignButton_android_background;
        if (typedArray.hasValue(i2)) {
            Views.setBackgroundCompat(this, typedArray.getDrawable(i2));
        }
        int i3 = R.styleable.DesignButton_button_backgroundColor;
        if (typedArray.hasValue(i3) || typedArray.hasValue(R.styleable.DesignButton_button_backgroundRipple) || typedArray.hasValue(R.styleable.DesignButton_button_borderColor)) {
            ColorStateList colorStateList = typedArray.getColorStateList(i3);
            ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.DesignButton_button_backgroundRipple);
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.DesignButton_button_cornerRadius, 0);
            ColorStateList colorStateList3 = typedArray.getColorStateList(R.styleable.DesignButton_button_borderColor);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.DesignButton_button_borderWidth, 0);
            if (colorStateList2 != null) {
                roundStateDrawable = RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, colorStateList, colorStateList2, dimensionPixelSize, colorStateList3, dimensionPixelSize2, 0, 0, 96, null);
            } else {
                roundStateDrawable = RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, colorStateList, null, dimensionPixelSize, colorStateList3, dimensionPixelSize2, 0, 0, 98, null);
            }
            Views.setBackgroundCompat(this, roundStateDrawable);
        }
        int i4 = R.styleable.DesignButton_android_minHeight;
        if (typedArray.hasValue(i4)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(i4, 0));
        }
        int i5 = R.styleable.DesignButton_android_minWidth;
        if (typedArray.hasValue(i5)) {
            setMinimumWidth(typedArray.getDimensionPixelSize(i5, 0));
        }
        int i6 = R.styleable.DesignButton_android_tint;
        if (typedArray.hasValue(i6)) {
            ImageViewCompat.setImageTintList(this.c, typedArray.getColorStateList(i6));
        }
        int i7 = R.styleable.DesignButton_button_spinnerStyle;
        if (typedArray.hasValue(i7)) {
            this.d.setAppearance(typedArray.getResourceId(i7, 0));
        }
        int i8 = R.styleable.DesignButton_button_iconColor;
        if (typedArray.hasValue(i8)) {
            this.g = typedArray.getColorStateList(i8);
            b();
        }
        int i9 = R.styleable.DesignButton_button_spinnerColorByTextColor;
        if (typedArray.hasValue(i9)) {
            this.e = typedArray.getBoolean(i9, this.e);
        }
        int i10 = R.styleable.DesignButton_button_iconColorByTextColor;
        if (typedArray.hasValue(i10)) {
            this.f = typedArray.getBoolean(i10, this.f);
        }
        int i11 = R.styleable.DesignButton_android_textAppearance;
        if (typedArray.hasValue(i11)) {
            int resourceId = typedArray.getResourceId(i11, 0);
            if (this.e || this.f) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(resourceId, new int[]{16842904});
                ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(0);
                if (this.e) {
                    this.d.setTintColor(colorStateList4);
                }
                if (this.f) {
                    ImageViewCompat.setImageTintList(this.c, colorStateList4);
                }
                obtainStyledAttributes.recycle();
            }
            TextViews.setTextAppearanceCompat(this.b, resourceId);
        }
        int i12 = R.styleable.DesignButton_android_textColor;
        if (typedArray.hasValue(i12)) {
            this.b.setTextColor(typedArray.getColorStateList(i12));
        }
        int i13 = R.styleable.DesignButton_android_textAllCaps;
        if (typedArray.hasValue(i13)) {
            this.b.setAllCaps(typedArray.getBoolean(i13, false));
        }
        int i14 = R.styleable.DesignButton_button_textPaddingTop;
        if (typedArray.hasValue(i14)) {
            Views.changePadding$default(this.b, 0, typedArray.getDimensionPixelSize(i14, 0), 0, 0, 13, null);
        }
        int i15 = R.styleable.DesignButton_button_textPaddingBottom;
        if (typedArray.hasValue(i15)) {
            Views.changePadding$default(this.b, 0, 0, 0, typedArray.getDimensionPixelSize(i15, 0), 7, null);
        }
        int i16 = R.styleable.DesignButton_button_alignment;
        if (typedArray.hasValue(i16)) {
            setAlignment(Alignment.values()[typedArray.getInt(i16, 0)]);
        }
    }

    public final void b() {
        List<Drawable> filterNotNull;
        ImageViewCompat.setImageTintList(this.c, this.g);
        Drawable[] compoundDrawables = this.b.getCompoundDrawables();
        if (!(compoundDrawables == null || (filterNotNull = ArraysKt___ArraysKt.filterNotNull(compoundDrawables)) == null)) {
            for (Drawable drawable : filterNotNull) {
                drawable.mutate().setTintList(this.g);
            }
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public final void c() {
        int ordinal = this.j.ordinal();
        int i2 = 17;
        if (ordinal == 0) {
            this.a.getLayoutParams().width = -2;
            this.b.getLayoutParams().width = -2;
            this.b.setGravity(17);
        } else if (ordinal == 1) {
            this.a.getLayoutParams().width = -1;
            this.b.getLayoutParams().width = -1;
            TextView textView = this.b;
            if (textView.getCompoundDrawables()[0] != null && this.b.getCompoundDrawables()[2] == null) {
                i2 = 5;
            } else if (this.b.getCompoundDrawables()[2] != null && this.b.getCompoundDrawables()[0] == null) {
                i2 = 3;
            }
            textView.setGravity(i2 | 16);
        }
        this.b.requestLayout();
        this.a.requestLayout();
    }

    public final void d(AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DesignButton, i2, i3);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.DesignButton_android_text);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DesignButton_android_enabled, true);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DesignButton_android_src);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.DesignButton_android_drawableLeft);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.DesignButton_android_drawableRight);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setEnabled(z);
        TextViews.bindText$default(this.b, text, false, 2, null);
        f();
        if (!(drawable2 == null && drawable3 == null)) {
            setImageDrawable$default(this, drawable2, drawable3, false, 4, null);
        }
        if (drawable != null) {
            setImageDrawable(drawable);
        }
    }

    public final void f() {
        Drawable[] compoundDrawables;
        Drawable[] compoundDrawables2;
        CharSequence text = this.b.getText();
        Intrinsics.checkNotNullExpressionValue(text, "textView.text");
        if (text.length() == 0) {
            Views.changePadding$default(this.b, 0, 0, 0, 0, 10, null);
            return;
        }
        TextView textView = this.b;
        Drawable drawable = null;
        if (!Views.isVisible(textView)) {
            textView = null;
        }
        Drawable drawable2 = (textView == null || (compoundDrawables2 = textView.getCompoundDrawables()) == null) ? null : compoundDrawables2[0];
        if (!(textView == null || (compoundDrawables = textView.getCompoundDrawables()) == null)) {
            drawable = compoundDrawables[2];
        }
        Views.changePadding$default(this.b, drawable2 != null ? this.i : this.h, 0, drawable != null ? this.i : this.h, 0, 10, null);
    }

    public final boolean isEllipsized() {
        if (this.b.getLayout() == null) {
            return false;
        }
        Layout layout = this.b.getLayout();
        Intrinsics.checkNotNullExpressionValue(layout, "textView.layout");
        int lineCount = layout.getLineCount();
        if (lineCount <= 0 || this.b.getLayout().getEllipsisCount(lineCount - 1) <= 0) {
            return false;
        }
        return true;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.j = alignment;
        c();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, R.styleable.DesignButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i2) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i2);
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        this.c.setImageDrawable(drawable);
        Views.show(this.c);
        if (Views.isVisible(this.b)) {
            Views.conceal(this.b);
        }
        b();
    }

    public final void setImageResource(@DrawableRes int i2) {
        Integer valueOf = Integer.valueOf(i2);
        Drawable drawable = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            drawable = getContext().getDrawable(valueOf.intValue());
        }
        setImageDrawable(drawable);
    }

    public final void setLoading(boolean z) {
        if (z) {
            Views.show(this.d);
            Views.conceal(this.a);
            return;
        }
        Views.show(this.a);
        Views.conceal(this.d);
    }

    public final void setText(@StringRes int i2) {
        String string = getContext().getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        setText(string);
    }

    public final void setImageResource(@DrawableRes int i2, @DrawableRes int i3) {
        Integer valueOf = Integer.valueOf(i2);
        boolean z = true;
        Drawable drawable = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        Drawable drawable2 = valueOf != null ? getContext().getDrawable(valueOf.intValue()) : null;
        Integer valueOf2 = Integer.valueOf(i3);
        if (valueOf2.intValue() <= 0) {
            z = false;
        }
        if (!z) {
            valueOf2 = null;
        }
        if (valueOf2 != null) {
            drawable = getContext().getDrawable(valueOf2.intValue());
        }
        setImageDrawable$default(this, drawable2, drawable, false, 4, null);
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.b.setText(charSequence);
        Views.show(this.b);
        if (Views.isVisible(this.c)) {
            Views.conceal(this.c);
        }
        f();
    }

    public final void setImageDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, boolean z) {
        TextViews.setCompoundDrawables$default(this.b, drawable, (Drawable) null, drawable2, (Drawable) null, 10, (Object) null);
        Views.show(this.b);
        if (Views.isVisible(this.c)) {
            Views.conceal(this.c);
        }
        f();
        if (z) {
            b();
        }
        c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Button(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.j = Alignment.CENTER;
        LayoutInflater.from(getContext()).inflate(R.layout.design_button_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.container)");
        this.a = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.text_view);
        TextView textView = (TextView) findViewById2;
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R….TruncateAt.END\n        }");
        this.b = textView;
        View findViewById3 = findViewById(R.id.image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image_view)");
        this.c = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.spinner);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.spinner)");
        this.d = (Spinner) findViewById4;
        setClickable(true);
        setFocusable(true);
        this.h = getContext().getResources().getDimensionPixelSize(R.dimen.button_medium_padding);
        this.i = getContext().getResources().getDimensionPixelSize(R.dimen.button_small_padding);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.button_drawable_padding));
        f();
        e(this, attributeSet, 0, 0, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Button(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.Nullable android.util.AttributeSet r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            int r1 = r0.intValue()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001f
            int r0 = r0.intValue()
            goto L_0x0021
        L_0x001f:
            int r0 = com.avito.android.lib.design.R.attr.button
        L_0x0021:
            r4.<init>(r5, r6, r0)
            com.avito.android.lib.design.button.Button$Alignment r5 = com.avito.android.lib.design.button.Button.Alignment.CENTER
            r4.j = r5
            android.content.Context r5 = r4.getContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r0 = com.avito.android.lib.design.R.layout.design_button_layout
            r5.inflate(r0, r4, r3)
            int r5 = com.avito.android.lib.design.R.id.container
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r0 = "findViewById(R.id.container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r4.a = r5
            int r5 = com.avito.android.lib.design.R.id.text_view
            android.view.View r5 = r4.findViewById(r5)
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setSingleLine(r3)
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r0.setEllipsize(r1)
            java.lang.String r1 = "findViewById<TextView>(R….TruncateAt.END\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r4.b = r0
            int r5 = com.avito.android.lib.design.R.id.image_view
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r1 = "findViewById(R.id.image_view)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.c = r5
            int r5 = com.avito.android.lib.design.R.id.spinner
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r1 = "findViewById(R.id.spinner)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            com.avito.android.lib.design.spinner.Spinner r5 = (com.avito.android.lib.design.spinner.Spinner) r5
            r4.d = r5
            r4.setClickable(r3)
            r4.setFocusable(r3)
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r5 = r5.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_medium_padding
            int r5 = r5.getDimensionPixelSize(r1)
            r4.h = r5
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r5 = r5.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_small_padding
            int r5 = r5.getDimensionPixelSize(r1)
            r4.i = r5
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r5 = r5.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_drawable_padding
            int r5 = r5.getDimensionPixelSize(r1)
            r0.setCompoundDrawablePadding(r5)
            r4.f()
            r5 = 4
            e(r4, r6, r7, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.button.Button.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Button(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable android.util.AttributeSet r5, int r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            int r1 = r0.intValue()
            r2 = 1
            if (r1 <= 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 == 0) goto L_0x001e
            int r0 = r0.intValue()
            goto L_0x0020
        L_0x001e:
            int r0 = com.avito.android.lib.design.R.attr.button
        L_0x0020:
            r3.<init>(r4, r5, r0)
            com.avito.android.lib.design.button.Button$Alignment r4 = com.avito.android.lib.design.button.Button.Alignment.CENTER
            r3.j = r4
            android.content.Context r4 = r3.getContext()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r0 = com.avito.android.lib.design.R.layout.design_button_layout
            r4.inflate(r0, r3, r2)
            int r4 = com.avito.android.lib.design.R.id.container
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r0 = "findViewById(R.id.container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.a = r4
            int r4 = com.avito.android.lib.design.R.id.text_view
            android.view.View r4 = r3.findViewById(r4)
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setSingleLine(r2)
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r0.setEllipsize(r1)
            java.lang.String r1 = "findViewById<TextView>(R….TruncateAt.END\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            r3.b = r0
            int r4 = com.avito.android.lib.design.R.id.image_view
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r1 = "findViewById(R.id.image_view)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.c = r4
            int r4 = com.avito.android.lib.design.R.id.spinner
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r1 = "findViewById(R.id.spinner)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            com.avito.android.lib.design.spinner.Spinner r4 = (com.avito.android.lib.design.spinner.Spinner) r4
            r3.d = r4
            r3.setClickable(r2)
            r3.setFocusable(r2)
            android.content.Context r4 = r3.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_medium_padding
            int r4 = r4.getDimensionPixelSize(r1)
            r3.h = r4
            android.content.Context r4 = r3.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_small_padding
            int r4 = r4.getDimensionPixelSize(r1)
            r3.i = r4
            android.content.Context r4 = r3.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r1 = com.avito.android.lib.design.R.dimen.button_drawable_padding
            int r4 = r4.getDimensionPixelSize(r1)
            r0.setCompoundDrawablePadding(r4)
            r3.f()
            r3.d(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.button.Button.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
