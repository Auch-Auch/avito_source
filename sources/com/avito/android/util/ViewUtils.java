package com.avito.android.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.IdRes;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0013J#\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/util/ViewUtils;", "", "Landroid/view/View;", "T", "view", "", "id", "findById", "(Landroid/view/View;I)Landroid/view/View;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;I)Landroid/view/View;", "Landroid/view/ViewGroup;", "container", "viewId", "", "removeView", "(Landroid/view/ViewGroup;I)V", "hideView", "(Landroid/view/View;)V", "showView", "Landroid/widget/TextView;", "", "text", "bindText", "(Landroid/widget/TextView;Ljava/lang/String;)V", "", "pickFocus", "(Landroid/app/Activity;)Z", "(Landroid/view/View;)Z", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ViewUtils {
    @NotNull
    public static final ViewUtils INSTANCE = new ViewUtils();

    @Deprecated(message = "Use {@link TextViews#bindText(TextView, CharSequence)} instead")
    public final void bindText(@Nullable TextView textView, @Nullable String str) {
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    public final <T extends View> T findById(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (T) view.findViewById(i);
    }

    public final void hideView(@NotNull ViewGroup viewGroup, @IdRes int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        hideView(viewGroup.findViewById(i));
    }

    public final boolean pickFocus(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(currentFocus, "activity.currentFocus ?: return true");
        return pickFocus(currentFocus);
    }

    public final void removeView(@NotNull ViewGroup viewGroup, @IdRes int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View findById = findById(viewGroup, i);
        if (findById != null) {
            viewGroup.removeView(findById);
        }
    }

    public final void showView(@NotNull ViewGroup viewGroup, @IdRes int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        showView(viewGroup.findViewById(i));
    }

    public final <T extends View> T findById(@NotNull Activity activity, @IdRes int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return (T) activity.findViewById(i);
    }

    public final void hideView(@Nullable View view) {
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public final boolean pickFocus(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup.isFocusable()) {
                    viewGroup.requestFocus();
                    return true;
                }
            }
        }
        return false;
    }

    public final void showView(@Nullable View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
