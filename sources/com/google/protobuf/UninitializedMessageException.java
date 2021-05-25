package com.google.protobuf;

import java.util.Collections;
import java.util.List;
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    public final List<String> a;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.a);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UninitializedMessageException(java.util.List<java.lang.String> r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Message missing required fields: "
            r0.<init>(r1)
            java.util.Iterator r1 = r6.iterator()
            r2 = 1
        L_0x000c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0025
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r2 == 0) goto L_0x001c
            r2 = 0
            goto L_0x0021
        L_0x001c:
            java.lang.String r4 = ", "
            r0.append(r4)
        L_0x0021:
            r0.append(r3)
            goto L_0x000c
        L_0x0025:
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            r5.a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UninitializedMessageException.<init>(java.util.List):void");
    }
}
