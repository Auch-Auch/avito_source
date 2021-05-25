package com.avito.android.lib.expected.badge_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0016J#\u0010\u0019\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R*\u0010)\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010 \u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R*\u0010/\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010 ¨\u0006:"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", VKApiConst.POSITION, "Landroid/view/View;", "getBadgeAt", "(I)Landroid/view/View;", "isBadgeVisible", "(I)Z", "(I)I", "Lcom/avito/android/lib/expected/badge_bar/FlexibleLine;", "view", AuthSource.SEND_ABUSE, "(Lcom/avito/android/lib/expected/badge_bar/FlexibleLine;ILandroid/view/View;)V", "", g.a, "Ljava/util/List;", "lines", "d", "I", "verticalOffset", "f", "minimumViewWidth", "value", "getMaxLines", "()I", "setMaxLines", "(I)V", "maxLines", "c", "Z", "allowReordering", "getMaxViews", "setMaxViews", "maxViews", "e", "horizontalOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class CompactFlexibleLayout extends ViewGroup {
    public int a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public List<FlexibleLine> g;

    @JvmOverloads
    public CompactFlexibleLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public CompactFlexibleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public CompactFlexibleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompactFlexibleLayout(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.compactFlexibleLayout : i, (i3 & 8) != 0 ? R.style.Design_Widget_CompactFlexibleLayout : i2);
    }

    public final void a(FlexibleLine flexibleLine, int i, View view) {
        if (!flexibleLine.getIndices().isEmpty()) {
            flexibleLine.setWidth(flexibleLine.getWidth() + this.e);
        }
        flexibleLine.setWidth(view.getMeasuredWidth() + flexibleLine.getWidth());
        flexibleLine.setHeight(Math.max(flexibleLine.getHeight(), view.getMeasuredHeight()));
        flexibleLine.add(i);
    }

    public final int b(int i) {
        Iterator<T> it = this.g.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Iterator<T> it2 = it.next().getIndices().iterator();
            while (true) {
                if (it2.hasNext()) {
                    i2++;
                    if (i == it2.next().intValue()) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    @Nullable
    public final View getBadgeAt(int i) {
        int b2 = b(i);
        int childCount = getChildCount();
        if (b2 >= 0 && childCount > b2) {
            return getChildAt(b2);
        }
        return null;
    }

    public final int getMaxLines() {
        return this.a;
    }

    public final int getMaxViews() {
        return this.b;
    }

    public final boolean isBadgeVisible(int i) {
        int childCount = getChildCount();
        int b2 = b(i);
        return b2 >= 0 && childCount > b2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i5 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                childAt.layout(0, 0, 0, 0);
                if (i5 == childCount) {
                    break;
                }
                i5++;
            }
        }
        int i6 = 0;
        for (T t : this.g) {
            Iterator<T> it = t.getIndices().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                View childAt2 = getChildAt(it.next().intValue());
                Intrinsics.checkNotNullExpressionValue(childAt2, VKApiUserFull.RelativeType.CHILD);
                int measuredWidth = childAt2.getMeasuredWidth();
                int measuredHeight = childAt2.getMeasuredHeight();
                int height = ((t.getHeight() - measuredHeight) / 2) + i6;
                childAt2.layout(i7, height, i7 + measuredWidth, measuredHeight + height);
                i7 += measuredWidth + this.e;
            }
            i6 += t.getHeight() + this.d;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0117 A[EDGE_INSN: B:110:0x0117->B:68:0x0117 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r25, int r26) {
        /*
        // Method dump skipped, instructions count: 485
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout.onMeasure(int, int):void");
    }

    public final void setMaxLines(int i) {
        if (this.a != i) {
            this.a = i;
            FlexibleLine[] flexibleLineArr = new FlexibleLine[i];
            for (int i2 = 0; i2 < i; i2++) {
                flexibleLineArr[i2] = new FlexibleLine(0, 0, null, 7, null);
            }
            this.g = ArraysKt___ArraysKt.toMutableList(flexibleLineArr);
            requestLayout();
        }
    }

    public final void setMaxViews(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactFlexibleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = Integer.MAX_VALUE;
        this.c = true;
        this.g = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt__CollectionsKt.emptyList());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CompactFlexibleLayout, i, i2);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CompactFlexibleLayout_compactFlexibleLayout_lineVerticalOffset, this.d);
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CompactFlexibleLayout_compactFlexibleLayout_viewHorizontalOffset, this.e);
        setMaxLines(obtainStyledAttributes.getInteger(R.styleable.CompactFlexibleLayout_compactFlexibleLayout_maxLines, this.a));
        setMaxViews(obtainStyledAttributes.getInteger(R.styleable.CompactFlexibleLayout_compactFlexibleLayout_maxViews, this.b));
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CompactFlexibleLayout_flexibleLayout_minimalViewWidth, this.f);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.CompactFlexibleLayout_compactFlexibleLayout_allowReordering, this.c);
        obtainStyledAttributes.recycle();
    }
}
