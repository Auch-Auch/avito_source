package com.avito.android.id_overlay;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/view/ViewGroup;", "", "x", "y", "Landroid/view/View;", "findViewAt", "(Landroid/view/ViewGroup;II)Landroid/view/View;", "Landroid/graphics/Rect;", "displayingRect", "(Landroid/view/View;)Landroid/graphics/Rect;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "", "moveTo", "(Landroid/graphics/Rect;II)V", "id-overlay_release"}, k = 2, mv = {1, 4, 2})
public final class ViewExtensionsKt {
    @NotNull
    public static final Rect displayingRect(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$displayingRect");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    @Nullable
    public static final View findViewAt(@NotNull ViewGroup viewGroup, int i, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$findViewAt");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        int i3 = 0;
        while (true) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                if (childAt instanceof ViewGroup) {
                    View findViewAt = findViewAt((ViewGroup) childAt, i, i2);
                    if (findViewAt != null && findViewAt.isShown()) {
                        return findViewAt;
                    }
                } else if (displayingRect(childAt).contains(i, i2)) {
                    return childAt;
                }
            }
            if (i3 == childCount) {
                return null;
            }
            i3++;
        }
    }

    public static final void moveTo(@NotNull Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "$this$moveTo");
        int width = rect.width();
        int height = rect.height();
        rect.left = i;
        rect.top = i2;
        rect.right = i + width;
        rect.bottom = i2 + height;
    }
}
