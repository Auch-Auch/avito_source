package com.avito.android.design.widget;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b'\u0010\u0010B!\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010)\u001a\u00020\u0015¢\u0006\u0004\b'\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\bJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0018\u00010\u0011R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0006R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\u0006¨\u0006,"}, d2 = {"Lcom/avito/android/design/widget/CollapsingTextViewToolbarLayout;", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "", "expansion", "", "setTextViewExpansion", "(F)V", "onFinishInflate", "()V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", g.a, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/avito/android/design/widget/CollapsingTextViewToolbarLayout$a;", "y", "Lcom/avito/android/design/widget/CollapsingTextViewToolbarLayout$a;", "offsetUpdatedListener", "", "z", "I", "textViewId", "Landroid/widget/TextView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/TextView;", "textView", "B", "F", "getCollapsedTextSize", "()F", "setCollapsedTextSize", "collapsedTextSize", "C", "getExpandedTextSize", "setExpandedTextSize", "expandedTextSize", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AuthSource.SEND_ABUSE, "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CollapsingTextViewToolbarLayout extends CollapsingToolbarLayout {
    public TextView A;
    public float B;
    public float C;
    public a y;
    public int z;

    public final class a implements AppBarLayout.OnOffsetChangedListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int i) {
            Intrinsics.checkNotNullParameter(appBarLayout, "layout");
            CollapsingTextViewToolbarLayout.this.setTextViewExpansion(CollapsingTextViewToolbarLayout.access$calculateExpansion(CollapsingTextViewToolbarLayout.this, (float) i, (float) (CollapsingTextViewToolbarLayout.this.getHeight() - CollapsingTextViewToolbarLayout.this.getMinimumHeight())));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingTextViewToolbarLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        g(context, null);
    }

    public static final float access$calculateExpansion(CollapsingTextViewToolbarLayout collapsingTextViewToolbarLayout, float f, float f2) {
        Objects.requireNonNull(collapsingTextViewToolbarLayout);
        if (f2 != 0.0f) {
            return ((float) 1) - Math.abs(f / f2);
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setTextViewExpansion(float f) {
        float f2 = this.B;
        float b = a2.b.a.a.a.b(this.C, f2, f, f2);
        TextView textView = this.A;
        if (textView != null) {
            textView.setTextSize(0, b);
        }
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingTextViewToolbarLayout);
        this.B = obtainStyledAttributes.getDimension(R.styleable.CollapsingTextViewToolbarLayout_collapsedTextSize, 0.0f);
        this.C = obtainStyledAttributes.getDimension(R.styleable.CollapsingTextViewToolbarLayout_expandedTextSize, 0.0f);
        this.z = obtainStyledAttributes.getResourceId(R.styleable.CollapsingTextViewToolbarLayout_collapsibleTextView, 0);
        obtainStyledAttributes.recycle();
    }

    public final float getCollapsedTextSize() {
        return this.B;
    }

    public final float getExpandedTextSize() {
        return this.C;
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.y == null) {
                this.y = new a();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this.y);
            return;
        }
        throw new IllegalStateException("CollapsingTextViewToolbarLayout parent must be AppBarLayout");
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        a aVar = this.y;
        if (aVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) aVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.z != 0) {
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            this.A = (TextView) rootView.findViewById(this.z);
        }
    }

    public final void setCollapsedTextSize(float f) {
        this.B = f;
    }

    public final void setExpandedTextSize(float f) {
        this.C = f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingTextViewToolbarLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        g(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollapsingTextViewToolbarLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        g(context, attributeSet);
    }
}
