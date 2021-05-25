package com.avito.android.search_filter;

import a2.b.a.a.a;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010.\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\u0012\u0012\u0006\u0010+\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0004\b/\u00100J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u0018*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010,R\u0016\u0010.\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010(¨\u00061"}, d2 = {"Lcom/avito/android/search_filter/GroupsBackgroundDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "onDrawOver", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", VKApiConst.POSITION, "Lkotlin/ranges/IntRange;", AuthSource.SEND_ABUSE, "(I)Lkotlin/ranges/IntRange;", "value", "", AuthSource.BOOKING_ORDER, "(Lkotlin/ranges/IntRange;I)Z", "", "f", "Ljava/util/List;", "getRanges", "()Ljava/util/List;", "setRanges", "(Ljava/util/List;)V", "ranges", "d", "I", "verticalPadding", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "divider", "e", "horizontalPadding", "Landroid/graphics/Rect;", "backgroundPadding", "background", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;IILjava/util/List;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class GroupsBackgroundDecoration extends RecyclerView.ItemDecoration {
    public final Rect a;
    public final Drawable b;
    public final Drawable c;
    public final int d;
    public final int e;
    @NotNull
    public List<IntRange> f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GroupsBackgroundDecoration(Drawable drawable, Drawable drawable2, int i, int i2, List list, int i3, j jVar) {
        this(drawable, drawable2, i, i2, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public final IntRange a(int i) {
        T t;
        Iterator<T> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.contains(i)) {
                break;
            }
        }
        return t;
    }

    public final boolean b(IntRange intRange, int i) {
        return i >= intRange.getStart().intValue() && i < intRange.getLast();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        for (T t : this.f) {
            if (childAdapterPosition == t.getFirst()) {
                if (childAdapterPosition == 0) {
                    i = 0;
                } else {
                    i = this.a.top;
                }
                rect.top = i + this.d;
            }
            if (b(t, childAdapterPosition)) {
                rect.bottom = this.c.getIntrinsicHeight();
            }
            if (childAdapterPosition == t.getLast()) {
                rect.bottom = this.a.bottom + this.d + rect.bottom;
            }
        }
    }

    @NotNull
    public final List<IntRange> getRanges() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft() - this.a.left;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) + this.a.right;
        int childCount = recyclerView.getChildCount();
        IntRange intRange = null;
        int i = 0;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            IntRange a3 = a(recyclerView.getChildAdapterPosition(childAt));
            if (a3 != null) {
                if (!Intrinsics.areEqual(intRange, a3)) {
                    if (!(i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE)) {
                        this.b.setBounds(paddingLeft, i2, width, i3);
                        this.b.draw(canvas);
                    }
                    Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                    i2 = (childAt.getTop() - this.d) - this.a.top;
                }
                Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                i3 = this.a.bottom + childAt.getBottom() + this.d;
            }
            i++;
            intRange = a3;
        }
        if (i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE) {
            this.b.setBounds(paddingLeft, i2, width, i3);
            this.b.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft() + this.e;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.e;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            IntRange a3 = a(childAdapterPosition);
            if (a3 != null && b(a3, childAdapterPosition)) {
                Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                int bottom = childAt.getBottom();
                this.c.setBounds(paddingLeft, bottom, width, this.c.getIntrinsicHeight() + bottom);
                this.c.draw(canvas);
            }
        }
    }

    public final void setRanges(@NotNull List<IntRange> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f = list;
    }

    public GroupsBackgroundDecoration(@NotNull Drawable drawable, @NotNull Drawable drawable2, int i, int i2, @NotNull List<IntRange> list) {
        Intrinsics.checkNotNullParameter(drawable, "background");
        Intrinsics.checkNotNullParameter(drawable2, "divider");
        Intrinsics.checkNotNullParameter(list, "ranges");
        this.b = drawable;
        this.c = drawable2;
        this.d = i;
        this.e = i2;
        this.f = list;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        Unit unit = Unit.INSTANCE;
        this.a = rect;
    }
}
