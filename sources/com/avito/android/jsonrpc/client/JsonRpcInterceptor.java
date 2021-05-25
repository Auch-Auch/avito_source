package com.avito.android.jsonrpc.client;

import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcInterceptor;", "", "Lcom/avito/android/jsonrpc/client/RpcRequest;", "request", "Ljava/lang/reflect/Method;", "method", "", "intercept", "(Lcom/avito/android/jsonrpc/client/RpcRequest;Ljava/lang/reflect/Method;)V", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public interface JsonRpcInterceptor {
    void intercept(@NotNull RpcRequest rpcRequest, @NotNull Method method);
}
