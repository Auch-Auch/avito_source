package org.junit.experimental.runners;

import org.junit.runners.Suite;
public class Enclosed extends Suite {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Enclosed(java.lang.Class<?> r7, org.junit.runners.model.RunnerBuilder r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Class[] r0 = r7.getClasses()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.length
            r1.<init>(r2)
            int r2 = r0.length
            r3 = 0
        L_0x000c:
            if (r3 >= r2) goto L_0x0020
            r4 = r0[r3]
            int r5 = r4.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isAbstract(r5)
            if (r5 != 0) goto L_0x001d
            r1.add(r4)
        L_0x001d:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0020:
            int r0 = r1.size()
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.Class[] r0 = (java.lang.Class[]) r0
            r6.<init>(r8, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.experimental.runners.Enclosed.<init>(java.lang.Class, org.junit.runners.model.RunnerBuilder):void");
    }
}
