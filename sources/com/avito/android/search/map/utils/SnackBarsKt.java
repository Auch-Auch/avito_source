package com.avito.android.search.map.utils;

import android.view.View;
import com.avito.android.util.Views;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/android/material/snackbar/Snackbar;", "disableSwipeToDismiss", "(Lcom/google/android/material/snackbar/Snackbar;)Lcom/google/android/material/snackbar/Snackbar;", "map_release"}, k = 2, mv = {1, 4, 2})
public final class SnackBarsKt {
    @NotNull
    public static final Snackbar disableSwipeToDismiss(@NotNull Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "$this$disableSwipeToDismiss");
        View view = snackbar.getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Views.withPreDrawListener(view, true, new SnackBarsKt$disableSwipeToDismiss$1$1(snackbar));
        return snackbar;
    }
}
