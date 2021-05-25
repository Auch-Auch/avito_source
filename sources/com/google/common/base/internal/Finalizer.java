package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class Finalizer implements Runnable {
    public static final Logger d = Logger.getLogger(Finalizer.class.getName());
    @NullableDecl
    public static final Constructor<Thread> e;
    @NullableDecl
    public static final Field f;
    public final WeakReference<Class<?>> a;
    public final PhantomReference<Object> b;
    public final ReferenceQueue<Object> c;

    static {
        Constructor<Thread> constructor;
        Field field = null;
        try {
            constructor = Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            constructor = null;
        }
        e = constructor;
        if (constructor == null) {
            try {
                Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
                declaredField.setAccessible(true);
                field = declaredField;
            } catch (Throwable unused2) {
                d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            }
        }
        f = field;
    }

    public Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.c = referenceQueue;
        this.a = new WeakReference<>(cls);
        this.b = phantomReference;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ all -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startFinalizer(java.lang.Class<?> r6, java.lang.ref.ReferenceQueue<java.lang.Object> r7, java.lang.ref.PhantomReference<java.lang.Object> r8) {
        /*
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = "com.google.common.base.FinalizableReference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            com.google.common.base.internal.Finalizer r0 = new com.google.common.base.internal.Finalizer
            r0.<init>(r6, r7, r8)
            java.lang.Class<com.google.common.base.internal.Finalizer> r6 = com.google.common.base.internal.Finalizer.class
            java.lang.String r6 = r6.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r7 = com.google.common.base.internal.Finalizer.e
            r8 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0047
            r2 = 0
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x003d }
            r5 = 0
            r4[r5] = r1     // Catch:{ all -> 0x003d }
            r4[r8] = r0     // Catch:{ all -> 0x003d }
            r5 = 2
            r4[r5] = r6     // Catch:{ all -> 0x003d }
            r5 = 3
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x003d }
            r4[r5] = r2     // Catch:{ all -> 0x003d }
            r2 = 4
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x003d }
            r4[r2] = r3     // Catch:{ all -> 0x003d }
            java.lang.Object r7 = r7.newInstance(r4)     // Catch:{ all -> 0x003d }
            java.lang.Thread r7 = (java.lang.Thread) r7     // Catch:{ all -> 0x003d }
            goto L_0x0048
        L_0x003d:
            r7 = move-exception
            java.util.logging.Logger r2 = com.google.common.base.internal.Finalizer.d
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r7)
        L_0x0047:
            r7 = r1
        L_0x0048:
            if (r7 != 0) goto L_0x004f
            java.lang.Thread r7 = new java.lang.Thread
            r7.<init>(r1, r0, r6)
        L_0x004f:
            r7.setDaemon(r8)
            java.lang.reflect.Field r6 = com.google.common.base.internal.Finalizer.f     // Catch:{ all -> 0x005a }
            if (r6 == 0) goto L_0x0064
            r6.set(r7, r1)     // Catch:{ all -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r6 = move-exception
            java.util.logging.Logger r8 = com.google.common.base.internal.Finalizer.d
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r8.log(r0, r1, r6)
        L_0x0064:
            r7.start()
            return
        L_0x0068:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Expected com.google.common.base.FinalizableReference."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.startFinalizer(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    public final boolean a(Reference<?> reference) {
        Method method;
        Class<?> cls = this.a.get();
        if (cls == null) {
            method = null;
        } else {
            try {
                method = cls.getMethod("finalizeReferent", new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new AssertionError(e2);
            }
        }
        if (method == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.b) {
                return false;
            }
            try {
                method.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.c.poll();
        } while (reference != null);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.c.remove())) {
        }
    }
}
