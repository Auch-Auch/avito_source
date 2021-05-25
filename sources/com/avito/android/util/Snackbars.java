package com.avito.android.util;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/android/material/snackbar/Snackbar;", "initButton", "(Lcom/google/android/material/snackbar/Snackbar;)Lcom/google/android/material/snackbar/Snackbar;", "Landroid/widget/TextView;", "getTextView", "(Lcom/google/android/material/snackbar/Snackbar;)Landroid/widget/TextView;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Snackbars")
public final class Snackbars {
    @NotNull
    public static final TextView getTextView(@NotNull Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "$this$getTextView");
        View view = snackbar.getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        View findViewById = view.findViewById(R.id.snackbar_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) findViewById;
    }

    @NotNull
    public static final Snackbar initButton(@NotNull Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "$this$initButton");
        View view = snackbar.getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        View findViewById = view.findViewById(R.id.snackbar_action);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById;
        Context context = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "button.context");
        button.setTypeface(Typefaces.getTypeface(context, TypefaceType.Bold));
        button.setTextSize(0, button.getResources().getDimension(R.dimen.snackbar_text));
        return snackbar;
    }
}
