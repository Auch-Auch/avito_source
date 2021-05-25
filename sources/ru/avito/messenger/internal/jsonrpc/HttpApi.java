package ru.avito.messenger.internal.jsonrpc;

import com.avito.android.util.preferences.SessionContract;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcRequest;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JI\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/jsonrpc/HttpApi;", "", "", "origin", SessionContract.SESSION, "", "queryParameters", "Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcRequest;", "request", "Lio/reactivex/Single;", "Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcResponse;", "sendRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcRequest;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface HttpApi {
    @POST("fallback")
    @NotNull
    Single<JsonRpcResponse> sendRequest(@Header("Origin") @NotNull String str, @Header("X-Session") @NotNull String str2, @QueryMap @NotNull Map<String, String> map, @Body @NotNull JsonRpcRequest jsonRpcRequest);
}
