package com.avito.android.jsonrpc.client;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J;\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "T", "", "R", "Lcom/avito/android/jsonrpc/client/RpcRequest;", "request", "Lkotlin/Function1;", "responseParser", "Lio/reactivex/Single;", "call", "(Lcom/avito/android/jsonrpc/client/RpcRequest;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Single;", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public interface JsonRpcClient<T> {
    @NotNull
    <R> Single<R> call(@NotNull RpcRequest rpcRequest, @NotNull Function1<? super T, ? extends R> function1);
}
