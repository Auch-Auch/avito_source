package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class DisableOnDebug implements TestRule {
    public final TestRule a;
    public final boolean b;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DisableOnDebug(org.junit.rules.TestRule r3) {
        /*
            r2 = this;
            org.junit.internal.management.RuntimeMXBean r0 = org.junit.internal.management.ManagementFactory.getRuntimeMXBean()
            java.util.List r0 = r0.getInputArguments()
            r2.<init>()
            r2.a = r3
            java.util.Iterator r3 = r0.iterator()
        L_0x0011:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "-Xdebug"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "-agentlib:jdwp"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0011
        L_0x002d:
            r3 = 1
            goto L_0x0030
        L_0x002f:
            r3 = 0
        L_0x0030:
            r2.b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.rules.DisableOnDebug.<init>(org.junit.rules.TestRule):void");
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        if (this.b) {
            return statement;
        }
        return this.a.apply(statement, description);
    }

    public boolean isDebugging() {
        return this.b;
    }
}
