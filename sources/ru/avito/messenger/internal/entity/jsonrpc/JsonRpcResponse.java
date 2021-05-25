package ru.avito.messenger.internal.entity.jsonrpc;

import a2.b.a.a.a;
import com.bluejamesbond.text.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000b\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcResponse;", "Lru/avito/messenger/api/entity/MessengerResponse;", "", "toString", "()Ljava/lang/String;", "", "id", "J", "getId", "()Ljava/lang/Long;", "jsonrpc", "Ljava/lang/String;", "getJsonrpc", "requestId", "getRequestId", "Lcom/google/gson/JsonElement;", "result", "Lcom/google/gson/JsonElement;", "getResult", "()Lcom/google/gson/JsonElement;", "Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcError;", "error", "Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcError;", "getError", "()Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcError;", CommonKt.EXTRA_RPC_ID, "getRpcId", "<init>", "(JLcom/google/gson/JsonElement;Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcError;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcResponse implements MessengerResponse {
    @SerializedName("error")
    @Nullable
    private final JsonRpcError error;
    @SerializedName("id")
    private final long id;
    @SerializedName("jsonrpc")
    @NotNull
    private final String jsonrpc = BuildConfig.VERSION_NAME;
    @SerializedName("requestId")
    @Nullable
    private final String requestId;
    @SerializedName("result")
    @NotNull
    private final JsonElement result;
    @SerializedName(CommonKt.EXTRA_RPC_ID)
    @Nullable
    private final String rpcId;

    public JsonRpcResponse(long j, @NotNull JsonElement jsonElement, @Nullable JsonRpcError jsonRpcError, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(jsonElement, "result");
        this.id = j;
        this.result = jsonElement;
        this.error = jsonRpcError;
        this.requestId = str;
        this.rpcId = str2;
    }

    @Nullable
    public final JsonRpcError getError() {
        return this.error;
    }

    @Override // ru.avito.messenger.api.entity.MessengerResponse
    @NotNull
    public Long getId() {
        return Long.valueOf(this.id);
    }

    @NotNull
    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final JsonElement getResult() {
        return this.result;
    }

    @Nullable
    public final String getRpcId() {
        return this.rpcId;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("JsonRpcResponse(id=");
        L.append(getId().longValue());
        L.append(", result=");
        L.append(this.result);
        L.append(", error=");
        L.append(this.error);
        L.append(", requestId=");
        L.append(this.requestId);
        L.append(", rpcId=");
        L.append(this.rpcId);
        L.append(", jsonrpc='");
        return a.t(L, this.jsonrpc, "')");
    }
}
