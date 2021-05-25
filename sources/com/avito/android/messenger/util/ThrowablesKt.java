package com.avito.android.messenger.util;

import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.util.NetworkException;
import com.avito.android.util.UnauthorizedException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "toAvitoException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ThrowablesKt {
    @NotNull
    public static final Throwable toAvitoException(@NotNull Throwable th) {
        Throwable th2;
        Intrinsics.checkNotNullParameter(th, "$this$toAvitoException");
        if (th instanceof NetworkException) {
            return th;
        }
        if ((th instanceof TimeoutException) || (th instanceof IOException)) {
            th2 = new NetworkException(th);
        } else if (!(th instanceof JsonRpcCallException)) {
            return th;
        } else {
            if (((JsonRpcCallException) th).getCode() == 3401) {
                th2 = new UnauthorizedException(th);
            } else {
                Throwable cause = th.getCause();
                return (cause == null || !(Intrinsics.areEqual(cause, th) ^ true)) ? th : toAvitoException(cause);
            }
        }
        return th2;
    }
}
