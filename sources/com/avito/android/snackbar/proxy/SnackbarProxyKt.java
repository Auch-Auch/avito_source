package com.avito.android.snackbar.proxy;

import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/android/material/snackbar/Snackbar;", "", "showSnackbar", "(Lcom/google/android/material/snackbar/Snackbar;)V", "snackbar-proxy_release"}, k = 2, mv = {1, 4, 2})
public final class SnackbarProxyKt {
    public static final void showSnackbar(@NotNull Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "$this$showSnackbar");
        snackbar.show();
        Unit unit = Unit.INSTANCE;
        SnackbarProxy proxy = SnackbarProxyHolder.INSTANCE.getProxy();
        if (proxy != null) {
            proxy.shown(snackbar);
        }
    }
}
