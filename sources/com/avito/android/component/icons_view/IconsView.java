package com.avito.android.component.icons_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010$J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006%"}, d2 = {"Lcom/avito/android/component/icons_view/IconsView;", "Landroid/widget/FrameLayout;", "", "", "Lcom/avito/android/image_loader/Picture;", "icons", "", "setIcons", "(Ljava/util/Map;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", FirebaseAnalytics.Param.INDEX, AuthSource.SEND_ABUSE, "(I)I", AuthSource.BOOKING_ORDER, "I", "iconPadding", "iconSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class IconsView extends FrameLayout {
    public int a;
    public int b;

    @JvmOverloads
    public IconsView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public IconsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public IconsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IconsView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? R.style.Widget_Avito_IconsView : i2);
    }

    public final int a(int i) {
        if (i > 0) {
            return -this.b;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int height = (getHeight() / 2) - (measuredHeight / 2);
                if (a(i5) + i6 + measuredWidth <= getWidth()) {
                    int a3 = a(i5) + i6;
                    int i7 = measuredWidth + a3;
                    childAt.layout(a3, height, i7, measuredHeight + height);
                    i6 = i7;
                } else {
                    childAt.setVisibility(8);
                }
                if (i5 != childCount) {
                    i5++;
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
        super.onMeasure(i, i2);
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i5 = 0;
            i4 = 0;
            i3 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                measureChild(childAt, i, i2);
                i4 += a(i5) + childAt.getMeasuredWidth();
                i3 = Math.max(i3, childAt.getMeasuredHeight());
                ViewGroup.combineMeasuredStates(0, childAt.getMeasuredState());
                if (i5 == childCount) {
                    break;
                }
                i5++;
            }
        } else {
            i4 = 0;
            i3 = 0;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumHeight()), i2, 0));
    }

    public final void setIcons(@NotNull Map<String, ? extends Picture> map) {
        Intrinsics.checkNotNullParameter(map, "icons");
        removeAllViews();
        for (Map.Entry<String, ? extends Picture> entry : map.entrySet()) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
            int i = this.a;
            simpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(i, i));
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture((Picture) entry.getValue()).load();
            simpleDraweeView.setTag(entry.getKey());
            addView(simpleDraweeView);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public IconsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.IconsView, i, i2);
        this.a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.IconsView_icon_size, this.a);
        this.b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.IconsView_icon_overflowMargin, this.b);
        obtainStyledAttributes.recycle();
    }
}
