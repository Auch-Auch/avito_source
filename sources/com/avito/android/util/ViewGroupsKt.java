package com.avito.android.util;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\u001a0\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000f\"\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"Landroid/view/ViewGroup;", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "operation", "forEachChild", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "", "forEachChildIndexed", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "size", "Landroid/graphics/drawable/ShapeDrawable;", "spacing", "(I)Landroid/graphics/drawable/ShapeDrawable;", "", "getIterableChildren", "(Landroid/view/ViewGroup;)Ljava/lang/Iterable;", "iterableChildren", "", "getChildren", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "children", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ViewGroupsKt {
    public static final void forEachChild(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$forEachChild");
        Intrinsics.checkNotNullParameter(function1, "operation");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                function1.invoke(childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void forEachChildIndexed(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$forEachChildIndexed");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Integer valueOf = Integer.valueOf(i);
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                function2.invoke(valueOf, childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @NotNull
    public static final Iterator<View> getChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$children");
        return new Object(viewGroup) { // from class: com.avito.android.util.ViewGroupsKt$children$1
            public int a;
            public final /* synthetic */ ViewGroup b;

            {
                this.b = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.getChildCount() > this.a;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            @Override // java.util.Iterator
            @NotNull
            public View next() {
                View childAt = this.b.getChildAt(this.a);
                this.a++;
                Intrinsics.checkNotNullExpressionValue(childAt, "this@children.getChildAt…lso { currentPosition++ }");
                return childAt;
            }
        };
    }

    @NotNull
    public static final Iterable<View> getIterableChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$iterableChildren");
        return new Object(viewGroup) { // from class: com.avito.android.util.ViewGroupsKt$iterableChildren$1
            public final /* synthetic */ ViewGroup a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupsKt.getChildren(this.a);
            }
        };
    }

    @NotNull
    public static final ShapeDrawable spacing(int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setIntrinsicHeight(i);
        shapeDrawable.setIntrinsicWidth(i);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(0);
        return shapeDrawable;
    }
}
