package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
public class RunAfters extends Statement {
    public final Statement a;
    public final Object b;
    public final List<FrameworkMethod> c;

    public RunAfters(Statement statement, List<FrameworkMethod> list, Object obj) {
        this.a = statement;
        this.c = list;
        this.b = obj;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.junit.runners.model.Statement r1 = r4.a     // Catch:{ all -> 0x0025 }
            r1.evaluate()     // Catch:{ all -> 0x0025 }
            java.util.List<org.junit.runners.model.FrameworkMethod> r1 = r4.c
            java.util.Iterator r1 = r1.iterator()
        L_0x0010:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()
            org.junit.runners.model.FrameworkMethod r2 = (org.junit.runners.model.FrameworkMethod) r2
            r4.invokeMethod(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r2 = move-exception
            r0.add(r2)
            goto L_0x0010
        L_0x0025:
            r1 = move-exception
            r0.add(r1)     // Catch:{ all -> 0x0048 }
            java.util.List<org.junit.runners.model.FrameworkMethod> r1 = r4.c
            java.util.Iterator r1 = r1.iterator()
        L_0x002f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()
            org.junit.runners.model.FrameworkMethod r2 = (org.junit.runners.model.FrameworkMethod) r2
            r4.invokeMethod(r2)     // Catch:{ all -> 0x003f }
            goto L_0x002f
        L_0x003f:
            r2 = move-exception
            r0.add(r2)
            goto L_0x002f
        L_0x0044:
            org.junit.runners.model.MultipleFailureException.assertEmpty(r0)
            return
        L_0x0048:
            r1 = move-exception
            java.util.List<org.junit.runners.model.FrameworkMethod> r2 = r4.c
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.next()
            org.junit.runners.model.FrameworkMethod r3 = (org.junit.runners.model.FrameworkMethod) r3
            r4.invokeMethod(r3)     // Catch:{ all -> 0x005f }
            goto L_0x004f
        L_0x005f:
            r3 = move-exception
            r0.add(r3)
            goto L_0x004f
        L_0x0064:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.internal.runners.statements.RunAfters.evaluate():void");
    }

    public void invokeMethod(FrameworkMethod frameworkMethod) throws Throwable {
        frameworkMethod.invokeExplosively(this.b, new Object[0]);
    }
}
