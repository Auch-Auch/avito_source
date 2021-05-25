package ru.avito.messenger.internal.entity.jsonrpc;

import com.avito.android.jsonrpc.client.JsonRpcCallException;
import kotlin.Metadata;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/entity/jsonrpc/MessengerJsonRpcCallException;", "Lcom/avito/android/jsonrpc/client/JsonRpcCallException;", "", "code", "", "message", "", "cause", "requestId", CommonKt.EXTRA_RPC_ID, "method", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerJsonRpcCallException extends JsonRpcCallException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessengerJsonRpcCallException(int i, String str, Throwable th, String str2, String str3, String str4, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : th, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) == 0 ? str4 : null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessengerJsonRpcCallException(int r4, @org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.Nullable java.lang.Throwable r6, @org.jetbrains.annotations.Nullable java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9) {
        /*
            r3 = this;
            r0 = 40
            java.lang.StringBuilder r0 = a2.b.a.a.a.I(r0)
            if (r9 == 0) goto L_0x0013
            java.lang.String r1 = "method="
            java.lang.String r2 = ", "
            java.lang.String r9 = a2.b.a.a.a.e3(r1, r9, r2)
            if (r9 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            java.lang.String r9 = ""
        L_0x0015:
            java.lang.String r1 = "requestId="
            java.lang.String r2 = ", rpcId="
            a2.b.a.a.a.n1(r0, r9, r1, r7, r2)
            java.lang.String r7 = ") "
            java.lang.String r5 = a2.b.a.a.a.u(r0, r8, r7, r5)
            r3.<init>(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException.<init>(int, java.lang.String, java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
