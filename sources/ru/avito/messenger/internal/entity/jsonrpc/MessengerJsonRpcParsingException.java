package ru.avito.messenger.internal.entity.jsonrpc;

import kotlin.Metadata;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002BC\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/avito/messenger/internal/entity/jsonrpc/MessengerJsonRpcParsingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "", "cause", "requestId", CommonKt.EXTRA_RPC_ID, "method", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerJsonRpcParsingException extends Exception {
    public MessengerJsonRpcParsingException() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessengerJsonRpcParsingException(String str, Throwable th, String str2, String str3, String str4, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessengerJsonRpcParsingException(@org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.Throwable r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r3 = this;
            java.lang.String r0 = "Error ("
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            if (r8 == 0) goto L_0x0013
            java.lang.String r1 = "method="
            java.lang.String r2 = ", "
            java.lang.String r8 = a2.b.a.a.a.e3(r1, r8, r2)
            if (r8 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            java.lang.String r8 = ""
        L_0x0015:
            java.lang.String r1 = "requestId="
            java.lang.String r2 = ", rpcId="
            a2.b.a.a.a.n1(r0, r8, r1, r6, r2)
            java.lang.String r6 = ") "
            java.lang.String r4 = a2.b.a.a.a.u(r0, r7, r6, r4)
            r3.<init>(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcParsingException.<init>(java.lang.String, java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
