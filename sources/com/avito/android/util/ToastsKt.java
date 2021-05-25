package com.avito.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "", "resId", "duration", "Landroid/widget/Toast;", "showToast", "(Landroid/content/Context;II)Landroid/widget/Toast;", "", "text", "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;", "proxy-toast_release"}, k = 2, mv = {1, 4, 2})
public final class ToastsKt {
    @JvmOverloads
    @SuppressLint({"ShowToast"})
    @NotNull
    public static final Toast showToast(@NotNull Context context, @StringRes int i) {
        return showToast$default(context, i, 0, 2, (Object) null);
    }

    @JvmOverloads
    @SuppressLint({"ShowToast"})
    @NotNull
    public static final Toast showToast(@NotNull Context context, @StringRes int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "$this$showToast");
        Toast makeText = Toast.makeText(context, i, i2);
        ProxyToast instance = ProxyToast.Companion.getInstance();
        Intrinsics.checkNotNullExpressionValue(makeText, "this");
        instance.show(makeText);
        Intrinsics.checkNotNullExpressionValue(makeText, "Toast.makeText(this, res…ast.instance.show(this) }");
        return makeText;
    }

    @JvmOverloads
    @SuppressLint({"ShowToast"})
    @NotNull
    public static final Toast showToast(@NotNull Context context, @NotNull CharSequence charSequence) {
        return showToast$default(context, charSequence, 0, 2, (Object) null);
    }

    public static /* synthetic */ Toast showToast$default(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return showToast(context, i, i2);
    }

    @JvmOverloads
    @SuppressLint({"ShowToast"})
    @NotNull
    public static final Toast showToast(@NotNull Context context, @NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$showToast");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Toast makeText = Toast.makeText(context, charSequence, i);
        ProxyToast instance = ProxyToast.Companion.getInstance();
        Intrinsics.checkNotNullExpressionValue(makeText, "this");
        instance.show(makeText);
        Intrinsics.checkNotNullExpressionValue(makeText, "Toast.makeText(this, tex…ast.instance.show(this) }");
        return makeText;
    }

    public static /* synthetic */ Toast showToast$default(Context context, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return showToast(context, charSequence, i);
    }
}
