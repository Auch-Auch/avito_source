package com.avito.android.jsonrpc.client;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\t¨\u0006\""}, d2 = {"Lcom/avito/android/jsonrpc/client/RpcRequest;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Object;", "id", "method", "params", "copy", "(JLjava/lang/String;Ljava/lang/Object;)Lcom/avito/android/jsonrpc/client/RpcRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMethod", AuthSource.SEND_ABUSE, "J", "getId", "c", "Ljava/lang/Object;", "getParams", "<init>", "(JLjava/lang/String;Ljava/lang/Object;)V", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public final class RpcRequest {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final Object c;

    public RpcRequest(long j, @NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(obj, "params");
        this.a = j;
        this.b = str;
        this.c = obj;
    }

    public static /* synthetic */ RpcRequest copy$default(RpcRequest rpcRequest, long j, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = rpcRequest.a;
        }
        if ((i & 2) != 0) {
            str = rpcRequest.b;
        }
        if ((i & 4) != 0) {
            obj = rpcRequest.c;
        }
        return rpcRequest.copy(j, str, obj);
    }

    public final long component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final Object component3() {
        return this.c;
    }

    @NotNull
    public final RpcRequest copy(long j, @NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(obj, "params");
        return new RpcRequest(j, str, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RpcRequest)) {
            return false;
        }
        RpcRequest rpcRequest = (RpcRequest) obj;
        return this.a == rpcRequest.a && Intrinsics.areEqual(this.b, rpcRequest.b) && Intrinsics.areEqual(this.c, rpcRequest.c);
    }

    public final long getId() {
        return this.a;
    }

    @NotNull
    public final String getMethod() {
        return this.b;
    }

    @NotNull
    public final Object getParams() {
        return this.c;
    }

    public int hashCode() {
        int a3 = c.a(this.a) * 31;
        String str = this.b;
        int i = 0;
        int hashCode = (a3 + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.c;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RpcRequest(id=");
        L.append(this.a);
        L.append(", method=");
        L.append(this.b);
        L.append(", params=");
        return a.r(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RpcRequest(long j, String str, Object obj, int i, j jVar) {
        this(j, str, (i & 4) != 0 ? r.emptyMap() : obj);
    }
}
