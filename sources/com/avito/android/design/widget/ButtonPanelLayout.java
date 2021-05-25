package com.avito.android.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006#"}, d2 = {"Lcom/avito/android/design/widget/ButtonPanelLayout;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "c", "I", "verticalMargin", AuthSource.BOOKING_ORDER, "totalWidth", AuthSource.SEND_ABUSE, "getOrientation$annotations", "()V", "orientation", "d", "horizontalMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OrientationMode", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonPanelLayout extends FrameLayout {
    public int a;
    public int b;
    public final int c;
    public final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/design/widget/ButtonPanelLayout$OrientationMode;", "", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OrientationMode {
    }

    @JvmOverloads
    public ButtonPanelLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ButtonPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = (int) getResources().getDimension(R.dimen.button_panel_vertical_margin);
        this.d = (int) getResources().getDimension(R.dimen.button_panel_horizontal_margin);
    }

    private static /* synthetic */ void getOrientation$annotations() {
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i5 = measuredWidth - paddingLeft;
        int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - paddingTop;
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i6 = 0;
            while (true) {
                View childAt = getChildAt(i6);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE));
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                if (this.a == 0) {
                    int i7 = measuredWidth - measuredWidth2;
                    childAt.layout(i7, paddingTop, i7 + measuredWidth2, measuredHeight2 + paddingTop);
                    measuredWidth -= measuredWidth2 + this.d;
                } else {
                    int paddingRight = ((measuredWidth - measuredWidth2) - getPaddingRight()) - getPaddingLeft();
                    childAt.layout(paddingRight, paddingTop, measuredWidth2 + paddingRight, paddingTop + measuredHeight2);
                    paddingTop = measuredHeight2 + this.c + paddingTop;
                }
                if (i6 != childCount) {
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        int childCount2 = getChildCount() - 1;
        int i8 = 0;
        if (childCount2 >= 0) {
            int i9 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            while (true) {
                View childAt = getChildAt(i9);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    i7 += childAt.getMeasuredWidth();
                    if (childAt.getMeasuredWidth() > i6) {
                        i6 = childAt.getMeasuredWidth();
                    }
                    i5 += childAt.getMeasuredHeight();
                    if (childAt.getMeasuredHeight() > i4) {
                        i4 = childAt.getMeasuredHeight();
                    }
                    i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
                }
                if (i9 == childCount2) {
                    break;
                }
                i9++;
            }
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        int i10 = childCount - 1;
        this.b = (this.d * i10) + i7;
        int max = Math.max(i5, getSuggestedMinimumHeight());
        int max2 = Math.max(i7, getSuggestedMinimumWidth());
        if (this.b > (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()) {
            i8 = 1;
        }
        this.a = i8;
        if (i8 == 0) {
            setMeasuredDimension(FrameLayout.resolveSizeAndState(max2, i, i3), getPaddingBottom() + getPaddingTop() + FrameLayout.resolveSizeAndState(i4, i2, i3 << 16));
        } else if (i8 == 1) {
            setMeasuredDimension(getPaddingRight() + getPaddingLeft() + FrameLayout.resolveSizeAndState(i6, i, i3), (this.c * i10) + getPaddingBottom() + getPaddingTop() + FrameLayout.resolveSizeAndState(max, i2, i3 << 16));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ButtonPanelLayout(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
