package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;
public class ExpectException extends Statement {
    public final Statement a;
    public final Class<? extends Throwable> b;

    public ExpectException(Statement statement, Class<? extends Throwable> cls) {
        this.a = statement;
        this.b = cls;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    @Override // org.junit.runners.model.Statement
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluate() throws java.lang.Exception {
        /*
            r3 = this;
            org.junit.runners.model.Statement r0 = r3.a     // Catch:{ AssumptionViolatedException -> 0x0043, all -> 0x0007 }
            r0.evaluate()     // Catch:{ AssumptionViolatedException -> 0x0043, all -> 0x0007 }
            r0 = 1
            goto L_0x0051
        L_0x0007:
            r0 = move-exception
            java.lang.Class<? extends java.lang.Throwable> r1 = r3.b
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x0015
            goto L_0x0050
        L_0x0015:
            java.lang.String r1 = "Unexpected exception, expected<"
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.Class<? extends java.lang.Throwable> r2 = r3.b
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = "> but was<"
            r1.append(r2)
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = ">"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>(r1, r0)
            throw r2
        L_0x0043:
            r0 = move-exception
            java.lang.Class<? extends java.lang.Throwable> r1 = r3.b
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x0066
        L_0x0050:
            r0 = 0
        L_0x0051:
            if (r0 != 0) goto L_0x0054
            return
        L_0x0054:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Expected exception: "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.Class<? extends java.lang.Throwable> r2 = r3.b
            java.lang.String r1 = a2.b.a.a.a.B2(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x0066:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.internal.runners.statements.ExpectException.evaluate():void");
    }
}
