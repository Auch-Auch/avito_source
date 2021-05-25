package hu.akarnokd.rxjava2.debug;

import java.util.HashSet;
public final class RxJavaAssemblyException extends RuntimeException {
    private static final long serialVersionUID = -6757520270386306081L;
    public final String a = buildStackTrace();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r6.contains("RxJavaPlugins") != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String buildStackTrace() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            java.lang.String r2 = "RxJavaAssemblyException: assembled\r\n"
            r0.append(r2)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0015:
            if (r4 >= r2) goto L_0x008d
            r5 = r1[r4]
            int r6 = r5.getLineNumber()
            r7 = 1
            if (r6 != r7) goto L_0x0022
        L_0x0020:
            r7 = 0
            goto L_0x007b
        L_0x0022:
            java.lang.String r6 = r5.getClassName()
            java.lang.String r8 = "java.lang.Thread"
            boolean r8 = r6.contains(r8)
            if (r8 == 0) goto L_0x002f
            goto L_0x0020
        L_0x002f:
            java.lang.String r8 = "junit.runner"
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x0020
            java.lang.String r8 = "org.junit.internal"
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x0020
            java.lang.String r8 = "junit4.runner"
            boolean r8 = r6.contains(r8)
            if (r8 == 0) goto L_0x0048
            goto L_0x007a
        L_0x0048:
            java.lang.String r8 = "java.lang.reflect"
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x0020
            java.lang.String r8 = "sun.reflect"
            boolean r8 = r6.contains(r8)
            if (r8 == 0) goto L_0x0059
            goto L_0x007a
        L_0x0059:
            java.lang.String r8 = ".RxJavaAssemblyException"
            boolean r8 = r6.contains(r8)
            if (r8 == 0) goto L_0x0062
            goto L_0x0020
        L_0x0062:
            java.lang.String r8 = "OnAssembly"
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x0020
            java.lang.String r8 = "RxJavaAssemblyTracking"
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x0020
            java.lang.String r8 = "RxJavaPlugins"
            boolean r6 = r6.contains(r8)
            if (r6 == 0) goto L_0x007b
        L_0x007a:
            goto L_0x0020
        L_0x007b:
            if (r7 == 0) goto L_0x008a
            java.lang.String r6 = "at "
            r0.append(r6)
            r0.append(r5)
            java.lang.String r5 = "\r\n"
            r0.append(r5)
        L_0x008a:
            int r4 = r4 + 1
            goto L_0x0015
        L_0x008d:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hu.akarnokd.rxjava2.debug.RxJavaAssemblyException.buildStackTrace():java.lang.String");
    }

    public static RxJavaAssemblyException find(Throwable th) {
        HashSet hashSet = new HashSet();
        while (th != null) {
            if (!(th instanceof RxJavaAssemblyException)) {
                if (!hashSet.add(th)) {
                    break;
                }
                th = th.getCause();
            } else {
                return (RxJavaAssemblyException) th;
            }
        }
        return null;
    }

    public Throwable appendLast(Throwable th) {
        HashSet hashSet = new HashSet();
        Throwable th2 = th;
        while (th2.getCause() != null) {
            if (!hashSet.add(th2)) {
                return th;
            }
            th2 = th2.getCause();
        }
        try {
            th2.initCause(this);
        } catch (Throwable unused) {
        }
        return th;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String stacktrace() {
        return this.a;
    }
}
