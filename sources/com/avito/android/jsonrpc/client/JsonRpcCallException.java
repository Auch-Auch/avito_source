package com.avito.android.jsonrpc.client;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcCallException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()I", "code", "", "message", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public class JsonRpcCallException extends Exception {
    public final int a;

    public JsonRpcCallException(int i, @Nullable String str, @Nullable Throwable th) {
        super("Error " + i + ": " + str, th);
        this.a = i;
    }

    public final int getCode() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonRpcCallException(int i, String str, Throwable th, int i2, j jVar) {
        this(i, str, (i2 & 4) != 0 ? null : th);
    }
}
