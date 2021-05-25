package a7.a.b.a.n;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcRequest;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public final class c<T> implements Predicate<JsonRpcResponse> {
    public final /* synthetic */ JsonRpcRequest a;

    public c(JsonRpcRequest jsonRpcRequest) {
        this.a = jsonRpcRequest;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(JsonRpcResponse jsonRpcResponse) {
        JsonRpcResponse jsonRpcResponse2 = jsonRpcResponse;
        Intrinsics.checkNotNullParameter(jsonRpcResponse2, CommonKt.EXTRA_RESPONSE);
        return jsonRpcResponse2.getId().longValue() == this.a.getId();
    }
}
