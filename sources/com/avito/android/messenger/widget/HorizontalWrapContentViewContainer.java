package com.avito.android.messenger.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/widget/HorizontalWrapContentViewContainer;", "Landroid/widget/LinearLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/view/View;", "view", "removeView", "(Landroid/view/View;)V", "notifyTargetViewChanged", "()V", AuthSource.SEND_ABUSE, "(Landroid/view/View;)I", "Landroid/view/View;", "targetView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class HorizontalWrapContentViewContainer extends LinearLayout {
    public View a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalWrapContentViewContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public final void notifyTargetViewChanged() {
        View view = this.a;
        if (view != null) {
            this.a = null;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -2;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getOrientation() == 0) {
            int i3 = -1;
            int childCount = getChildCount() - 1;
            int i4 = 0;
            if (childCount >= 0) {
                int i5 = 0;
                while (true) {
                    View childAt = getChildAt(i5);
                    Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                    int i6 = childAt.getLayoutParams().width;
                    if (childAt.getVisibility() != 0 || i6 != -2) {
                        if (i5 == childCount) {
                            break;
                        }
                        i5++;
                    } else {
                        i3 = i5;
                        break;
                    }
                }
            }
            if (i3 >= 0) {
                View childAt2 = getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt2, "wrapContentView");
                if (getOrientation() == 0) {
                    int a3 = a(childAt2) + childAt2.getLeft();
                    IntRange intRange = new IntRange(i3 + 1, getChildCount() - 1);
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(intRange, 10));
                    Iterator it = intRange.iterator();
                    while (it.hasNext()) {
                        arrayList.add(getChildAt(((IntIterator) it).nextInt()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        View view = (View) next;
                        Intrinsics.checkNotNullExpressionValue(view, "it");
                        if (view.getVisibility() == 0) {
                            arrayList2.add(next);
                        }
                    }
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        View view2 = (View) it3.next();
                        Intrinsics.checkNotNullExpressionValue(view2, "it");
                        i4 += a(view2);
                    }
                    i4 = (getMeasuredWidth() - (a3 + i4)) - getPaddingRight();
                }
                if (i4 < 0) {
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.width = childAt2.getMeasuredWidth() + i4;
                    childAt2.setLayoutParams(layoutParams);
                }
                this.a = childAt2;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@Nullable View view) {
        super.removeView(view);
        if (Intrinsics.areEqual(view, this.a)) {
            this.a = null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalWrapContentViewContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalWrapContentViewContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
