package com.avito.android.util;

import android.app.Dialog;
import android.view.View;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u000b\u001a\u00028\u0000\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0007*\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/app/Dialog;", "", "dismissDialog", "(Landroid/app/Dialog;)V", "", "isShowing", "(Landroid/app/Dialog;)Z", "Landroid/view/View;", "T", "", "id", "findView", "(Landroid/app/Dialog;I)Landroid/view/View;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Dialogs")
public final class Dialogs {
    public static final void dismissDialog(@Nullable Dialog dialog) {
        boolean z = true;
        if (dialog == null || !dialog.isShowing()) {
            z = false;
        }
        if (z && dialog != null) {
            dialog.dismiss();
        }
    }

    public static final /* synthetic */ <T extends View> T findView(Dialog dialog, @IdRes int i) {
        Intrinsics.checkNotNullParameter(dialog, "$this$findView");
        T t = (T) dialog.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(t, "findViewById(id)");
        return t;
    }

    public static final boolean isShowing(@Nullable Dialog dialog) {
        return dialog != null && dialog.isShowing();
    }
}
