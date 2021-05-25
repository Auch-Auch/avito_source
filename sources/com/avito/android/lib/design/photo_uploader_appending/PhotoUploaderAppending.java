package com.avito.android.lib.design.photo_uploader_appending;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\f\u0012\b\b\u0002\u0010/\u001a\u00020\f¢\u0006\u0004\b0\u00101J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\n\u001a\u00020\u00052\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0010\u001a\u00020\u00052\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "state", "", "setState", "([I)V", "", "text", "setText", "(Ljava/lang/String;)V", "", "(Ljava/lang/Integer;)V", "Landroid/graphics/drawable/Drawable;", "icon", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "extraSpace", "onCreateDrawableState", "(I)[I", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "(I)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "textView", "d", "[I", "currentState", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "contentContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploaderAppending extends FrameLayout implements AppearanceChangeableView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final int[] e = new int[0];
    @NotNull
    public static final int[] f = {R.attr.state_error};
    public ImageView a;
    public TextView b;
    public LinearLayout c;
    public int[] d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending$Companion;", "", "", "STATE_ERROR", "[I", "getSTATE_ERROR", "()[I", "STATE_NORMAL", "getSTATE_NORMAL", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final int[] getSTATE_ERROR() {
            return PhotoUploaderAppending.f;
        }

        @NotNull
        public final int[] getSTATE_NORMAL() {
            return PhotoUploaderAppending.e;
        }

        public Companion(j jVar) {
        }
    }

    @JvmOverloads
    public PhotoUploaderAppending(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public PhotoUploaderAppending(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public PhotoUploaderAppending(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploaderAppending(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? com.avito.android.lib.design.R.attr.photoUploaderAppending : i, (i3 & 8) != 0 ? com.avito.android.lib.design.R.style.Design_Widget_PhotoUploaderAppending : i2);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, typedArray.getColorStateList(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_backgroundColor), typedArray.getColorStateList(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_rippleColor), typedArray.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_cornerRadius, 0), typedArray.getColorStateList(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_borderColor), typedArray.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_borderWidth, 0), 0, 0, 96, null));
        int i = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_textAppearance;
        if (typedArray.hasValue(i)) {
            TextView textView = this.b;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            }
            TextViews.setTextAppearanceCompat(textView, typedArray.getResourceId(i, 0));
        }
        int i2 = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_textColor;
        if (typedArray.hasValue(i2)) {
            TextView textView2 = this.b;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            }
            textView2.setTextColor(typedArray.getColorStateList(i2));
        }
        int i3 = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_contentSpacing;
        if (typedArray.hasValue(i3)) {
            LinearLayout linearLayout = this.c;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            }
            linearLayout.setShowDividers(2);
            LinearLayout linearLayout2 = this.c;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            }
            linearLayout2.setDividerDrawable(ViewGroupsKt.spacing(typedArray.getDimensionPixelSize(i3, 0)));
        }
        int i4 = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_iconColor;
        if (typedArray.hasValue(i4)) {
            ImageView imageView = this.a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            ImageViewsKt.setImageTintListCompat(imageView, typedArray.getColorStateList(i4));
        }
        int i5 = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_contentOrientation;
        if (typedArray.hasValue(i5)) {
            LinearLayout linearLayout3 = this.c;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            }
            linearLayout3.setOrientation(typedArray.getInt(i5, 0));
        }
        int i6 = com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_contentPadding;
        if (typedArray.hasValue(i6)) {
            LinearLayout linearLayout4 = this.c;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            }
            Views.changePadding(linearLayout4, typedArray.getDimensionPixelSize(i6, 0));
        }
        setText(typedArray.getString(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_text));
        setIcon(typedArray.getDrawable(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_icon));
    }

    @Override // android.view.View, android.view.ViewGroup
    @NotNull
    public int[] onCreateDrawableState(int i) {
        int[] mergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(i + this.d.length), this.d);
        Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "View.mergeDrawableStates(states, currentState)");
        return mergeDrawableStates;
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, com.avito.android.lib.design.R.styleable.PhotoUploaderAppending);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setIcon(@Nullable Drawable drawable) {
        ImageView imageView = this.a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setState(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "state");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        this.d = copyOf;
        refreshDrawableState();
    }

    public final void setText(@Nullable String str) {
        TextView textView = this.b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    public final void setIcon(@DrawableRes @Nullable Integer num) {
        Drawable drawable;
        if (num != null) {
            drawable = ContextCompat.getDrawable(getContext(), num.intValue());
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public final void setText(@StringRes @Nullable Integer num) {
        String str;
        if (num != null) {
            str = getContext().getString(num.intValue());
        } else {
            str = null;
        }
        setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoUploaderAppending(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = new int[0];
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.PhotoUploaderAppending, i, i2);
        LayoutInflater.from(getContext()).inflate(obtainStyledAttributes.getResourceId(com.avito.android.lib.design.R.styleable.PhotoUploaderAppending_photoUploaderAppending_layout, com.avito.android.lib.design.R.layout.photo_uploader_appending), (ViewGroup) this, true);
        View findViewById = findViewById(com.avito.android.lib.design.R.id.icon_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.a = (ImageView) findViewById;
        View findViewById2 = findViewById(com.avito.android.lib.design.R.id.text_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(com.avito.android.lib.design.R.id.content_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.c = (LinearLayout) findViewById3;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
