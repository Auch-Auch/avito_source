package com.avito.android.snackbar.proxy;

import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/snackbar/proxy/SnackbarProxyHolder;", "", "Lcom/avito/android/snackbar/proxy/SnackbarProxy;", AuthSource.SEND_ABUSE, "Lcom/avito/android/snackbar/proxy/SnackbarProxy;", "getProxy", "()Lcom/avito/android/snackbar/proxy/SnackbarProxy;", "setProxy", "(Lcom/avito/android/snackbar/proxy/SnackbarProxy;)V", "proxy", "<init>", "()V", "snackbar-proxy_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting
public final class SnackbarProxyHolder {
    @NotNull
    public static final SnackbarProxyHolder INSTANCE = new SnackbarProxyHolder();
    @Nullable
    public static SnackbarProxy a;

    @Nullable
    public final SnackbarProxy getProxy() {
        return a;
    }

    public final void setProxy(@Nullable SnackbarProxy snackbarProxy) {
        a = snackbarProxy;
    }
}
