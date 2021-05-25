package ru.avito.messenger.internal.entity.jsonrpc;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/jsonrpc/JsonRpcError;", "", "", "toString", "()Ljava/lang/String;", "message", "Ljava/lang/String;", "getMessage", "", "code", "I", "getCode", "()I", "<init>", "(ILjava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcError {
    @SerializedName("code")
    private final int code;
    @SerializedName("message")
    @Nullable
    private final String message;

    public JsonRpcError(int i, @Nullable String str) {
        this.code = i;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("JsonRpcError(code=");
        L.append(this.code);
        L.append(", message=");
        return a.s(L, this.message, ')');
    }
}
