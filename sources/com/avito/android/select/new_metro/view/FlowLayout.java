package com.avito.android.select.new_metro.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\nR\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/avito/android/select/new_metro/view/FlowLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "lines", "setMaxLines", "(I)V", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "(Landroid/view/View;)Landroid/view/View;", "s", "I", "maxLines", "", "getShowedLines", "()Ljava/util/List;", "showedLines", "t", "getDividerSize", "()I", "setDividerSize", "dividerSize", "", "r", "Ljava/util/List;", "currentLines", "Lkotlin/Function0;", VKApiConst.Q, "Lkotlin/jvm/functions/Function0;", "getOnMeasureChanged", "()Lkotlin/jvm/functions/Function0;", "setOnMeasureChanged", "(Lkotlin/jvm/functions/Function0;)V", "onMeasureChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class FlowLayout extends ConstraintLayout {
    @NotNull
    public Function0<Unit> q;
    public final List<List<View>> r;
    public int s;
    public int t;

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public FlowLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public FlowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowLayout(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final View b(View view) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Resources resources2 = context2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(resources2.getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        return view;
    }

    public final int getDividerSize() {
        return this.t;
    }

    @NotNull
    public final Function0<Unit> getOnMeasureChanged() {
        return this.q;
    }

    @NotNull
    public final List<List<View>> getShowedLines() {
        int size = this.r.size();
        int i = this.s;
        if (size > i) {
            return CollectionsKt___CollectionsKt.take(this.r, i);
        }
        return this.r;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        List<View> list;
        List<View> list2;
        int i7;
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        this.r.clear();
        int i8 = 0;
        if (getChildCount() > 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int childCount = getChildCount();
            i3 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = getChildAt(i11);
                Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                b(childAt);
                if (i3 == 0) {
                    i3 += childAt.getMeasuredHeight();
                }
                int measuredWidth = childAt.getMeasuredWidth();
                int i12 = this.t;
                if (i9 + i12 + measuredWidth > size) {
                    i6 = childAt.getMeasuredHeight() + this.t + i3;
                    i4 = i10 + 1;
                    i5 = measuredWidth;
                } else {
                    i6 = i3;
                    i4 = i10;
                    i5 = i12 + measuredWidth + i9;
                }
                if (i4 >= this.r.size()) {
                    list = new ArrayList<>();
                    this.r.add(list);
                } else {
                    list = this.r.get(i4);
                }
                int i13 = i4 - 1;
                View view = (i13 < 0 || this.r.size() <= i13) ? null : (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.r.get(i13));
                constraintSet.clear(childAt.getId(), 3);
                constraintSet.clear(childAt.getId(), 4);
                constraintSet.clear(childAt.getId(), 6);
                constraintSet.clear(childAt.getId(), 7);
                if (view == null) {
                    constraintSet.connect(childAt.getId(), 3, i8, 3);
                    list2 = list;
                    i7 = 6;
                } else {
                    i7 = 6;
                    list2 = list;
                    constraintSet.connect(childAt.getId(), 3, view.getId(), 4, this.t);
                }
                View view2 = (View) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list2);
                if (view2 == null) {
                    constraintSet.connect(childAt.getId(), i7, 0, i7);
                } else {
                    constraintSet.connect(childAt.getId(), 6, view2.getId(), 7, this.t);
                }
                list2.add(childAt);
                i11++;
                i3 = i6;
                i9 = i5;
                i10 = i4;
                i8 = 0;
            }
            constraintSet.applyTo(this);
        } else {
            i3 = 0;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        int i14 = Integer.MAX_VALUE;
        if (this.s != Integer.MAX_VALUE) {
            if (getChildCount() > 0) {
                View childAt2 = getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(0)");
                b(childAt2);
                int measuredHeight = childAt2.getMeasuredHeight();
                int i15 = this.s;
                i14 = ((i15 - 1) * this.t) + (measuredHeight * i15);
            } else {
                i14 = 0;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min(paddingBottom, i14), 1073741824));
        this.q.invoke();
    }

    public final void setDividerSize(int i) {
        this.t = i;
    }

    public final void setMaxLines(int i) {
        this.s = i;
        requestLayout();
    }

    public final void setOnMeasureChanged(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.q = function0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FlowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.q = a.a;
        this.r = new ArrayList();
        this.s = Integer.MAX_VALUE;
    }
}
