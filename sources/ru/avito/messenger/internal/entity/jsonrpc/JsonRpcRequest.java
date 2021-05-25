package ru.avito.messenger.internal.entity.jsonrpc;

import a2.b.a.a.a;
import com.bluejamesbond.text.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcRequest;", "", "", "toString", "()Ljava/lang/String;", "method", "Ljava/lang/String;", "getMethod", "params", "Ljava/lang/Object;", "getParams", "()Ljava/lang/Object;", "", "id", "J", "getId", "()J", "jsonrpc", "getJsonrpc", "<init>", "(JLjava/lang/String;Ljava/lang/Object;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcRequest {
    @SerializedName("id")
    private final long id;
    @SerializedName("jsonrpc")
    @NotNull
    private final String jsonrpc;
    @SerializedName("method")
    @NotNull
    private final String method;
    @SerializedName("params")
    @NotNull
    private final Object params;

    public JsonRpcRequest(long j, @NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(obj, "params");
        this.id = j;
        this.method = str;
        this.params = obj;
        this.jsonrpc = BuildConfig.VERSION_NAME;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final Object getParams() {
        return this.params;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("JsonRpcRequest(id=");
        L.append(this.id);
        L.append(", method='");
        L.append(this.method);
        L.append("', params=");
        L.append(this.params);
        L.append(", jsonrpc='");
        return a.t(L, this.jsonrpc, "')");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonRpcRequest(long j, String str, Object obj, int i, j jVar) {
        this(j, str, (i & 4) != 0 ? r.emptyMap() : obj);
    }
}
